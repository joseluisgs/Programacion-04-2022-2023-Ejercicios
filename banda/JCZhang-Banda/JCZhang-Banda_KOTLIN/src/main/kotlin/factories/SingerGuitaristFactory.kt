package factories

import models.SingerGuitarist

object SingerGuitaristFactory {
    var singerGuitaristCounter = 0
    fun createRandomSingerGuitarist(): SingerGuitarist {
        singerGuitaristCounter++
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
        val toneTypes = arrayOf(
            "High",
            "Low"
        )
        val typeOfGuitar = arrayOf(
            "A",
            "B"
        )
        val name = names[names.indices.random()]
        val yearsOfExperience = expYears[expYears.indices.random()]
        val tone = toneTypes[toneTypes.indices.random()]
        val guitarType = typeOfGuitar[typeOfGuitar.indices.random()]

        return SingerGuitarist(name, yearsOfExperience, tone, guitarType)
    }
}