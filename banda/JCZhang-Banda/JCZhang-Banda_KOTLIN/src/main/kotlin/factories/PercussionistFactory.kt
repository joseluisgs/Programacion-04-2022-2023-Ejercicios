package factories

import models.Percussionist

object PercussionistFactory {
    var percussionistCounter = 0
    fun createRandomPercussionist(): Percussionist {
        percussionistCounter++
        val names = arrayOf(
            "Paquita",
            "Ernesto",
            "Antonio",
            "Alfonso",
            "Patricio",
            "BobEsponja",
            "Arenita",
            "DonCangrejo",
            "Calamardo",
            "Juan",
            "Laura",
            "Aitana",
            "Aitor",
            "Juanjo",
            "Paco"
        )
        val expYears = arrayOf(
            2,
            4,
            25,
            6,
            8,
            54,
            56,
            3,
            6,
            27,
            4,
            1,
            7,
            36,
            0,
            13
        )
        val typeOfPercussion = arrayOf(
            "A",
            "B"
        )
        val name = names[names.indices.random()]
        val yearsOfExperience = expYears[expYears.indices.random()]
        val percussionType = typeOfPercussion[typeOfPercussion.indices.random()]
        return Percussionist(name, yearsOfExperience, percussionType)
    }
}