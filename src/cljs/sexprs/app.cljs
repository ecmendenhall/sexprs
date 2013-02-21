(ns sexprs.app
  (:use [sexprs.wrappers :only [send GET listen]])
  (:use-macros [sexprs.macros :only [defapp]]))

(defn testapp []
  (defn hello [rq rs] (send rs "HELLO WORLD!"))
  (defapp helloworld (GET "/" hello))
  (do (listen helloworld 3000)))
