(ns hello-mesos.component.scheduler-driver
  (:require [com.stuartsierra.component :as component]
            [clj-mesos.scheduler :as mesos]))

(defrecord SchedulerDriver [master scheduler driver]
  component/Lifecycle
  (start [component]
    (when-not driver
      (let [driver (mesos/driver (:scheduler scheduler)
                                 {:user "" :name "hello"}
                                 master)]
        (mesos/start driver)
        (assoc component :driver driver))))
  (stop [component]
    (when driver
      (mesos/stop driver)
      (assoc component :driver nil))))

(defn new-scheduler-driver
  [master]
  (map->SchedulerDriver {:master master}))
