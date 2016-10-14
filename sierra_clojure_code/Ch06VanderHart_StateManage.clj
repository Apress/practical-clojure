;; Example code for Chapter 6
;; Author: Luke VanderHart

;; Listing 6-1, Bank Accounts in STM
(def account1 (ref 1000))
(def account2 (ref 1500))

(defn transfer
	"transfers amount of money from a to b"
	[a b amount]
	(dosync
		(alter a - amount)
		(alter b + amount)))

(transfer account1 account2 300)
(transfer account2 account1 50)

(println “Account #1:” @account1)
(println “Account #2:” @account2)

;; Listing 6-2, An Address Book in STM

(def my-contacts (ref []))

(defn add-contact
	"adds a contact to the provided contact list"
	[contacts contact]
	(dosync
		(alter contacts conj (ref contact))))

(defn print-contacts
	"prints a list of contacts"
	[contacts]
	(doseq [c @contacts]
		(println (str "Name: " (@c :lname) ", " (@c :fname)))))
		
(add-contact my-contacts {:fname "Luke" :lname "VanderHart"})
(add-contact my-contacts {:fname "Stuart" :lname "Sierra"})
(add-contact my-contacts {:fname "John" :lname "Doe"})

(print-contacts my-contacts)

;; Listing 6-3, Adding Initials to the Address Book

(defn add-initials
	"adds initials to a single contact and returns it"
	[contact]
	(assoc contact :initials
		(str (first (contact :fname)) (first (contact :lname)))))
		
(defn add-all-initials
	"adds initials to each of the contacts in a list of contacts"
	[contacts]
	(dosync
		(doseq [contact (ensure contacts)]
			(alter contact add-initials))))
			
(defn print-contacts-and-initials
	"prints a list of contacts, with initials"
	[contacts]
	(dorun (map (fn [c]
			(println (str "Name: " (@c :lname) ", " (@c :fname) " (" (@c :initials) ")"))) @contacts)))
			
(defn print-contacts-and-initials
	"prints a list of contacts, with initials"
	[contacts]
	(doseq [c @contacts]
		(println (str "Name: " (@c :lname) ", " (@c :fname) " (" (@c :initials) ")"))))
		
(add-all-initials my-contacts)
(print-contacts-and-initials my-contacts)


