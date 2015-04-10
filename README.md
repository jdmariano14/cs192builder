# CS 192 ME - Builder Pattern

## Given
A basic implementation of generating SQL queries in Java (using the Builder pattern).

## Task
Add code to the Main class to generate the expected SQL queries for items 1-5 using the QueryBuilder class.

## Deliverables
The Main class with the appropriate methods filled out, along with any other classes (if any) you decide to modify or extend.

## Notes
* The syntax for generating some example queries are included as a guide (below the blank item methods in the Main class).
* The required queries for this ME were taken from a CS 165 problem set that used a version of the Northwind database (https://northwinddatabase.codeplex.com/). The schema diagrams and SQL files are included if you wish to replicate the database in your DBMS for testing. 
* However, if you're feeling lazy, the "with-expected-queries" branch shows correct (albeit not necessarily elegant) queries that you can simply recreate with the builder.
* As the source package was developed (virtually) entirely using test-driven development (TDD), you may find the test package and commit history useful for determining the exact purpose and output of each method.
* Feel free to modify or extend the code as you please, so long as you stick to the purpose of the ME, i.e. the Builder pattern. For example, you may wish to pipe output to a file instead, or experiment with creating queries other than SELECT.
