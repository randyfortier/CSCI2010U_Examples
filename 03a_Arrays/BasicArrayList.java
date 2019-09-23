public class BasicArrayList {
    private String[] elements;
    private int count;

    public BasicArrayList(int startCapacity) {
        elements = new String[startCapacity];
        count = 0;
    }

    private void resizeIfNecessary() {
        // if we are not at capacity, return
        if ((count + 1) < elements.length) {
            return;
        }

        // make a larger array
        int newCapacity = elements.length * 2;
        String[] newArray = new String[newCapacity];

        // copy over the elements
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }

    public void insertEnd(String newElement) {
        resizeIfNecessary();
        elements[count] = newElement;
        count++;
    }

    public void insertBeginning(String newElement) {
        resizeIfNecessary();

        // move all elements to the right
        for (int i = count - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }

        // insert our new value
        elements[0] = newElement;
        count++;
    }

    public void removeFromBeginning() {
        for (int i = 0; i <= count; i++) {
            elements[i] = elements[i + 1];
        }
        elements[count - 1] = null;
        count--;
    }

    public static void main(String[] args) {
        BasicArrayList names = new BasicArrayList(4);

        names.insertEnd("Dinosaur");
        names.insertBeginning("Gator");
        names.insertEnd("Monk");
        names.insertBeginning("Teradactyl");
        names.insertEnd("Gorilla");
        names.removeFromBeginning();
        names.print();

    }

    public void print() {
        System.out.print("[ ");
        for (String val: elements) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }
}