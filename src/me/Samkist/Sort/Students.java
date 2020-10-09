package me.Samkist.Sort;

import java.util.ArrayList;
import java.util.Iterator;

public class Students {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Main main;

    public Students(Main main) {
        this.main = main;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void sort(String type) {
        new Sorter<>(students, type);
    }

    public void addStudent(Student s) {
        students.add(s);
        new Sorter<>(students, "id");
        main.updateList();
    }

    public Student getStudent(int id) throws NullPointerException {
        Iterator<Student> it = students.iterator();

        while(it.hasNext()) {
            Student current = it.next();
            if(current.getStudentID() == id) {
                return current;
            }
        }
        throw new NullPointerException("Student with this ID not found.");
    }

    public void removeStudent(int id) throws NullPointerException {
        Iterator<Student> it = students.iterator();

        while(it.hasNext()) {
            Student current = it.next();
            if(current.getStudentID() == id) {
                it.remove();
                return;
            }
        }
        throw new NullPointerException("Student with this ID not found.");
    }

    public ArrayList<Student> getSortedByID() {
        return new Sorter<Student>(students, "id").get();
    }

    public ArrayList<Student> getSortedByGPA() {
        return new Sorter<Student>(students, "gpa").get();
    }
}
