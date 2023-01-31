package models

import interfaces.IPercussionist

class Percussionist(override var name: String?, override var yearsOfExperience: Int, var percussionType: String) :
    Musician(name, yearsOfExperience), IPercussionist {
    override fun toPercussion() {
        println("Im a Percussionist and im playing Guitar")
    }

    companion object{
        var salary: Double = Musician.salary * 1.35
    }

}