(ns demos.chans
  (:require [cljs.core.async :refer [chan <! >!]]
    [reagent.core :as r])
  (:require-macros [cljs.core.async.macros :as m]))

(defonce my-chan (chan))

(defonce state (r/atom "so lonely"))

(defn get-msg []
  (m/go
    (reset! state (<! my-chan))
    (get-msg)))

(defn go []
  (get-msg))

(defn page []
  [:div
    [:div {:on-click #(reset! state "")} [:p "reset"]]
    [:div {:on-click (fn [] (m/go (>! my-chan "hi")))} [:p "send"]]
    [:p @state]])
