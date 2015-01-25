(ns hello-mesos.scheduler
  (:require [clj-mesos.scheduler :as mesos]))

(defn tasks-info
  [uuid {:keys [slave-id]}]
  [{:name "hello-mesos"
    :task-id uuid
    :slave-id slave-id
    :resources {:cpus 0.5
                :mem 128.0}
    :command {:shell true
              :value "while true; do echo \"HEY\"; sleep 2; done; "}}])

(defn scheduler
  [scheduler-state]
  (mesos/scheduler
   (statusUpdate [driver status]
                 (condp = (:task-state status)
                   :task-running (println status)
                   (println status)))
   (resourceOffers [driver offers]
                   (doseq [offer offers]
                     (let [uuid (str (java.util.UUID/randomUUID))]
                       (when (< 0 (:to-launch @scheduler-state))
                         (try
                           (mesos/launch-tasks driver (:id offer) (tasks-info uuid
                                                                              offer))
                           (swap! scheduler-state update-in [:to-launch] dec)
                           (catch Exception e
                             (.printStackTrace e)))))))))
