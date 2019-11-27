public class SimpleListMap {
    private class MapNode {
        public MapNode next;
        public int key;
        public String value;
    }

    private MapNode head = null;
    private int numEntries = 0;

    private MapNode findNode(int key) {
        // navigate to the node with a matching key
        MapNode current = head;
        while (current != null && current.key != key) {
            current = current.next;
        }

        return current;
    }

    public String put(int key, String newValue) {
        MapNode node = findNode(key);

        if (node == null) {
            // insert a new node
            MapNode newNode = new MapNode();
            newNode.key = key;
            newNode.value = newValue;
            newNode.next = head;
            head = newNode;

            numEntries++;

            return null;
        } else {
            // overwrite the existing value
            String oldValue = node.value;
            node.value = newValue;
            return oldValue;
        }
    }

    public String get(int key) {
        MapNode node = findNode(key);

        return node != null ? node.value : null;
    }

    public String remove(int key) {
        // handle the special case:  empty list
        if (head == null) {
            return null;
        }

        // handle the special case:  first element matches
        if (head.key == key) {
            String oldValue = head.value;
            head = head.next;

            numEntries--;

            return oldValue;
        }

        // find the predecessor node
        MapNode current = head.next;
        MapNode pred = head;
        while (current != null && current.key != key) {
            pred = current;
            current = current.next;
        }

        String oldValue = current != null ? current.value : null;

        if (pred != null) {
            pred.next = current.next;

            numEntries--;
        }

        return oldValue;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return numEntries;
    }

    public void print() {
        MapNode current = head;
        while (current != null) {
            System.out.print("(" + current.key + "," + current.value + ") ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SimpleListMap map = new SimpleListMap();

        System.out.println("Is empty? " + map.isEmpty());

        map.print();
        map.put(5, "A");
        map.print();
        map.put(7, "B");
        map.print();
        map.put(2, "C");
        map.print();
        map.put(8, "D");
        map.print();
        map.put(2, "E");
        map.print();

        System.out.println("get(7): " + map.get(7));
        System.out.println("get(4): " + map.get(4));
        System.out.println("get(2): " + map.get(2));

        System.out.println("size(): " + map.size());

        map.remove(5);
        map.print();
        map.remove(2);
        map.print();

        System.out.println("Is empty? " + map.isEmpty());
    }
}