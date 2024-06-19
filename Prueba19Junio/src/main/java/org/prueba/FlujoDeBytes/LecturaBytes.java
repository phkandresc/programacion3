package org.prueba.FlujoDeBytes;

import java.io.FileInputStream;
import java.io.IOException;

public class LecturaBytes {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/main/java/org/prueba/FlujoDeBytes/entrada.txt");
            int data = inputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
