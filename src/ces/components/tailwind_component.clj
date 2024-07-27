(ns ces.components.tailwind-component
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [com.stuartsierra.component :as component]))

(defn get-executable-name
  ([] (get-executable-name (System/getProperty "os.name") (System/getProperty "os.arch")))
  ([current-platform architecture]
   (case [(str/lower-case current-platform) (str/lower-case architecture)]
     ["windows" "amd64"] "tailwindcss-windows-x64.exe"
     ["windows" "arm64"] "tailwindcss-windows-arm64.exe"
     ["linux" "amd64"] "tailwindcss-linux-x64"
     ["linux" "aarch64"] "tailwindcss-linux-arm64"
     ["mac os x" "x86_64"] "tailwindcss-macos-x64"
     ["mac os x" "aarch64"] "tailwindcss-macos-arm64"
     (throw (IllegalArgumentException. (str "Unsupported platform or architecture: " current-platform "-" architecture))))))

(defn get-settings
  ([] (get-settings (get-executable-name) (str/lower-case (System/getProperty "os.name"))))
  ([executable-name platform]
    {:is-posix   (or (= platform "linux") (= platform "mac os x")) 
     :input-css  (io/file (io/resource "assets/css/app.css"))
     :output-css (io/file (io/resource "public/css/tailwind") "tailwind.min.css")
     :config     (io/file (io/resource "assets/tailwind.config.js"))
     :assets-bin (io/file (io/resource "assets") "assets_bin")
     :cli-bin    (io/file (io/resource "assets") "assets_bin" executable-name)
     :cli-download-url (str "https://github.com/tailwindlabs/tailwindcss/releases/latest/download/" executable-name)}))

(def default-settings (get-settings))

(defn download-cli
  ([] (download-cli default-settings))
  ([settings]
   (when-not (.exists (settings :cli-bin))
     (.mkdirs (settings :assets-bin))
     (.createNewFile (settings :cli-bin)))
   (with-open [in  (io/input-stream  (settings :cli-download-url))
               out (io/output-stream (settings :cli-bin))]
     (io/copy in out))
   (when (settings :is-posix)
     (.setExecutable (settings :cli-bin) true))))


(defn run-cli
  [& {:keys [watch minify settings] :or {watch false, minify false, settings default-settings}}]
  (when-not (.exists (settings :cli-bin))
    (download-cli settings))
  (let [command (-> [(str (settings :cli-bin))
                      "-i" (str (settings :input-css)) 
                      "-o" (str (settings :output-css))
                      "-c" (str (settings :config))]
                     (concat (when minify ["--minify"]))
                     (concat (when watch  ["--watch"]))
                     (vec))
        process (-> 
                  (ProcessBuilder. command)
                  (.start))]
    (if watch
      {:watch true :process process} 
      (do (.waitFor process) 
          {:watch false :process nil}))))

(defn stop-cli 
  [opts]
  (when (opts :watch)
    (.destroy (opts :process))))

(defrecord TailwindComponent
  [config]
  component/Lifecycle

  (start
    [component]
    (println (str ";; Starting Tailwind Component"))
    (let [process (run-cli :watch true)]
      (assoc component :process-opts process)))

  (stop
    [component]
    (println ";; Stoping Tailwind Component")
    (stop-cli (:process-opts component))
    (assoc component :process-opts nil)))

(defn new-process [config]
  (map->TailwindComponent {:config config}))
