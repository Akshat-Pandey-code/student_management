public class Student{
    private int id;
    private String name;
    private String course;
    private int year;

    private int marks1;
    private int marks2;
    private int marks3;

    private int total;
    private double percentage;
    private String grade;

    
    public Student(int id, String name, String course, int year, int marks1, int marks2, int marks3) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.year = year;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;

        calculateResults(); // auto calculate total, percentage, grade
    }

        // Auto calculate total, percentage, grade
    private void calculateResults() {
        this.total = marks1 + marks2 + marks3;
        this.percentage = total / 3.0;

        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else grade = "F";
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getYear() { return year; }

    public int getMarks1() { return marks1; }
    public int getMarks2() { return marks2; }
    public int getMarks3() { return marks3; }

    public int getTotal() { return total; }
    public double getPercentage() { return percentage; }
    public String getGrade() { return grade; }

    //setters for update
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setYear(int year) { this.year = year; }

    public void setMarks(int m1, int m2, int m3) {
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        calculateResults(); // recalc result
    }

    @Override
    public String toString() {
        return  "ID: " + id + ", Name: " + name + ", Course: " + course + 
                ", Year: " + year + ", Marks: [" + marks1 + ", " + marks2 + ", " + marks3 + "]" +
                ", Total: " + total + ", %: " + String.format("%.2f", percentage) +
                ", Grade: " + grade;
    }

}