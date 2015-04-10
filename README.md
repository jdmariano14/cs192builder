# CS 192 ME - Builder Pattern
Machine Exercise for CS 192 under Sir Edgar Felizmenio.

## Given
A basic implementation of generating SQL SELECT queries in Java (using the Builder pattern).

## Task
Add code to the Main class to generate the expected SQL queries for items 1-5 using the included QueryBuilder class.

## Deliverables
The Main class with the appropriate methods filled out, along with any other classes (if any) you decide to modify or extend. Send to the email specified in the FB group.

## Usage
* Compile (javac) the files in "src/querybuilder192".
* Go up one level (cd ..) from the directory where the compiled (.class) files are located.
```
$ java querybuilder192.Main
```

* Alternatively, just remove the (first) line "package querybuilder192;" from all the source files, and they will behave like typical Java classes written from scratch.
* Developed on Oracle Java 1.8.0_40

## Notes
* The syntax for generating some example queries is included as a guide (below the blank item methods in the Main class).
* The required queries for this ME were taken from a CS 165 problem set that used a version of the Northwind database (https://northwinddatabase.codeplex.com/).
* If you're up for a challenge, the schema diagrams and SQL files are included so you can replicate the database in your DBMS and test your output there.
* Alternatively, the "with-expected-queries" branch shows correct (albeit not necessarily elegant) queries that you can simply recreate with the builder.
* We will test the generated queries with our copy of the database, so your output does not have to match our expected queries exactly. Any equivalent query will do; you may simply use our answers to the problem set as a guide.
* As the source package was developed (virtually) entirely using test-driven development (TDD), you may find the test package and commit history useful for determining the exact purpose and output of each method.
* Feel free to modify or extend the code as you please, so long as you stick to the purpose of the ME, i.e. the Builder pattern. For example, you may wish to pipe output to a file instead, or experiment with creating queries other than SELECT.
