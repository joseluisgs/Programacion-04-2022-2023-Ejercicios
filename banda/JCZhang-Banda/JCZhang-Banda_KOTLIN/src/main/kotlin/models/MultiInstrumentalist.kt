package models

import interfaces.IBassGuitarist
import interfaces.IPercussionist
import interfaces.IPianist

class MultiInstrumentalist(
    override var name: String?,
    override var yearsOfExperience: Int,
    var percussionType: String,
    var numberOfKeys: Int,
    var guitarType: String
) :
    Musician(name, yearsOfExperience), IPercussionist, IPianist, IBassGuitarist {
    override fun toPercussion() {
        println("Im a multiinstrumentalist and im playing percussion")
    }

    override fun playPiano() {
        println("Im a multiinstrumentalist and im playing piano")
    }

    override fun playBass() {
        println("Im a multiinstrumentalist and im playing bass")
    }

    companion object {
        var salary: Double = Musician.salary * 1.5
    }
}