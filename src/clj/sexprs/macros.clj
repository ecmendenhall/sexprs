(ns sexprs.macros)

(defmacro defapp [app-name & routes]
  `(do
     (def express# (js/require "express"))
     (def ~app-name (express#))
     (-> ~app-name
       ~@routes)))

(defmacro js-alias
  ([js-name]
   `(defn ~js-name
       ([obj#] (. ~js-name obj#))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#))))

  ([docstring js-name]
   `(defn ~js-name
       ~docstring
       ([obj#] (. ~js-name obj#))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#))))

  ([docstring js-name cljs-name]
    `(defn ~cljs-name
       ~docstring
       ([obj#] (. ~js-name obj#))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#)))))
