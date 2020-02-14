package me.Samkist.Sort;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

import javax.swing.*;

public class AddStudentDialog extends GBDialog {

    private Main main;
    private JLabel nameLabel = addLabel("Name: ", 1, 1, 1, 1);
    private JTextField nameField = addTextField("", 1, 2, 1,1);
    private JButton startButton = addButton("Create Student", 2, 1,2, 1 );

    private IntegerField updateField = addIntegerField(1,1, 1, 1, 1);
    private JComboBox<String> dataType = addComboBox(1, 2, 1, 1);
    private JButton updateStudent = addButton("Update Student", 2, 1, 1, 1);
    private JTextArea displayArea = addTextArea("", 3, 1, 1,1);
    private JButton done = addButton("Done", 4, 1, 1, 1);

    private Student student;

    public AddStudentDialog(JFrame jFrame, Main main) {
        super(jFrame);
        displayArea.setEditable(false);
        displayArea.setVisible(false);
        this.main = main;

        dataType.addItem("HW Average");
        dataType.addItem("Quiz");
        dataType.addItem("Test");



        updateField.setVisible(false);
        dataType.setVisible(false);
        updateStudent.setVisible(false);
        done.setVisible(false);

        setTitle("Add Student");
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(startButton)) {
            nameField.setVisible(false);
            nameLabel.setVisible(false);
            startButton.setVisible(false);
            student = new Student(nameField.getText());

            updateField.setVisible(true);
            dataType.setVisible(true);
            updateStudent.setVisible(true);
            displayArea.setVisible(true);
            done.setVisible(true);
        }

        if(jButton.equals(updateStudent)) {
            if(dataType.getSelectedIndex() == 0) {
                student.setHomeWorkAverage((double) updateField.getNumber());
            }

            if(dataType.getSelectedIndex() == 1) {
                try {
                    student.addQuiz((double) updateField.getNumber());
                } catch(IndexOutOfBoundsException e) {
                    messageBox("Too many quizzes (Max 8)");
                }
            }

            if(dataType.getSelectedIndex() == 2) {
                try {
                    student.addTest((double) updateField.getNumber());
                } catch(IndexOutOfBoundsException e) {
                    messageBox("Too many tests (Max 5)");
                }
            }

            displayArea.setText(student.print());
        }

        if(jButton.equals(done)) {
            main.getStudents().addStudent(student);
            this.setVisible(false);
        }
    }
}
