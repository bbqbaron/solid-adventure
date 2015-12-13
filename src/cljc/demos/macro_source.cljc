(ns demos.macro-source)

(defmacro infix [[first second third]] (list second first third))
