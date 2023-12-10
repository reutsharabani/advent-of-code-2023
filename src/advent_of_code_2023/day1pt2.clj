(ns advent-of-code-2023.day1pt2
  (:require [clojure.string :as string]))

(def input "resources/day1pt2.txt")

(def t1 "two1nine\neightwothree\nabcone2threexyz\nxtwone3four\n4nineeightseven2\nzoneight234\n7pqrstsixteen")

(def s->n {"one" 1
           "two" 2
           "three" 3
           "four" 4
           "five" 5
           "six" 6
           "seven" 7
           "eight" 8
           "nine" 9
           ;;"zero" "0"
           })
(defn sn->n [sn]
  (get s->n sn (read-string sn)))

(defn extract-numbers [row]
  (->> row
       (re-seq #"(?=(\d|one|two|three|four|five|six|seven|eight|nine))")
       (map last)
       (map sn->n)
       ))

(-> input
    slurp
    string/lower-case
    string/split-lines
    (->>
     (map extract-numbers)
     (map (juxt first last))
     (map string/join)
     (map read-string)
     (reduce +)))
;; => 55218
