package org.prueba.FlujoDeDatos;

import java.io.*;

public class LeerYEscribirDatos {
    static void escribirFichero(String nombreFich, String nomb[],
                                int ed[]) throws IOException, IOException {
        DataOutputStream salida =null;

        try {
            salida = new DataOutputStream(new FileOutputStream(nombreFich));
            for (int i = 0; i < nomb.length; i++) {
                salida.writeUTF(nomb[i]+'\n');
                salida.writeInt(ed[i]);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (salida != null) {
                salida.close();
            }
        }
    }

    static void leerFichero(String nombreFich) throws IOException {
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(nombreFich));
            while (true) {
                System.out.println("Nombre: " +entrada.readUTF()+"Edad: "+entrada.readInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Pedro", "María"};
        int[] edades = {18, 30, 45, 23};
        try {
            escribirFichero("src/main/java/org/prueba/FlujoDeDatos/datos.txt", nombres, edades);
            leerFichero("src/main/java/org/prueba/FlujoDeDatos/datos.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
