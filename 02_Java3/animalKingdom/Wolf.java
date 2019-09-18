package animalKingdom;

// final - cannot subclass
public class Wolf extends Animal {
    private int numTeeth = 36;

    public Wolf() {
        super("Canis Lupis", "Canid");
        this.isCarnivorous = true;
    }

    public void speak() {
        System.out.println("Aaaoooooo!");
    }

    public int getNumTeeth() {
        return numTeeth;
    }
}