package org.prueba.DibujarApp.model;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class ListaFormas {
    private LinkedList<Forma> listaFormas;

    public ListaFormas(){
        listaFormas = new LinkedList<>();
    }


    public void agregar(String tipo, Point punto, int ancho, int alto, boolean tieneRelleno, Color color, Graphics g){
        Forma forma = null;
        switch (tipo){
            case "Rectangulo":
                forma = new Rectangulo(punto, ancho, alto, tieneRelleno, color);
                forma.dibujar(g);
                break;
            case "Ovalo":
                forma = new Ovalo(punto, ancho, alto, tieneRelleno, color);
                forma.dibujar(g);
                break;
            case "RectRedondeado":
                forma = new RectRedondeado(punto, ancho, alto, tieneRelleno, color);
                forma.dibujar(g);
                break;
        }
        listaFormas.add(forma);
    }

    public void grabarEnArchivo(String nombreArchivo){
        try {
            ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(nombreArchivo+".dat"));
            archivo.writeObject(listaFormas);
            archivo.flush();
            archivo.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void recuperarDeArchivo(String nombreArchivo){
        try {
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(nombreArchivo));
            listaFormas = (LinkedList<Forma>) archivo.readObject();
            archivo.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void dibujarFormas(Graphics g){
        for (Forma f : listaFormas){
            f.dibujar(g);
        }
    }

    public void borrarFormas(){
        listaFormas.clear();
    }
}
