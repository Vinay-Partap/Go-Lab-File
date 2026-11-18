
(println "========== Q2: EXCEPTION HANDLING ==========")

;; ==========================================
;; 1. ARITHMETIC EXCEPTION
;; ==========================================

(println "\n----- ARITHMETIC EXCEPTION -----")

(try
  (println "Result:" (/ 10 0))

  (catch ArithmeticException e
    (println "Arithmetic Error:" (.getMessage e)))

  (finally
    (println "Arithmetic Exception Handled")))


;; ==========================================
;; 2. NULL POINTER EXCEPTION
;; ==========================================

(println "\n----- NULL POINTER EXCEPTION -----")

(try
  (let [obj nil]
    (.length obj))

  (catch NullPointerException e
    (println "Null Pointer Error:" (.getMessage e)))

  (finally
    (println "Null Pointer Exception Handled")))


;; ==========================================
;; 3. CUSTOM EXCEPTION USING EX-INFO
;; ==========================================

(println "\n----- CUSTOM EXCEPTION -----")

;; Function that deliberately throws an exception
(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above"
                    {:age age
                     :error "Underage"}))
    (println "Eligible for registration")))

(try
  (check-age 16)

  (catch clojure.lang.ExceptionInfo e
    (println "Custom Error:" (ex-message e))
    (println "Error Details:" (ex-data e))
    (println "Recovery: Please enter a valid age."))

  (finally
    (println "Custom Exception Handled")))


;; ==========================================
;; 4. GRACEFUL RECOVERY
;; ==========================================

(println "\n----- GRACEFUL RECOVERY -----")

(defn safe-division [a b]
  (try
    (/ a b)

    (catch ArithmeticException e
      (println "Error:" (.getMessage e))
      (println "Recovery: Returning 0")
      0)

    (finally
      (println "Division operation completed"))))

(println "10 / 2 =" (safe-division 10 2))
(println "10 / 0 =" (safe-division 10 0))


(println "\n========== END OF Q2 ==========")
