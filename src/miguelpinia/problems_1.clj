(ns miguelpinia.problems-1
  (:require [clojure.string :as s]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def arr [-4 3 -9 0 4 1])

(defn plusMinus [arr]
  (let [size     (count arr)
        f        #(format "%.6f" (float %))
        g        (group-by #(cond
                              (> % 0) 1
                              (< % 0) -1
                              :else   0)
                           arr)
        positive (-> g (get 1) (count) (/ size))
        negative (-> g (get -1) (count) (/ size))
        zeros    (-> g (get 0) (count) (/ size))]
    (println (format "%s\n%s\n%s"
                     (f positive)
                     (f negative)
                     (f zeros)))))

#_(plusMinus arr)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; If we are calculating the minimum-sum, we can solve this problem in linear time. just we need to find the maximum and make the rest from the sum of all elements
;; Similar case for the maximum-sum and find the minimum value in the array

(def arr [1 3 5 7 9])

(defn miniMaxSum [arr]
  (let [arr-sum (reduce + arr)
        maximum (- arr-sum (apply min arr))
        minimum (- arr-sum (apply max arr))]
    (println (str minimum " " maximum))))

(miniMaxSum arr)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; https://www.hackerrank.com/challenges/time-conversion/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn timeConversion [s]
  (let [time_s (s/split s #":")
        hour   (Integer/parseInt (first time_s))
        mins   (second time_s)
        secs   (clojure.string/join (take 2 (nth time_s 2)))
        am?    (= "AM" (clojure.string/join (take-last 2 (last time_s))))
        pm?    (not am?)
        hour_s (cond
                 (and am? (= hour 12)) "00"
                 (and pm? (< hour 12)) (str (+ 12 hour))
                 :else               (format "%02d" hour))]
    (clojure.string/join ":" [hour_s mins secs])))

(timeConversion "07:05:45PM")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-sparse-arrays/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def strings ["ab" "ab" "abc"])

(def queries ["ab" "abc" "bc"])

(def results [2 1 0])

(defn matchingStrings [strings queries]
  (loop [results []
         query   (first queries)
         rest-q  (rest queries)]
    (if (nil? query)
      results
      (recur (conj results
                   (->> strings (filter #(= % query)) count))
             (first rest-q)
             (rest rest-q)))))

(matchingStrings strings queries)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-lonely-integer/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def a [1 2 3 4 3 2 1])
(def b [1 1 2])
(def c [0 0 1 2 1])

(defn lonelyInteger [a]
  (->> (loop [values {}
              a      a]
         (if (empty? a)
           values
           (recur
            (update values (first a) (fnil inc 0))

            (rest a))))
       (filter #(= (second %) 1))
       first
       first))

(defn lonelyInteger2 [a]
  (reduce (fn [val acc] (bit-xor acc val)) a))

(lonelyInteger2 c)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-flipping-bits/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def n 2147483647)
(defn flipingBits [n] (bit-xor n (- (long (Math/pow 2 32)) 1)))
(flipingBits 1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-diagonal-difference/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn diagonalDifference [arr]
  (let [size     (count arr)
        both     (loop [a []
                        b []
                        i 0]
                   (if (> i (- size 1))
                     [a b]
                     (recur (conj a (get-in arr [i i]))
                            (conj b (get-in arr [i (- size (+ i 1))]))
                            (inc i))))
        sum-both (map #(apply + %) both)
        result   (apply - sum-both)]
    (Math/abs result)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; hackerrank.com/challenges/one-month-preparation-kit-countingsort1/problem ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def arr [63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33])


(defn countingSort-worst-performer [arr]
  (let [x (make-array Integer/TYPE 100)]
    (doseq [v arr]
      (aset x v (inc (aget x v))))
    x))

(defn countingSort-best-performer [arr]
  (let [size (count arr)]
    (loop [i    0
           vals (into [] (repeat 100 0))]
      (if (>= i size)
        vals
        (recur (inc i)
               (update vals (nth arr i) inc))))))

#_(def result [0 2 0 2 0 0 1 0 1 2 1 0 1 1 0 0 2 0 1 0 1 2 1 1 1 3 0 2 0 0 2 0 3 3 1 0 0 0 0 2 2 1 1 1 2 0 2 0 1 0 1 0 0 1 0 0 2 1 0 1 1 1 0 1 0 1 0 2 1 3 2 0 0 2 1 2 1 0 2 2 1 2 1 2 1 1 2 2 0 3 2 1 1 0 1 1 1 0 2 2])

#_(frequencies arr)

#_(= result (vec (countingSort arr)))
