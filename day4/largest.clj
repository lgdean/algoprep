(ns largest
  (:require [clojure.test :refer :all]))

(defn nth-largest
  [n vals]
  22)

(deftest nth-largest-test
  (testing "should find largest"
    (is (= 5 (nth-largest 1 [3,5,1]))))
  (testing "should handle example given"
    (is (= 5 (nth-largest 2 [5,2,4,7,1])))))

(run-tests)

