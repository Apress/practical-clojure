;;; ch09_game.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; The Players (pages 133-134)

(def a {:name "Arthur", :species ::human, :strength 8})

(def b {:name "Balfor", :species ::elf, :strength 7})

(def c {:name "Calis", :species ::elf, :strength 5})

(def d {:name "Drung", :species ::orc, :strength 6})


;;; The move Multimethod (page 134)

(defmulti move :species)

(defmethod move ::elf [creature]
  (str (:name creature) " runs swiftly."))

(defmethod move ::human [creature]
  (str (:name creature) " walks steadily."))

(defmethod move ::orc [creature]
  (str (:name creature) " stomps heavily."))


;;; The attack Multimethod (page 134)

(defmulti attack (fn [creature]
                   (if (> (:strength creature) 5)
                     :strong
                     :weak)))

(defmethod attack :strong [creature]
  (str (:name creature) " attacks mightily."))

(defmethod attack :weak [creature]
  (str (:name creature) " attacks feebly."))


;;; The encounter Multimethod (page 135)

(defmulti encounter (fn [x y]
                      [(:species x) (:species y)]))

(defmethod encounter [::elf ::orc] [elf orc]
  (str "Brave elf " (:name elf)
       " attacks evil orc " (:name orc)))

(defmethod encounter [::orc ::elf] [orc elf]
  (str "Evil orc " (:name orc)
       " attacks innocent elf " (:name elf)))

(defmethod encounter [::elf ::elf] [orc1 orc2]
  (str "Two elves, " (:name orc1)
       " and " (:name orc2)
       ", greet each other."))

(defmethod encounter :default [x y]
  (str (:name x) " and " (:name y)
       " ignore each other."))


;;; The talk Multimethod (page 136)

(defmulti talk :species :default "other")

(defmethod talk ::orc [creature]
  (str (:name creature) " grunts."))

(defmethod talk "other" [creature]
  (str (:name creature) " speaks."))


;;; The Hierarchy (page 136)

(derive ::human ::good)
(derive ::elf ::good)
(derive ::orc ::evil)
(derive ::elf ::magical)
(derive ::orc ::magical)
(derive ::hero ::human)


;;; The cast-spell Multimethod (page 137)

(defmulti cast-spell :species)

(defmethod cast-spell ::magical [creature]
  (str (:name creature) " casts a spell."))

(defmethod cast-spell :default [creature]
  (str "No, " (:name creature) " is not magical!"))


;;; The encounter Multimethod Redefined (page 138)

(defmulti encounter (fn [x y]
                      [(:species x) (:species y)]))

(defmethod encounter [::good ::good] [x y]
  (str (:name x) " and " (:name y) " say hello."))

(defmethod encounter [::good ::evil] [x y]
  (str (:name x) " is attacked by " (:name y)))

(defmethod encounter [::evil ::good] [x y]
  (str (:name x) " attacks " (:name y)))

(defmethod encounter :default [x y]
  (str (:name x) " and " (:name y)
       " ignore one another."))


;;; Hierarchies with Java Classes (page 138)

(derive java.util.Date ::evil)


;;; The invert Multimethod (page 139)

(defmulti invert class)

(defmethod invert Number [x]
  (- x))

(defmethod invert String [x]
  (apply str (reverse x)))


;;; The slay Multimethod (page 140)

(defmulti slay :species)

(defmethod slay ::good [creature]
  (str "Oh no! A good creature was slain!"))

(defmethod slay ::magical [creature]
  (str "A magical creature was slain!"))

(prefer-method slay ::good ::magical)

