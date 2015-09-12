(ns permute
  (:require [clojure.test :refer :all]))

;; problem 1 of https://algoprep.wordpress.com/2015/08/28/daily-interview-6/
;; As I understand it, the time performance is slightly slower than linear
;; (because set addition/removal is not quite constant).

(defn pal-permutation?
  [s]
  (let [spare-letters
        (reduce
         (fn [acc letter]
           (if (contains? acc letter)
             (disj acc letter)
             (conj acc letter)))
         #{} ; this is an empty hash set
         (remove #(contains? #{\  \, \! \.} %) s))]
    (<= (count spare-letters) 1)))

(deftest pal-permute-test
  (testing "should handle simplest case"
    (is (true? (pal-permutation? "a")))
    (is (true? (pal-permutation? ""))))
  (testing "but not everything"
    (is (false? (pal-permutation? "ab"))))
  (testing "a classic (with spaces that should not matter)"
    (is (true? (pal-permutation? "able was i ere i saw elba")))
    (is (true? (pal-permutation? "able was i  ere i saw elba"))))
  (testing "another classic (with punctuation)"
    (is (true? (pal-permutation? "mana, a nalp. a canal, panama!"))))
  )

;; TODO handle spaces.  (and apparently also punctuation and case?)

(run-tests)

