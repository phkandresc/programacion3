package ColaPrioridad;

import java.util.PriorityQueue;
import java.util.Queue;

public class ColaPrioridad {
    private Queue<Integer> integerQueue = new PriorityQueue<>();

    public ColaPrioridad() {
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
    }

    public void printInfo() {
        System.out.println("Cola de prioridad de cadenas: " + integerQueue);
        System.out.println("Tamaño de la cola: " + integerQueue.size());
        System.out.println("Elemento mayor prioridad: " + integerQueue.peek());
        System.out.println("Eliminando el primer elemento(poll)...");
        integerQueue.poll();

        System.out.println("Elementos restantes:");
        while (!integerQueue.isEmpty()) {
            System.out.print(integerQueue.poll());
        }
    }
}
