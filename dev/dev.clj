(ns dev
    (:require [com.stuartsierra.component.repl :as component-repl]
              [ces.core   :as core]
              [ces.config :as config]
              [dev.server :as dev-server]))

(component-repl/set-init
  (fn [_old-system]
      (-> (config/read-config)
          (core/ces-system))))
