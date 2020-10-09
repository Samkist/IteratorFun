package me.Samkist.Sort;

import BreezySwing.DoubleField;
import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

import javax.swing.*;
import java.util.Iterator;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class EditStudentDialog extends GBDialog {

	private Main main;
	private Student student;
	private JLabel nameLabel = addLabel("Name: ", 1, 1, 1, 1);
	private JLabel gpaLabel = addLabel("GPA: ", 2, 1, 1, 1);
	private JLabel gradeLabel = addLabel("Grade: ",3, 1, 1, 1);
	private JTextField nameField = addTextField("", 1, 2, 1,1);
	private DoubleField gpaField = addDoubleField(0, 2, 2, 1, 1);
	private IntegerField gradeField = addIntegerField(9,3,2,1,1);
	private JButton editButton = addButton("Edit Student", 5, 1,2, 1 );
	private JButton removeButton = addButton("Remove Student", 6, 1, 2, 1);

	public EditStudentDialog(JFrame jFrame, Main main, Student s) {
		super(jFrame);
		this.main = main;
		this.student = s;

		nameField.setText(student.getName());
		gpaField.setNumber(student.getGPA());
		gradeField.setNumber(student.getGrade());
		setTitle("Add Student");
		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void buttonClicked(JButton jButton) {
		if(jButton.equals(editButton)) {
			if(!validateContainers())
				return;
			updateStudent();
			main.updateList();
			setVisible(false);
		}
		if(jButton.equals(removeButton)) {
			main.getStudents().removeStudent(student.getStudentID());
			main.updateList();
			setVisible(false);
		}
	}


	private void updateStudent() {
		Iterator<Student> it = main.getStudents().getStudents().iterator();
		while(it.hasNext()) {
			Student s = it.next();

			if(this.student.equals(s)) {
				it.remove();
			}
		}
		Student s = new Student(student.getStudentID(),
				nameField.getText(),
				gpaField.getNumber(),
				gradeField.getNumber());
		main.getStudents().addStudent(s);
		this.setVisible(false);
	}

	public boolean validateContainers() {
		boolean validated = gpaField.isValidNumber() && gradeField.isValidNumber();
		if(!validated)
			messageBox("Please enter valid data.");
		return validated;
	}
}
