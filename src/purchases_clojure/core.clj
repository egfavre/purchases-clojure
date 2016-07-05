(ns purchases-clojure.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main []
  (println "Which Category?")
  (let [category (read-line)
        purchases (slurp "purchases.csv")
        purchases (str/split-lines purchases)
        purchases (map (fn [line] (str/split line #","))
                    purchases)
        header (first purchases)
        purchases (rest purchases)
        purchases (map(fn [line] (zipmap header line))
                    purchases)
        purchases (filter  (fn [line] (= category (get line "category")))
                    purchases) 
        file-text (pr-str purchases)]
    (spit "filtered_purchases.edn" file-text)))
     
     
 
       