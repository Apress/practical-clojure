;;; ch07_even_odd.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; Forward Declarations (page 122)

(declare is-even? is-odd?)

(defn is-even? [n]
  (if (= n 2) true
     (is-odd? (dec n))))

(defn is-odd? [n]
  (if (= n 3) true
     (is-even? (dec n))))
