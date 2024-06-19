package org.prueba.ListaArticulos.model;

import java.io.Serializable;

public class Articulo implements Serializable {
    private int codigo;
    private String nombre;


    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
