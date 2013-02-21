(ns sexprs.example.core
  (:use [sexprs.wrappers :only [send GET listen static]])
  (:use-macros [sexprs.macros :only [defapp use-middleware]])
  (:require [hiccups.runtime :as hiccupsrt])
  (:require-macros [hiccups.core :as hiccups]))

(defn template []
  (hiccups/html
    [:html
     [:head
      [:link {:rel "stylesheet" :href "/static/style.css"}]
      [:title "sexprs"]]
     [:body
      [:h1 "(sexprs"]
      [:h2 "(a lightweight clojurescript wrapper for " [:a {:href "http://expressjs.com/"} "express"] ")"]
      [:h1#close ")"]
      [:iframe {:width 600 
                :height 450 
                :src "http://www.youtube.com/embed/NGbUOlTLzqk"
                :frameborder 0}]]]))

(defn main-handler [req res]
  (.log js/console (str (aget req "method") "  " (aget req "url")))
  (send res (template)))

(defn send-file [req res]
  (let [file (aget (aget req "params") "file")]
    (.sendfile res (str js/__dirname "/static/" file))))

(defapp example
    (GET "/" main-handler)
    (GET "/static/:file" send-file))

(defn run-server []

  (defn get-port []
  (+ 3000 (rand-int 2000)))

  (try
    (let [port (get-port)]
      (listen example port)
      (.log js/console (str "Node server listening on port " port)))
    (catch js/Object e (do
                         (.log js/console e)
                         (recur)))))

(run-server)
