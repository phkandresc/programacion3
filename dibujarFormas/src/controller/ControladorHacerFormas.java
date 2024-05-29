package controller;

import model.ListaFormas;
import view.HacerFormas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorHacerFormas implements ActionListener, MouseListener {
    private HacerFormas vista;
    private ListaFormas formas;
    private Point puntoInicial;
    private Color color;

    public ControladorHacerFormas(HacerFormas vista) {
        this.vista = vista;
        this.formas = new ListaFormas();
        this.vista.btnGrabar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnRestaurar.addActionListener(this);
        this.vista.btnColorFigura.addActionListener(this);
        this.vista.lienzo.addMouseListener(this);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLimpiar) {
            vista.lienzo.repaint();
            formas.borrarTodo();
        } else if (e.getSource() == vista.btnRestaurar) {
            JOptionPane.showMessageDialog(null, "Restaurar");
        } else if (e.getSource() == vista.btnGrabar) {
            JOptionPane.showMessageDialog(null, "Grabar");
        } else if (e.getSource() == vista.btnColorFigura) {
            color = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        puntoInicial = e.getPoint().getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point p = e.getPoint().getLocation();
        formas.agregar(vista.comboBox.getSelectedItem().toString(),
                color,
                puntoInicial,
                Math.abs(p.x - puntoInicial.x),
                Math.abs(p.y - puntoInicial.y),
                vista.rdbtnRelleno.isSelected(),
                vista.lienzo.getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
