(ns sexprs.core
  (:use [sexprs.wrappers :only [send GET listen]])
  (:use-macros [sexprs.macros :only [defapp]]))

(defn hello [rq rs] (send rs "HELLO WORLD!"))
(defapp helloworld (GET "/" hello))
(listen helloworld 3000)
