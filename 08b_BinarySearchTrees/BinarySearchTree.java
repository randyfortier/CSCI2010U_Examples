// CSCI 2010U - 08b Binary Search Trees

public class BinarySearchTree {
    private BSTNode root = null;
 
    public BinarySearchTree() {
        this.root = null;
    }
 
    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }
 
    public void insert(int newValue) {
        if (root == null) {
            BSTNode newNode = new BSTNode();
            newNode.value = newValue;
            this.root = newNode;
        } else {
            this.root.insert(newValue);
        }
    }
 
    public void print() {
        if (root == null) {
            System.out.println("null");
        } else {
            System.out.println("Height: " + this.root.getHeight());
            this.root.print(0);
        }
    }
 
   public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
 
        // these inserts result in a tree very lopsided to the left
        tree.insert(6);
        tree.insert(7);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.print();
    }
 }
 