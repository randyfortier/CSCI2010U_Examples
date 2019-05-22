package animalKingdom;

public abstract class Animal {
  private String species;
  private int stamina;
  protected String colour;

  public Animal(String species,
                int stamina,
                String colour) {
    this.species = species;
    this.stamina = stamina;
    this.colour = colour;
  }

  public String toString() {
    return this.species;
  }

  public abstract void speak();
}
