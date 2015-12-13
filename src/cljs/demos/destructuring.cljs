(ns demos.destructuring)

(defonce input {
  :foo {
    :bar {
      :baz [1 2 3]
    }
  }
  :quux ["quux1" "quux2" "quux3"]
})

(defn input-view
  [
    {{ { [a b c] :baz :as bar } :bar :as foo } :foo [first-quux second-quux third-quux] :quux :as data}
  ]
    [:div
      [:p (str "Data: " data)]
      [:p (str "Foo: " foo)]
      [:p (str "Bar: " bar)]
      [:p (str "Baz: A: " a " B: " b " C: " c)]
      [:p (str "Quux: " [first-quux second-quux third-quux])]])

(defn page [] (input-view input))
