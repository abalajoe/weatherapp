(ns weathermaxspreadapp.core
  ^{:author "@joeabala"
    :doc "application reads weather file and calculates the maximum spread"
    :added "1.0"
    }
  (:gen-class)
  (:require [clojure.string :as clstr]))

(def weather-file "/Users/abala/Downloads/weather_test1.dat")
;(def weather-file (System/getProperty "weather_file"))

(defn calculate-spread
  "Function calculates spread for all the days"
  [^String file]
  (let [spread-col (atom [])] ;; spread collection --- a vector containing spread values for the month
    (with-open [rdr (clojure.java.io/reader file)] ;; open and read file
      (doseq [
              line (-> (line-seq rdr) ;; parse file line by lien
                       (next)         ;; drop first line (header)
                       (drop-last)) ;; drop last line (footer)
              ]
        (when (not= 0 (count line)) ;; remove any empty rows
          (let [[_ max-temp min-temp _] (->>
                                          (filter #(not (clstr/blank? %)) ;; remove white spaces
                                                  (clstr/split line #" "))
                                          (take 4)) ;; take the first 4 columns
                max-temp (clstr/replace max-temp #"\*" "") ;; remove * from maximum temperature dataset
                min-temp (clstr/replace min-temp #"\*" "") ;; remove * from minimum temperature dataset
                spread (- (Integer/parseInt max-temp) (Integer/parseInt min-temp)) ;; calculate spread
                _ (swap! spread-col conj spread) ;; insert spread to collection
                ]))))
    @spread-col ;; return the spread collection result, populated with values for entire month
    ))

(defn print-result
  "Function prints day and max spread to stdout"
  [spread]
  (let [max-spread (apply max spread) ;; get the maximum spread
        day-of-month (-> (.indexOf spread max-spread) ;; get the day of month
                         (+ 1));; add 1 because Java method indexOf starts counting from 0
        ]
    (prn day-of-month max-spread) ;; print day of month and max spread
    [day-of-month max-spread] ;; return vector comprising of day and spread
    ))

(defn -main
  "Execution starts here -- start service"
  [& args]
  (if (.exists (clojure.java.io/file weather-file)) ;; check if file exists
    (print-result (calculate-spread weather-file)) ;; file exists, proceed
    (do ;; file does not exist
      (println "File " weather-file " does not exist") ;; log error
      (System/exit 1)))) ;; terminate application -- erroneous termination

;(-main)