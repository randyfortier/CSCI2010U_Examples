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
    
    public void print(int depth) {
        if (this.right != null) {
          this.right.print(depth + 1);
        }
    
        for (int i = 0; i < depth; i++) {
          System.out.print("\t");
        }
        System.out.println(this.value);
    
        if (this.left != null) {
          this.left.print(depth + 1);
        }
    }
    
    public int getHeight() {
        int leftHeight = 1;
        if (left != null) {
          leftHeight = left.getHeight() + 1;
        }
    
        int rightHeight = 0;
        if (right != null) {
          rightHeight = right.getHeight() + 1;
        }
    
        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }
}