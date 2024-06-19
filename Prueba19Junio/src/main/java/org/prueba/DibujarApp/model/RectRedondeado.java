package org.prueba.DibujarApp.model;

import java.awt.*;

public class RectRedondeado extends Forma{
    public RectRedondeado (Point p, int ancho, int alto, boolean tieneRelleno, Color color){
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
            g.fillRoundRect(getPunto().x, getPunto().y, getAncho(), getAlto(), 20, 20);
        } else {
            g.drawRoundRect(getPunto().x, getPunto().y, getAncho(), getAlto(), 20, 20);
        }
    }
}
