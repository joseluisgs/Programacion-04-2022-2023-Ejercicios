package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object CantanteProFactory {
    fun create(): Musico.CantantePro {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val capacidadPulmonar = sorteoDatos.randomPulmonarCapacity()
        val tipoGuitarra = sorteoDatos.randomTipoGuitarra()
        return Musico.CantantePro(name, "Voz y guitarra", experienceYear, capacidadPulmonar, tipoGuitarra)
    }
}