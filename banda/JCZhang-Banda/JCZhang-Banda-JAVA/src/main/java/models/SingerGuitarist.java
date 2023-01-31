package models;

import interfaces.IGuitarist;
import interfaces.ISinger;

public class SingerGuitarist extends Musician implements ISinger, IGuitarist {

    String name;
    int yearsOfExperience;
    String tone;
    String guitarType;

    static double salary = (Musician.salary * 1.5);

    public SingerGuitarist(String name, int yearsOfExperience, String tone, String guitarType) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.tone = tone;
        this.guitarType = guitarType;

    }

    @Override
    public void playGuitar() {
        System.out.println("Im a SingerGuitarist and im playing guitar");
    }

    @Override
    public void sing() {
        System.out.println("Im a SingerGuitarist and im singing");
    }
}
