(ns ces.pages.shop.layouts
  (:require [ces.pages.shared.components :as shared-components]
            [ces.pages.shared.layouts :as shared-layouts]
            [ces.pages.shared.utils :refer [make-title format-currency]]))

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
     (menu-button)]
    [:a {:href  "/"
         :title (make-title)}
     (shared-components/logo {:class "h-5 w-auto"})]
    [:div {:class "flex gap-4"}
     (cart-button)
     (search-button)]]])


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

(defn user-menu-section
  ([]
   [:div {:class "p-4 border-b border-secondary-100 flex gap-4 items-center"}
    (shared-components/avatar)
    [:div {:class "flex flex-col gap-2 flex-1"}
     [:span.skeleton.text {:class "w-10/12"}]
     [:span.skeleton.text.xs {:class "w-8/12"}]]])
  ([data]
   [:a {:href "/conta" :class "p-4 border-b border-secondary-100 flex gap-4 items-center hover:bg-secondary-50 transition-color"}
    (if (nil? data)
      (shared-components/avatar)
      (shared-components/avatar (:avatar-url data)))
    [:div {:class "flex flex-col flex-1"}
     [:span {:class "text-secondary-800 font-medium"}
      (if (nil? data) "Bem vindo" (:full-name data))]
     [:span {:class "text-secondary-500 text-sm"}
      (if (nil? data) "Entre para ver seus pedidos" "Bem vindo!")]]]))

