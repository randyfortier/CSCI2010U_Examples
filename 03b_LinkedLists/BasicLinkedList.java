public class BasicLinkedList {

   class Node {
      public Node next;
      public String value;
   }

   private Node root;
   private int count; // not strictly necessary, but faster

   public BasicLinkedList() {
      root = null;
   }

   public void insertEnd(String newElement) {
      // handle the special case of an empty linked list
      if (root == null) {
         root = new Node();
         root.next = null;
         root.value = newElement;
         return;
      }

      // move to the end of the linked list
      Node current = root;
      while (current.next != null) {
         current = current.next;
      }

      // insert the element here
      Node newNode = new Node();
      newNode.next = null;
      newNode.value = newElement;
      current.next = newNode;
   }

   public void insertBeginning(String newElement) {
      // create a new node
      Node newNode = new Node();
      newNode.next = root;
      newNode.value = newElement;

      // this node becomes the new root
      root = newNode;
   }

   public void insertAt(int index, String newElement) {
      // handle the special case of inserting at the beginning
      if (index == 0) {
         insertBeginning(newElement);
      }

      // move to the correct position
      int currentIndex = 0;
      Node current = root;
      Node pred = null;
      while (currentIndex < index && current != null) {
         currentIndex++;
         pred = current;
         current = current.next;
      }

      // if the index was too large
      if (currentIndex < index) {
         throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
      }

      // insert at this position
      Node newNode = new Node();
      newNode.next = current;
      newNode.value = newElement;
      pred.next = newNode;
   }

   public void print() {
      System.out.print("[");

      Node current = root;
      while (current != null) {
         System.out.print(current.value);

         if (current.next != null) {
            System.out.print(", ");
         }

         current = current.next;
      }

      System.out.println("]");
   }

   public static void main(String[] args) {
      BasicLinkedList list = new BasicLinkedList();

      list.insertEnd("Rick");
      list.insertEnd("Morty");
      list.insertBeginning("Jane");
      list.insertEnd("Xavier");
      list.insertBeginning("Tatiana");
      list.insertEnd("Kumar");
      list.insertAt(3, "Carla");

      list.print();
   }
}
