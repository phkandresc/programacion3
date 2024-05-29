package model;

import java.awt.*;

public class RectRedondeado extends Forma {
    public RectRedondeado(Point punto, int ancho, int alto, boolean tieneRelleno, Color color) {
        super(punto, ancho, alto, tieneRelleno, color);
    }

    @Override
    public void Dibujar(Graphics g) {
        g.setColor(getColor());
        if (isTieneRelleno()) {
            g.fillRoundRect(getPunto().x, getPunto().y, getAncho(), getAlto(), 20, 20);
        } else {
            g.drawRoundRect(getPunto().x, getPunto().y, getAncho(), getAlto(), 20, 20);
        }
    }
}
