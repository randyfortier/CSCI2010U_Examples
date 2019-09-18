package animalKingdom;

public abstract class Animal {
    private String species;
    private String genus;
    protected boolean isCarnivorous;

    public Animal(String species, String genus) {
        this.species = species;
        this.genus = genus;
        this.isCarnivorous = false;  
    }

    public abstract void speak();
}