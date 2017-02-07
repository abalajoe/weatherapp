:: Weather App Script
:: @jeoabala

:: Set Java path
set path="C:\Program Files (x86)\Java\jdk1.7.0_51\bin"

:: Weather file and Jar file
set weather_file=weather.dat
set jar=weather.jar

:: Run App
java -Dweather_file=%weather_file% -jar %jar%