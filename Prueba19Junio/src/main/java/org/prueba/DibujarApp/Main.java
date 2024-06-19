package org.prueba.DibujarApp;

import org.prueba.DibujarApp.controller.DibujarAppController;
import org.prueba.DibujarApp.view.HacerFormas;

public class Main {
    public static void main(String[] args) {
        DibujarAppController controller = new DibujarAppController(new HacerFormas());
    }
}
