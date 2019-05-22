import java.util.*;

public class Week01b {

   interface FloatFilter {
      boolean match(float value);
   }

   public static List<Float> filterList(List<Float> items, FloatFilter filter) {
      List<Float> result = new ArrayList<Float>();
      for (float item: items) {
         if (filter.match(item)) {
            result.add(item);
         }
      }
      return result;
   }

   public static void printList(List<Float> items) {
      System.out.print("[");
      boolean first = true;
      for (float value: items) {
         if (first) {
            first = false;
         } else {
            System.out.print(", ");
         }
         System.out.print(value);
      }
      System.out.println("]");
   }

   public static void runDemo() {
      // lists and generics
      List<String> names = new ArrayList<>();
      names.add("Randy");
      names.add("Ashfaq");
      names.add("Ahmed");
      names.add("Vishan");
      names.add("Harambe");

      for (String name: names) {
         Pair<String, Float> namePair = new Pair<>(name, 0.0f);
         System.out.println(namePair);
      }

      // instantiating classes
      Student lucy = new Student();
      lucy.sid = "200000001";
      lucy.name = "Lucy Smith";
      lucy.setStartDate("2019/09/31");

      Pair<String,Student> studentEntry = new Pair<>("lucy", lucy);
      System.out.println(studentEntry);

      // using lambdas
      List<Float> grades = new ArrayList<Float>();
      grades.add(54.5f);
      grades.add(76.0f);
      grades.add(72.5f);
      grades.add(66.0f);
      grades.add(43.25f);
      grades.add(81.0f);

      List<Float> passingGrades = filterList(grades, (float grade) -> grade > 50.0f);
      System.out.println("Passing grades:");
      printList(passingGrades);
   }

   public static void main(String[] args) {
      runDemo();
   }
}
