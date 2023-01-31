package models

import interfaces.ITrumpeter

class Trumpeter(override var name: String?, override var yearsOfExperience: Int, var lungCapacity: Int) :
    Musician(name, yearsOfExperience), ITrumpeter {
    override fun breath() {
        println("Im trumpeter $name and im breathing")
    }

    override fun interpret() {
        println("Im trumpeter $name and im interpreting with my trumpet")
    }

    override fun playTrumpet() {
        println("Im trumpeter $name and im play trumpet")
    }

    companion object {
        var salary = Musician.salary * 1.2
    }
}