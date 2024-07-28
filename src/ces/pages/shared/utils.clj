(ns ces.pages.shared.utils
  (:require [ces.config :as config]
            [struct.core :as st]))

(def app-config
  (get (config/read-config) :app {:shop-title       "Ecommerce"
                                  :management-title "Ecommerce Management"}))

(defn make-title
  [& {:keys [page-title variant] :or {page-title nil, variant :shop-title}}]
  (let [app-title (get app-config variant)]
    (if (nil? page-title) app-title (str page-title " • " app-title))))

(defn fmap [f map]
  (into {} (for [[k v] map] [k (f v)])))

(defn validate [data schema]
  (let [result (st/validate data schema)]
    {:valid? (nil? (first result))
     :values (or (second result) {})
     :errors (fmap #(if (string? %) [%] (into [] %)) (or (first result) {}))}))
