(defproject hello-mesos "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "MIT"
            :url "https://github.com/edpaget/hello-mesos/LICENSE"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.7"]]
                   :source-paths ["dev"]}
             :user {:plugins [[cider/cider-nrepl "0.9.0-SNAPSHOT"]]}})
