import models.Catan

fun main() {
    val partida = Catan()
    partida.iniciarRepartoTablero()
    partida.iniciarPartida()
    partida.printFinPartida()
}