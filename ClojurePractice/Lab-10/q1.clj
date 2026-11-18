
(println "========== Q1: IMMUTABLE DATA STRUCTURES ==========")

;; ==========================================
;; 1. LIST
;; ==========================================

(println "\n----- LIST -----")

(def my-list '(10 20 30 40))

(println "Original List:" my-list)

;; first operation
(println "First Element:" (first my-list))

;; rest operation
(println "Rest of List:" (rest my-list))

;; conj operation (adds element at the beginning)
(def new-list (conj my-list 5))

(println "After conj:" new-list)

;; Demonstrating immutability
(println "Original List (unchanged):" my-list)


;; ==========================================
;; 2. VECTOR
;; ==========================================

(println "\n----- VECTOR -----")

(def my-vector [10 20 30 40])

(println "Original Vector:" my-vector)

;; get by index
(println "Element at Index 2:" (get my-vector 2))

;; count operation
(println "Vector Count:" (count my-vector))

;; conj operation (adds element at the end)
(def new-vector (conj my-vector 50))

(println "After conj:" new-vector)

;; Demonstrating immutability
(println "Original Vector (unchanged):" my-vector)


;; ==========================================
;; 3. MAP
;; ==========================================

(println "\n----- MAP -----")

(def my-map {:name "Vinay" :age 22 :course "CSE"})

(println "Original Map:" my-map)

;; get operation
(println "Student Name:" (get my-map :name))

;; assoc operation (adds or updates a key)
(def updated-map (assoc my-map :city "Gurgaon"))

(println "After assoc:" updated-map)

;; dissoc operation (removes a key)
(def new-map (dissoc my-map :age))

(println "After dissoc:" new-map)

;; Demonstrating immutability
(println "Original Map (unchanged):" my-map)


;; ==========================================
;; 4. SET
;; ==========================================

(println "\n----- SET -----")

(def my-set #{10 20 30 40})

(println "Original Set:" my-set)

;; contains? operation
(println "Contains 20:" (contains? my-set 20))

;; conj operation (adds an element)
(def updated-set (conj my-set 50))

(println "After conj:" updated-set)

;; disj operation (removes an element)
(def new-set (disj my-set 20))

(println "After disj:" new-set)

;; Demonstrating immutability
(println "Original Set (unchanged):" my-set)


(println "\n========== END OF Q1 ==========")
