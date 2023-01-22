package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object GuitarristaFactory {
    fun create(): Musico.Guitarrista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val tipoGuitarra = sorteoDatos.randomTipoGuitarra()
        return Musico.Guitarrista(name, "Guitarra", experienceYear, tipoGuitarra)
    }
}