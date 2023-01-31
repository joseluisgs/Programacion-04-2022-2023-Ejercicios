package models;


import interfaces.IGuitarist;

public class Guitarist extends Musician implements IGuitarist {

    String guitarType;
    String name;
    int yearsOfExperience;
    static double salary = (Musician.salary * 1.35);

    public Guitarist(String name, int yearsOfExperience, String GuitarType) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.guitarType = GuitarType;
    }

    @Override
    public void playGuitar() {
        System.out.println("Im a guitarist and im playing guitar");
    }
}
