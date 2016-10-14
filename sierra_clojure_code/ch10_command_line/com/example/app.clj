;;; app.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; A Simple Command-Line Program (page 157)

(ns com.example.app
  (:gen-class))

(defn -main [& args]
  (println "Hello, World!"))
