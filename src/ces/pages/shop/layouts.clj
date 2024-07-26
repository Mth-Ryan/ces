(ns ces.pages.shop.layouts
  (:require [hiccup.page :as p]
            [hiccup2.core :as h]))

(defn base-layout
  [title & content]
  (h/html
    (h/raw "<!DOCTYPE html>")
    [:html {:lang "pt"}
     [:head
      [:title title]
      (p/include-js "https://unpkg.com/htmx.org@2.0.1")
      (p/include-js "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js")
      (p/include-js "https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp,container-queries")]
     [:body content]]))

(defn header
  []
  [:header {:class "text-xl"}
   [:h1 "Ecommerce"]])

(defn footer
  []
  [:footer {:class "text-lg"}
   [:h3 "Ecommerce"]])

(defn default-layout
  [title & content]
  (base-layout
    title
    (header)
    [:main content]
    (footer)))