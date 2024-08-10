(ns ces.responses
  (:require [hiccup2.core :as h]))

(defn ok 
  ([body] (ok {} body))
  ([headers body] {:status 200
                   :headers (conj {"Content-Type" "text/html"} headers) 
                   :body (str (h/html body))}))