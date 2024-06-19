package org.prueba.DibujarApp.model;

import java.awt.*;
import java.io.Serializable;

public abstract class Forma implements Serializable {
    private Point punto;
    private int ancho, alto;
    private boolean tieneRelleno;
    private Color color;

    public Point getPunto() {
        return punto;
    }

    public void setPunto(Point punto) {
        this.punto = punto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public boolean getTieneRelleno() {
        return tieneRelleno;
    }

    public void setTieneRelleno(boolean tieneRelleno) {
        this.tieneRelleno = tieneRelleno;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void dibujar(Graphics g);
}
