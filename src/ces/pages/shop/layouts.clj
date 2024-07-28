(ns ces.pages.shop.layouts
  (:require [hiccup.page :as p]
            [hiccup2.core :as h]
            [ces.pages.shop.components :as components]))

(defn base-layout
  [opts & content]
  (h/html
    (h/raw "<!DOCTYPE html>")
    [:html {:lang "pt"}
     [:head
      [:title (opts :title)]
      [:link {:rel "apple-touch-icon" :sizes "180x180" :href "/images/apple-touch-icon.png"}]
      [:link {:rel "icon" :type "image/png" :sizes "32x32" :href "/images/favicon-32x32.png"}]
      [:link {:rel "icon" :type "image/png" :sizes "16x16" :href "/images/favicon-16x16.png"}]
      [:link {:rel "manifest" :href "/site.webmanifest"}]
      [:link {:rel "mask-icon" :href "/safari-pinned-tab.svg" :color "#2d89ef"}]
      [:meta {:name "msapplication-TileColor" :content "#2d89ef"}]
      (p/include-css "/css/tailwind/tailwind.min.css")]
     [:body 
      content 
      (p/include-js "https://unpkg.com/htmx.org@2.0.1"
                    "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js")]]))


(defn default-layout
  [opts & content]
  (base-layout
    opts
    [:div {:class "flex h-60 min-h-screen flex-col"}
     (components/header)
     [:main {:class "flex-1"}
      content]
     (components/footer)]))