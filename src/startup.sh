#! /bin/sh

# Weather App Script
# @jeoabala

# Jar file and weather file
weather_file="weather.dat"
jar="weather.jar"

# Run App
java -Dweather_file=$weather_file -jar $jar
