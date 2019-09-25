public class LinkedList {
    class Node {
        public String value;
        public Node next;
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void print() {
        System.out.print("[ ");
        Node current = head;
        if (current != null) {
            System.out.print(current.value + " ");
        }
        while ((current != null) && (current.next != null)) {
            current = current.next;
            System.out.print(current.value + " ");
        }
        System.out.println("]");
    }

    public void insertEnd(String newValue) {
        // create a new node for our value
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = null;

        // increase the size
        size++;

        // handle the special case
        if (head == null) {
            head = newNode;
            return;
        }

        // go to the last element
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // add the element
        current.next = newNode;
    }

    public void removeEnd() {
        // handle the empty list special case
        // TODO

        size--;

        // navigate to the second last element
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        // handle the 1-element list special case
        if (previous == null) {
            head = null;
            return;
        }

        // delete the element
        previous.next = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.print();
        list.insertEnd("Sandra");
        list.print();
        list.insertEnd("Paolo");
        list.print();
        list.insertEnd("Carla");
        list.print();
    }
}