(ns dev.server
  (:require [clojure.core.async :as a]
            [io.pedestal.log :as l]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.interceptor :as interceptor]))

(defn reload-chan-interceptor
  [publication]
  (interceptor/interceptor
    {:name  ::reload-chan-interceptor
     :enter (fn [context]
              (let [chan (a/chan)]
                (a/sub publication :reload chan)
                (assoc context ::reload-chan chan)))
     :leave (fn [context]
              (when-let [chan (::reload-chan context)]
                (a/unsub publication :reload chan)
                (a/close! chan))
              (dissoc context ::reload-chan))}))

(defn make-routes
  [reload-publication]
  (route/expand-routes #{}))

(defn start [config]
  (let [reload-chan (a/chan)
        reload-publication (a/pub reload-chan :msg-type)
        routes (make-routes reload-publication)
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
      (let [out-chan (a/chan)]
        (a/sub reload-publication :reload out-chan)
        (a/go-loop []
          (let [{:keys [message]} (a/<! out-chan)]
            (l/info :message "Sending reload event" :reload message)
            (recur))))
      (.addShutdownHook
        (Runtime/getRuntime)
        (new Thread #((do (http/stop server)
                          (a/close! reload-chan)))))
      {:server server
       :reload (fn []
                 (a/>!! reload-chan {:msg-type :reload :message "true"}))})))