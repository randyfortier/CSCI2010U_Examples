public class Factorial {
   public static int factorial(int n) {
      if (n == 0) {
         return 1;
      }

      return n * factorial(n - 1);
   }

   public static void main(String[] args) {
      if (args.length < 1) {
         System.out.println("Usage:  java Factorial <n>");
         System.exit(0);
      }

      int n = Integer.parseInt(args[0]);

      if (n < 0) {
         throw new IllegalArgumentException("Factorial is only defined for non-negative integers");
      }

      System.out.println("factorial("+n+") = " + factorial(n));
   }
}
