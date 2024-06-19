package org.prueba.DibujarApp.model;

import java.awt.*;

public class Ovalo extends Forma{
    public Ovalo (Point p, int ancho, int alto, boolean tieneRelleno, Color color){
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
            g.fillOval(getPunto().x, getPunto().y, getAncho(), getAlto());
        } else {
            g.drawOval(getPunto().x, getPunto().y, getAncho(), getAlto());
        }
    }
}
