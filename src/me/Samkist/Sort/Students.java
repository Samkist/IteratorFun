package me.Samkist.Sort;

import java.util.ArrayList;

public class Students {
    private static final int MAX_STUDENTS = 15;
    private ArrayList<Student> students = new ArrayList<>();
    private Main main;

    public Students(Main m) {
        main = m;
    }

    public void addStudent(Student s) throws IndexOutOfBoundsException {
        if(students.size() + 1 > 15) throw new IndexOutOfBoundsException();
        students.add(s);
        if(students.size() >= 15) main.disableAddStudent();
    }

    public ArrayList<Student> getSortedByName() {
        return new Sorter<Student>(students, "name").get();
    }

    public ArrayList<Student> getSortedByAverage() {
        return new Sorter<Student>(students, "normal").get();
    }
}
