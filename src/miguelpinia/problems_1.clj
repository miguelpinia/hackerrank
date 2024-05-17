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
