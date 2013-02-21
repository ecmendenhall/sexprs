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
       ([obj#] (. obj# ~js-name))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#))))

  ([docstring js-name]
   `(defn ~js-name
       ~docstring
       ([obj#] (. obj# ~js-name))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#))))

  ([docstring js-name cljs-name]
    `(defn ~cljs-name
       ~docstring
       ([obj#] (. obj# ~js-name))
       ([obj# arg1#] (. obj# ~js-name arg1#))
       ([obj# arg1# arg2#] (. obj# ~js-name arg1# arg2#))
       ([obj# arg1# arg2# arg3#] (. obj# ~js-name arg1# arg2# arg3#)))))

(defmacro js-property
  ([docstring js-prop]
  `(defn ~js-prop
     ~docstring
     [obj#]
     (aget obj# (str '~js-prop))))

  ([docstring js-prop cljs-prop]
   `(defn ~cljs-prop
      ~docstring
     [obj#]
     (aget obj# (str '~js-prop)))))
