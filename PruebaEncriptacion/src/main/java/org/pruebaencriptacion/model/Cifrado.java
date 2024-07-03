package org.pruebaencriptacion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cifrado {
    private char[][] matriz;
    private int ancho;

    public Cifrado() {
    }

    public Cifrado(int ancho) {
        this.ancho = ancho;
        this.matriz = generarMatriz(ancho);
    }

    private char[][] generarMatriz(int ancho) {
        String caracteres = "abcdefghijklmnñopqrstuvwxyz1234567890_- .,$#%&+*/";
        List<char[]> filas = new ArrayList<>();

        // Variable para contar las filas que se van a generar
        int index = 0;

        /*Iterar sobre la cadena de caracteres
         con un incremento igual al ancho de la matriz
         para obtener las subcadenas de longitud igual al ancho
         */

        for (int i = 0; i < caracteres.length(); i += ancho) {
            // Calcular el índice final de la subcadena
            int end = Math.min(i + ancho, caracteres.length());
            // Agregar la subcadena a la lista de filas
            filas.add(caracteres.substring(i, end).toCharArray());
            // Incrementar el índice de las filas
            index++;
        }

        /* Crear una matriz de caracteres con las filas generadas
         y el ancho de la matriz
         */
        char[][] matriz = new char[index][ancho];
        // Iterar sobre las filas y agregarlas a la matriz
        for (int i = 0; i < filas.size(); i++) {
            // Obtener la fila actual
            char[] fila = filas.get(i);
            // Iterar sobre la fila y agregar los caracteres a la matriz
            for (int j = 0; j < fila.length; j++) {
                // Agregar el carácter a la matriz
                matriz[i][j] = fila[j];
            }
        }
        return matriz;
    }

    public String cifrar(String mensaje) {
        // Crear un StringBuilder para almacenar el mensaje cifrado
        StringBuilder mensajeCifrado = new StringBuilder();
        mensaje = mensaje.toLowerCase(); // Convertir el mensaje a minúsculas para asegurar la correspondencia con la matriz

        // Iterar sobre cada carácter del mensaje
        for (char c : mensaje.toCharArray()) {
            // Encontrar las coordenadas del carácter en la matriz
            int[] coordenadas = encontrarCoordenadas(c);
            // Añadir las coordenadas como fila y columna, empezando desde 0
            //append agrega los valores de las coordenadas al mensajeCifrado
            mensajeCifrado.append(String.format("%d%d ", coordenadas[0], coordenadas[1]));
        }
        // Devolver el mensaje cifrado como una cadena
        //toString convierte el mensajeCifrado a cadena
        //trim elimina los espacios en blanco al principio y al final de la cadena
        return mensajeCifrado.toString().trim();
    }

    public String descifrar(String mensajeCifrado) {
        // Crear un StringBuilder para almacenar el mensaje descifrado
        StringBuilder mensajeDescifrado = new StringBuilder();
        // Dividir el mensaje cifrado en partes separadas por espacios
        //split divide el mensajeCifrado en partes separadas por espacios
        String[] partes = mensajeCifrado.split(" ");

        // Iterar sobre cada parte del mensaje cifrado//
        // cada parte es una fila y columna
        for (int i = 0; i < partes.length; i++) {
            // fila es el primer dígito de la parte
            int fila = Integer.parseInt(partes[i])/10;
            // columna es el segundo dígito de la parte
            int columna = Integer.parseInt(partes[i]) % 10;
            // Agregar al mensaje descifrado el carácter correspondiente en la matriz
            mensajeDescifrado.append(matriz[fila][columna]);
        }
        // Devolver el mensaje descifrado como una cadena
        return mensajeDescifrado.toString();
    }

    private int[] encontrarCoordenadas(char c) {
        c = Character.toLowerCase(c); // Convertir a minúscula para asegurar la correspondencia con la matriz

        // Iterar sobre cada fila y columna de la matriz
        for (int fila = 0; fila < matriz.length; fila++) {
            // Iterar sobre cada columna de la fila actual
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                // Si el carácter actual es igual al carácter buscado
                if (matriz[fila][columna] == c) {
                    // Devolver las coordenadas de la fila y columna
                    return new int[]{fila, columna};
                }
            }
        }

        // Si el carácter no se encuentra en la matriz, lanzar una excepción
        throw new IllegalArgumentException("Carácter no encontrado en la matriz: " + c);
    }

    public void imprimirMatriz() {
        // Iterar sobre cada fila de la matriz
        for (char[] fila : matriz) {
            // Iterar sobre cada carácter de la fila
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
}





