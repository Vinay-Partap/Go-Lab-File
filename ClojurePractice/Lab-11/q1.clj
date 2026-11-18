
(println "========== Q1: JAVA INTEROPERABILITY ==========")

;; ==========================================
;; 1. JAVA STATIC METHODS
;; ==========================================

(println "\n----- JAVA STATIC METHODS -----")

;; Math static methods
(println "Absolute Value:" (Math/abs -25))
(println "Square Root:" (Math/sqrt 144))
(println "Maximum:" (Math/max 10 20))

;; System static method
(println "Current Time in Milliseconds:"
         (System/currentTimeMillis))


;; ==========================================
;; 2. CREATE JAVA OBJECT INSTANCES
;; ==========================================

(println "\n----- JAVA OBJECT CREATION -----")

;; Create ArrayList object
(def java-list (new java.util.ArrayList))

;; Create HashMap object
(def java-map (new java.util.HashMap))

(println "ArrayList Created:" java-list)
(println "HashMap Created:" java-map)


;; ==========================================
;; 3. INVOKE INSTANCE METHODS
;; ==========================================

(println "\n----- INSTANCE METHODS -----")

;; ArrayList methods
(.add java-list "Clojure")
(.add java-list "Java")
(.add java-list "Python")

(println "ArrayList:" java-list)
(println "First Element:" (.get java-list 0))
(println "List Size:" (.size java-list))

;; HashMap methods
(.put java-map "Name" "Vinay")
(.put java-map "Course" "CSE")
(.put java-map "University" "KR Mangalam")

(println "HashMap:" java-map)
(println "Student Name:" (.get java-map "Name"))
(println "Map Size:" (.size java-map))


;; ==========================================
;; 4. CONVERT CLOJURE AND JAVA COLLECTIONS
;; ==========================================

(println "\n----- COLLECTION CONVERSION -----")

;; Clojure Vector to Java ArrayList
(def clojure-vector [10 20 30 40])

(def converted-list
  (java.util.ArrayList. clojure-vector))

(println "Original Clojure Vector:" clojure-vector)
(println "Converted Java ArrayList:" converted-list)

;; Java ArrayList to Clojure Vector
(def converted-vector
  (vec converted-list))

(println "Converted Clojure Vector:" converted-vector)

;; Clojure Map to Java HashMap
(def clojure-map {:name "Vinay" :age 22})

(def converted-map
  (java.util.HashMap. clojure-map))

(println "Original Clojure Map:" clojure-map)
(println "Converted Java HashMap:" converted-map)

;; Java HashMap to Clojure Map
(def final-map
  (into {} converted-map))

(println "Converted Clojure Map:" final-map)


(println "\n========== END OF Q1 ==========")
