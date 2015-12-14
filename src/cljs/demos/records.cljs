(ns demos.records (:require [re-com.core :as h]))

(defprotocol Animal
  (speak [this])
  (legs [this]))

(deftype DuckRecord [voice] Animal
  (speak [this] voice))

(defn page []
  [h/v-box
    :children [
      [h/label :label (str "A Duck says: " (-> (DuckRecord. "quack") speak))]]])
