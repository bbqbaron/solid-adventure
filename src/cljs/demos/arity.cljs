(ns demos.arity
  (:require [reagent.core :as r]
    [re-com.core :as h]))

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





(defonce state (r/atom "<hit a button>w"))

(defn foo
  ([a] 1)
  ([a b] 2)
  ; must have at least the arity of the previous!
  ([a b & foos] (+ 2 (count foos))))

(defn page []
  [:div
    [:p (str "# args: " @state)]
    [h/button :on-click #(reset! state (foo 0)) :label "(foo 0)"]
    [h/button :on-click #(reset! state (foo 0 0)) :label "(foo 0 0)"]
    [h/button :on-click #(reset! state (foo 0 0 0 0 0 0 0 0)) :label "(foo 0 0 0 0 0 0 0 0)"]])
