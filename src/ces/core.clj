(ns ces.core
  (:require [ces.config :as conf]
            [com.stuartsierra.component :as component]
            [next.jdbc.connection :as connection]
            [ces.components.tailwind-component :as tailwind-component]
            [ces.components.server-component :as server-component])
  (:import (com.zaxxer.hikari HikariDataSource)))

(defn ces-system
  [config]
  (component/system-map
   :tailwind-component (tailwind-component/new-process config)
   :data-source        (connection/component HikariDataSource (:db config))
   :server-component   (component/using
                         (server-component/new-server config)
                         [:data-source])))

(defn -main []
  (let [system (-> (conf/read-config)
                   (ces-system)
                   (component/start-system))]
    (println ";; Starting CES System")
    (.addShutdownHook
     (Runtime/getRuntime)
     (new Thread #(component/stop-system system)))))
