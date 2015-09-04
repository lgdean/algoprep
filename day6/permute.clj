(ns permute
  (:require [clojure.test :refer :all]))

(defn pal-permutation?
  [s]
  true)

(deftest pal-permute-test
  (testing "should handle simplest case"
    (is (= true (pal-permutation? "a"))))
  (testing "but not everything"
    (is (= false (pal-permutation? "ab")))))

(run-tests)

