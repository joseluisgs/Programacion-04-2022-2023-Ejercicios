package models

import interfaces.ISinger

class Singer(override var name: String?, override var yearsOfExperience: Int, var tone: String) :
    Musician(name, yearsOfExperience), ISinger {
    override fun breath() {
        println("Im singer $name and im breathing")
    }

    override fun sing() {
        println("Im a singer and im singing")
    }

    companion object {
        var salary = Musician.salary * 1.4
    }
}