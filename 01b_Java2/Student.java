public class Student {
  public String sid;
  public String name;
  private String startDate;

  // accessor (get)
  public String getStartDate() {
    return this.startDate;
  }

  // mutator (set)
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public static int add(int a, int b) {
    // add the two values
    return a + b;
  }

  public String toString() {
     return this.name + " (" + this.sid + "; " + this.startDate + ")";
  }
}
