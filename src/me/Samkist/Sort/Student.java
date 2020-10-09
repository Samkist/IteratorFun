package me.Samkist.Sort;

public class Student implements Comparable<Student> {
    private static int ID = 0;
    private int studentID;
    private String name;
    private double GPA;
    private int grade;

    public Student(int id, String name, double gpa, int grade) {
        this.studentID = id;
        this.name = name;
        this.GPA = gpa;
        this.grade = grade;
    }

    public Student(String name, double gpa, int grade) {
        this.studentID = ID++;
        this.name = name;
        this.GPA = gpa;
        this.grade = grade;
    }

    public static int getID() {
        return ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //Used for comparison
    @Override
    public String toString() {
        return studentID + "";
    }

    //Used for printing
    public String print() {
        return "Name: " + getName() + "\n"
                + "ID: " + getID() + "\n"
                + "GPA: " + getGPA() + "\n"
                + "Grade: " + getGrade() + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return (int) (student.getStudentID() - getStudentID());
    }
}
