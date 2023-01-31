package models;

import interfaces.ISinger;

public class Singer extends Musician implements ISinger {

    String name;
    int yearsOfExperience;
    String tone;
    static double salary = (Musician.salary * 1.4);

    public Singer(String name, int yearsOfExperience, String tone) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.tone = tone;
    }

    @Override
    public void breath() {
        System.out.println("Im singer "+ name+ " and im breathing");
    }


    @Override
    public void sing() {
        System.out.println("Im a singer and im singing");
    }
}
