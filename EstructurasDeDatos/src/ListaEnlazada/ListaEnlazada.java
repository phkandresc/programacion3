package ListaEnlazada;

import java.util.LinkedList;

public class ListaEnlazada {
    private LinkedList<Integer> integerList = new LinkedList<>();

    public ListaEnlazada() {
        for(int i = 1; i < 6; i++) {
            integerList.add(i);
        }
    }

    public void printInfo() {
        System.out.println("Lista de enteros: " + integerList);
        System.out.println("Tamaño de la lista: " + integerList.size());
        System.out.println("Primer elemento: " + integerList.getFirst());
        System.out.println("Último elemento: " + integerList.getLast());
        System.out.println("Elemento en la posición 2: " + integerList.get(1));
        System.out.println("Índice del elemento 3: " + integerList.indexOf(3));
        System.out.println("¿La lista contiene el número 3?: " + integerList.contains(3));
        System.out.println("¿La lista está vacía?: " + integerList.isEmpty());
        System.out.println("Eliminando el primer elemento...");
        integerList.removeFirst();
        System.out.println("Lista de enteros: " + integerList);
    }
}
