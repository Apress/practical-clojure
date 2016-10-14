;;; ch13_pair_type.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; The Pair Datatype (page 182) 

(defrecord Pair [x y]
  java.lang.Comparable
    (compareTo [this other]
       (let [result (compare x (:x other))]
         (if (zero? result)
           (compare y (:y other))
           result))))
