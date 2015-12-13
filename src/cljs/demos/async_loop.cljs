(ns demos.async-loop
  (:require-macros [cljs.core.async.macros :refer [go-loop]])
  (:require
    [cljs.core.async :refer [<! timeout]]
    [reagent.core :as r]))

(enable-console-print!)

(defn every-x [x fun]
  (go-loop []
    (<! (timeout 500))
    (fun)
    (recur)))

(defonce counter (r/atom 0))

(defn go []
  (every-x 500 #(swap! counter inc)))

(defn page[]
  (fn []
    [:h2 @counter]))
