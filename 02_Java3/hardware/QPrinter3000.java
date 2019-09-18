package hardware;

public class QPrinter3000 implements Printer, Scanner {
    public void print(String text) {
        System.out.println("Printing: " + text);
    }

    public String scan() {
        return "the quick brown fox...";
    }
}