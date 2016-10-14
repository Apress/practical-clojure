;;; ch13_payroll.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; The Payroll Protocol (page 186)

(defprotocol Payroll
  (paycheck [emp hrs]))

(defrecord HourlyEmployee [name rate]
  Payroll
  (paycheck [hrs] (* rate hrs)))

(defrecord SalariedEmployee [name salary]
  Payroll
  (paycheck [hrs] (/ salary 12.0)))

(defn contract [amount]
  (reify Payroll (paycheck [hrs] amount)))
