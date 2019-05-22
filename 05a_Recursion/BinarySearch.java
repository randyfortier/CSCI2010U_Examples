public class BinarySearch {
   public static boolean binarySearch(int[] data, int toFind) {
      return binarySearch(data, toFind, 0, data.length - 1);
   }

   public static boolean binarySearch(int[] data, int toFind, int startIndex, int endIndex) {
      if (startIndex > endIndex) {
         // looking in an empty sub-list
         return false;
      }

      int middle = (startIndex + endIndex) / 2;
      if (data[middle] == toFind) {
         // this is our element
         return true;
      } else if (toFind < data[middle]) {
         // search the first half of the list
         return binarySearch(data, toFind, startIndex, middle - 1);
      } else {
         // search the second half of the list
         return binarySearch(data, toFind, middle + 1, endIndex);
      }
   }

   public static void main(String[] args) {
      int[] list = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

      System.out.println("Is 8 in the list? " + binarySearch(list, 8));
      System.out.println("Is 5 in the list? " + binarySearch(list, 5));
      System.out.println("Is 20 in the list? " + binarySearch(list, 20));
   }
}
