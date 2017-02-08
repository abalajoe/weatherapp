#! /usr/bin/env bash

# Weather App Script
# @joeabala

# Jar file and weather file
weather_file="weather.dat"
jar="weather.jar"

# Run App
java -Dweather_file=$weather_file -jar $jar
