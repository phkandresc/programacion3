package org.prueba.ListaArticulos.controller;

import org.prueba.ListaArticulos.model.Articulo;

import java.io.*;
import java.util.ArrayList;

public class ArticulosController {
    private ArrayList<Articulo> listaArticulos ;
    private Articulo articulo;

    public ArticulosController() {
        this.articulo = new Articulo();
        this.listaArticulos= new ArrayList<>();
    }

    public void agregarArticulo(int codigo, String nombre){
        articulo = new Articulo();
        articulo.setCodigo(codigo);
        articulo.setNombre(nombre);
        listaArticulos.add(articulo);
    }

    public void nuevoProveedor(){
        listaArticulos = new ArrayList<>();
    }

    public void grabarArticulos(String nombreArchivo){
        try {
            ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(nombreArchivo + ".txt"));
            archivo.writeObject(listaArticulos);
            archivo.flush();
            archivo.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void recuperarArticulos(String nombreArchivo){
        try {
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(nombreArchivo + ".txt"));
            listaArticulos = null;
            listaArticulos = (ArrayList<Articulo>) archivo.readObject();
            archivo.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void imprimirArticulos(){
        for (Articulo articulo : listaArticulos){
            System.out.println(articulo.toString());
        }
    }

    public static void main(String[] args) {
        ArticulosController articulosController = new ArticulosController();
        articulosController.agregarArticulo(1, "Articulo 1");
        articulosController.agregarArticulo(2, "Articulo 2");
        articulosController.agregarArticulo(3, "Articulo 3");
        articulosController.grabarArticulos("articulosProveedor1");

        articulosController.nuevoProveedor();
        articulosController.agregarArticulo(4, "Articulo 4");
        articulosController.agregarArticulo(5, "Articulo 5");
        articulosController.agregarArticulo(6, "Articulo 6");
        articulosController.grabarArticulos("articulosProveedor2");

        articulosController.recuperarArticulos("articulosProveedor1");
        articulosController.imprimirArticulos();
        System.out.println("*******************");
        articulosController.recuperarArticulos("articulosProveedor2");
        articulosController.imprimirArticulos();


    }
}
