package models

import interfaces.IGuitarist

class Guitarist(override var name: String?, override var yearsOfExperience: Int, var guitarType: String) :
    Musician(name, yearsOfExperience), IGuitarist {
    override fun playGuitar() {
        println("Im a guitarist and im playing guitar")
    }

    companion object {
        var salary: Double = Musician.salary * 1.35
    }
}