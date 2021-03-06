[![Build Status](https://travis-ci.com/mtumilowicz/calculator.svg?branch=master)](https://travis-ci.com/mtumilowicz/calculator)
# calculator
Project created for company from Warsaw during the process of 
recruitment. It is a simple implementation of basic methods of 
calculator (on `ints`).
## Preconditions & assumptions
We have a file (`*.txt`) that contains operations (uppercase or 
lowercase):  
`ADD`  
`SUBTRACT`  
`MULTIPLY`  
`DIVIDE`  
`APPLY` - is used to indicate the start number in a series of actions.  
Each line contains only one above-mentioned action and a single `int` 
number. `APPLY` is used exactly once - in the last line of the file.  
Precedence of arithmetic operations is ignored, in other words:  
`ADD 10`  
`ADD 5`  
`SUBTRACT 3`  
`ADD 6`  
`MULTIPLY -1`  
`SUBTRACT -1`  
`DIVIDE 5`  
`APPLY 3`
is evaluated to expression:
`(((((((3 + 10) + 5) - 3) + 6) * (-1)) - (-1)) / 5)`


## Solution
In case of bad input we throw: `IllegalArgumentException`.  
If during evaluation `int` is overflow - 
we re-throw `ArithmeticException` (we use functions from `guava` to 
evaluate operations on `ints` - they take care of overflowing).  
Test coverage for crucial elements.  
All classes that could be immutable are immutable.  
In `Main` class in `main` method we load (hardcoded) `*.txt` file 
from resources (path: `src/main/resources/operations.txt` so to run 
the program using console we have to replace the file and just type: 
`java Main` (remember to compile project at least once, and to 
provide access to third-party libraries.).
## Third-party libraries
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>22.0</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.6</version>
        </dependency>