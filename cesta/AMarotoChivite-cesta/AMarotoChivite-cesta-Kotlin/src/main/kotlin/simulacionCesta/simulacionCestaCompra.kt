package simulacionCesta

import simulacionCesta.factories.FinalCestFactory
import simulacionCesta.utils.menuCest

fun main(args: Array<String>) {
    // Inicializamos la línea de cesta que contiene objetos aleatorios
    val cest = FinalCestFactory.create()
    // Iniciamos menú
    menuCest(cest)
}