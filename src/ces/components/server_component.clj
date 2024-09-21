(ns ces.components.server-component
    (:require [com.stuartsierra.component :as component]
              [io.pedestal.log :as l]
              [io.pedestal.http :as http]
              [io.pedestal.interceptor :as interceptor]
              [ces.routes :as routes]))

(defn inject-dependencies
  [dependencies]
  (interceptor/interceptor
    {:name ::inject-dependencies
     :enter (fn [context]
              (assoc context :deps dependencies))}))

(defrecord ServerComponent
  [config
   data-source]
  component/Lifecycle

  (start
    [component]
    (let [server (-> {::http/routes routes/routes
                      ::http/type :jetty
                      ::http/join? false
                      ::http/resource-path "public"
                      ::http/secure-headers {:content-security-policy-settings {:object-src "none"}}
                      ::http/port (-> config :web-server :port)}
                     (http/default-interceptors)
                     (update ::http/interceptors concat
                             [(inject-dependencies component)])
                     (http/create-server)
                     (http/start))]
      (l/info :message "Starting Server Component" 
              :port (-> config :web-server :port)
              :server server)
      (assoc component :server server)))

  (stop
    [component]
    (when-let [server (:server component)]
      (http/stop server))
    (l/info :message "Stopping Server Component"
            :port (-> config :web-server :port))
    (assoc component :server nil)))

(defn new-server [config]
  (map->ServerComponent {:config config}))
