package model;

import java.awt.*;

public class Rectangulo extends Forma{
    public Rectangulo(Point punto, int ancho, int alto, boolean tieneRelleno, Color color) {
        super(punto, ancho, alto, tieneRelleno, color);
    }

    @Override
    public void Dibujar(Graphics g) {
        g.setColor(getColor());
        if (isTieneRelleno()) {
            g.fillRect(getPunto().x, getPunto().y, getAncho(), getAlto());
        } else {
            g.drawRect(getPunto().x, getPunto().y, getAncho(), getAlto());
        }
    }

}
