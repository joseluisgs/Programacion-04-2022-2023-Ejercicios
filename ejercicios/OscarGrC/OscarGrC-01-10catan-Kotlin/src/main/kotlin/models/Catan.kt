package models

class Catan {
    var tablero = TableroCatan()
    var jugadorInventario = Array(3) { 0 }
    var iaInventario = Array(3) { 0 }
    var isGanadorJugador = false
    var isGanadorIA = false


    fun iniciarRepartoTablero() {
        println("")
        println("     COMIENZA LA PARTIDA")
        println("")
        println("     SELECCION DE CASILLAS")
        var contador = 0
        do {
            tablero.printTableroColocacion()
            var posicion = getUserAnswerColocacion()
            tablero.tablero[posicion.first][posicion.second].master = "Jugador"
            contador += 1
            posicion = getRandomAnswer()
            println("La IA  selecciona la casilla ${tablero.tablero[posicion.first][posicion.second].posicionEnTablero}")
            tablero.tablero[posicion.first][posicion.second].master = "IA"
            contador += 1
        } while (contador != 12)
    }

    private fun getUserAnswerColocacion(): Pair<Int, Int> {
        var localUserReply: String
        var isValidReply = false
        val regex = Regex("[0-9]||[1][0-2]")
        var salidaA: Int = 0
        var salidaB: Int = 0
        println("Escoje una posicion libre")
        do {
            print("  :")
            localUserReply = readln().trim()
            if (!regex.matches(localUserReply)) {
                println("Error en patron")
            }else{
            for (i in tablero.tablero.indices) {
                for (j in tablero.tablero[i].indices) {
                    if (tablero.tablero[i][j].posicionEnTablero == localUserReply.toInt()
                        && tablero.tablero[i][j].master != ""
                    ) {
                        println("Casilla ya ocupada")
                    }
                    if (tablero.tablero[i][j].posicionEnTablero == localUserReply.toInt()
                        && tablero.tablero[i][j].master == ""
                    ) {
                        salidaA = i
                        salidaB = j
                        isValidReply = true
                    }
                }
            }
        }} while (!isValidReply)
        return Pair(salidaA, salidaB)
    }

    private fun getRandomAnswer(): Pair<Int, Int> {
        var randomValue: Int
        var isValid = false
        do {
            randomValue = (1..12).random()
            for (i in tablero.tablero.indices) {
                for (j in tablero.tablero[i].indices) {
                    if (tablero.tablero[i][j].posicionEnTablero == randomValue
                        && tablero.tablero[i][j].master == ""
                    ) {
                        return Pair(i, j)
                    }
                }
            }
        } while (!isValid)
        return Pair(0, 0)
    }

    fun iniciarPartida() {
        var contador = 0
        do {
            val azar = (1..6).random()
            contador += 1
            println("RONDA $contador")
            println("---------------------------")
            if (contador % 2 != 0) println("Turno Jugador") else println("Turno IA ")
            println("")
            println("El dado gira y sale $azar")
            tablero.printTablero()
            if (contador % 2 != 0) {
                jugadorInventario = addRecursos(azar, jugadorInventario, tablero)
                println(
                    "El Jugador tiene: ${printInventario(jugadorInventario)}"
                )
                isGanadorJugador = checkGanador(jugadorInventario)
            } else {
                iaInventario = addRecursos(azar, iaInventario, tablero)
                println(
                    "  La IA tiene:    ${printInventario(iaInventario)}"
                )
                isGanadorIA = checkGanador(iaInventario)
            }
            Thread.sleep(2000)
            println("")
        } while (!isGanadorJugador && !isGanadorIA)

    }

    private fun addRecursos(azar: Int, jugadorInventario: Array<Int>, tablero: TableroCatan): Array<Int> {
        for (i in tablero.tablero.indices) {
            for (j in tablero.tablero[i].indices) {
                if (tablero.tablero[i][j].valor == azar) {
                    when (tablero.tablero[i][j].recurso) {
                        CasillaCatan.TipoRecurso.Madera -> jugadorInventario[0] += 1
                        CasillaCatan.TipoRecurso.Trigo -> jugadorInventario[1] += 1
                        CasillaCatan.TipoRecurso.Piedra -> jugadorInventario[2] += 1
                    }
                }
            }
        }
        return jugadorInventario
    }
    private fun checkGanador(jugador: Array<Int>): Boolean {
        for (i in jugador.indices) {
            if (jugador[i] < 20) return false
        }
        return true
    }
    private fun printInventario(jugar:Array<Int>):String{
        return " ${jugar[0]} Madera" +
                " ${jugar[1]} Trigo ${jugar[2]} Piedra "
    }
    fun printFinPartida() {
        println("")
        println(" RESULTADOS FINALES")
        println("")
        println("JUGADOR.- ${printInventario(jugadorInventario)}")
        println("     IA.- ${printInventario(iaInventario)}")
        println("")
        if (isGanadorIA) println("Lo siento parece que eres un Perdedor")
        else println("Felicidades eres el ganador")


    }

}