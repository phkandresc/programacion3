package Cola;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<String> stringQueue = new LinkedList<>();

    public Cola() {
        stringQueue.add("Primero");
        stringQueue.add("Segundo");
        stringQueue.add("Tercero");
        stringQueue.add("Cuarto");
        stringQueue.add("Quinto");
    }

    public void printInfo() {
        System.out.println("Cola de cadenas: " + stringQueue);
        System.out.println("Tamaño de la cola: " + stringQueue.size());
        System.out.println("Primer elemento: " + stringQueue.peek());
        System.out.println("Eliminando el primer elemento(poll)...");
        stringQueue.poll();
        System.out.println("Cola de cadenas: " + stringQueue);
    }

}
