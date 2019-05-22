public class BasicArray {
   private String[] elements;
   private int count;

   public BasicArray(int startSize) {
      elements = new String[startSize];
   }

   private void resizeIfNecessary() {
      if ((count + 1) >= elements.length) {
         // make a new, larger, array
         String[] newArray = new String[elements.length * 2];

         // copy over the elements
         for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
         }

         // replace the array
         elements = newArray;
      }
   }

   public void insertEnd(String newElement) {
      resizeIfNecessary();

      elements[count] = newElement;
      count++;
   }

   public void insertBeginning(String newElement) {
      resizeIfNecessary();

      // move all of the elements forward one position
      for (int i = count - 1; i >= 0; i--) {
         elements[i+1] = elements[i];
      }

      // add the element to the start
      elements[0] = newElement;
      count++;
   }

   public void insertAt(int index, String newElement) {
      if (index >= count) {
         throw new ArrayIndexOutOfBoundsException("No such index: " + index);
      }

      resizeIfNecessary();

      // move all of the elements forward one position
      for (int i = count - 1; i >= index; i--) {
         elements[i+1] = elements[i];
      }

      // add the element to the specified index
      elements[index] = newElement;
      count++;
   }

   public void print() {
      System.out.print("[");

      for (int i = 0; i < count; i++) {
         System.out.print(elements[i]);

         if (i < (count - 1)) {
            System.out.print(", ");
         }
      }

      System.out.println("]");
   }

   public static void main(String[] args) {
      BasicArray array = new BasicArray(5);

      array.insertEnd("Rick");
      array.insertEnd("Morty");
      array.insertBeginning("Jane");
      array.insertEnd("Xavier");
      array.insertBeginning("Tatiana");
      array.insertEnd("Kumar");
      array.insertAt(3, "Carla");

      array.print();

      array.insertAt(20, "Invalid Index");
   }
}
