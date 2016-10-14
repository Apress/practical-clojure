;;; ch14_gcd.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; Euclid's Algorithm with Primitive Integers

(defn gcd [a b]
  (loop [a (int a), b (int b)]
    (cond (zero? a) b
          (zero? b) a
          (> a b) (recur (- a b) b)
          :else (recur a (- b a)))))
