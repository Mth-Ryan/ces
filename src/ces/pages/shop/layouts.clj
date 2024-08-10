(ns ces.pages.shop.layouts
  (:require [ces.pages.shared.components :as shared-components]
            [ces.pages.shared.layouts :as shared-layouts]))

(defn header []
  [:header {:class "sticky top-0 backdrop-blur bg-white/80 shadow-sm z-20 transition-all py-2"}
   [:div {:class "max-w-screen-lg mx-auto flex items-center justify-between px-6 text-secondary-700"}
    [:button {:type  "button"
              :class "rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
     [:svg {:xmlns        "http://www.w3.org/2000/svg"
            :fill         "none"
            :viewBox      "0 0 24 24"
            :stroke-width "1.5"
            :stroke       "currentColor"
            :class        "size-6"}
      [:path {:stroke-linecap  "round"
              :stroke-linejoin "round"
              :d               "M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"}]]]

    [:a {:href  "/"
         :title "sailboat UI"}
     (shared-components/logo {:class "h-5 w-auto"})]

    [:button {:type  "button"
              :class "rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
     [:svg {:xmlns        "http://www.w3.org/2000/svg"
            :fill         "none"
            :viewBox      "0 0 24 24"
            :stroke-width "1.5"
            :stroke       "currentColor"
            :class        "size-6"}
      [:path {:stroke-linecap  "round"
              :stroke-linejoin "round"
              :d               "M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 0 0-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 0 0-16.536-1.84M7.5 14.25 5.106 5.272M6 20.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Zm12.75 0a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Z"}]]]]])


(defn footer []
  [:footer {:class "text-secondary-500"}
   [:div {:class "pt-16 pb-12 text-sm border-t border-secondary-100 bg-secondary-50"}
    [:div {:class "max-w-screen-lg px-6 mx-auto"}
     [:div {:class "grid grid-cols-4 gap-6 md:grid-cols-8 lg:grid-cols-12"}
      [:div {:class           "col-span-4 md:col-span-8 lg:col-span-4"
             :aria-labelledby "footer-header"}
       (shared-components/logo {:class "h-5 mb-4 text-secondary-700"})
       [:p "Expertly made, responsive, accessible components in React and HTML ready to be used on your website or app. Just copy and paste them on your Tailwind CSS project."]]

      [:nav {:class           "col-span-2 md:col-span-4 lg:col-span-2"
             :aria-labelledby "footer-product-5-logo"}
       [:h3 {:class "mb-6 text-base font-medium text-secondary-700"
             :id    "footer-product-5-logo"}
        "Product"]
       [:ul
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Features"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Customers"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Why us?"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Pricing"]]]]

      [:nav {:class           "col-span-2 md:col-span-4 lg:col-span-2"
             :aria-labelledby "footer-docs-5-logo"}
       [:h3 {:class "mb-6 text-base font-medium text-secondary-700"
             :id    "footer-docs-5-logo"}
        "Docs & Help"]
       [:ul
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Documentation"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Training"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "System status"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "FAQ's"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Help Center"]]]]

      [:nav {:class           "col-span-2 md:col-span-4 lg:col-span-2"
             :aria-labelledby "footer-about-5-logo"}
       [:h3 {:class "mb-6 text-base font-medium text-secondary-700"
             :id    "footer-about-5-logo"}
        "About us"]
       [:ul
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "About us"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Careers"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Leadership"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Blog"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Events"]]]]

      [:nav {:class           "col-span-2 md:col-span-4 lg:col-span-2"
             :aria-labelledby "footer-get-in-touch-5-logo"}
       [:h3 {:class "mb-6 text-base font-medium text-secondary-700"
             :id    "footer-get-in-touch-5-logo"}
        "Get in touch"]
       [:ul
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Contact"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Support"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Partners"]]
        [:li {:class "mb-2 leading-6"}
         [:a {:href  "javascript:void(0)"
              :class "transition-colors duration-300 hover:text-purple-500 focus:text-purple-600"}
          "Join research"]]]]]]]])


(defn default-layout
  [opts & content]
  (shared-layouts/base-layout
    opts
    [:div {:class "flex h-60 min-h-screen flex-col"}
     (header)
     [:main {:id "content" :class "flex-1"}
      content]
     (footer)]))


(defn auth-layout
  [opts & content]
  (shared-layouts/base-layout
    opts
    [:div {:class "flex h-60 min-h-screen flex-col"}
     [:main {:class "flex-1 md:grid grid-cols-2 min-h-screen"}
      [:a {:href "/" :class "absolute top-6 left-6"} (shared-components/logo {:class "h-6"})]
      [:div {:class "hidden md:block w-full h-full bg-center bg-cover bg-[url('/images/auth-hero-banner.webp')]"}]
      [:div {:id "content" :class "p-6 flex flex-col w-full h-full items-center justify-center me-auto"}
       content]]
     (footer)]))