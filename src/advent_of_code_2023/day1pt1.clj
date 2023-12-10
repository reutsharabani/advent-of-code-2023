(ns advent-of-code-2023.day1pt1
  (:require [clojure.string :as string]))

(def input "resources/day1pt1.txt")

(def t1 "1abc2\npqr3stu8vwx\na1b2c3d4e5f\ntreb7uchet")

(-> input
    slurp
    string/lower-case
    (string/replace #"[a-z]" "")
    string/split-lines
    (->>
     (map (juxt first last))
     (map string/join)
     (map read-string)
     (reduce +)))
;; => 54951
