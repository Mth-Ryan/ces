(ns dev.server
  (:require [clojure.core.async :as a]
            [io.pedestal.log :as l]
            [io.pedestal.http :as http]
            [io.pedestal.http.sse :as sse]
            [io.pedestal.interceptor :as interceptor]))

(defn reload-chan-interceptor
  [chan]
  (interceptor/interceptor
    {:name  ::reload-chan-interceptor
     :enter (fn [context] (assoc context ::reload-chan chan))
     :leave (fn [context] (dissoc context ::reload-chan))}))

(defn reload-handler
  [event-chan context]
  (while true
    (let [message (a/<!! (context ::reload-chan))]
         (a/>!! event-chan {:name "reload" :data message}))))

(defn make-routes
  [reload-chan]
  #{["/reload" :get [(reload-chan-interceptor reload-chan) (sse/start-event-stream reload-handler)] :route-name :hot-reload]})

(defn start [config]
  (let [reload-chan (a/chan)
        routes (make-routes reload-chan)
        server (-> {::http/routes         routes
                    ::http/type           :jetty
                    ::http/join?          false
                    ::http/secure-headers {:content-security-policy-settings {:object-src "none"}}
                    ::http/port           (-> config :dev-server :port)}
                   (http/default-interceptors)
                   (http/create-server)
                   (http/start))]
    (do
      (l/info :message "Starting dev server")
      (.addShutdownHook
        (Runtime/getRuntime)
        (new Thread #((do (http/stop server)
                          (a/close! reload-chan)))))
      {:server server :reload-chan reload-chan})))