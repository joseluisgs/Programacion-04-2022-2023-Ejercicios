package gameCatan

import gameCatan.factories.ComputerFactory
import gameCatan.factories.HumanFactory
import gameCatan.factories.MapFactory
import gameCatan.utils.funciones

fun main(args: Array<String>) {

    // Inicialización de nuestros objetos
    val map = MapFactory.create()
    val playerHumano = HumanFactory.create()
    val playerComputer = ComputerFactory.create()
    // Iniciamos simulación
    funciones.simulationCatan(map, playerHumano, playerComputer)
}