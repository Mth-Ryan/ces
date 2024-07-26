(ns ces.pages.shop.home
  (:require [ces.pages.shop.layouts :as layouts]))

(defn page []
  (layouts/default-layout 
    "Ecommerce"
    [:p "Hello world!"]))

(defn handler [_request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str (page))})