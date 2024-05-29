package Controller;

import View.NicomacoView;
import Model.NicomacoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NicomacoController implements ActionListener {
    private NicomacoModel model;
    private NicomacoView view;

    public NicomacoController(){
        this.model = new NicomacoModel();
        this.view = new NicomacoView();
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setContentPane(view.contentPanel);
        view.pack();
        view.setVisible(true);
        view.calcularButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.calcularButton){
            view.txtResultado.setText("");
            model.setFilas(Integer.parseInt(view.txtIngresarNumero.getText()));
            view.txtResultado.setText(model.calcularCubos());
        }
    }
}
