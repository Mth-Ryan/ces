(ns ces.pages.shared.layouts
  (:require [hiccup.page :as p]
            [hiccup2.core :as h]
            [ces.pages.shared.utils :refer [make-title]]))

(defn base-layout
  [opts & content]
  [:html {:lang "pt"}
   [:head
    [:title (make-title :page-title (:title opts))]
    [:meta {:charset "utf-8"}] 
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
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
                  "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js")]])
