(ns ces.pages.shop.account
  (:require [ces.responses :as responses]
            [ces.pages.shared.utils :refer [encode-uri]]))

(defn handler [request]
  (responses/redirect (str "/entrar?return-url=" (encode-uri "/entrar"))))