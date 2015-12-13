(ns demos.macros
  (:require-macros [demos.macro-source :as m]))

(defn page []
  [:p (m/infix (1 + 1))])
