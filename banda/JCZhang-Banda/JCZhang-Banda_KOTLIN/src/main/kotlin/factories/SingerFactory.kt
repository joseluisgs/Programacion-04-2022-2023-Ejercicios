package factories

import models.Singer

object SingerFactory {
    var singerCounter = 0
    fun createRandomSinger(): Singer {
        singerCounter++
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
        val toneTypes = arrayOf(
            "High",
            "Low"
        )
        val name = names[names.indices.random()]
        val yearsOfExperience = expYears[expYears.indices.random()]
        val tone = toneTypes[toneTypes.indices.random()]

        return Singer(name, yearsOfExperience, tone)
    }
}