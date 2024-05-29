package Controller;

import Model.Student;
import View.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController implements ActionListener {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
        this.view.btnUpdate.addActionListener(this);
        view.setVisible(true);
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentRollNumber(String rollNumber) {
        model.setRollNumber(rollNumber);
    }

    public String getStudentName() {
        return model.getName();
    }

    public String getStudentRollNumber() {
        return model.getRollNumber();
    }

    public void updateView() {
        view.viewStudentInfo(model.getRollNumber(), model.getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnUpdate) {
            setStudentName("Jane");
            setStudentRollNumber("12345");
            updateView();
        }
    }
}
