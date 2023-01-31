package factories

import models.MultiInstrumentalist

object MultiInstrumentalistFactory {
    var multiInstrumentalistCounter = 0

    fun createRandomMultiInstrumentalist(): MultiInstrumentalist {
        multiInstrumentalistCounter++
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
        val keyNumber = arrayOf(
            49,
            61,
            88
        )
        val typeOfGuitar = arrayOf(
            "A",
            "B"
        )
        val name = names[names.indices.random()]
        val yearsOfExperience = expYears[expYears.indices.random()]
        val numberOfKeys = keyNumber[keyNumber.indices.random()]
        val PercussionType = typeOfPercussion[typeOfPercussion.indices.random()]
        val guitarType = typeOfGuitar[typeOfGuitar.indices.random()]
        return MultiInstrumentalist(name, yearsOfExperience, PercussionType, numberOfKeys, guitarType)
    }
}