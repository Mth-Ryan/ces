(ns ces.pages.shop.routes
  (:require [ces.pages.shop.home :as home]
            [ces.pages.shop.login :as login]
            [io.pedestal.http.body-params :as body-params]))

(def routes
  #{["/" :get home/handler :route-name :home]
    ["/entrar" :get login/handler :route-name :login]
    ["/entrar/partials/form" :post [(body-params/body-params) login/form-handler] :route-name :login-form]})