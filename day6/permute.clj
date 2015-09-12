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

;; pseudo-code in imperative style:
;; create an empty hash set (to be used for letters).
;; for each letter in input:
;;   if it's a space or punctuation, ignore;
;;   otherwise, check membership in the set of letters.
;;     if it's in the set, remove it.
;;     otherwise, it's not in the set, so add it.
;; now check the size of the set of letters.
;;   return true if it has 0 or 1 elements (otherwise false).

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

;; TODO maybe handle other punctuation; make it case-insensitive

(run-tests)

