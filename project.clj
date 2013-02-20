(defproject sexprs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1535"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj"]
  :cljsbuild {
    :builds [{
      :source-paths ["src/cljs"]
      :compiler {
        :output-to "resources/public/sexprs.js"
        :optimizations :whitespace
        :pretty-print true}}]})
