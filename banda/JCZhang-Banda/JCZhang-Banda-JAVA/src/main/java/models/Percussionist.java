package models;

import interfaces.IPercussionist;

public class Percussionist extends Musician implements IPercussionist {
    String name;
    int yearsOfExperience;
    String percussionType;

    static double salary = Musician.salary*1.35;
    public Percussionist(String name, int yearsOfExperience, String percussionType) {
        super(name, yearsOfExperience);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.percussionType = percussionType;
    }


    @Override
    public void toPercussion() {
        System.out.println("Im a Percussionist and im playing Guitar");
    }
}
