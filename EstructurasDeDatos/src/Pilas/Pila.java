package Pilas;

import java.util.Stack;

public class Pila {
    private Stack<Integer> pila = new Stack<>();

    public Pila() {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
    }

    public void printInfo() {
        System.out.println("Pila:");

        System.out.println("¿La pila está vacía? " + pila.empty());
        System.out.println("Elemento en la parte superior de la pila: " + pila.peek());
        System.out.println("Eliminando elemento en la parte superior de la pila: " + pila.pop());
        System.out.println("Tamaño de la pila: " + pila.size());

        int posicion = pila.search(2);
        System.out.println("Posición de '2' en la pila: " + posicion);
        while (!pila.empty()) {
            System.out.println("Eliminando elemento en la parte superior de la pila: " + pila.pop());
        }
    }
}
