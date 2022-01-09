# MowItNow:

This is an academic project written in scala language. The aim of this project is to create a scala program that gets an instructions file to manage one or several lawn mowers. You can find more details about the the project in "MowItNow.pdf" file.

## About the program:

The program sets up lawn mowers that can perform turn right and left or move foward. 

Lawn mowers move sequentially, meaning that no two lawn mowers are functional at the same time. 

The programs are in the main folder. To run the project, go the Run package and execute MowItNowRun scala program and get the final positions of mowers.

To verify the different functions used in the program, go to the test folder and run the tests.

The input of the MowItNowRunner is the "instructions.txt" file in resources folder.:

5 5<br/>
1 2 N<br/>
GAGAGAGAA<br/>
3 3 E<br/>
AADAADADDA<br/>

The obtained result is: 

Tondeuse 1 : 1 3 N<br/>
Tondeuse 2 : 5 1 E


##Technical environment used:

```
    - Scala version 2.13.1
    - SBT(Scala build tool) version 1.6.1
```


## Author of the project:
- Ouyahya Yasmine

