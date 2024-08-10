(ns ces.pages.shop.login
  (:require [ces.pages.shared.components :as shared-components]
            [ces.pages.shop.layouts :as shop-layouts]
            [struct.core :as st]
            [ces.pages.shared.utils :refer [validate make-title encode-uri]]
            [ces.responses :as responses]))


(defn form
  ([] (form {}))
  ([data]
   [:form {:class "space-y-3 w-full"
           :hx-post (str "/entrar/partials/form?return-url=" (encode-uri (get data :return-url "/")))
           :hx-swap "outerHTML transition:true"}
    (shared-components/text-input-with-auto-error-removal
      {:placeholder "voce@email.com"
       :type        "email"
       :name        "email"
       :value       (get-in data [:values :email] "")
       :errors      (get-in data [:errors :email])})
    (shared-components/text-input-with-auto-error-removal
      {:placeholder "Sua senha"
       :type        "password"
       :name        "password"
       :value       (get-in data [:values :password] "")
       :errors      (get-in data [:errors :password])})
    (shared-components/error-messages (get-in data [:top-level :errors]))
    (shared-components/button {:type "submit" :class "w-full"} "Entrar")]))


(defn content
  [context] 
  (list 
    (shared-components/button
          {:hx-replace-url (str "/crie-sua-conta?return-url=" (get context :return-url "/"))
           :hx-get (str "/crie-sua-conta/partials/content?return-url=" (get context :return-url "/"))
           :hx-target "#content"
           :hx-swap "innerHTML transition:true"
           :class   "absolute top-6 right-6"
           :variant :ghost}
          "Crie sua conta")

    [:h1 {:class "font-semibold text-2xl"} "Entrar"]

    [:p {:class "text-gray-500"} "Entre com seu email e senha."]

    [:div {:class "mt-4 w-full max-w-96"}
     (form {:return-url (:return-url context)})

     [:div {:class "my-4 flex items-center gap-4 before:h-px before:flex-1 before:bg-gray-300 before:content-[''] after:h-px after:flex-1 after:bg-gray-300 after:content-['']"}
      "Ou continue com"]

     [:div {:class "flex gap-2 flex-wrap"}
      (shared-components/link-button
        {:href    (:google-redirect-url context)
         :class   "flex-1 min-w-fit inline-flex items-center justify-center gap-1.5"
         :variant :outline}
        [:svg {:xmlns "http://www.w3.org/2000/svg" :height "16" :viewBox "0 0 24 24" :width "16" :class "size-4"}
         [:path {:d "M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z" :fill "#4285F4"}]
         [:path {:d "M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z" :fill "#34A853"}]
         [:path {:d "M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z" :fill "#FBBC05"}]
         [:path {:d "M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z" :fill "#EA4335"}]
         [:path {:d "M1 1h22v22H1z" :fill "none"}]]
        "Google")

      (shared-components/link-button
        {:href    (:facebook-redirect-url context)
         :class   "flex-1 min-w-fit inline-flex items-center justify-center gap-1.5"
         :variant :outline}
        [:svg {:xmlns "http://www.w3.org/2000/svg" :xml:space "preserve" :width "16" :height "16" :style "shape-rendering:geometricPrecision;text-rendering:geometricPrecision;image-rendering:optimizeQuality;fill-rule:evenodd;clip-rule:evenodd" :viewBox "0 0 14222 14222" :class "size-4"}
         [:path {:d "M14222 7111C14222 3184 11038 0 7111 0S0 3184 0 7111c0 3549 2600 6491 6000 7025V9167H4194V7111h1806V5544c0-1782 1062-2767 2686-2767 778 0 1592 139 1592 139v1750h-897c-883 0-1159 548-1159 1111v1334h1972l-315 2056H8222v4969c3400-533 6000-3475 6000-7025z" :style "fill:#1977f3;fill-rule:nonzero"}]
         [:path {:d "m9879 9167 315-2056H8222V5777c0-562 275-1111 1159-1111h897V2916s-814-139-1592-139c-1624 0-2686 984-2686 2767v1567H4194v2056h1806v4969c362 57 733 86 1111 86s749-30 1111-86V9167h1657z" :style "fill:#fefefe;fill-rule:nonzero"}]
         ]
        "Facebook")]

     [:p {:class "text-gray-500 mt-8 text-center"}
      "Ao clicar em continuar, Você está concordando com nossos "
      (shared-components/link {:href "/termos-de-uso"} "Termos de uso")
      " e "
      (shared-components/link {:href "/politica-de-privacidade"} "Política de Privacidade")]]))


(defn page [context]
  (shop-layouts/auth-layout {:title "Login"} (content context)))


(defn handler [request]
  (let [return-url (get-in request [:query-params :return-url] "/")]
    (responses/ok (page {:return-url            return-url
                         :google-redirect-url   "www.google.com"
                         :facebook-redirect-url "www.facebook.com"}))))


(defn content-handler [request]
  (let [return-url (get-in request [:query-params :return-url] "/")]
    (responses/ok (list [:title (make-title :page-title "Entrar")]
                        (content {:return-url            return-url
                                  :google-redirect-url   "www.google.com"
                                  :facebook-redirect-url "www.facebook.com"})))))

(def login-schema
  {:email    [[st/required :message "Digite seu email para entrar"]]
   :password [[st/required :message "Digite sua senha para entrar"]]})

(defn form-handler [request]
  (let [return-url (get-in request [:query-params :return-url] "/")
        result (-> request
                   (:form-params)
                   (validate login-schema)
                   (conj {:return-url return-url}))]
    (if (:valid? result)
      (responses/ok {"HX-Redirect" return-url} (form result))
      (responses/ok (form result)))))
