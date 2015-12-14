(ns demos.search
  (:require-macros [cljs.core.async.macros :as m])
  (:require [goog.dom :as dom]
            [goog.events :as events]
            [cljs.core.async :refer [<! put! chan]]
            [re-com.core :as h] [reagent.core :as r])
  (:import [goog.net Jsonp]
           [goog Uri]))

; see http://swannodette.github.io/2013/11/07/clojurescript-101/

(defonce search-req (chan))
(defonce query (r/atom ""))
(defonce results (r/atom []))

(def wiki-search-url
  "http://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=")

(defn jsonp [uri]
  (let [req (Jsonp. (Uri. uri))]
    (.send req nil (fn [res] (reset! results res)))))

(defn query-url [q]
  (str wiki-search-url q))

(defn search-btn []
  [h/button :on-click (fn [] (print "click") (put! search-req true)) :label "go"])

(defn search-field []
  [h/input-text
    :on-change #(reset! query %)
    :change-on-blur? false
    :model query])

(defn search-results []
  [h/v-box
    :children [
      (map (fn [r] [h/label :label (str r)]) @results)]])

(defn page []
  [h/h-box
    :children [
      [search-field]
      [search-btn]
      [search-results]]])

(defn go []
  (m/go
    (while true
      (<! search-req)
      (print "request")
      (jsonp (query-url @query)))))
