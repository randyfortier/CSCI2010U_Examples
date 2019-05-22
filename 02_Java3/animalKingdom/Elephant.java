package animalKingdom;

public class Elephant extends Animal {
  public Elephant(int stamina, String colour) {
    super("Elephant", stamina, colour);
  }

  public String toString() {
    return this.colour + " Elephant";
  }

  public void speak() {
    System.out.println("toot toot");
  }
}
