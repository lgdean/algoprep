(ns anagrams
  (:require [clojure.test :refer :all]))

(defn anagrams?
  [one other]
  (let [letters-in (fn [s] (reduce
                            (fn [acc letter]
                              (assoc acc letter (inc (get acc letter 0))))
                            (hash-map)
                            s))]
    (= (letters-in one) (letters-in other))))

(deftest anagrams-test
  (testing "empty strings, yes"
    (is (true? (anagrams? "" ""))))
  (testing "should handle example given"
    (is (true? (anagrams? "silent" "listen"))))
  (testing "but not other non-anagram things"  
    (is (false? (anagrams? "silent" "listennn")))
    (is (false? (anagrams? "si" "li")))
    (is (false? (anagrams? "silent" "silens"))))
)

(run-tests)
