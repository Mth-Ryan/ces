(ns ces.core
    (:require [ces.config :as conf]
              [io.pedestal.http :as http]
              [io.pedestal.http.route :as route]
              [com.stuartsierra.component :as component]
              [ces.components.server-component :as server-component]))

(defn respond-hello
  [request]
  {:status 200 :body "Hello world!"})

(def routes
  (route/expand-routes
    #{["/greet" :get respond-hello :route-name :greet]}))

(defn create-server [config]
  (http/create-server
    {::http/routes routes
     ::http/type   :jetty
     ::http/join?  false
     ::http/port   (-> config :web-server :port)}))

(defn start [config]
  (http/start (create-server config)))

(defn ces-system
  [config]
  (component/system-map
    :server-component (server-component/new-server config)))

(defn -main []
  (let [system (-> (conf/read-config)
                   (ces-system)
                   (component/start-system))]
       (println ";; Starting CES System")
       (.addShutdownHook
         (Runtime/getRuntime)
         (new Thread #(component/stop-system system)))))

