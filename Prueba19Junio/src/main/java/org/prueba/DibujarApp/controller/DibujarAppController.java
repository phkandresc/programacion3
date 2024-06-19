package org.prueba.DibujarApp.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.prueba.DibujarApp.model.Forma;
import org.prueba.DibujarApp.model.ListaFormas;
import org.prueba.DibujarApp.view.HacerFormas;

public class DibujarAppController implements ActionListener, MouseListener {
    private HacerFormas view;
    private ListaFormas listaFormas;
    private Forma forma;
    private Point puntoInicial;
    private Point puntoFinal;
    private Color color;

    public DibujarAppController(HacerFormas hacerFormas){
        this.view = hacerFormas;
        this.listaFormas = new ListaFormas();
        this.view.btnLimpiar.addActionListener(this);
        this.view.btnGrabar.addActionListener(this);
        this.view.btnRestaurar.addActionListener(this);
        this.view.btnColorFigura.addActionListener(this);
        this.view.lienzo.addMouseListener(this);
        iniciar();
    }

    private void iniciar(){
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("./");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(e.getSource() == view.btnLimpiar){
            listaFormas.borrarFormas();
            view.lienzo.repaint();
        }

        if(e.getSource() == view.btnGrabar){
            if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION){
                listaFormas.grabarEnArchivo(fileChooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(view, "Archivo grabado correctamente");
            }
        }

        if(e.getSource() == view.btnRestaurar){
            System.out.println("Restaurar");
            listaFormas.borrarFormas();
            view.lienzo.repaint();
            if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
                listaFormas.recuperarDeArchivo(fileChooser.getSelectedFile().getAbsolutePath());
                listaFormas.dibujarFormas(view.lienzo.getGraphics());
                JOptionPane.showMessageDialog(view, "Archivo restaurado correctamente");
            }
        }

        if(e.getSource() == view.btnColorFigura){
            color = JColorChooser.showDialog(view, "Seleccione un color", null);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        puntoInicial = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        puntoFinal = e.getPoint();
        int ancho = Math.abs(puntoFinal.x - puntoInicial.x);
        int alto = Math.abs(puntoFinal.y - puntoInicial.y);
        listaFormas.agregar(view.comboBox.getSelectedItem().toString(), puntoInicial, ancho, alto, view.rdbtnRelleno.isSelected(), color, view.lienzo.getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
