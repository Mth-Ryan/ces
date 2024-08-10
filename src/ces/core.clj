(ns ces.core
  (:require [ces.config :as conf]
            [com.stuartsierra.component :as component]
            [ces.components.tailwind-component :as tailwind-component]
            [ces.components.server-component :as server-component]))

(defn ces-system
  [config]
  (component/system-map
   :tailwind-component (tailwind-component/new-process config)
   :server-component (server-component/new-server config)))

(defn -main []
  (let [system (-> (conf/read-config)
                   (ces-system)
                   (component/start-system))]
    (println ";; Starting CES System")
    (.addShutdownHook
     (Runtime/getRuntime)
     (new Thread #(component/stop-system system)))))
