(ns test.macros)

(defmacro describe [thing & test-body]
  `(~'js/describe ~thing (fn [] ~@test-body)))

(defmacro it [should-do this-thing]
  `(~'js/it ~should-do
      (fn []
        (. (aget (~'expect ~this-thing) "to") ~'be true))))

(defmacro before-each [do-this-stuff]
  `(~'beforeEach
     (fn []
       ~@do-this-stuff nil) nil))
