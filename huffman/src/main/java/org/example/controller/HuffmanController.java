package org.example.controller;

import org.example.model.ArbolHuffman;
import org.example.model.Nodo;
import org.example.model.Simbolo;
import org.example.view.HuffmanView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HuffmanController implements ActionListener {
    private HuffmanView view;
    private ArbolHuffman arbol;
    private Nodo raiz;
    private Simbolo[] simbolos;

    public HuffmanController(){
        view = new HuffmanView();
        arbol = new ArbolHuffman();
        view.btnSeleccionarArchivo.addActionListener(this);
        view.btnComprimir.addActionListener(e -> comprimirArchivo());
        view.btnDescomprimir.addActionListener(e -> descomprimirArchivo());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto y binarios", "txt", "bin"));
        int result = fileChooser.showOpenDialog(view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            view.txtArchivo.setText(selectedFile.getAbsolutePath());
        }
    }

    private void comprimirArchivo() {
        String archivoOrigen = view.txtArchivo.getText();
        String archivoDestino = archivoOrigen.replace(".txt", "_comprimido.bin");
        String contenido = leerArchivo(archivoOrigen);
        if (contenido != null) {
            arbol.ComprimeTexto(archivoDestino, contenido);
            JOptionPane.showMessageDialog(view, "Archivo comprimido exitosamente: " + archivoDestino);
        } else {
            JOptionPane.showMessageDialog(view, "Error al leer el archivo de origen.");
        }
    }

    private void descomprimirArchivo() {
        String archivoComprimido = view.txtArchivo.getText();
        String archivoDestino = archivoComprimido.replace("_comprimido.bin", "_descomprimido.txt");
        String contenido = arbol.DescomprimeTexto(archivoComprimido);
        if (contenido != null) {
            escribirArchivo(archivoDestino, contenido);
            JOptionPane.showMessageDialog(view, "Archivo descomprimido exitosamente: " + archivoDestino);
        } else {
            JOptionPane.showMessageDialog(view, "Error al descomprimir el archivo.");
        }
    }

    private String leerArchivo(String ruta) {
        try {
            return new String(Files.readAllBytes(Paths.get(ruta)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void escribirArchivo(String ruta, String contenido) {
        try {
            Files.write(Paths.get(ruta), contenido.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

