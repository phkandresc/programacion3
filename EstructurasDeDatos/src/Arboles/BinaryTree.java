package Arboles;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int data){
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data){
        if (root == null){
            root = new TreeNode(data);
            return root;
        }

        if (data < root.getData()){
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()){
            root.setRight(insertRec(root.getRight(), data));
        }

        return root;
    }

    //Izquierda, raiz, derecha
    public void inOrder(){
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root){
        if (root != null){
            inOrderRec(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderRec(root.getRight());
        }
    }

    //Raiz, izquierda, derecha
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
        }
    }

    //Izquierda, derecha, raiz
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.getLeft());
            postorderRec(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean search(int data){
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode root, int data) {
        if (root == null){
            return false;
        }

        if (root.getData() == data){
            return true;
        }else if (data < root.getData()){
            return searchRec(root.getLeft(), data);
        } else {
            return searchRec(root.getRight(), data);
        }
    }

    public void delete(int data){
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode root, int data){
        if (root == null){
            return root;
        }

        if (data < root.getData()){
            root.setLeft(deleteRec(root.getLeft(), data));
        } else if (data > root.getData()){
            root.setRight(deleteRec(root.getRight(), data));
        } else {
            //Nodo con un solo hijo o sin hijos
            if (root.getLeft() == null){
                return root.getRight();
            } else if (root.getRight() == null){
                return root.getLeft();
            }

            //Nodo con dos hijos
            root.setData(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getData()));
        }

        return root;
    }

    private int minValue(TreeNode root){
        int minValue = root.getData();
        while (root.getLeft() != null){
            minValue = root.getLeft().getData();
            root = root.getLeft();
        }
        return minValue;
    }
}
