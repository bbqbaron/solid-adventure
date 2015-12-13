(ns demos.functional)

(defn page []
  [:div
    (map
      (fn [fun] (->> (fun) str (into [:p])))
      [
        ; anonymous variadic functions with #
        #(map (partial + 1) [1 2 3 4 5])
        ; _.map([1,2,3,4,5], function (a) { return a + 1;});
        ; two-form reduce
        #(reduce + [1 2 3 4 5])
        #(reduce + 1 [1 2 3 4 5])
        ; _.reduce([1,2,3,4,5], function (a,b) {return a+b;})
        ; partials aren't as easy as i'd like
        #(filter (partial = 2) [0 2 3 2 4 2 5 2])
        ; _.filter([1,2,3,4,5], function (a) { return a === 2;})
        ; i wish clojure had better partials and composition
        ; : /
        #(map (apply comp (map (partial apply partial) [[+ 2] [- 3]])) [1 2 3])
        ; haskell version
        ; map ((+ 2) . (- 3)) [1, 2, 3]
        ; addTopping topping sandwich = ...
        ; map (addTopping wensleydale) [sandwich1, sandwich2]
        ; js
        ; _.map([1,2,3], function (a) { return 3 - a + 2; })
      ])])
