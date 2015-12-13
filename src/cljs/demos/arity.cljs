(ns demos.arity
  (:require [reagent.core :as r]))

  ; (+ 1 2)
  ; (- 3 1)
  ; (def a 1)
  ;
  ; (def foo (fn [a]
  ;   (+ 1 a)))
  ;
  ; (foo 2) ; 3
  ;
  ; (defn foo2 [a]
  ;   (+ 1 a))

  ; no return
  ; data structures
  ; [1 2 3 4 5]
  ; {:foo 1 :bar 2}
  ; keywords
  ; :a
  ; lists of fixed system stuff
  ; :div :p :input
  ; namespaced keywords
  ; ::a
  ; vs js
  ; anonymous functions
  ; #(+ 1 2) ; (#(+ 1 2)) => 3
  ; let
  ; (defn foo [a]
      ; (let [a-plus-one (+ 1 a)]
      ;   (+ 1 a-plus-one)))





(defonce state (r/atom ""))

(defn foo
  ([a] "1 arg")
  ([a b] "2 arg")
  ; must have at least the arity of the previous!
  ([a b & foos] (str (+ 2 (count foos)) " args")))

(defn page []
  [:div
    [:p @state]
    [:div {:on-click #(reset! state (foo 0))} "foo 0"]
    [:div {:on-click #(reset! state (foo 0 0))} "foo 0 0"]
    [:div {:on-click #(reset! state (foo 0 0 0 0 0 0 0 0))} "foo 0 0 0 0 0 0 0 0"]])
