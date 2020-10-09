package me.Samkist.Sort;

import BreezySwing.GBFrame;

import javax.swing.*;
import java.awt.print.Book;
import java.util.Iterator;

public class Main extends GBFrame {

    private static JFrame frame = new Main();

    private JButton addStudent = addButton("New Student", 1, 1, 1, 1);
    private JList<String> studentList = addList(1, 2, 1, 1);

    private Students students = new Students(this);

    public Main() {
        updateList();
    }

    public static void main(String[] args) {
        frame.setSize(400, 400);
        frame.setTitle("Iterator Fun");
        frame.setVisible(true);
    }

    public void disableAddStudent() {
        addStudent.setEnabled(false);
    }

    public Students getStudents() {
        return students;
    }

    public void updateList() {
        DefaultListModel<String> model = (DefaultListModel<String>)studentList.getModel();
        Iterator<Student> it = students.getStudents().iterator();
        model.removeAllElements();
        students.sort("id");
        model.addElement("Students List - Double Click to Edit");
        while(it.hasNext()) {
            Student s = it.next();

            model.addElement("ID: " + s.getStudentID() + " Name: " + s.getName() + " GPA: " + s.getGPA() + " Grade: " + s.getGrade());
        }

    }

    @Override
    public void buttonClicked(JButton jButton) {
        if (jButton.equals(addStudent)) {
            new AddStudentDialog(frame, this);
        }
    }

    public void listDoubleClicked(JList<String> listObj, String itemClicked) {
        if(listObj.equals(studentList)) {
            if(itemClicked.startsWith("Students"))
                return;
            int studentID = Integer.parseInt(itemClicked.split(" ")[1]);
            new EditStudentDialog(frame,this,students.getStudent(studentID));
        }
    }
}
