;; Example code for Chapter 5
;; Author: Luke VanderHart

;; Snippet: printall function
(defn printall [s]
	(if (not (empty? s))
		(do
			(println (str "Item: " (first s)))
			(recur (rest s)))))

			
;; Snippet: make-int-seq function	
(defn make-int-seq [max]
	(loop [acc nil n max]
		(if (zero? n)
			acc
			(recur (cons n acc) (dec n)))))
			
;; Snippet: lazy-counter function
(defn lazy-counter [base increment]
	(lazy-seq
		(cons base (lazy-counter (+ base increment) increment))))
		

;; Snippet: non-lazy counter function
(defn counter [base increment]
	(cons base (counter (+ base increment) increment)))

;; Snippet: lazy-counter-iterate function
(defn lazy-counter-iterate [base increment]
	(iterate (fn [n] (+ n increment)) base))