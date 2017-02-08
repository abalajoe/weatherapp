# weathermaxspreadapp

A Clojure library designed to calculate the difference between maximum and minimum temperatures and print the day with the highest difference on standard output.

## Usage

Download the project into your local computer and navigate to the run folder. For UNIX based users, open the terminal, navigate to the run folder. Next, make the start script executable by executing the below command: 

    sudo chmod +x startup.sh 
    
Now you can run the program by executing the below command:    
    
    sudo ./startup.sh
    
Alternatively (without using startup.sh), open the command prompt, navigate to the run folder and execute the below commands:
    
     sudo chmod +x startup.sh
     java -Dweather_file=weather.dat -jar weather.jar
     
    
For windows based users, navigate to the run folder, open the startup.bat file and edit the Java path to suit your computer's Java path. Next, open the command prompt, navigate to the run folder and execute the below command:

    startup.bat
    
Alternatively (without using startup.bat), open the command prompt, navigate to the run folder and execute the below command:
    
    java -Dweather_file=weather.dat -jar weather.jar
    

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
