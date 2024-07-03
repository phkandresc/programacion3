package org.pruebaencriptacion.controller;

import org.pruebaencriptacion.model.Cifrado;
import org.pruebaencriptacion.view.CifradoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CifradoController implements ActionListener {
    private Cifrado cifrado;
    private CifradoView view;
    private File archivoEncriptar;
    private File archivoDesencriptar;
    private File archivoClaveDesencriptar;

    public CifradoController( ) {
        this.view = new CifradoView();
        this.cifrado = new Cifrado();
        view.btnCargarArchivoCifrar.addActionListener(this);
        view.btnEncriptar.addActionListener(this);
        view.btnCargarArchivoDesencriptar.addActionListener(this);
        view.btnCargarClaveDesencriptacion.addActionListener(this);
        view.btnDesencriptar.addActionListener(this);
        view.setVisible(true);
    }

    public void cargarMensajeDesdeArchivo(String nombreArchivo) throws IOException {
        StringBuilder mensaje = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                mensaje.append(scanner.nextLine());
            }
        }
        String mensajeCifrado = cifrado.cifrar(mensaje.toString());
        guardarMensajeCifrado(mensajeCifrado, "mensaje_cifrado.txt");
        guardarMatrizComoClave(cifrado.getMatriz(), "clave.txt");
    }

    private void guardarMensajeCifrado(String mensajeCifrado, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(mensajeCifrado);
        }
    }

    private void guardarMatrizComoClave(char[][] matriz, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (char[] fila : matriz) {
                writer.write(String.valueOf(fila));
                writer.newLine();
            }
        }
    }


    public void cargarClaveDesdeArchivo(String nombreArchivo) throws IOException {
        List<char[]> filas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                filas.add(linea.toCharArray());
            }
        }
        char[][] matriz = new char[filas.size()][];
        for (int i = 0; i < filas.size(); i++) {
            matriz[i] = filas.get(i);
        }
        cifrado.setMatriz(matriz);
    }

    public void desencriptarMensajeDesdeArchivo(String mensajeCifradoArchivo, String claveArchivo) throws IOException {
        String mensajeCifrado = cargarMensajeDesdeArchivoSimple(mensajeCifradoArchivo);
        cargarClaveDesdeArchivo(claveArchivo);
        String mensajeDesencriptado = cifrado.descifrar(mensajeCifrado);
        guardarMensajeDesencriptado(mensajeDesencriptado, "mensaje_desencriptado.txt");
    }

    private String cargarMensajeDesdeArchivoSimple(String nombreArchivo) throws IOException {
        StringBuilder mensaje = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                mensaje.append(scanner.nextLine());
            }
        }
        return mensaje.toString();
    }

    private void guardarMensajeDesencriptado(String mensajeDesencriptado, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(mensajeDesencriptado);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnCargarArchivoCifrar) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            archivoEncriptar = fileChooser.getSelectedFile();
            view.txtArchivoEncriptar.setText(archivoEncriptar.getAbsolutePath());

        } else if (e.getSource() == view.btnEncriptar) {
            // Pedir ancho
            int ancho = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ancho de la matriz"));
            cifrado = new Cifrado(ancho);
            try {
                cargarMensajeDesdeArchivo(archivoEncriptar.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Mensaje cifrado y clave guardados correctamente.");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == view.btnCargarArchivoDesencriptar) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            archivoDesencriptar = fileChooser.getSelectedFile();
            view.txtArchivoDesencriptar.setText(archivoDesencriptar.getAbsolutePath());
        }else if (e.getSource() == view.btnCargarClaveDesencriptacion) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            archivoClaveDesencriptar = fileChooser.getSelectedFile();
            view.txtArchivoClave.setText(archivoClaveDesencriptar.getAbsolutePath());
        } else if (e.getSource() == view.btnDesencriptar) {
            try {
                desencriptarMensajeDesdeArchivo(archivoDesencriptar.getAbsolutePath(), archivoClaveDesencriptar.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Mensaje desencriptado guardado correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al desencriptar el mensaje.");
            }
        }
    }

    public static void main(String[] args) {
        new CifradoController();
    }
}

