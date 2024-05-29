package model;

import java.awt.*;

public class Ovalo extends Forma{

    public Ovalo(Point punto, int ancho, int alto, boolean tieneRelleno, Color color) {
        super(punto, ancho, alto, tieneRelleno, color);
    }

    @Override
    public void Dibujar(Graphics g) {
        g.setColor(getColor());
        if (isTieneRelleno()) {
            g.fillOval(getPunto().x, getPunto().y, getAncho(), getAlto());
        } else {
            g.drawOval(getPunto().x, getPunto().y, getAncho(), getAlto());
        }
    }
}
