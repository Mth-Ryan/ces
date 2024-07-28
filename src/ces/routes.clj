(ns ces.routes
  (:require [io.pedestal.http.route :as route]
            [clojure.set :as set]
            [ces.pages.shop.routes :as shop-routes]))

(defn respond-hello
  [request]
  {:status 200 :body "Hello world!"})

(def routes
  (-> (set/union 
        shop-routes/routes)
      (route/expand-routes)))


(def url-for (route/url-for-routes routes))