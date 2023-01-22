package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object TrompetistaFactory {
    fun create(): Musico.Trompetista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val pulmonarCapacity = sorteoDatos.randomPulmonarCapacity()
        return Musico.Trompetista(name, "Trompeta", experienceYear, pulmonarCapacity)
    }
}