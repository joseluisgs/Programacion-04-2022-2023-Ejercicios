package models

import interfaces.IGuitarist
import interfaces.ISinger

class SingerGuitarist(
    override var name: String?,
    override var yearsOfExperience: Int,
    var tone: String,
    var guitarType: String
) :
    Musician(name, yearsOfExperience), ISinger, IGuitarist {
    override fun playGuitar() {
        println("Im a SingerGuitarist and im playing guitar")
    }

    override fun sing() {
        println("Im a SingerGuitarist and im singing")
    }

    companion object {
        var salary = Musician.salary * 1.5
    }
}