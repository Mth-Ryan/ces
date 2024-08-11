(ns ces.pages.shop.layouts
  (:require [ces.pages.shared.components :as shared-components]
            [ces.pages.shared.layouts :as shared-layouts]
            [ces.pages.shared.utils :refer [make-title]]))

(defn menu-button []
  [:button {:type    "button"
            :id      "main-menu-button"
            :title   "Menu"
            :onclick "document.getElementById('main-menu').showModal(); document.body.style.overflow = 'hidden';"
            :class   "rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
   [:svg {:xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor" :class "size-6"}
    [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"}]]])

(defn search-button []
  [:button {:type    "button"
            :id      "header-search-button"
            :title   "Pesquisar"
            :onclick "document.getElementById('search-modal').showModal(); document.body.style.overflow = 'hidden';"
            :class   "hidden sm:block rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
   [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
    [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z"}]]])


(defn account-button []
  [:a {:href  "/conta"
       :type  "button"
       :id    "header-account-button"
       :title "Conta"
       :class "hidden sm:block rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
   [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
    [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"}]]])

(defn cart-button
  ([] (cart-button 0))
  ([n]
   [:button (conj
              {:type    "button"
               :id      "shopping-cart-button"
               :title   "Carrinho"
               :onclick "document.getElementById('shopping-cart').showModal(); document.body.style.overflow = 'hidden';"
               :class   "relative rounded-lg border border-transparent bg-transparent p-1.5 text-center text-sm font-medium text-gray-700 shadow-none transition-all hover:bg-gray-100 disabled:bg-transparent disabled:text-gray-400"}
              (when (< 0 n) {:data-count n}))
    [:svg {:xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor" :class "size-6"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 0 0-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 0 0-16.536-1.84M7.5 14.25 5.106 5.272M6 20.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Zm12.75 0a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Z"}]]]))

(defn header []
  [:header {:class "sticky top-0 backdrop-blur bg-white/80 shadow-sm z-20 transition-all py-2 border-b border-secondary-100"}
   [:div {:class "max-w-screen-lg mx-auto flex items-center justify-between px-6 text-secondary-700"}

    [:div {:class "flex gap-4"}
     (menu-button)
     (search-button)]
    [:a {:href  "/"
         :title (make-title)}
     (shared-components/logo {:class "h-5 w-auto"})]
    [:div {:class "flex gap-4"}
     (cart-button)
     (account-button)]]])


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

(defn main-menu
  []
  (shared-components/sheet
    {:id "main-menu" :title "Menu"}
    [:h1 "Hello world"]))

(defn shopping-cart
  []
  (shared-components/sheet
    {:id "shopping-cart" :variant :right :title "Carrinho"}
    [:h1 "Hello world"]))

(defn search-modal
  []
  (shared-components/modal
    {:id "search-modal"}
    [:h1 "Hello world"]))


(defn bottom-menu
  []
  [:div {:class "sticky bottom-0 sm:hidden grid grid-cols-4 bg-white/80 backdrop-blur border-t border-secondary-200 text-secondary-700 text-sm"}
   [:a {:class "p-2 flex flex-col gap-1 items-center" :href "/"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25"}]]
    "Home"]
   [:button {:class   "p-2 flex flex-col gap-1 items-center"
             :onclick "document.getElementById('search-modal').showModal(); document.body.style.overflow = 'hidden';"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z"}]]
    "Pesquisar"]
   [:a {:class "p-2 flex flex-col gap-1 items-center" :href "/pedidos"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M15.75 10.5V6a3.75 3.75 0 1 0-7.5 0v4.5m11.356-1.993 1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 0 1-1.12-1.243l1.264-12A1.125 1.125 0 0 1 5.513 7.5h12.974c.576 0 1.059.435 1.119 1.007ZM8.625 10.5a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm7.5 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z"}]]
    "Pedidos"]
   [:a {:class "p-2 flex flex-col gap-1 items-center" :href "/conta"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"}]]
    "Conta"]])

(defn default-layout
  [opts & content]
  (shared-layouts/base-layout
    opts
    [:div {:class "flex h-60 min-h-screen flex-col"}
     (header)
     (main-menu)
     (shopping-cart)
     (search-modal)
     [:main {:id "content" :class "flex-1"}
      content]
     (footer)
     (bottom-menu)]))


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