package simulacionBandaMusica.factories

import simulacionBandaMusica.models.Banda
import simulacionBandaMusica.models.Musico
import java.util.*

object BandaFactory {
    fun create(): Banda {
        val tammanoBanda = 50
        val vectorMusicos = arrayOfNulls<Musico>(tammanoBanda)
        val probCantante = 20 //20%
        val probGuitarrista = 40 //20%
        val probBajista = 50 //10%
        val probTeclista = 60 //10%
        val probPercusionista = 75 //15%
        val probTrompetista = 80 //5%
        val probCantantePro = 95 //15%
        for (i in vectorMusicos.indices) {
            val r = Random()
            val num = r.nextInt(100) + 1
            if (num <= probCantante && vectorMusicos[i] == null) {
                vectorMusicos[i] = CantanteFactory.create()
            } else if (num <= probGuitarrista && vectorMusicos[i] == null) {
                vectorMusicos[i] = GuitarristaFactory.create()
            } else if (num <= probBajista && vectorMusicos[i] == null) {
                vectorMusicos[i] = BajistaFactory.create()
            } else if (num <= probTeclista && vectorMusicos[i] == null) {
                vectorMusicos[i] = TeclistaFactory.create()
            } else if (num <= probPercusionista && vectorMusicos[i] == null) {
                vectorMusicos[i] = PercusionistaFactory.create()
            } else if (num <= probTrompetista && vectorMusicos[i] == null) {
                vectorMusicos[i] = TrompetistaFactory.create()
            } else if (num <= probCantantePro && vectorMusicos[i] == null) {
                vectorMusicos[i] = CantanteProFactory.create()
            } else if (vectorMusicos[i] == null) {
                vectorMusicos[i] = MultiFactory.create()
            }
        }
        return Banda(vectorMusicos)
    }
}