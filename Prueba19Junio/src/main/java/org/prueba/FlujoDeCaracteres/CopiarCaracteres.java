package org.prueba.FlujoDeCaracteres;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarCaracteres {
    public static void main(String[] args) {
        FileReader entrada = null;
        FileWriter salida = null;

        try {
            entrada = new FileReader("src/main/java/org/prueba/FlujoDeCaracteres/entrada.txt");
            salida = new FileWriter("src/main/java/org/prueba/FlujoDeCaracteres/salida.txt");

            int c;
            while ((c = entrada.read()) != -1) {
                salida.write(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
