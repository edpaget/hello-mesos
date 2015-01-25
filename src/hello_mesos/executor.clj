(ns hello-mesos.executor
  (:require [clj-mesos.executor :as mesos]))

(defn executor
  []
  (mesos/executor
   (launchTask [driver task-info]
               (println "HERE"))
   (registered [driver slave-info]
               (println slave-info))))
