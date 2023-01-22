package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Musico
import simulacionBandaMusica.utils.sorteoDatos

object BajistaFactory {
    fun create(): Musico.Bajista {
        val name = sorteoDatos.randomName()
        val experienceYear = sorteoDatos.randomAnno()
        val numCuerdas = sorteoDatos.randomNumCuerdas()
        return Musico.Bajista(name, "Bajo", experienceYear, numCuerdas)
    }
}