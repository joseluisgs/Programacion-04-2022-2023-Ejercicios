package models

import interfaces.IBassGuitarist

class BassGuitarist(override var name: String?, override var yearsOfExperience: Int, var numberOfStrings: Int) :
    Musician(name, yearsOfExperience), IBassGuitarist {
    override fun playBass() {
        println("Im a bass guitarist and im playing bass guitar")
    }

    companion object {
        var salary: Double = Musician.salary * 1.5
    }
}