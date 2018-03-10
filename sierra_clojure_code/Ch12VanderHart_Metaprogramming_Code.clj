;; Example code for Chapter 12
;; Author: Luke VanderHart

;; Snippit, triple-do macro
(defmacro triple-do [form]
	(list 'do form form form))

;; Snippit, infix macro
(defmacro infix [form]
	(cons (second form) (cons (first form) (nnext form))))
	
;; Snippit, template-triple-do macro
(defmacro template-triple-do [form]
	`(do ~form ~form ~form))
	
;; Snippit, template-infix macro (incorrect version)
(defmacro template-infix [form]
	`(~(second form) ~(first form) ~(nnext form)))
	
;; Snippit, template-infix macro (correct version)
(defmacro template-infix [form]
	`(~(second form) ~(first form) ~@(nnext form)))
	
;; Snippit, rand-expr macro
(defmacro rand-expr [form1 form2]
	`(let [n# (rand-int 2)]
		(if (zero? n#) ~form1 ~form2)))
		
;; Snippit, rand-expr-multi macro
(defmacro rand-expr-multi [& exprs]
	`(let [ct# ~(count exprs)]
		(case (rand-int ct#)
		~@(interleave (range (count exprs)) exprs))))

;; Snippit, ++ macro
(defmacro ++ 
	[& exprs]
       (if (>= 2 (count exprs))
               `(+ ~@exprs)
               `(+ ~(first exprs) (++ ~@(rest exprs)))))

;; Snippit, xml-helper function and xml macro
(defn xml-helper [form]
	(if (not (seq? form))
		(str form)
		(let [name (first form)
			  children (rest form)]
			(str "<" name ">"
				 (apply str (map xml-helper children))
				 "</" name ">"))))
				 
(defmacro xml [form]
	(xml-helper form))
	
