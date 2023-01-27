package factories

import models.Electricista
var nominaElectricista = 0

class ElectricistasFactory {
    fun crearElectricistaRandom(): Electricista{
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
            "Juanjo",
            "Paco"
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
            0,
            13
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
            14,
            23
        )

        val nombre = nombres[nombres.indices.random()]
        val aniosExp = aniossExp[aniossExp.indices.random()]
        val horasDiarias = tiempoDiario[tiempoDiario.indices.random()]

        nominaElectricista += 1800
        return Electricista(nombre, aniosExp, horasDiarias)
    }
}