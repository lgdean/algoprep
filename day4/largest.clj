(ns largest
  (:require [clojure.test :refer :all]))

(defn do-insert
  [x sorted-vals]
  (cond (empty? sorted-vals) (list x)
        (< x (first sorted-vals)) (cons x sorted-vals)
        :else (cons (first sorted-vals) (do-insert x (rest sorted-vals)))))

(defn maybe-insert
  [x sorted-vals]
  (if (<= x (first sorted-vals)) sorted-vals
      (do-insert x (rest sorted-vals))))

(defn nth-largest
  [n vals]
  (let [init-largest (sort (take n vals))
        helper (fn helper [so-far others]
                 (cond (empty? others) (first so-far)
                       :else (helper (maybe-insert (first others) so-far)
                                     (rest others))))]
    (helper init-largest (drop n vals))))

(deftest nth-largest-test
  (testing "should find largest"
    (is (= 5 (nth-largest 1 [3,5,1]))))
  (testing "nice short example"
    (is (= 5 (nth-largest 1 [5]))))
  (testing "should handle example given"
    (is (= 5 (nth-largest 2 [5,2,4,7,1])))))

(run-tests)

