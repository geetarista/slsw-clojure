(ns slsw.test.collection-type
  (:use [slsw.collection-type])
  (:use [clojure.test]))

(deftest test-collection-type
  (is (= :vector (collection-type [1 2 3])))
  (is (= :list (collection-type '(1 2 3))))
  (is (= :map (collection-type {:chewie :wookie :lea :human})))
  )
