package org.prueba.FlujoDeBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarBytes {
    /*
     * Copia un archivo de texto byte a byte
     * */

    public static void main(String[] args) throws IOException {
        //FileInputStream flujo de entrada de bytes
        FileInputStream entrada = null;
        //FileOutputStream flujo de salida de bytes
        FileOutputStream salida = null;

        try {
            //entrada.txt es el archivo que se va a copiar
            entrada = new FileInputStream("src/main/java/org/prueba/FlujoDeBytes/entrada.txt");
            //salida.txt es el archivo que se va a crear con la copia
            salida = new FileOutputStream("src/main/java/org/prueba/FlujoDeBytes/salida.txt");

            //lee y copia byte a byte
            int c;
            //lee un byte del archivo de entrada y lo escribe en el archivo de salida
            while ((c = entrada.read()) != -1) {
                salida.write(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //cierra los flujos
            if (entrada != null) {
                entrada.close();
            }
            //cierra los flujos
            if (salida != null) {
                salida.close();
            }
        }

    }
}
