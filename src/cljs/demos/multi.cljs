(ns demos.multi)

(defonce animals [{:species :dog} {:species :cat} {:species :reindeer} {:species :gila-monster}])

(defmulti speak :species)

(defmethod speak :dog [_] "woof")
(defmethod speak :cat [_] "mew")
(defmethod speak :reindeer [_] "...honk?")
(defmethod speak :default [_] "stony silence")

(defn page [] [:div
  (map (fn [a] [:p (speak a)]) animals)])
