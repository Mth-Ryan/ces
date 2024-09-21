(ns ces.routes
  (:require [io.pedestal.http.route :as route]
            [clojure.set :as set]
            [ces.pages.shop.routes :as shop-routes]
            [io.pedestal.interceptor :as interceptor]
            [io.pedestal.interceptor.chain :as chain]
            [next.jdbc :as jdbc]))

(defn inject-dependencies
  [dependencies]
  (interceptor/interceptor
    {:name ::inject-dependencies
     :enter (fn [context]
              (assoc context :some-crazy-name dependencies))}))

(defn db-status-handler
  [context]
  (clojure.pprint/pprint context)
  {:status 200
   :body (str "Database version: ")})

(def routes
  (-> (set/union
        #{["/db-status" :get [(inject-dependencies {:config {:port 8000}}) db-status-handler] :route-name :db-status]}
        shop-routes/routes)
      (route/expand-routes)))


(def url-for (route/url-for-routes routes))