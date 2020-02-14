package me.Samkist.Sort;

import BreezySwing.GBFrame;

import javax.swing.*;

public class Main extends GBFrame {

    private static JFrame frame = new Main();

    private JButton addStudent = addButton("New Student", 0, 0, 1, 1);
    private JButton byName = addButton("Sort by Name", 1, 0, 1, 1);
    private JButton byAverage = addButton("Sort by Average", 2, 1, 1,1);

    private Students students = new Students(this);

    public static void main(String[] args) {
        frame.setSize(400, 400);
        frame.setTitle("Selection Sort");
        frame.setVisible(true);
    }

    public void disableAddStudent() {
        addStudent.setEnabled(false);
    }

    public Students getStudents() {
        return students;
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if (jButton.equals(addStudent)) {
            new AddStudentDialog(frame, this);
        }

        if(jButton.equals(byName)) {
            new SortPrintDialog(frame, students.getSortedByName());
        }

        if(jButton.equals(byAverage)) {
            new SortPrintDialog(frame, students.getSortedByAverage());
        }
    }
}
