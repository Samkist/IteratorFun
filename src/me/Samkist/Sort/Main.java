package me.Samkist.Sort;

import BreezySwing.GBFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.Iterator;

public class Main extends GBFrame {

    private static JFrame frame = new Main();

    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton idButton = addRadioButton("Sort ID",3, 1, 1, 1);
    private JRadioButton gpaButton = addRadioButton("Sort GPA",4, 1, 1, 1);
    private JButton addStudent = addButton("New Student", 1, 1, 1, 1);
    private JList<String> studentList = addList(1, 2, 1, 4);

    private Students students = new Students(this);

    public Main() {
        updateList();

        bg.add(idButton);
        bg.add(gpaButton);
        idButton.addActionListener(buttonListener);
        gpaButton.addActionListener(buttonListener);
        idButton.setSelected(true);
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
        if(idButton.isSelected()) {
            students.sort("id");
        } else if(gpaButton.isSelected()) {
            students.sort("gpa");
        }
        Iterator<Student> it = students.getStudents().iterator();
        model.removeAllElements();
        model.addElement("Students List - Double Click to Edit");
        while(it.hasNext()) {
            Student s = it.next();

            model.addElement("ID: " + s.getStudentID() + " Name: " + s.getName() + " GPA: " + s.getGPA() + " Grade: " + s.getGrade());
        }

    }

    ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            updateList();
        }
    };

    @Override
    public void buttonClicked(JButton jButton) {
        if (jButton.equals(addStudent)) {
            new AddStudentDialog(frame, this);
        }
        updateList();
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
