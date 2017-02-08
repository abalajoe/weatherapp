(ns weathermaxspreadapp.core-test
  ^{:author "@joeabala"
    :doc "Test namespace. weather_test1.dat and weather_test2.dat are located in the run folder"
    :added "1.0"
    }
  (:require [clojure.test :refer :all]
            [weathermaxspreadapp.core :as core]
            [weathermaxspreadapp.core :refer :all]))

(deftest calculate-spread-test
  "Testing calculate-spread function"
  (is (= [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30]
         (core/calculate-spread "/Users/abala/abala/projects/clojure/weatherapp/src/weather_test1.dat"))) ;; edit file path appropriately
  (is (= [15 20 10 40 5 5 50 5 10 10 5 30 10 10 15 10 5 25 20 20 20 40 25 25 25 45 20 5 5 5]
         (core/calculate-spread "/Users/abala/abala/projects/clojure/weatherapp/src/weather_test2.dat")))) ;; edit file path appropriately

(deftest print-results-test
  "Testing print results function"
  (is (= [3 3.8] (core/print-result [1.5 2.3 3.8])))
  (is (= [1 44.3] (core/print-result [44.3 32.8 41.2])))
  (is (= [2 95.1] (core/print-result [88.5 95.1 10.2]))))