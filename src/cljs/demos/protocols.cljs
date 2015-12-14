(ns demos.protocols
  (:require [reagent.core :as r] [re-com.core :as h]))

(defprotocol FooPro
  (bar [this]))

(def foo (reify FooPro
  (bar [this] "foo")))

(def foo2 (reify FooPro
  (bar [this] "foo2")))

(defn page []
  [h/v-box
    :children
      (map
        (fn [f] (bar f))
        [foo foo2])])
