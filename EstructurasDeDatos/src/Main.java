import ListaEnlazada.ListaEnlazada;
import Cola.Cola;
import ColaPrioridad.ColaPrioridad;
import Pilas.Pila;
import Arboles.BinaryTree;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Cola cola = new Cola();
        ColaPrioridad colaPrioridad = new ColaPrioridad();
        Pila pila = new Pila();

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(12);

        System.out.println("Arbol vacio: "+binaryTree.isEmpty());
        System.out.println("InOrder: ");
        binaryTree.inOrder();
        System.out.println("\nPreOrder: ");
        binaryTree.preorder();
        System.out.println("\nPostOrder: ");
        binaryTree.postorder();
        System.out.println("\nBuscar 7: "+binaryTree.search(7));
        System.out.println("Eliminar 7 ");
        binaryTree.delete(7);
        System.out.println("InOrder: ");
        binaryTree.inOrder();
    }
}
