package arbol;

public interface BTree<E extends Comparable>{
    // Cada árbol no vacío tiene dos hijos, derecha e izquierda. 
    // Estas constantes deben ser usadas para decirle el lado sobre el cual se va a insertar o extraer 
    // De esta manera no se tiene que duplciar código para cada lado 
    // Se puede usar una enimeración para hacer esto
    static final int IZQ = 0;
    static final int DER = 1;

    // Retorna true si el árbol está vacío
    boolean estaVacio();
    // Retorna la información almacenada en la raíz del árbol, su hijo de la izquierda y de la derecha
    // BTreeExceptions son lanzadas si el árbol está vacío.
    E getInfo() throws BTreeException;
    BTree<E> getIzq() throws BTreeException;
    BTree<E> getDer() throws BTreeException;

    // Inserta un árbol en el hijo de la derecha o izquierda
    //
    // Una BTreeException es lanzada si el lado no es izquierda o derecha
    // o si el árbol de la insercción está vacío
    void insertar(BTree<E> arbol, int lado) throws BTreeException;
    void insertar(E infor) throws BTreeException;

    // Returna y extrae el hijo especificado (IZQ o DER)
    //
    // Una BTreeException es lanzada si el lado no es IZQ o DER o si 
    // el árbol donde se quiere extraer está vacío
    BTree<E> extraer(int side) throws BTreeException;

    // Generate una representación textual del árbol.
    //
    // toString por defecto muestra en pre-order.
    String toStringPreOrder();
    String toStringInOrder();
    String toStringPostOrder();
    String toString(); // pre-order

    // Retorna el tamaño del árbol (número de nodos)
    // 0 si está vacio
    int tamano();
    // Retorna la altura del arbol (número de saltos entre la raíz
    // y su hijo hoja de mas profundidad).
    // -1 para árboles vacío.
    int altura();

    // Retorna verdadero si el árbol es igua a otro árbol.
    //
    // Dos árboles son iguales si sus nodos mantienen la misma información
    // y si ellos son distribuidos en la misma forma.
    boolean equals(BTree<E> tree);
    // Verdadero su el subárbol "arbol" es igual al almacenado.
    boolean encontrar(BTree<E> arbol);
}