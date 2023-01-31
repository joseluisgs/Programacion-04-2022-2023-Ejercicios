package models;

import interfaces.IBassGuitarist;
import interfaces.IPercussionist;
import interfaces.IPianist;

public class MultiInstrumentalist extends Musician implements IPercussionist, IPianist, IBassGuitarist {

    String name;
    int yearsOfExperience;
    String percussionType;
    int numberOfKeys;
    String guitarType;
    static double salary = (Musician.salary * 1.5);

    public MultiInstrumentalist(String name, int yearsOfExperience, String percussionType, int numberOfKeys, String guitarType) {
        super(name, yearsOfExperience);
        this.name =name;
        this.yearsOfExperience = yearsOfExperience;
        this.percussionType = percussionType;
        this.numberOfKeys = numberOfKeys;
        this.guitarType = guitarType;
    }

    @Override
    public void toPercussion() {
        System.out.println("Im a multiinstrumentalist and im playing percussion");
    }

    @Override
    public void playPiano() {
        System.out.println("Im a multiinstrumentalist and im playing piano");
    }

    @Override
    public void playBass() {
        System.out.println("Im a multiinstrumentalist and im playing bass");
    }
}
