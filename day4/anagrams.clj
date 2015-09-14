(ns anagrams
  (:require [clojure.test :refer :all]))

;; wonder whether i'll ever implement this.

(defn anagrams?
  [one other]
  (= (.length one) (.length other)))

(deftest anagrams-test
  (testing "empty strings, yes"
    (is (true? (anagrams? "" ""))))
  (testing "should handle example given"
    (is (true? (anagrams? "silent" "listen"))))
  (testing "but not other non-anagram things"  
    (is (false? (anagrams? "silent" "listennn")))
    (is (false? (anagrams? "silent" "silens"))))
)

(run-tests)
