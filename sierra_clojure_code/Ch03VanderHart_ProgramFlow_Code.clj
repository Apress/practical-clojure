;; Example code for Chapter 3
;; Author: Luke VanderHart

;; Snippet: weather-judge function
(defn weather-judge
	"Given a temperature in degrees centigrade, comments on the weather."
	[temp]
	(cond
		(< temp 20) "It's cold"
		(> temp 25) "It's hot"
		:else "It's comfortable"))

;; Snippet: seconds-to-weeks function
(defn seconds-to-weeks
	"Converts seconds to weeks"
	[seconds]
	(/ (/ (/ (/ seconds 60) 60) 24) 7))

;; Snippet: expanded seconds-to-weeks function
(defn seconds-to-weeks
	"Converts seconds to weeks"
	[seconds]
	(let [minutes (/ seconds 60)
		  hours (/ minutes 60)
		  days (/ hours 24)
		  weeks (/ days 7)]
	weeks))
	
;; Listing 3-1, Calculating Square Roots
(defn abs
	"Calculates the absolute value of a number"
	[n]
	(if (< n 0)
		(* -1 n)
		n))

(defn avg
	"returns the average of two arguments"
	[a b]
	(/ (+ a b) 2))

(defn good-enough?
	"Tests if a guess is close enough to the real square root"
	[number guess]
	(let [diff (- (* guess guess) number)]
		(if (< (abs diff) 0.001)
			true
			false)))

(defn sqrt
	"returns the square root of the supplied number"
	([number] (sqrt number 1.0))
	([number guess]
		(if (good-enough? number guess)
			guess
			(sqrt number (avg guess (/ number guess))))))
		
;; Listing 3-2, Calculating Exponents
(defn power
	"Calculates a number to the power of a provided exponent."
	[number exponent]
	(if (zero? exponent)
		1
		(* number (power number (- exponent 1)))))
		
;; Listing 3-3, Adding up numbers without Tail Recursion
(defn add-up
	"adds all the numbers below a given limit"
	([limit] (add-up limit 0 0 ))
	([limit current sum]
		(if (< limit current)
			sum
			(add-up limit (+ 1 current) (+ current sum)))))
			
;; Listing 3-4, Adding up Numbers Correctly with Tail-recursion
(defn add-up
	"adds all the numbers up to a limit"
	([limit] (add-up limit 0 0 ))
	([limit current sum]
		(if (< limit current)
			sum
			(recur limit (+ 1 current) (+ current sum)))))
			
;; Snippet, example of loop
(loop [i 0]
	(if (= i 10)
		i
		(recur (+ i 1))))
		
		
;; Snippet, square root function using recur
(defn sqrt
	"returns the square root of the supplied number"
	([number] (sqrt number 1.0))
	([number guess]
		(if (good-enough? number guess)
			guess
			(recur number (avg guess (/ number guess))))))
		
;; Snippet, square root function using loop
(defn loop-sqrt
	"returns the square root of the supplied number"
	[number]
	(loop [guess 1.0]
		(if (good-enough? number guess)
			guess
			(recur (avg guess (/ number guess))))))

;; Snippet, square function with side effects
(defn square
	"Squares a number, with side effects."
	[x]
	(println "Squaring" x)
	(println "The return value will be" (* x x))
	(* x x))
	
;; Snippet, arg-switch function
(defn arg-switch
	"Applies the supplied function to the arguments in both possible orders. "
	[fun arg1 arg2]
	(list (fun arg1 arg2) (fun arg2 arg1)))
	
;; Snippet, rangechecker function
(defn rangechecker
	"Returns a function that determines if a number is in a provided range."
	[min max]
	(fn [num]
		(and (<= num max)
		(<= min num))))
		
		



