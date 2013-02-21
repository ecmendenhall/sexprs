(defproject sexprs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1535"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj" "test/clj"]
  :cljsbuild {
    :test-commands {"tests" ["mocha" "test/js/test"]}
    :builds {
             :dev {:source-paths ["src/cljs"]
                   :compiler {
                     :output-to "resources/public/sexprs.js"
                     :optimizations :simple
                     :pretty-print true}}

             :app {:source-paths ["example/cljs" "src/cljs"]
                   :compiler {
                     :output-to "example/example.js"
                     :optimizations :simple
                     :pretty-print true}}

             :test {:source-paths ["test/cljs"]
                    :compiler {
                      :output-to "test/js/test.js"
                      :optimizations :simple
                      :pretty-print true}}}})