(defn links-menu-section
  []
  [:div {:class "border-b border-secondary-100 flex flex-col"}
   [:a {:href "/pedidos" :class "p-4 flex gap-4 items-center text-secondary-700 hover:bg-secondary-50 hover:text-secondary-800 transition-colors"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M15.75 10.5V6a3.75 3.75 0 1 0-7.5 0v4.5m11.356-1.993 1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 0 1-1.12-1.243l1.264-12A1.125 1.125 0 0 1 5.513 7.5h12.974c.576 0 1.059.435 1.119 1.007ZM8.625 10.5a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm7.5 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z"}]]
    "Seus Pedidos"]
   [:a {:href "/ofertas" :class "p-4 flex gap-4 items-center text-secondary-700 hover:bg-secondary-50 hover:text-secondary-800 transition-colors"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m8.99 14.993 6-6m6 3.001c0 1.268-.63 2.39-1.593 3.069a3.746 3.746 0 0 1-1.043 3.296 3.745 3.745 0 0 1-3.296 1.043 3.745 3.745 0 0 1-3.068 1.593c-1.268 0-2.39-.63-3.068-1.593a3.745 3.745 0 0 1-3.296-1.043 3.746 3.746 0 0 1-1.043-3.297 3.746 3.746 0 0 1-1.593-3.068c0-1.268.63-2.39 1.593-3.068a3.746 3.746 0 0 1 1.043-3.297 3.745 3.745 0 0 1 3.296-1.042 3.745 3.745 0 0 1 3.068-1.594c1.268 0 2.39.63 3.068 1.593a3.745 3.745 0 0 1 3.296 1.043 3.746 3.746 0 0 1 1.043 3.297 3.746 3.746 0 0 1 1.593 3.068ZM9.74 9.743h.008v.007H9.74v-.007Zm.375 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm4.125 4.5h.008v.008h-.008v-.008Zm.375 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z"}]]
    "Ofertas"]
   [:a {:href "/mais-vendidos" :class "p-4 flex gap-4 items-center text-secondary-700 hover:bg-secondary-50 hover:text-secondary-800 transition-colors"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M9.813 15.904 9 18.75l-.813-2.846a4.5 4.5 0 0 0-3.09-3.09L2.25 12l2.846-.813a4.5 4.5 0 0 0 3.09-3.09L9 5.25l.813 2.846a4.5 4.5 0 0 0 3.09 3.09L15.75 12l-2.846.813a4.5 4.5 0 0 0-3.09 3.09ZM18.259 8.715 18 9.75l-.259-1.035a3.375 3.375 0 0 0-2.455-2.456L14.25 6l1.036-.259a3.375 3.375 0 0 0 2.455-2.456L18 2.25l.259 1.035a3.375 3.375 0 0 0 2.456 2.456L21.75 6l-1.035.259a3.375 3.375 0 0 0-2.456 2.456ZM16.894 20.567 16.5 21.75l-.394-1.183a2.25 2.25 0 0 0-1.423-1.423L13.5 18.75l1.183-.394a2.25 2.25 0 0 0 1.423-1.423l.394-1.183.394 1.183a2.25 2.25 0 0 0 1.423 1.423l1.183.394-1.183.394a2.25 2.25 0 0 0-1.423 1.423Z"}]]
    "Mais Vendidos"]
   [:a {:href "/sobre/contato" :class "p-4 flex gap-4 items-center text-secondary-700 hover:bg-secondary-50 hover:text-secondary-800 transition-colors"}
    [:svg {:class "size-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M20.25 8.511c.884.284 1.5 1.128 1.5 2.097v4.286c0 1.136-.847 2.1-1.98 2.193-.34.027-.68.052-1.02.072v3.091l-3-3c-1.354 0-2.694-.055-4.02-.163a2.115 2.115 0 0 1-.825-.242m9.345-8.334a2.126 2.126 0 0 0-.476-.095 48.64 48.64 0 0 0-8.048 0c-1.131.094-1.976 1.057-1.976 2.192v4.286c0 .837.46 1.58 1.155 1.951m9.345-8.334V6.637c0-1.621-1.152-3.026-2.76-3.235A48.455 48.455 0 0 0 11.25 3c-2.115 0-4.198.137-6.24.402-1.608.209-2.76 1.614-2.76 3.235v6.226c0 1.621 1.152 3.026 2.76 3.235.577.075 1.157.14 1.74.194V21l4.155-4.155"}]]
    "Contato"]])

(defn category-accordion
  [major-category]
  [:details {:class "text-secondary-700"}
   [:summary {:class "cursor-pointer px-4 py-2 hover:bg-secondary-50 transition-colors select-none flex items-center justify-between"}
    (:title major-category)
    [:svg {:data-accordion-icon-open "" :class "size-4" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m19.5 8.25-7.5 7.5-7.5-7.5"}]]
    [:svg {:data-accordion-icon-close "" :class "size-4" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
     [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m4.5 15.75 7.5-7.5 7.5 7.5"}]]]
   [:div {:class "w-full flex flex-col"}
    (for [sub (:sub-categories major-category)]
      [:a {:href  (str "/categorias/" (:slug major-category) "/" (:slug sub))
           :class "block px-8 py-2 w-full hover:bg-secondary-50 transition-colors"}
       (:title sub)])
    [:a {:href  (str "/categorias/" (:slug major-category))
         :class "block px-8 py-2 w-full hover:bg-secondary-50 transition-colors"}
     "Ver tudo"]]])

(defn categories-menu-section
  ([]
   [:div {:class "flex-1 flex flex-col overflow-y-auto"}
    [:span {:class "font-medium text-secondary-700 p-4"}
     "Categorias"]
    [:ul {:class "space-y-2 w-full"}
     (for [i (take 12 (range))]
       [:li {:class "py-2 px-4 w-full"}
        [:div.skeleton.text {:style (str "width: " (+ 60 (rand-int 39)) "%")}]])]])
  ([major-categories]
   [:div {:class "flex-1 flex flex-col overflow-y-auto"}
    [:span {:class "font-medium text-secondary-700 p-4"}
     "Categorias"]
    (for [major major-categories]
      (category-accordion major))]))

(defn main-menu
  []
  (shared-components/sheet
    {:id "main-menu" :title "Menu"}
    (user-menu-section {:full-name  "Mateus Ryan"
                        :avatar-url "https://avatars.githubusercontent.com/u/46976272?v=4&size=64"})
    (links-menu-section)
    (categories-menu-section
      (list {:title          "Cabelos"
             :slug           "cabelos"
             :sub-categories (list {:title "Shapoos" :slug "shampoos"}
                                   {:title "Leve-in" :slug "leve-in"})}
            {:title          "Maquiagem"
             :slug           "maquiagem"
             :sub-categories (list {:title "Batoms" :slug "batoms"}
                                   {:title "Base" :slug "base"})}))))

(defn shopping-cart-list
  ([]
   [:ul {:class "flex-1 w-full overflow-y-auto"}
    (for [i (take 5 (range))]
      [:li {:class "w-full p-4 flex gap-4"}
       ;; Thumb
       [:div.skeleton {:class "size-20 sm:size-24 rounded-md self-center"}]

       ;; Info
       [:div {:class "flex-1 flex flex-col gap-2"}
        [:span.skeleton.text.sm {:class "w-10/12"}]
        [:span.skeleton.text.sm {:class "mt-1 w-8/12"}]
        [:div {:class "flex gap-2 items-end mt-2"}
         [:span.skeleton.text.sm {:class "w-[6ch]"}]
         [:span.skeleton.text.xs {:class "w-[6ch]"}]]]

       ;; Count control
       [:div {:class "flex flex-col items-center gap-3 self-center text-secondary-800"}
        [:div.skeleton {:class "size-6 rounded-full"}]
        [:span.skeleton.text.sm {:class "w-[1ch]"}]
        [:div.skeleton {:class "size-6 rounded-full"}]]])])
  ([items]
   (if (= (count items) 0)
     [:div {:class "flex-1 w-full flex flex-col items-center justify-center text-center text-secondary-500 gap-8"}
      [:svg {:class "size-24 text-secondary-300" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
       [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 0 0-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 0 0-16.536-1.84M7.5 14.25 5.106 5.272M6 20.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Zm12.75 0a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Z"}]]
      [:span {:class "max-w-[30ch]"}
       "Adicione items ao seu carrinho para iniciar um pedido"]]
     [:ul {:class "flex-1 w-full overflow-y-auto"}
      (for [item items]
        [:li {:class "w-full p-4 flex gap-4"}
         ;; Thumb
         [:img {:src   (:thumb item)
                :class "size-20 sm:size-24 rounded-md object-cover object-center self-center"}]

         ;; Info
         [:div {:class "flex-1 flex flex-col gap-2"}
          [:span {:class "font-medium text-secondary-700 line-clamp-2"}
           (:title item)]
          [:div {:class "flex gap-2 items-end"}
           [:span {:class "font-semibold text-secondary-800"}
            (format-currency (:final-price item))]
           [:span {:class "text-xs text-secondary-500 line-through"}
            (format-currency (:original-price item))]]]

         ;; Count control
         [:div {:class "flex flex-col items-center gap-3 self-center text-secondary-800"}
          [:button {:class "rounded-full border border-secondary-200 p-1 bg-white hover:bg-gray-100 focus:ring focus:ring-gray-100 disabled:cursor-not-allowed disabled:border-gray-100 disabled:bg-gray-50 disabled:text-gray-400 shadow-sm"}
           [:svg {:class "size-4" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
            [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M12 4.5v15m7.5-7.5h-15"}]]]
          [:span {:class "text-secondary-700 font-medium"}
           (:count item)]
          [:button {:class "rounded-full border border-secondary-200 p-1 bg-white hover:bg-gray-100 focus:ring focus:ring-gray-100 disabled:cursor-not-allowed disabled:border-gray-100 disabled:bg-gray-50 disabled:text-gray-400 shadow-sm"}
           (if (<= 2 (:count item))
             [:svg. {:class "size-4" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
              [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M5 12h14"}]]
             [:svg {:class "size-4" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
              [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0"}]])]]])])))

(defn shopping-cart-calculate-delivery
  [items]
  [:div {:class "p-4 border-t border-secondary-200 flex gap-4 text-secondary-700"}
   [:div {:class "w-full"}
    [:div {:class "flex gap-4 justify-between items-center"}
     [:span {:class "font-medium"} "Calcule seu Frete"]
     [:a {:title "Como descobrir meu CEP?"
          :target "_blank"
          :href  "https://buscacepinter.correios.com.br/app/endereco/index.php"
          :class "flex gap-2 items-center"}
      [:span {:class "text-sm text-secondary-500"} "Não sei meu CEP"]
      [:span {:class "flex items-center justify-center size-5 text-white bg-secondary-400 text-xs rounded-full"} "?"]]]
    [:form {:class "flex gap-2 w-full mt-4"}
     (shared-components/text-input {:type "text" :name "cep" :placeholder "Digite seu CEP" :class "flex-1"})
     (shared-components/button {:variant :secondary} "Calcular")]]])

(defn shopping-cart-action-buttons
  [items]
  [:div {:class "p-4 border-t border-secondary-200 flex flex-wrap-reverse gap-4 bg-secondary-50"}
   (shared-components/button
     {:class "flex-1 min-w-fit text-nowrap" :variant :outline :onclick "document.getElementById('shopping-cart').close();"}
     "Continuar comprando")
   (when-not (= (count items) 0)
     (shared-components/button
       {:class "flex-1 flex gap-2 items-center justify-center min-w-fit text-nowrap"}
       [:svg {:class "size-5" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke-width "1.5" :stroke "currentColor"}
        [:path {:stroke-linecap "round" :stroke-linejoin "round" :d "M15.75 10.5V6a3.75 3.75 0 1 0-7.5 0v4.5m11.356-1.993 1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 0 1-1.12-1.243l1.264-12A1.125 1.125 0 0 1 5.513 7.5h12.974c.576 0 1.059.435 1.119 1.007ZM8.625 10.5a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm7.5 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z"}]]
       "Finalizar compra"))])

(defn shopping-cart
  []
  (shared-components/sheet
    {:id "shopping-cart" :variant :right :title "Carrinho" :style "max-width: 500px"}
    (let [items (list {:title          "Combo Siàge Pro Cronology Cronograma Capilar Acelerado Completo (4 itens)"
                       :count          1
                       :original-price 387.87
                       :final-price    287.87
                       :thumb          "https://nagtgkjtgxsetolrcdhw.supabase.co/storage/v1/object/public/images/91ab0668-cca4-4655-bc84-20169ac636a0.webp"}
                      {:title          "Eudora H Refresh Desodorante Colônia 100ml"
                       :count          2
                       :original-price 99.90
                       :final-price    89.90
                       :thumb          "https://nagtgkjtgxsetolrcdhw.supabase.co/storage/v1/object/public/images/4ce1be4d-5b00-4651-b4f2-6292c9fc0611.webp"})]
      (list
        (shopping-cart-list items)
        (shopping-cart-calculate-delivery items)
        (shopping-cart-action-buttons items)))))

(defn search-modal
  []
  (shared-components/modal
    {:id "search-modal"}
    [:h1 "Hello"]))


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
     (search-modal)
     [:main {:id "content" :class "flex-1"}
      content]
     (footer)
     (bottom-menu)
     (main-menu)
     (shopping-cart)]))


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