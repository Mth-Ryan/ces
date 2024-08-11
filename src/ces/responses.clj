(ns ces.responses
  (:require [hiccup2.core :as h]))

(defn ok 
  ([body] (ok {} body))
  ([headers body] {:status 200
                   :headers (conj {"Content-Type" "text/html"} headers) 
                   :body (str (h/html body))}))

(defn redirect
  [location]
  {:status 302
   :headers {"Location" location}})