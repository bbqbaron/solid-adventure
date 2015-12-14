(ns demos.multi
  (:require [reagent.core :as r][re-com.core :as h]))

(defonce animals [{:species :dog} {:species :cat} {:species :reindeer} {:species :gila-monster}])

(defmulti speak :species)

(defmethod speak :dog [_] "woof")
(defmethod speak :cat [_] "mew")
(defmethod speak :reindeer [_] "...honk?")
(defmethod speak :default [_] "stony silence")

(defonce state (r/atom ""))

(defn speak-btn [w]
  [h/button :label (str w) :on-click #(reset! state (speak w))])

(defn page []
  [h/v-box
    :children [
      [h/h-box :children (map speak-btn animals)]
      [h/label :label @state]]])
