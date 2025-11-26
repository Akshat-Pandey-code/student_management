# Student Management System 

 A complete Console-based **Student Management System** demonstrating:

1. OOP Concepts
2. CRUD Operations
3. Collections (ArrayList)
4. Searching
5. Sorting
6. Analysis
7. Input Validation
8. Save to file

----

## Features
### 1. Add Student

* Accepts ID, Name, Course, Year (YYYY), and 3 Subject Marks
* Automatically calculates:
   1. Total Marks
   2. Percentage (2 decimal places)
   3. Grade (A, B, C, F)

### 2. View All Students

* Prints all stored student records
* Uses Student class’s toString() for clean formatting

### 3. Search Student
* Search by ID
* Search by Name (full or partial)
* Case-insensitive search

### 4. Delete Student
* Delete a student by ID
* Safe removal using linear search

### 5. Update Student

 You can update:
  1. Name
  2. Course
  3. Year
  4. Marks (and auto recalculate totals)

### 6. Sorting Options
 Sort students by:
  1. ID
  2. Name
  3. Total Marks (descending)
  4. Percentage (descending)

### Uses Comparator + Collections.sort()

### 7. Class Analysis
* Calculates:
* Topper
* Lowest scorer
* Class average percentage
* Number of passed students
* Number of failed students
* All percentages formatted to 2 decimal places.

### 8. Save to file
- Saves all the data in a file

----

## Tech Stack
* Java 8+
* ArrayList
* Comparator
* OOP (Classes, Objects, Methods, Encapsulation)
* Scanner (Input)
* String.format() for formatting numeric output

----

## Project Structure
STUDENT_MANAGEMENT_SYSTEM
  |- Main.java
  |- Student.java

----

## Sample Output
===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View Students
3. Search Student
4. Delete Student
5. Update Student
6. Sorting Options
7. Class Analysis
8. Save to File
9. Exit

Enter choice:

----

## How to Run
- javac Main.java Student.java
- java Main

----