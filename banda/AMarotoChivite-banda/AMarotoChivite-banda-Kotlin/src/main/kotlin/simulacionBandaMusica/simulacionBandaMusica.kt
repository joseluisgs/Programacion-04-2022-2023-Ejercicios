package simulacionBandaMusica

import simulacionBandaMusica.factories.BandaFactory
import simulacionBandaMusica.utils.funcionesMenu

fun main(args: Array<String>) {
    // Instanciamos la banda
    val banda = BandaFactory.create()
    funcionesMenu.menuBandaMusica(banda.vectorMusicos)
}
