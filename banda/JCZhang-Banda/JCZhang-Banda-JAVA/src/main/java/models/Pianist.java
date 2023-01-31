package models;

import interfaces.IPianist;

public class Pianist extends Musician implements IPianist {

    String name;
    int yearsOfExperience;
    int numberOfKeys;
    static double salary = (Musician.salary * 1.3);
    public Pianist(String name, int yearsOfExperience, int numberOfKeys) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.numberOfKeys = numberOfKeys;

    }

    @Override
    public void playPiano() {
        System.out.println("im a pianist and im playing piano");
    }
}
