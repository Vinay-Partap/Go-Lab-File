
(println "========== Q2: SEQUENCE TRANSFORMATIONS ==========")

;; ==========================================
;; COLLECTION 1: VECTOR
;; ==========================================

(println "\n----- COLLECTION 1: VECTOR -----")

(def numbers [1 2 3 4 5 6 7 8 9 10])

(println "Original Vector:" numbers)

;; 1. MAP - Square each element
(println "Squares:" (map #(* % %) numbers))

;; 2. FILTER - Select even numbers
(println "Even Numbers:" (filter even? numbers))

;; 3. REDUCE - Calculate sum
(println "Sum:" (reduce + numbers))

;; 4. TAKE - Get first five elements
(println "Take 5:" (take 5 numbers))

;; 5. DROP - Skip first five elements
(println "Drop 5:" (drop 5 numbers))

;; THREADING MACRO - Chain operations using ->>
(println "Threading (Even Squares):"
         (->> numbers
              (filter even?)
              (map #(* % %))
              (take 3)))


;; ==========================================
;; COLLECTION 2: LIST
;; ==========================================

(println "\n----- COLLECTION 2: LIST -----")

(def marks '(45 78 90 32 65 88 50 95))

(println "Original List:" marks)

;; 1. MAP - Add 5 grace marks
(println "Updated Marks:" (map #(+ % 5) marks))

;; 2. FILTER - Select marks >= 50
(println "Passed Marks:" (filter #(>= % 50) marks))

;; 3. REDUCE - Find maximum marks
(println "Maximum Marks:" (reduce max marks))

;; 4. TAKE - Get first four marks
(println "Take 4:" (take 4 marks))

;; 5. DROP - Skip first three marks
(println "Drop 3:" (drop 3 marks))

;; THREADING MACRO - Chain operations using ->>
(println "Threading (Passed Marks + 5):"
         (->> marks
              (filter #(>= % 50))
              (map #(+ % 5))
              (take 4)))


(println "\n========== END OF Q2 ==========")
