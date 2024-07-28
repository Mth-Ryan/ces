(ns ces.pages.shop.home
  (:require [ces.pages.shop.layouts :as layouts]
            [ces.pages.shared.components :as shared-components]))

(defn page []
  (layouts/default-layout 
    {:title nil}
    (shared-components/section [:p "Hello world!"])))

(defn handler [_request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str (page))})