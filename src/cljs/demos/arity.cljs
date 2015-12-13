(ns demos.arity
  (:require [reagent.core :as r]))

(defonce state (r/atom ""))

(defn foo
  ([a] "1 arg")
  ([a b] "2 arg")
  ; must have at least the arity of the previous!
  ([a b & args] (str (+ 2 (count args)) " args")))

(defn page []
  [:div
    [:p @state]
    [:div {:on-click #(reset! state (foo 0))} "foo 0"]
    [:div {:on-click #(reset! state (foo 0 0))} "foo 0 0"]
    [:div {:on-click #(reset! state (foo 0 0 0 0 0 0 0 0))} "foo 0 0 0 0 0 0 0 0"]])
