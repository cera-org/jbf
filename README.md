# JBF
Brainfuck interpreter made with java
## How to download and compile
REQUIREMENT: Java 5 or newer</br>
To compile all java files enter this command in the same directory as the files: 
```ps
javac *.java
```
Then to run a brainfuck file, use this command replacing "cat.bf" with the file of your choice. You may add another argument to fulfil the stdin stream, though not required by brainfuck files that don't use the "," instruction.
```ps
java FileReaderForJBF cat.bf "Hello, World!"
```
# Features
- Conditional Loops
- Nested loop support
- Pointer wrapping
- Generic "," functionality

Please open an issue if you have any suggestions!<3
