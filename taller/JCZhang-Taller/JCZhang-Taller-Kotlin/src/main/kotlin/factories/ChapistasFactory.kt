package factories

import models.Chapista

var nominaChapistas = 0
class ChapistasFactory {

    fun crearChapistaRandom(): Chapista {
        val nombres = arrayOf(
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
            "Juanjo"
        )
        val aniossExp = arrayOf(
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
            0
        )
        val tiempoDiario = arrayOf(
            8,
            5,
            16,
            4,
            5,
            7,
            10,
            9,
            1,
            20,
            12,
            14
        )

        val nombre = nombres[nombres.indices.random()]
        val aniosExp = aniossExp[aniossExp.indices.random()]
        val horasDiarias = tiempoDiario[tiempoDiario.indices.random()]

        nominaChapistas += 1700
        return Chapista(nombre, aniosExp, horasDiarias)
    }
}