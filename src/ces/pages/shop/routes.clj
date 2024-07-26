(ns ces.pages.shop.routes
  (:require [ces.pages.shop.home :as home]))

(def routes 
  #{["/" :get home/handler :route-name :home]})