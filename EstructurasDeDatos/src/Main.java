import ListaEnlazada.ListaEnlazada;
import Cola.Cola;
import ColaPrioridad.ColaPrioridad;
import Pilas.Pila;
import Arboles.BinaryTree;
import Map.*;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Cola cola = new Cola();
        ColaPrioridad colaPrioridad = new ColaPrioridad();
        Pila pila = new Pila();
        HashMapUse hashMapUse = new HashMapUse();
        BinaryTree binaryTree = new BinaryTree();

        hashMapUse.printMapEntry();
        System.out.println();
        hashMapUse.printMapIterator();
        System.out.println();
        TreeMapUse treeMapUse = new TreeMapUse();
        treeMapUse.printMapEntry();
        System.out.println();
        LinkedHashMapUse linkedHashMapUse = new LinkedHashMapUse();
        linkedHashMapUse.printMapEntry();
    }
}
