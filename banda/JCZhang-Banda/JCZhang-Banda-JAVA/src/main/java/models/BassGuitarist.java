package models;

import interfaces.IBassGuitarist;

public class BassGuitarist extends Musician implements IBassGuitarist {

    String name;
    int yearsOfExperience;
    int numberOfStrings;
    static double salary = (Musician.salary * 1.5);


    public BassGuitarist(String name, int yearsOfExperience, int numberOfStrings) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.numberOfStrings = numberOfStrings;

    }

    @Override
    public void playBass() {
        System.out.println("Im a bass guitarist and im playing bass guitar");
    }
}
