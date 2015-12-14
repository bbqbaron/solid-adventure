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
              [demos.multi :as multi]
              [re-com.core :as h]))

(async/go)
(chans/go)

(defn empty-page [] [:p "Nuthin'"])
(defonce state (atom {:current-page empty-page}))

(defn section-link [where title]
  [h/button
    :on-click #(swap! state (fn [s] (assoc s :current-page where)))
    :label title])

(defn home-page []
  [h/h-box
    :size "auto"
    :children [
      (section-link async/page "Async Loop")
      (section-link chans/page "Chans")
      (section-link arity/page "Arity")
      (section-link derivation/page "Derivation")
      (section-link dest/page "Destructuring")
      (section-link fun/page "Functional")
      (section-link lazy/page "Lazy")
      (section-link macros/page "Macros")
      (section-link multi/page "Multimethods")]])

(defn current-page []
  [h/v-box
    :children [
      [home-page]
      [(:current-page @state)]]])

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
