package model;

import java.awt.*;

public abstract class Forma {
    private Point punto;
    private int ancho, alto;
    private boolean tieneRelleno;
    private Color color;

    public Forma(Point punto, int ancho, int alto, boolean tieneRelleno, Color color) {
        this.punto = punto;
        this.ancho = ancho;
        this.alto = alto;
        this.tieneRelleno = tieneRelleno;
        this.color = color;
    }

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

    public boolean isTieneRelleno() {
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

    public abstract void Dibujar(Graphics g);
}
