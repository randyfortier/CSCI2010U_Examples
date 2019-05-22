import java.util.List;
import java.util.ArrayList;

import animalKingdom.*;
import hardware.*;

public class Week02 {
   public static String sharedName;

   public final String name;

   private class CustomScanner implements Scanner {
      public String scan() {
         return "custom scanner: this is a test message.";
      }
   }

   public Week02(String name) {
      sharedName = name;

      this.name = name;
      //this.name = name + "_updated";
   }

   public void runDemo() {
      System.out.println("Shared name: " + sharedName);
      System.out.println("name: " + name);

      // inheritance
      Animal animal = new Elephant(9001, "grey");
      //Elephant elephant = new Animal("Cheetah", 1, "brown");

      System.out.println(animal.toString());
      animal.speak();

      // multiple inheritance (sort of)
      Printer printer = new QPrinter2100();
      printer.print("Your printer is working!");

      Scanner scanner = (Scanner)printer;
      String result = scanner.scan();
      System.out.println("scan: " + result);

      // anonymous class
      Printer customPrinter = new Printer() {
        public void print(String str) {
           System.out.println("Custom printer: " + str);
        }
      };
      customPrinter.print("Your custom printer is working!");

      // inner class
      Scanner customScanner = new CustomScanner();
      System.out.println(customScanner.scan());
   }

  public static void main(String[] args) {
     Week02 demo1 = new Week02("Demo1");
     Week02 demo2 = new Week02("Demo2");
     demo1.runDemo();
  }
}
