;;; ch14_transients.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; Simple Loop Without Transients

(loop [m {}, i 0]
  (if (> i 127)
    m
    (recur (assoc m (char i) i) (inc i))))


;;; Simple Loop With Transients

(loop [m (transient {}), i 0]
  (if (> i 127)
    (persistent! m)
    (recur (assoc! m (char i) i) (inc i))))
