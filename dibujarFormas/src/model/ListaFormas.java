package model;

import java.awt.*;
import java.util.LinkedList;

public class ListaFormas {
    private LinkedList<Forma> formas;

    public ListaFormas() {
        formas = new LinkedList<>();
    }

    public void agregar(String tipo, Color color, Point punto, int ancho, int alto, boolean tieneRelleno, Graphics g) {
        Forma f = new Rectangulo(punto, ancho, alto, tieneRelleno, color);

        if (tipo.equals("Rectangulo")) {
            f = new Rectangulo(punto, ancho, alto, tieneRelleno, color);
            f.Dibujar(g);
        } else if (tipo.equals("Ovalo")) {
            f = new Ovalo(punto, ancho, alto, tieneRelleno, color);
            f.Dibujar(g);
        } else if (tipo.equals("RectRedondeado")) {
            f = new RectRedondeado(punto, ancho, alto, tieneRelleno, color);
            f.Dibujar(g);
        } else if (tipo.equals("Linea")) {
            f = new Linea(punto, ancho, alto, tieneRelleno, color);
            f.Dibujar(g);
        }

        formas.add(f);
    }

    public void borrarTodo() {
        formas.clear();
    }
}
