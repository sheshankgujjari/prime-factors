#Problem Statement
Take as input the path to a file containing one integer per line. 
For each integer in the file, ouput to the console a comma-delimited list of the integer's prime factors. 
The list of integers on each line of the output should multiply to produce the input integer. 


# Prime factors type
Display the prime factors with comma separated based on the input provided



## Compile and create jar

```
$ gradle clean build
```

#Test results
Open the below in browser with the project path specified in {{project-path}}
ile:///{{project-path}}/linked-list/build/reports/tests/test/index.html


#Pre-Requisite 
Input file with integer values needs to be provided. Sample input file is in the project folder with
the name "primetest.txt"


#How to run/execute
```
$ java -jar {{project-path}}/build/libs/prime-factors.jar {{inputfile-path}}
```