public class BSTNode {
    public BSTNode left = null;
    public BSTNode right = null;
    public BSTNode parent = null;
    public int value = 0;

    public void insert(int newValue) {
        if (newValue < this.value) {
            // go left
            if (this.left != null) {
                this.left.insert(newValue);
            } else {
                BSTNode newNode = new BSTNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.left = newNode;
            }
        } else {
            // go right
            if (this.right != null) {
                this.right.insert(newValue);
            } else {
                BSTNode newNode = new BSTNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.right = newNode;
            }
        }
    }
    
}