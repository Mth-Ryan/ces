(ns ces.components.server-component
    (:require [com.stuartsierra.component :as component]
              [io.pedestal.http :as http]
              [ces.routes :as routes]))

(defrecord ServerComponent
  [config]
  component/Lifecycle

  (start
    [component]
    (println (str ";; Starting Server Component on " (-> config :web-server :port)))
    (let [server (-> {::http/routes routes/routes
                      ::http/type   :jetty
                      ::http/join?  false
                      ::http/port   (-> config :web-server :port)}
                     (http/create-server)
                     (http/start))]
      (assoc component :server server)))

  (stop
    [component]
    (println ";; Stoping Server Component")
    (when-let [server (:server component)]
      (http/stop server))
    (assoc component :server nil)))

(defn new-server [config]
  (map->ServerComponent {:config config}))
