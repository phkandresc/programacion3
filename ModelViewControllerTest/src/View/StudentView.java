package View;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame{

    public JPanel panelInfo;
    public JLabel lblInfo;
    public JLabel lblTitulo;
    public JButton btnUpdate;

    public StudentView() {
        setTitle("Student View");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panelInfo = new JPanel();
        panelInfo.setBorder(BorderFactory.createEmptyBorder());
        panelInfo.setLayout(new GridLayout(0,1));
        panelInfo.add(lblTitulo = new JLabel("Student Information"));
        panelInfo.add(lblInfo = new JLabel());
        panelInfo.add(btnUpdate = new JButton("Update"));
        add(panelInfo);
    }

    public void viewStudentInfo(String rollNumber, String name) {
        lblInfo.setText(rollNumber + " " + name);
    }

}
