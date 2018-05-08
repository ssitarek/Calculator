A file TaskDescriptionCalculator.pdf can be found in the main folder of the application.
It is a description of the task that I have got from you, but I have removed the company name.




How to run application from command line:

1) main application folder is: CalculateFromFile, please go inside and open the folder:
CalculateFromFile\out\artifacts\CalculateFromFile_jar

2) please copy the file (or files) that contains the list of command,
in this particular case one file has been attached:
SetOfOperations.txt

2) open the CMD window or PowerShell window and type there: java -jar {application} {fileName},
for this particular case it should be a command:
java -jar CalculateFromFile.jar SetOfOperations.txt

3) in case of multiple files (e.g. SetOfOperations01.txt and SetOfOperations02.txt) the command shoud be:
java -jar CalculateFromFile.jar SetOfOperations01.txt SetOfOperations02.txt