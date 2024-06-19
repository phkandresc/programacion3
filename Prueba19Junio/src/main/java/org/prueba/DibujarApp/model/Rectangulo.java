package org.prueba.DibujarApp.model;

import java.awt.*;

public class Rectangulo extends Forma{
    public Rectangulo (Point p, int ancho, int alto, boolean tieneRelleno, Color color){
        setPunto(p);
        setAncho(ancho);
        setAlto(alto);
        setTieneRelleno(tieneRelleno);
        setColor(color);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (getTieneRelleno()){
            g.fillRect(getPunto().x, getPunto().y, getAncho(), getAlto());
        } else {
            g.drawRect(getPunto().x, getPunto().y, getAncho(), getAlto());
        }
    }
}
