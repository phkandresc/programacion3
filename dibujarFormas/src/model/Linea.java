package model;

import java.awt.*;

public class Linea extends Forma{
    public Linea(Point punto, int ancho, int alto, boolean tieneRelleno, Color color) {
        super(punto, ancho, alto, tieneRelleno, color);
    }

    @Override
    public void Dibujar(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getPunto().x, getPunto().y, getPunto().x + getAncho(), getPunto().y + getAlto());
    }
}
