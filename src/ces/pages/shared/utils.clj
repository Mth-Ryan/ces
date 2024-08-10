(ns ces.pages.shared.utils
  (:require [ces.config :as config]
            [struct.core :as st]
            [org.sqids.clojure :as sqids])
  (:import (java.net URLEncoder)))

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

(defn encode-uri
  [text]
  (URLEncoder/encode text "UTF-8"))

(def short-id-options
  (sqids/sqids))

(defn make-random-short-id 
  []
  (sqids/encode short-id-options (take 5 (repeat (rand-int 42)))))