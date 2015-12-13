(ns demos.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [demos.arity :as arity]
              [demos.async-loop :as async]
              [demos.chans :as chans]))

(async/go)
(chans/go)

(defn empty-page [] [:p "Nuthin'"])
(defonce state (atom {:current-page empty-page}))

;; -------------------------
;; Views

(defn section-link [where title]
  [:div
    {:on-click #(swap! state (fn [s] (assoc s :current-page where)))}
    [:p title]])

(defn home-page []
  [:div
    [:h2 "Welcome to demos"]
    (section-link empty-page "Empty")
    (section-link async/page "Async")
    (section-link chans/page "Chans")
    (section-link arity/page "Arity")])

(defn current-page []
  [:div
    [home-page]
    [(:current-page @state)]
    ])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
