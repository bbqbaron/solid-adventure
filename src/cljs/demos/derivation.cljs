(ns demos.derivation)

(derive ::person ::animal)
(derive ::beast ::animal)
(derive ::canine ::beast)
(derive "dog" ::canine)
(derive "squid" ::beast)
(derive ::maimonides ::person)

(defonce animals ["dog" "squid" ::maimonides])

(defmulti speak identity)

(defmethod speak ::beast [_] [:p "Do they even vocalize?"])
(defmethod speak ::canine [_] [:p "Bark, maybe?"])
(defmethod speak ::person [_] [:p "Pure erudition"])

(derive 1 ::cool)
(derive 2 ::uncool)

(defmulti is-cool identity)

(defmethod is-cool ::cool [_] "yeah!")
(defmethod is-cool ::uncool [_] "nah")
(defmethod is-cool :default [_] "meh")

(defn page []
  (reduce into [:div]
    [(map speak animals)
    (map (comp (partial into [:p]) is-cool) [1 2])]))
