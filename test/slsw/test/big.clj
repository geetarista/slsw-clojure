(ns slsw.test.big
  (:use [slsw.big])
  (:use [clojure.test]))

(deftest test-big
  (is (= true (big "some string" 5)))
  (is (= false (big "some string" 20)))
  )
