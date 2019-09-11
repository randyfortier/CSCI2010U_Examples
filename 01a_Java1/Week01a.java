
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
         // Can't access non-static here in main():
         //System.out.println("Age: " + w1.age);
         System.out.println("Name: " + w1.name);

         long bankBalance = 100000000000L;
         Integer otherAccount = 500;
         
         float gpa = 2.4f;
         String ageStr = "20 years old";
         try {
            age = Integer.parseInt(ageStr);
            // succeeded
         } catch (NumberFormatException e) {
            // failed
            e.printStackTrace();
         } finally {
            // succeeded or failed
         }
         System.out.printf("Your age is %d.\n", age);

         char keyPressed = 'B';
         String name = "Randy";
         if ((keyPressed == 'A') && (name.equals("Randy"))) {
            System.out.println("Welcome to the CSIS!");
         } else if (name.equals("Justin")) {
            System.out.println("Welcome PM!");
         } else {
            System.out.println("No entry!");
         }

         int choice = 7;
         switch (choice) {
             case 0:
                // do something for 0
                break;
             case 1:
                // do something for 1
                break;
            default:
                // all other cases

         }

         int hp = -30;
         hp = (hp < 0) ? 0 : hp;

         int numTurns = 3;
         while (numTurns > 0) {
             // do something
             System.out.println("Hello from while");
             numTurns--;
         }

         numTurns = 3;
         do {
             // do something
             System.out.println("Hello from do-while");
             numTurns--;
         } while (numTurns > 0);

         numTurns = 3;
         for (int i = numTurns; i > 0; i--) {
             // do something
             System.out.println("Hello from for");
         }

         float[] grades = new float[] {27.0f, 30.0f, 15.0f, 19.0f};
         for (float grade : grades) {
            System.out.println("Grade: " + grade);
         }
     }
}