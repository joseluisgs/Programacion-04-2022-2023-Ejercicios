package factories

import models.JefeTaller
var nominaJefeTaller = 0

class JefeTallerFactory {

    fun crearJefeTallerRandom(): JefeTaller {
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
            "Aitor"
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
            36
        )

        val nombre = nombres[nombres.indices.random()]
        val aniosExp = aniossExp[aniossExp.indices.random()]
        nominaJefeTaller += 2500
        return JefeTaller(nombre, aniosExp)
    }
}