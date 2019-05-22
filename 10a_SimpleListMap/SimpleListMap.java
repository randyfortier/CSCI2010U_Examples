public class SimpleListMap {
   private class MapNode {
      public MapNode next;
      public int key;
      public String value;
   }

   private MapNode start = null;

   private MapNode findNode(int key) {
      MapNode current = start;
      while (current != null && current.key != key) {
         current = current.next;
      }

      if (current == null) {
         // no such key found
         return null;
      } else {
         // found the key
         return current;
      }
   }

   public void put(int key, String value) {
      MapNode node = findNode(key);

      if (node != null) {
         // node already exists, modify the value
         node.value = value;
      } else {
         // key does not exist, create a new node at the start
         MapNode newNode = new MapNode();
         newNode.key = key;
         newNode.value = value;
         newNode.next = start;
         start = newNode;
      }
   }

   public String get(int key) {
      MapNode node = findNode(key);

      if (node == null) {
         // no such key found
         return null;
      } else {
         // found the key, return the value
         return node.value;
      }
   }

   public void remove(int key) {
      // handle the special case where the key is the start node
      if (start != null && start.key == key) {
         start = start.next;
         return;
      }

      // bypass the node with the specified key
      MapNode current = start;
      MapNode pred = null;
      while (current != null && current.key != key) {
         pred = current;
         current = current.next;
      }
      pred.next = current.next;
   }

   public boolean isEmpty() {
      return (start == null);
   }

   public int size() {
      int size = 0;
      MapNode current = start;
      while (current != null) {
         current = current.next;
         size++;
      }
      return size;
   }

   public void print() {
      MapNode current = start;
      while (current != null) {
         System.out.print("(" + current.key + "," + current.value + ") ");
         current = current.next;
      }
      System.out.println("");
   }

   public static void main(String[] args) {
      /*
      isEmpty()    true        Ø
      put(5,A)     null        (5,A)
      put(7,B)     null        (5,A),(7,B)
      put(2,C)     null        (5,A),(7,B),(2,C)
      put(8,D)     null        (5,A),(7,B),(2,C),(8,D)
      put(2,E)     C           (5,A),(7,B),(2,E),(8,D)
      get(7)       B           (5,A),(7,B),(2,E),(8,D)
      get(4)       null        (5,A),(7,B),(2,E),(8,D)
      get(2)       E           (5,A),(7,B),(2,E),(8,D)
      size()       4           (5,A),(7,B),(2,E),(8,D)
      remove(5)    A           (7,B),(2,E),(8,D)
      remove(2)    E           (7,B),(8,D)
      get(2)       null        (7,B),(8,D)
      IsEmpty()    false       (7,B),(8,D)
      */
      SimpleListMap map = new SimpleListMap();

      System.out.println("Is Empty? " + map.isEmpty());

      map.put(5, "A");
      map.put(7, "B");
      map.put(2, "C");
      map.put(8, "D");
      map.put(2, "E");

      System.out.println("get(7) = " + map.get(7));
      System.out.println("get(4) = " + map.get(4));
      System.out.println("get(2) = " + map.get(2));

      System.out.println("size() = " + map.size());

      map.remove(5);
      map.remove(2);

      System.out.println("get(2) = " + map.get(2));

      System.out.println("Is Empty? " + map.isEmpty());

      map.print();
   }
}
