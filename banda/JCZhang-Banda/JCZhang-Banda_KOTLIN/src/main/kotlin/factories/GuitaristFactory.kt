package factories

import models.Guitarist


object GuitaristFactory {
    var guitaristCounter = 0
    fun createRandomGuitarist(): Guitarist {
        guitaristCounter++
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
        val expYears = intArrayOf(
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
        val typeOfGuitar = arrayOf(
            "A",
            "B"
        )
        val name = names[names.indices.random()]
        val yearsOfExperience = expYears[expYears.indices.random()]
        val guitarType = typeOfGuitar[typeOfGuitar.indices.random()]

        return Guitarist(name, yearsOfExperience, guitarType)
    }
}