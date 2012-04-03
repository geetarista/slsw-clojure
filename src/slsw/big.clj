(ns slsw.big)

(defn big
  "Returns true if a string st is longer than n characters"
  [st n]
  (> (count st) n))
