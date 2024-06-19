package org.prueba.Serializacion;

import java.io.*;
import java.util.ArrayList;

public class ContenedorEmpleados {
    private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

    public void grabarDatos(){
        try{
            ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("empleados.txt"));
            archivo.writeObject(listaEmpleados);
            archivo.flush();
            archivo.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void recuperarDatos(){
        try {
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream("empleados.txt"));
            listaEmpleados = (ArrayList<Empleado>) archivo.readObject();
            archivo.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ContenedorEmpleados contenedor = new ContenedorEmpleados();
        contenedor.listaEmpleados.add(new Empleado("Juan", "Perez", 30));
        contenedor.listaEmpleados.add(new Empleado("Ana", "Lopez", 25));
        contenedor.listaEmpleados.add(new Empleado("Pedro", "Gomez", 40));
        contenedor.grabarDatos();
        contenedor.recuperarDatos();
        for (Empleado empleado : contenedor.listaEmpleados){
            System.out.println(empleado);
        }
    }
}
