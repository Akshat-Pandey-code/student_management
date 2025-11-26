import java.io.FileWriter;
import java.util.*;

public class Main {
    
    private static ArrayList<Student> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        

         while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sorting Options");
            System.out.println("7. Class Analysis");
            System.out.println("8. Save students to File");
            System.out.println("9. Exit");
            
            System.out.print("Enter choice: ");

             int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: updateStudent(); break;
                case 6: sortingMenu(); break;
                case 7: classAnalysis(); break;
                case 8: saveToFile();
                break;  
                case 9: 
                    System.out.println("Exiting Program. Goodbye!");
                    System.exit(0);
  

                default: System.out.println("Invalid Choice!");
            }
         }
    }
    //Case 1: adding students
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

    int year;

    while (true) {
        System.out.print("Enter Year (YYYY): ");
        year = sc.nextInt();

        if (year >= 1900 && year <= 2100) {
            break; // valid year
        }

        System.out.println("Invalid year! Please enter a valid 4-digit year.");
    }

        System.out.print("Enter Marks in Subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter Marks in Subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter Marks in Subject 3: ");
        int m3 = sc.nextInt();

        list.add(new Student(id, name, course, year, m1, m2, m3));

        System.out.println("Student Added Successfully!");
    }


    //Case 2: viewing students
    public static void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    //Case 3: Searching students
    public static void searchStudent() {
    if (list.isEmpty()) {
        System.out.println("No students available to search!");
        return;
    }

    System.out.println("\nSearch By:");
    System.out.println("1. Search by ID");
    System.out.println("2. Search by Name");
    System.out.print("Enter choice: ");
    int ch = sc.nextInt();
    sc.nextLine();

    boolean found = false;

        switch (ch) {
            case 1:
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                for (Student s : list) {
                    if (s.getId() == id) {
                        System.out.println("\nStudent Found:");
                        System.out.println(s);
                        found = true;
                        break;
                    }
                }   break;
            case 2:
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine().toLowerCase();
                for (Student s : list) {
                    if (s.getName().toLowerCase().contains(name)) {
                        System.out.println("\nStudent Found:");
                        System.out.println(s);
                        found = true;
                    }
                }   break;
            default:
                System.out.println("Invalid Search Option!");
                return;
        }

      if (!found) {
         System.out.println("No matching student found!");
      }
    }
    
    //Case 4: Delete Students
    public static void deleteStudent() {

        if (list.isEmpty()) {
            System.out.println("No students available to delete!");
            return;
        }

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                removed = true;
                System.out.println("Student Deleted Successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with given ID not found!");
        }
    }
    //Case 5: Update Students
    public static void updateStudent() {

        if (list.isEmpty()) {
            System.out.println("No students available to update!");
            return;
        }

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        Student target = null;

        for (Student s : list) {
            if (s.getId() == id) {
                target = s;
                break;
            }
        }

        if (target == null) {
            System.out.println("Student with given ID not found!");
            return;
        }

        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Course");
        System.out.println("3. Year");
        System.out.println("4. Marks");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                target.setName(newName);
                System.out.println("Name updated successfully!");
                break;

            case 2:
                System.out.print("Enter new course: ");
                String newCourse = sc.nextLine();
                target.setCourse(newCourse);
                System.out.println("Course updated successfully!");
                break;

            case 3:
                System.out.print("Enter new year: ");
                int newYear = sc.nextInt();
                target.setYear(newYear);
                System.out.println("Year updated successfully!");
                break;

            case 4:
                System.out.print("Enter Marks in Subject 1: ");
                int m1 = sc.nextInt();

                System.out.print("Enter Marks in Subject 2: ");
                int m2 = sc.nextInt();

                System.out.print("Enter Marks in Subject 3: ");
                int m3 = sc.nextInt();

                target.setMarks(m1, m2, m3); // auto recalculates total, % and grade
                System.out.println("Marks updated successfully!");
                break;

            default:
                System.out.println("Invalid update option!");
                return;
        }

        System.out.println("\nUpdated Student Details:");
        System.out.println(target);
    }

    //Case 6: sorting students
    public static void sortingMenu() {

        if (list.isEmpty()) {
            System.out.println("No students available to sort!");
            return;
        }

        System.out.println("\nSort By:");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Name");
        System.out.println("3. Sort by Total Marks");
        System.out.println("4. Sort by Percentage");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        switch(ch) {
            case 1:
                Collections.sort(list, Comparator.comparingInt(Student::getId));
                System.out.println("Sorted by ID!");
                break;

            case 2:
                Collections.sort(list, Comparator.comparing(Student::getName));
                System.out.println("Sorted by Name!");
                break;

            case 3:
                Collections.sort(list, Comparator.comparingInt(Student::getTotal).reversed());
                System.out.println("Sorted by Total Marks (Highest first)!");
                break;

            case 4:
                Collections.sort(list, Comparator.comparingDouble(Student::getPercentage).reversed());
                System.out.println("Sorted by Percentage (Highest first)!");
                break;

            default:
                System.out.println("Invalid sorting option!");
                return;
        }

        System.out.println("\nSorted Student List:");
        viewStudents();  // reuse  view method
    }
    
    //Case 7: Class Analysis
    public static void classAnalysis() {

        if (list.isEmpty()) {
            System.out.println("No students available for analysis!");
            return;
        }

        int totalMarksSum = 0;
        Student topper = list.get(0);
        Student lowest = list.get(0);

        int passCount = 0;
        int failCount = 0;

        for (Student s : list) {

            // For topper
            if (s.getTotal() > topper.getTotal())
                topper = s;

            // For lowest
            if (s.getTotal() < lowest.getTotal())
                lowest = s;

            // For average
            totalMarksSum += s.getPercentage();

            // Pass/fail logic
            if (s.getGrade().equals("F"))
                failCount++;
            else
                passCount++;
        }

        double avgPercentage = totalMarksSum / list.size();

        System.out.println("\n===== CLASS ANALYSIS REPORT =====");
        System.out.println("Topper: " + topper.getName() + " (" 
            + String.format("%.2f", topper.getPercentage()) + "%)");

        System.out.println("Lowest Scorer: " + lowest.getName() + " (" 
            + String.format("%.2f", lowest.getPercentage()) + "%)");

        System.out.println("Class Average Percentage: " 
            + String.format("%.2f", avgPercentage));

        System.out.println("Passed Students: " + passCount);
        System.out.println("Failed Students: " + failCount);
    }
    
   //Case 8: Save data to file
    public static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");

            for (Student s : list) {
                fw.write(
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getCourse() + "," +
                    s.getYear() + "," +
                    s.getMarks1() + "," +
                    s.getMarks2() + "," +
                    s.getMarks3() + "," +
                    s.getTotal() + "," +
                    s.getPercentage() + "," +
                    s.getGrade() + "\n"
                );
            }

            fw.close();
            System.out.println("Student data saved to file successfully!");

        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }


}
