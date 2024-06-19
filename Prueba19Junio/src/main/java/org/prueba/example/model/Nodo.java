package org.example.model;

public class Nodo{
 private Character caracter;
     private Integer value;
     private Nodo izq;
     private Nodo der;
     private String camino;
     
     public Nodo(){
         value = null;
         izq = null;
         der = null;
         camino = "";
     }
     
     public Nodo(Character caracter, Integer value){
         this.caracter = caracter;
         this.value = value;
         izq = null;
         der = null;
         camino = "";
     }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Nodo getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }
}
