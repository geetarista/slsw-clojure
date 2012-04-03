; Calling Basic Functions

(- 1) ; -1
(+ 1 1) ; 2
(* 10 10) ; 100
(/ 1 3) ; 1/3
(/ 2 4) ; 1/2
(/ 2.0 4) ; 0.5
(class (/ 1 3)) ; clojure.lang.Ratio
(mod 5 4) ; 1
(/ (/ 12 2) (/ 6 2)) ; 2
(+ 2 2 2 2) ; 8
(- 8 1 2) ; 5
(/ 8 2 2) ; 2
(< 1 2 3) ; true
(< 1 3 2 4) ; false
(+ 3.0 5) ; 8.0
(+ 3 5.0) ; 8.0

(println "master yoda\nluke skywalker\ndarth vader")
; master yoda
; luke skywalker
; darth vader
; nil

(str 1) ; "1"
(str "yoda, " "luke,  " "darth") ; "yoda, luke,  darth"
(str "one: " 1 " two: " 2) ; "one: 1 two: 2"
\a ; \a
(str \f \o \r \c \e) ; "force"
(= "a" \a) ; false
(= (str \a) "a") ; true

; Booleans and Expressions

(= 1 1.0) ; true
(= 1 2) ; false
(< 1 2) ; true

(class true) ; java.lang.Boolean
(class (= 1 1)) ; java.lang.Boolean

(if true (println "True it is."))
; True it is.
; nil

(if (> 1 2) (println "True it is."))
; nil

(if (< 1 2)
  (println "False it is not."))
; False it is not.
; nil

(if false (println "true") (println "false"))
; false
; nil

(first ())
; nil

(if 0 (println "true"))
; true
; nil

(if nil (println "true"))
; nil

(if "" (println "true"))
; true
; nil

; Lists, Maps, Sets, and Vectors
; Use lists for code and vectors for data

; lists
(list 1 2 3) ; (1 2 3)
'(1 2 3) ; (1 2 3)

(first '(:r2d2 :c3po)) ; :r2d2
(last '(:r2d2 :c3po)) ; :c3po
(rest '(:r2d2 :c3po)) ; :c3po
; construct a new list given a head and a tail
(cons :battle-droid '(:r2d2 :c3po)) ; (:battle-droid :r2d2 :c3po)

; vectors
[:hutt :wookie :ewok] ; [:hutt :wookie :ewok]

(first [:hutt :wookie :ewok]) ; :hutt
(nth [:hutt :wookie :ewok] 2) ; :ewok
(nth [:hutt :wookie :ewok] 0) ; :hutt
(last [:hutt :wookie :ewok]) ; :ewok
([:hutt :wookie :ewok] 2) ; :ewok

(concat [:darth-vader] [:darth-maul]) ; (:darth-vader :darth-maul)

(first [:hutt :wookie :ewok]) ; :hutt
(rest [:hutt :wookie :ewok]) ; (:wookie :ewok)

; sets
#{:x-wing :y-wing :tie-fighter} ; #{:x-wing :y-wing :tie-fighter}

(def spacecraft #{:x-wing :y-wing :tie-fighter}) ; #'user/spacecraft
spacecraft ; #{:x-wing :y-wing :tie-fighter}
(count spacecraft) ; 3
(sort spacecraft) ; (:tie-fighter :x-wing :y-wing)
(sorted-set 2 3 1) ; #{1 2 3}
(clojure.set/union #{:skywalker} #{:vader}) ; #{:skywalker :vader}
(clojure.set/difference #{1 2 3} #{2})

; sets are also functions
(#{:jar-jar :chewbacca} :chewbacca) ; :chewbacca
(#{:jar-jar :chewbacca} :luke) ; nil

; maps
{:chewie :wookie :lea :human} ; {:chewie :wookie, :lea :human}
{:darth-vader "obi wan", :luke "yoda"} ; {:darth-vader "obi wan", :luke "yoda"}

(def mentors {:darth-vader "obi wan", :luke "yoda"}) ; #'user/mentors
mentors ; {:darth-vader "obi wan", :luke "yoda"}
; maps are functions
(mentors :luke) ; "yoda"
; keywords are functions
(:luke mentors) ; "yoda"

(merge {:y-wing 2, :x-wing 4} {:tie-fighter 2})
; {:tie-fighter 2, :y-wing 2, :x-wing 4}
(merge-with + {:y-wing 2, :x-wing 4} {:tie-fighter 2 :x-wing 3})
; {:tie-fighter 2, :y-wing 2, :x-wing 7}

(assoc {:one 1} :two 2) ; {:two 2, :one 1}
(sorted-map 1 :one, 3 :three, 2 :two) ; {1 :one, 2 :two, 3 :three}

; Defining Functions

(defn force-it [] (str "Use the force," "Luke.")) ; #'user/force-it
(force-it) ; "Use the force,Luke."

; add description to function
(defn force-it
  "The first function a young Jedi needs"
  []
  (str "Use the force," "Luke"))
(doc force-it)
; -------------------------
; user/force-it
; ([])
;   The first function a young Jedi needs
; nil

(defn force-it
  "The first function a young Jedi needs"
  [jedi]
  (str "Use the force," jedi))
; #'user/force-it
(force-it "Luke") ; "Use the force,Luke"

(doc str)
; -------------------------
; clojure.core/str
; ([] [x] [x & ys])
;   With no args, returns the empty string. With one arg x, returns
;   x.toString().  (str nil) returns the empty string. With more than
;   one arg, returns the concatenation of the str values of the args.
; nil

; Bindings

(def line [[0 0] [10 20]]) ; #'user/line
line ; [[0 0] [10 20]]

(defn line-end [ln] (last  ln)) ; #'user/line-end
(line-end line) ; [10 20]

(defn line-end [[_ second]] second) ; #'user/line-end
(line-end line) ; [10 20]

(def board [[:x :o :x] [:o :x :o] [:o :x :o]]) ; #'user/board
(defn center [[_ [_ c _] _]] c) ; #'user/center
(center board) ; :x
(defn center [[_ [_ c]]] c)
(defn center [board]
  (let [[_ [_ c]] board] c))

(def person {:name "Jabba" :profession "Gangster"}) ; #'user/person
(let [{name :name} person] (str "The person's name is " name))
; "The person's name is Jabba"

(def villains [{:name "Godzilla" :size "big"} {:name "Ebola" :size "small"}])
; #'user/villains
(let [[_ {name :name}] villains] (str "Name of the second villain: " name))
; "Name of the second villain: Ebola"

; Anonymous Functions

(def people ["Lea", "Han Solo"]) ; #'user/people
(count "Lea") ; 3
(map count people) ; (3 8)
(defn twice-count [w] (* 2 (count w))) ; #'user/twice-count
(twice-count "Lando") ; 10
(map twice-count people) ; (6 16)
(map (fn [w] (* 2 (count w))) people) ; (6 16)
; # defines anonymous function, with % bound to each item of the sequence
(map #(* 2 (count %)) people) ; (6 16)

(def v [3 1 2]) ; #'user/v
(apply + v) ; 6
(apply max v) ; 3

(filter odd? v) ; (3 1)
(filter #(< % 3) v) ; (1 2)



