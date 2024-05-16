package arbol;


public class Ciudades {
    public static void main(String[] args) throws BTreeException{
        //BTree<Persona> ana = new LBTree<Persona>(new Persona("Ana", 20));
        BTree<String> madrid = new LBTree<String>(new String("Madrid"));
        BTree<String> paris = new LBTree<>("Paris");
        BTree<String> berlin = new LBTree<>("Berlin");
        BTree<String> brusselas = new LBTree<>("Brusselas");
        BTree<String> lima = new LBTree<>("Lima");
        BTree<String> moscu = new LBTree<>("Moscu");
        BTree<String> hanoi = new LBTree<>("Hanoi");
        BTree<String> praga = new LBTree<>("Praga");
        BTree<String> kiev = new LBTree<>("Kiev");
        BTree<String> seoul = new LBTree<>("Seoul");
        BTree<String> taipei = new LBTree<>("Taipei");  
       
        try {
            praga.insertar(seoul, BTree.IZQ);
            praga.insertar(taipei, BTree.DER);
            moscu.insertar(praga, BTree.IZQ);
            berlin.insertar(lima, BTree.IZQ);
            berlin.insertar(moscu, BTree.DER);
            hanoi.insertar(kiev, BTree.DER);
            brusselas.insertar(hanoi, BTree.IZQ);
            paris.insertar(brusselas, BTree.IZQ);
            madrid.insertar(paris, BTree.IZQ);
            madrid.insertar(berlin, BTree.DER);
        } catch (BTreeException e) {
            System.err.println("ERROR: " + e);
            return;
        }
        System.out.println("Tamaño del Arbol Madrid = " + madrid.tamano());
        System.out.println("Arbol Madrid = " + madrid);
        System.out.println("Tamaño del Arbol Moscu = " + moscu.tamano());
        System.out.println("Arbol Moscu = " + moscu.toStringPostOrder());
       System.out.println("Arbol Moscu = " + madrid.toStringPreOrder());  
       
    }
}