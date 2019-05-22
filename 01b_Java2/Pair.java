public class Pair<A,B> {
   public A key;
   public B value;

   public Pair(A key, B value) {
      this.key = key;
      this.value = value;
   }

   public String toString() {
      return key + " -> " + value;
   }
}
