package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object PercusionistaFactory {
    fun create(): Musico.Percusionista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val tipoPercusion = sorteoDatos.randomTipoPercusion()
        return Musico.Percusionista(name, "Percusión", experienceYear, tipoPercusion)
    }
}