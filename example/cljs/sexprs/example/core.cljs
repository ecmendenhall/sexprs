(ns sexprs.example.core
  (:use [sexprs.wrappers :only [send GET listen]])
  (:use-macros [sexprs.macros :only [defapp]]))

(defn say-hi [req res]
  (send res "Hello world!"))

(defapp hello
    (GET "/" say-hi))

(listen hello 3000)
