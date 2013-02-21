(ns test.core
  (:require [sexprs.wrappers :as w])
  (:use-macros [test.macros :only [describe it before-each]]))

(def expect (js/require "expect.js"))
(def express (js/require "express"))
(def app (express))

;;;;;;;;;;;;;;;;;;;
;; Application
;;;;;;;;;;;;;;;;;;;

(describe "set-value"
  (it "should assign a setting value"
      (do
       (w/set-value app "title" "Canadian House of Pizza & Garbage")
       (= (aget (aget app "settings") "title") "Canadian House of Pizza & Garbage"))))

(describe "get"
  (it "should get a setting value"
      (= (w/get app "title") "Canadian House of Pizza & Garbage")))

(describe "enable"
  (it "should set a setting to true"
      (do
        (w/enable app "trust proxy")
        (aget (aget app "settings") "trust proxy"))))

(describe "disable"
  (it "should set a setting to false"
      (do
        (w/disable app "trust proxy")
        (false? (aget (aget app "settings") "trust proxy")))))

(describe "enabled"
  (it "should check if a setting is enabled"
      (false? (w/enabled app "trust proxy"))))

(describe "disabled"
  (it "should check if a setting is disabled"
      (true? (w/disabled app "trust proxy"))))

;; TK: app.configure()
;; TK: app.use()
;; TK: app.settings
;; TK: app.engine()
;; TK: app.param()

(describe "get"
  (it "should register an HTTP GET route"
      (do
        (w/GET app 
               "/chopag" 
               (fn 
                 [rq rs] 
                 (.send rs "Ontario's stripmall paradise!")))
        (and (= (.-path (first (aget (aget (aget app "_router") "map") "get"))) "/chopag")
             (= (.-method (first (aget (aget (aget app "_router") "map") "get"))) "get")))))

(describe "locals"
  (it "should contain the settings already defined"
      (let [locals (w/locals app)]
      (= (aget (aget locals "settings") "title")
         "Canadian House of Pizza & Garbage"))))

(describe "routes"
  (it "should contain the routes already defined"
      (let [routes (w/routes app)]
        (and (= (aget (first (aget routes "get")) "path")) "/chopag")
             (= (aget (first (aget routes "get")) "method") "get"))))
;
;; app.listen()


;;;;;;;;;;;;;;;;;;;
;; Request
;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;
