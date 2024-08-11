(ns ces.pages.shared.layouts
  (:require [hiccup.page :as p]
            [hiccup2.core :as h]
            [ces.pages.shared.utils :refer [config make-title make-random-short-id encode-uri]]))

(defn make-url
  ([url] (make-url url (= (get config :run-env :dev) :dev)))
  ([url cache-break?]
   (if cache-break?
     (str url "?=" (encode-uri (make-random-short-id)))
     url)))

(defn base-layout
  [opts & content]
  (list
    (h/raw "<!DOCTYPE html>")
    [:html {:lang "pt"}
     [:head
      [:title (make-title :page-title (:title opts))]
      [:meta {:charset "utf-8"}] 
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
      [:link {:rel "apple-touch-icon" :sizes "180x180" :href (make-url "/images/apple-touch-icon.png")}]
      [:link {:rel "icon" :type "image/png" :sizes "32x32" :href (make-url "/images/favicon-32x32.png")}]
      [:link {:rel "icon" :type "image/png" :sizes "16x16" :href (make-url "/images/favicon-16x16.png")}]
      [:link {:rel "manifest" :href (make-url "/site.webmanifest")}]
      [:link {:rel "mask-icon" :href (make-url "/safari-pinned-tab.svg") :color "#2d89ef"}]
      [:meta {:name "msapplication-TileColor" :content "#2d89ef"}]
      (p/include-css (make-url "/css/tailwind/tailwind.min.css"))]
     [:body
      content
      (p/include-js "https://unpkg.com/htmx.org@2.0.1"
                    "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js")]]))
