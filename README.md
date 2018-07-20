Calculate a result from a set of instructions.

Instructions comprise of a keyword and a number that are separated by a space per
line. Instructions are loaded from file and results are output to the screen. Any number
of Instructions can be specified. Instructions can be any binary operators of your choice
(e.g., add, divide, subtract, multiply etc). The instructions will ignore mathematical
precedence. The last instruction should be “apply” and a number (e.g., “apply 3”). The
calculator is then initialised with that number and the previous instructions are applied
to that number.

Examples of the calculator lifecycle might be:
- Example 1
```
Input from file:
add 2
multiply 3
apply 10

Output: 36

Explanation: 10 + 2 * 3 = 36
```
- Example 2
```
Input from file:
multiply 3
add 2
apply 10

Output: 32

Explanation: 10 * 3 + 2 = 32
```
- Example 3
```
Input from file: 
apply 1

Output: 1
```


How to run application from command line:

1) main application folder is: CalculateFromFile, please enter inside and open the folder:
CalculateFromFile\out\artifacts\CalculateFromFile_jar

2) please copy the file (or files) that contains the list of command,
in this particular case one file has been attached:
SetOfOperations.txt

2) open the CMD window or PowerShell window and type there: java -jar {application} {fileName},
for this particular case it should be a command:
java -jar CalculateFromFile.jar SetOfOperations.txt

3) in case of multiple files (e.g. SetOfOperations01.txt and SetOfOperations02.txt) the command shoud be:
java -jar CalculateFromFile.jar SetOfOperations01.txt SetOfOperations02.txt