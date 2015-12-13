(ns demos.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [demos.arity :as arity]
              [demos.async-loop :as async]
              [demos.chans :as chans]
              [demos.derivation :as derivation]
              [demos.destructuring :as dest]
              [demos.functional :as fun]
              [demos.lazy :as lazy]
              [demos.macros :as macros]
              [demos.multi :as multi]))

(async/go)
(chans/go)

(defn empty-page [] [:p "Nuthin'"])
(defonce state (atom {:current-page empty-page}))

(defn section-link [where title]
  [:div
    {:on-click #(swap! state (fn [s] (assoc s :current-page where)))}
    [:p title]])

(defn home-page []
  [:div
    [:h2 "Welcome to demos"]
    (section-link async/page "Async")
    (section-link chans/page "Chans")
    (section-link arity/page "Arity")
    (section-link derivation/page "Derivation")
    (section-link dest/page "Destructuring")
    (section-link fun/page "Functional")
    (section-link lazy/page "Lazy")
    (section-link macros/page "Macros")
    (section-link multi/page "Multimethods")])

(defn current-page []
  [:div
    [home-page]
    [(:current-page @state)]])

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
