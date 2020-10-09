package me.Samkist.Sort;

import BreezySwing.DoubleField;
import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

import javax.swing.*;

public class AddStudentDialog extends GBDialog {

    private Main main;
    private JLabel nameLabel = addLabel("Name: ", 1, 1, 1, 1);
    private JLabel gpaLabel = addLabel("GPA: ", 2, 1, 1, 1);
    private JLabel gradeLabel = addLabel("Grade: ",3, 1, 1, 1);
    private JTextField nameField = addTextField("", 1, 2, 1,1);
    private DoubleField gpaField = addDoubleField(0, 2, 2, 1, 1);
    private IntegerField gradeField = addIntegerField(9,3,2,1,1);
    private JButton createButton = addButton("Create Student", 5, 1,2, 1 );

    public AddStudentDialog(JFrame jFrame, Main main) {
        super(jFrame);
        this.main = main;

        setTitle("Add Student");
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(createButton)) {
            if(!validateContainers())
                return;
            main.getStudents().addStudent(new Student(
                    nameField.getText(),
                    gpaField.getNumber(),
                    gradeField.getNumber()
            ));
            main.updateList();
            setVisible(false);
        }
    }

    public boolean validateContainers() {
        boolean validated = gpaField.isValidNumber() && gradeField.isValidNumber();
        if(!validated)
            messageBox("Please enter valid data.");
        return validated;
    }
}
