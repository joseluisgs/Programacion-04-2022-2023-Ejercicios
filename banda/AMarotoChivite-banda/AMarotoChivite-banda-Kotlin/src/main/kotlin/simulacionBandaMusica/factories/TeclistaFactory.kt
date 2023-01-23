package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object TeclistaFactory {
    fun create(): Musico.Teclista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val numTeclas = sorteoDatos.randomNumTeclas()
        return Musico.Teclista(name, "Teclado", experienceYear, numTeclas)
    }
}