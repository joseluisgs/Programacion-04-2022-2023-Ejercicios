package models

import interfaces.IPianist

class Pianist(override var name: String?, override var yearsOfExperience: Int, var numberOfKeys: Int) :
    Musician(name, yearsOfExperience), IPianist {
    override fun playPiano() {
        println("im a pianist and im playing piano")
    }

    companion object {
        var salary = Musician.salary * 1.3
    }
}