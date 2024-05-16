package arbol;
public class LBTree<E  extends Comparable> implements BTree<E>{
    private LBNode<E> raiz;
    public LBTree() {
        raiz = null;
    }
    public LBTree(E info) {
        raiz = new LBNode<E>(info, new LBTree<E>(), new LBTree<E>());
    }
   
    public boolean estaVacio() {
        return (raiz == null);
    }
 
    public E getInfo() throws BTreeException {
        if (estaVacio()) {
            throw new BTreeException("Arbol Vacío, no tiene información");
        }
        return raiz.getInfo();
    }

    public BTree<E> getIzq() throws BTreeException {
        if (estaVacio()) {
            throw new BTreeException("Arbol no tiene hijo de la izquierda");
        }
        return raiz.getIzq();
    }

    public BTree<E> getDer() throws BTreeException {
        if (estaVacio()) {
            throw new BTreeException("Arbol no tiene hijo de la derecha");
        }
        return raiz.getDer();
    }

    public void insertar(BTree<E> arbol, int lado) throws BTreeException {
        if (estaVacio()) 
        {
            
            throw new BTreeException("No puede insertar en un árbol Vacío");
        }
        if (lado == BTree.IZQ) {
            raiz.setIzq(arbol);
        } else if (lado == BTree.DER) {
            raiz.setDer(arbol);
        } else {
            throw new BTreeException("Invalido argumento lado");
        }
    }
    public void insertar(E infor) throws BTreeException {
        if (estaVacio()) {
            raiz = new LBNode<E>(infor, new LBTree<E>(), new LBTree<E>());
        }
        else if (raiz.getInfo().compareTo(infor)>0) {
            raiz.getIzq().insertar(infor); 
        }
        else if (raiz.getInfo().compareTo(infor)<0) {
            raiz.getDer().insertar(infor);
    }
   }
    
    public BTree<E> extraer(int lado) throws BTreeException {
        BTree<E> retval;
        try {
            if (lado == BTree.IZQ) {
                retval = getIzq();
                raiz.setIzq(new LBTree<E>());
            } else if (lado == BTree.DER) {
                retval = getDer();
                raiz.setDer(new LBTree<E>());
            } else {
                throw new BTreeException("Invalido argumento lado");
            }
        } catch (BTreeException e) {
            throw new BTreeException("No se puede extraer información, árbol vacío");
        }
        return retval;
    }

    public int tamano() { // número de nodos del árbol
        try {
            return 1 + getIzq().tamano() + getDer().tamano();
        } catch (BTreeException e) {
            return 0;
        }
    }

    public String toStringPreOrder() {
        try {
            return getInfo().toString() + " " +
                getIzq().toStringPreOrder() +
                getDer().toStringPreOrder();
        } catch (BTreeException e) {
            return "";
        }
    }

    public String toStringInOrder() {
        try {
            return getIzq().toStringInOrder() +
                getInfo().toString() + " " +
                getDer().toStringInOrder();
        } catch (BTreeException e) {
            return "";
        }
    }

    public String toStringPostOrder() {
        try {
            return getIzq().toStringPostOrder() +
                getDer().toStringPostOrder() +
                getInfo().toString() + " ";
        } catch (BTreeException e) {
            return "";
        }
    }

    public String toString() {
        return toStringPreOrder();
    }

    public int altura() {
        try {
            int alturaIzq = getIzq().altura();
            int alturaDer = getDer().altura();
            return 1 + Math.max(alturaIzq, alturaDer);
        } catch (BTreeException e) {
            return -1;
        }
    }

    public boolean equals(BTree<E> arbol) {
        try {
            return (getInfo().equals(arbol.getInfo()));// &&
                    //getIzq().equals(arbol.getIzq()) &&
                    //getDer().equals(arbol.getDer()));
        } catch (BTreeException e) {
            if (this.estaVacio() && arbol.estaVacio()) {
                return true;
            } else {
                return false;
            }
        }
    }    

    public boolean encontrar(BTree<E> arbol) {
        if (this.equals(arbol)) {
            return true;
        } else {
            try {
                if (getIzq().encontrar(arbol)) {
                    return true;
                } else {
                    return (getDer().encontrar(arbol));
                }
            } catch (BTreeException e) {
                return false;
            }
        }
    }
}