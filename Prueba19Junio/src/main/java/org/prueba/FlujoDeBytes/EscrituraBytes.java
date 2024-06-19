package org.prueba.FlujoDeBytes;

import java.io.FileOutputStream;
import java.io.IOException;

public class EscrituraBytes {
    public static void main(String[] args) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/main/java/org/prueba/FlujoDeBytes/entrada.txt");
            String data = "Hello, World!";
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
