(ns demos.lazy)

(defonce zeroes (repeat 0))
(defonce numbers (cycle [1 2 3]))
(defonce reduce-it (reductions + (repeat 1)))

(defn page []
  [:div
    [:p (str (take 10 zeroes))]
    [:p (str (take 15 numbers))]
    [:p (str (take 10 reduce-it))]
    [:p (str (take 30 reduce-it))]])
