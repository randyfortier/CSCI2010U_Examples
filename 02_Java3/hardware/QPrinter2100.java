package hardware;

public class QPrinter2100 implements Printer, Scanner {
  public void print(String str) {
    System.out.println("print: " + str);
  }

  public String scan() {
    return "all work and no play make Jack a dull boy";
  }
}
