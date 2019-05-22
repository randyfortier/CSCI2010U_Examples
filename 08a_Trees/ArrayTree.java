
public class ArrayTree {
   private String[] values;

   public ArrayTree(String[] initialValues) {
      values = initialValues;
   }

   public String get(int index) {
      return values[index];
   }

   public int getParent(int index) {
      return (index - 1) / 2;
   }

   public int getLeftChild(int index) {
      return index * 2 + 1;
   }

   public int getRightChild(int index) {
      return (index + 1) * 2;
   }

   public void printInOrder() {
      printNode(0);
   }

   private void printNode(int index) {
      if (index < 0 || index >= values.length) {
         return;
      }

      printNode(getLeftChild(index));
      System.out.println(get(index));
      printNode(getRightChild(index));
   }

   public static void main(String[] args) {
      String[] values = {"5", "3", "8", "1", "4", "7", "10"};

      ArrayTree tree = new ArrayTree(values);
      System.out.println("Root node:   " + tree.get(0));

      int index = 1;
      System.out.println("Node:        " + tree.get(index));
      System.out.println("Four parent: " + tree.get(tree.getParent(index)));
      System.out.println("Four left:   " + tree.get(tree.getLeftChild(index)));
      System.out.println("Four right:  " + tree.get(tree.getRightChild(index)));

      tree.printInOrder();
   }
}
