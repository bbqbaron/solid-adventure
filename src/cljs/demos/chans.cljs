(ns demos.chans
  (:require [cljs.core.async :refer [chan <! >!]]
    [reagent.core :as r] [re-com.core :as h])
  (:require-macros [cljs.core.async.macros :as m]))

(defonce my-chan (chan))

(defonce state (r/atom ""))

(defn get-msg []
  (m/go
    (reset! state (<! my-chan))
    (get-msg)))

; goodbye callback hell

(defn go []
  (get-msg))

(defn page []
  [h/h-box
    :children [
      [h/button :on-click #(reset! state "") :label "reset"]
      [h/button :on-click (fn [] (m/go (>! my-chan "hi"))) :label "send"]
      [h/label :label (str "Got: " @state)]]])
