(ns ces.routes
  (:require [io.pedestal.http.route :as route]
            [clojure.set :as set]))

(defn respond-hello
  [request]
  {:status 200 :body "Hello world!"})

(def routes
  (-> (set/union 
        #{["/greet" :get respond-hello :route-name :greet]})
      (route/expand-routes)))
