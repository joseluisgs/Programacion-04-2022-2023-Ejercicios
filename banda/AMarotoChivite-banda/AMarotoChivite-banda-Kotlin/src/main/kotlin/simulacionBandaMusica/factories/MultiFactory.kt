package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object MultiFactory {
    fun create(): Musico.MultiInstrumentista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val numCuerdas = sorteoDatos.randomNumCuerdas()
        val numTeclas = sorteoDatos.randomNumTeclas()
        val tipoPercusion = sorteoDatos.randomTipoPercusion()
        return Musico.MultiInstrumentista(
            name,
            "Bajo,teclado y percusión",
            experienceYear,
            numCuerdas,
            numTeclas,
            tipoPercusion
        )
    }
}