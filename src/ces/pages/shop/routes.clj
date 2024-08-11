(ns ces.pages.shop.routes
  (:require [ces.pages.shop.home :as home]
            [ces.pages.shop.login :as login]
            [ces.pages.shop.signup :as signup]
            [ces.pages.shop.account :as account]
            [io.pedestal.http.body-params :as body-params]))

(def routes
  #{["/" :get home/handler :route-name :home]

    ;; Login routes
    ["/entrar" :get login/handler :route-name :login]
    ["/entrar/partials/content" :get login/content-handler :route-name :login-content]
    ["/entrar/partials/form" :post [(body-params/body-params) login/form-handler] :route-name :login-form]

    ;; Signup routes
    ["/crie-sua-conta" :get signup/handler :route-name :signup]
    ["/crie-sua-conta/partials/content" :get signup/content-handler :route-name :signup-content]
    ["/crie-sua-conta/partials/form" :post [(body-params/body-params) signup/form-handler] :route-name :signup-form]
    
    ;; Account routes
    ["/conta" :get account/handler :route-name :account]})