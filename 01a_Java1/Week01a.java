
/**
 * Week01a
 *
 * This is the demo from lecture 1a
 *
 * @author Randy J. Fortier
 * @date September 6, 2019
 */
public class Week01a {
    static int age = 5;
    String name = "Randy";

    /**
     * main
     * 
     * The entry point for our app
     * 
     * @arg args Command-line arguments
     */
     public static void main(String[] args) {
         System.out.println("Age: " + age);

         int age = 44;
         System.out.println("Age: " + age);
         System.out.println("Age: " + Week01a.age);

         Week01a w1 = new Week01a();
         System.out.println("Age: " + w1.age);
         System.out.println("Name: " + w1.name);

     }
}