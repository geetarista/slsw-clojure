(ns slsw.collection-type)

(defn collection-type
  "returns :list, :map, or :vector based on the type of collection col"
  [col]
  (if (= (type col) clojure.lang.PersistentVector)
      :vector
      (if (= (type col) clojure.lang.PersistentArrayMap)
          :map
          (if (= (type col) clojure.lang.PersistentList)
              :list)))
  )
