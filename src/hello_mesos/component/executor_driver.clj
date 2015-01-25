(ns hello-mesos.component.executor-driver
  (:require [com.stuartsierra.component :as component]
            [clj-mesos.executor :as mesos]))

(defrecord ExecutorDriver [executor driver]
  component/Lifecycle
  (start [component]
    (if driver
      (mesos/start driver)
      (let [driver (mesos/driver executor)]
        (assoc component :driver driver)
        (mesos/start driver))))
  (stop [_]
    (when driver
      (mesos/stop driver))))

(defn new-executor-driver
  [executor]
  (map->ExecutorDriver {:executor executor}))
