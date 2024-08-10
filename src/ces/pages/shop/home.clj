(ns ces.pages.shop.home
  (:require [ces.pages.shop.layouts :as layouts]
            [ces.pages.shared.components :as shared-components]
            [ces.responses :as responses]))

(defn page []
  (layouts/default-layout 
    {:title nil}
    (shared-components/section [:p "Hello world!"])))

(defn handler [_request]
  (responses/ok (page)))