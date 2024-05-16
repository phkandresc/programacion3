package arbol;

class LBNode<E extends Comparable> {
    private E info;
    private BTree<E> izq;
    private BTree<E> der;

    LBNode(E info, BTree<E> izq, BTree<E> der) {
        this.izq = izq;
        this.der = der;
        this.info = info;
    }

    E getInfo() {
        return info;
    }

    void setInfo(E info) {
        this.info = info;
    }

    BTree<E> getIzq() {
        return izq;
    }

    void setIzq(BTree<E> izq) {
        this.izq = izq;
    }

    BTree<E> getDer() {
        return der;
    }

    void setDer(BTree<E> der) {
        this.der = der;
    }
}