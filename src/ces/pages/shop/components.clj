(ns ces.pages.shop.components)

(defn logo [attributes]
  [:svg {:viewBox "0 0 127.182 20"
         :fill    "none"
         :stroke  "currentColor"
         :xmlns   "http://www.w3.org/2000/svg"
         :class   (get attributes :class "")}
   [:path {:d                "M15 6v12a3 3 0 1 0 3-3H6a3 3 0 1 0 3 3V6a3 3 0 1 0-3 3h12a3 3 0 1 0-3-3"
           :style            "stroke-width:2.13543;stroke-dasharray:none;"
           :transform        "matrix(.79477 0 0 .79477 .463 .463)"
           :data-v-inspector "components/Logo.vue:7:5"}]
   [:path {:d                "M34.686 4.598h9.182V6.25h-7.217v4.3h6.916v1.653H36.65v5.262h7.392v1.654h-9.357zm11.604 8.268h5.243v1.595H46.29zm15.933-4.222v1.673q-.759-.418-1.527-.622-.759-.214-1.537-.214-1.741 0-2.704 1.109-.963 1.099-.963 3.093t.963 3.103q.963 1.099 2.704 1.099.778 0 1.537-.205.768-.214 1.527-.632v1.654q-.75.35-1.556.525-.798.175-1.703.175-2.46 0-3.91-1.546-1.45-1.547-1.45-4.173 0-2.665 1.46-4.193 1.469-1.527 4.017-1.527.827 0 1.615.175.788.166 1.527.506zm7.334.837q-1.44 0-2.276 1.128-.837 1.119-.837 3.074 0 1.955.827 3.083.837 1.119 2.286 1.119 1.43 0 2.266-1.129.837-1.128.837-3.073 0-1.936-.837-3.064-.836-1.138-2.266-1.138zm0-1.518q2.334 0 3.667 1.518 1.332 1.517 1.332 4.202 0 2.675-1.332 4.202-1.333 1.517-3.667 1.517-2.344 0-3.677-1.517-1.323-1.527-1.323-4.202 0-2.685 1.323-4.202 1.333-1.518 3.677-1.518zm16.448 2.354q.671-1.206 1.605-1.78.934-.574 2.198-.574 1.702 0 2.626 1.197.924 1.186.924 3.385v6.575H91.56v-6.517q0-1.566-.554-2.325-.555-.758-1.693-.758-1.39 0-2.198.924-.807.924-.807 2.519v6.157h-1.8v-6.517q0-1.576-.554-2.325-.555-.758-1.712-.758-1.372 0-2.18.933-.806.924-.806 2.51v6.157h-1.8V8.226h1.8v1.692q.612-1.001 1.468-1.478.856-.477 2.033-.477 1.187 0 2.014.603.836.603 1.235 1.751zm19.405 0q.671-1.206 1.605-1.78.934-.574 2.198-.574 1.702 0 2.627 1.197.924 1.186.924 3.385v6.575h-1.8v-6.517q0-1.566-.554-2.325-.555-.758-1.693-.758-1.39 0-2.198.924-.807.924-.807 2.519v6.157h-1.8v-6.517q0-1.576-.554-2.325-.555-.758-1.712-.758-1.372 0-2.18.933-.806.924-.806 2.51v6.157h-1.8V8.226h1.8v1.692q.612-1.001 1.468-1.478.856-.477 2.033-.477 1.187 0 2.014.603.836.603 1.235 1.751zm20.242 2.909v.875h-8.23q.117 1.848 1.11 2.82 1.001.964 2.781.964 1.032 0 1.994-.253.973-.253 1.926-.759v1.693q-.963.408-1.974.622-1.012.214-2.053.214-2.606 0-4.133-1.517-1.518-1.518-1.518-4.105 0-2.675 1.44-4.24 1.45-1.577 3.9-1.577 2.198 0 3.473 1.42 1.284 1.41 1.284 3.843zm-1.79-.526q-.02-1.468-.827-2.344-.797-.875-2.12-.875-1.498 0-2.403.846-.895.846-1.03 2.383zm11.04-2.801q-.302-.175-.662-.253-.35-.087-.778-.087-1.517 0-2.334.992-.807.982-.807 2.83v5.74h-1.8V8.225h1.8v1.692q.564-.992 1.468-1.468.905-.487 2.199-.487.184 0 .408.03.224.019.496.068zm9.28-1.255v1.673q-.76-.418-1.528-.622-.759-.214-1.537-.214-1.74 0-2.704 1.109-.963 1.099-.963 3.093t.963 3.103q.963 1.099 2.704 1.099.778 0 1.537-.205.769-.214 1.527-.632v1.654q-.749.35-1.556.525-.798.175-1.702.175-2.461 0-3.91-1.546-1.45-1.547-1.45-4.173 0-2.665 1.46-4.193 1.468-1.527 4.017-1.527.826 0 1.614.175.788.166 1.527.506zm12.43 4.582v.875h-8.229q.117 1.848 1.11 2.82 1.001.964 2.781.964 1.031 0 1.994-.253.973-.253 1.926-.759v1.693q-.963.408-1.975.622-1.011.214-2.052.214-2.607 0-4.134-1.517-1.517-1.518-1.517-4.105 0-2.675 1.44-4.24 1.449-1.577 3.9-1.577 2.198 0 3.472 1.42 1.284 1.41 1.284 3.843zm-1.79-.526q-.019-1.468-.826-2.344-.798-.875-2.12-.875-1.499 0-2.403.846-.895.846-1.031 2.383z"
           :style            "font-size:19.9206px;fill:currentColor;stroke-width:.627419;"
           :aria-label       (get attributes :aria-label "")
           :transform        "matrix(.79477 0 0 .79477 .463 .463)"
           :data-v-inspector "components/Logo.vue:8:5"}]])


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
     (logo {:class "h-5 w-auto"})]

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
       (logo {:class "h-5 mb-4 text-secondary-700"})
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