package models;

import interfaces.ITrumpeter;

public class Trumpeter extends Musician implements ITrumpeter {

    String name;
    int yearsOfExperience;

    int lungCapacity;

    static double salary = (Musician.salary * 1.2);

    public Trumpeter(String name, int yearsOfExperience, int lungCapacity) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.lungCapacity = lungCapacity;
    }

    @Override
    public void breath() {
        System.out.println("Im trumpeter "+ name+ " and im breathing");
    }

    @Override
    public void interpret() {
        System.out.println("Im trumpeter "+ name+ " and im interpreting with my trumpet");
    }

    @Override
    public void playTrumpet() {
        System.out.println("Im trumpeter "+ name+ " and im play trumpet");
    }
}
