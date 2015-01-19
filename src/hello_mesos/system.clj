(ns hello-mesos.system
  (:require [com.stuartsierra.component :as component]
            [hello-mesos.component.mesos-master :refer [new-master]]
            [hello-mesos.component.scheduler :refer [new-scheduler]]))

(defn executor-crawl
  [command id uri name]
  {:executor-id }
  )

(defn execture-render)

(defn system
  [{:keys [master url]}
   {:or {url "http://mesosphere.io"}}]
  (component/system-map
   :master (new-master master)
   :scheduler (component/using
               (new-scheduler )))
  )

(defn -main
  [master & [tasks & _]]
  
  )
