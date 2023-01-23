package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object CantanteFactory {
    fun create(): Musico.Cantante {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val pulmonarCapacity = sorteoDatos.randomPulmonarCapacity()
        return Musico.Cantante(name, "Voz", experienceYear, pulmonarCapacity)
    }
}