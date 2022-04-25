{% include navigation.html %}

# PBL Week 1 Reflection
## AX Code Reflection
- Tester methods were actually way more useful than I thought. Implementing it into my [rarity code](https://github.com/zenxha/musicgacha/blob/a4885cd57fea7dc379b372fd512e036ea7df71ef/src/main/java/com/musicgacha/controllers/RandomController.java#L59-L75), which had a lot of bugs at first, let me know that the algorithm itself wasn't what was bugging out the system, and helped isolate where the issue actually was
- I also found out that by using [forloops to create multiple instances of the same element in an ArrayList](https://github.com/zenxha/musicgacha/blob/a4885cd57fea7dc379b372fd512e036ea7df71ef/src/main/java/com/musicgacha/controllers/RandomController.java#L23-L25), along with using a [random selector for elements of an arraylist](https://github.com/zenxha/musicgacha/blob/a4885cd57fea7dc379b372fd512e036ea7df71ef/src/main/java/com/musicgacha/controllers/RandomController.java#L53-L56), you can kind of create some probability and make elements rarer than others
>-method is stil lvery rudamentary and can definatly be improved upon though. 
## AX Faculty Lectures
### Unit 2 Lecture
- To run code on a machine you must use machine language(hard for programmers to understand) in some way
>- Programming language is designed to make it easier for programmers to understand
- Assembler converts the assembly language program to machine language
- Programmers wanted to use higher level programming (easier to understand for programmers)
>- try to move away from CPU thinking and more into human thinking
- Languages developed sometimes had very specific purposes (some languages are business specific)

**Java**
- Java developed partly from C++
- Object Oriented Programming
>- Knowing how to use objects allows you to solve problems, doesn't need to actually fully understand it
>- OOP allows to define objects to use later to solve problems in a program
>- OOP needs a "factory" which is a class that gernerats objects
>- Sometimes the code to a class isn't given, but by knowing the purpose you can use them

### Unit 1 Lecture
**Primitive Data Types**
- Declaration tells Java the type of variable you want to make (ex: int num;)
>- Assigning value is next step (num = 3;)
>- 2 steps can be done together (int num = 3;)
- int prepresents integers, double represents decimals, etc
>- Doubles include fractional portions, but integers dont, therefore doubles cannot be stored as integers (can't add integers and doulbes and store as int)
- Multiple numeric primitive data types due to memory

|Integers|Floating Point Numbers|
|---|---|
|byte - 1 byte|float - 4 bytes|
|short - 2 bytes|double - 8 bytes|
|int - 4 bytes||
|long - 8 bytes||

- More bytes represents larger number, but takes more memopry
>- we want to conserve memory used, can help with **optimization**

**Characters and Booleans**
- char is unicode encoding, wich is used for characters (2 bytes)
- boolean is true/false (1 byte)

**Final Thoughts**
- OOP in java doesn't want to limit the data types a user can use
- 8 primitive types, but these let us build off of it to create our own data types
 
