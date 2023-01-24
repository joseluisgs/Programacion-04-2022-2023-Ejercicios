package gameCatan.utils

import gameCatan.enums.TypeOwner
import gameCatan.enums.TypeResource
import gameCatan.models.*
import gameCatan.models.Map
import java.util.*

object funciones {

    /**
     * Verificamos que se creen dos casillas de recursos como mínimo
     *
     * @param boxes mapa de casillas
     * @return true si hay dos casillas de cada o más, false en caso contrario
     */
    fun checkTwiceResources(boxes: Array<Array<Box?>>): Boolean {
        var countWood = 0
        var countCoal = 0
        var countSeed = 0
        for (i in boxes.indices) {
            for (j in boxes[i].indices) {
                if (boxes[i][j]!!.typeResource == TypeResource.WOOD) {
                    countWood++
                }
                if (boxes[i][j]!!.typeResource == TypeResource.WOOD) {
                    countCoal++
                }
                if (boxes[i][j]!!.typeResource == TypeResource.WOOD) {
                    countSeed++
                }
            }
        }
        return countWood >= 2 && countCoal >= 2 && countSeed >= 2
    }

    /**
     * Simulación principal
     *
     * @param map            mapa donde se jugará
     * @param playerHumano   jugador uno que tomará decisiones
     * @param playerComputer jugador dos máquina, con decisiones aleatorias
     * @throws InterruptedException
     */
    @Throws(InterruptedException::class)
    fun simulationCatan(map: Map?, playerHumano: Human?, playerComputer: Computer?) {
        // FASE 1: Elegir casillas, el humano decide yel computer elige solo
        while (!checkBoxesAssigment(map)) {
            // Primero elige Humano
            while (true) {
                // Imprimir mapa
                map!!.print()
                println()
                println("HUMANO -> Introduce el valor de fila y columna de la casilla que quieras apropiar...")
                val userRowRespond = userRespond("Fila (1-" + map.sizeRow + ") : ")
                val userColumnRespond = userRespond("Columna (1-" + map.sizeCol + ") : ")
                if (checkRows(map, userRowRespond)
                    && checkColumns(map, userColumnRespond)
                ) {
                    if (checkBoxEmptyHuman(map, userRowRespond, userColumnRespond)) {
                        // Asignamos la posición en propiedad del Humano
                        humanDecision(map, userRowRespond, userColumnRespond)
                        break
                    } else {
                        println("CASILLA OCUPADA!")
                    }
                }
            }
            // Segundo elige Computer
            println("MAQUINA -> Eligiendo casilla...")
            Thread.sleep(1200)
            computerDecision(map)
        }

        // FASE 2: Lanzar dados e ir incrementando los almacenes en función de lo que haya en el tablero
        // el número del dado que nos salga nos aumentará ese valor de los recursos que coincidan...
        var contadorRondas = 0
        do {
            println("RONDA " + contadorRondas++)
            println("--------")
            // Imprimir mapa
            map!!.print()
            println(playerHumano)
            println(playerComputer)
            println()

            // Primero elige Humano
            val resultDadeHuman = randomDade()
            println("HUMANO -> Lanza un dado... ha salido $resultDadeHuman")
            accionPlayer(map, resultDadeHuman, playerHumano)
            // Check ganador
            if (checkWinner(playerHumano)) {
                // Imprimir resultados
                println(playerHumano)
                println(playerComputer)
                println()
                println("Ha ganado el HUMANO!")
                System.exit(0)
            }

            // Segundo elige Maquina
            val resultDadeComputer = randomDade()
            println("MAQUINA -> Lanza un dado... Ha salido $resultDadeComputer")
            accionPlayer(map, resultDadeComputer, playerComputer)
            // Check ganador
            if (checkWinner(playerComputer)) {
                // Imprimir resultados
                println(playerHumano)
                println(playerComputer)
                println()
                println("Ha ganado la MÁQUINA!")
                System.exit(0)
            }
            // Imprimir resultados
            println("RESULTADOS:")
            println(playerHumano)
            println(playerComputer)
            println("NADIE HA GANADO... siguiente ronda...")
            Thread.sleep(1000)
        } while (true)
    }

    /**
     * Verificar que esté sin propiedad la casilla para poder asignar propiedad
     *
     * @param map               mapa de las casillas
     * @param userRowRespond    cadena de ubicación de la fila a verificar
     * @param userColumnRespond cadena de ubicación de la columna a verificar
     * @return true si está sin propiedad, false en caso contrario
     */
    @JvmStatic
    fun checkBoxEmptyHuman(map: Map?, userRowRespond: String, userColumnRespond: String): Boolean {
        val userRowRespondCast = userRowRespond.toInt() - 1
        val userColumnRespondCast = userColumnRespond.toInt() - 1
        return map!!.matrix[userRowRespondCast][userColumnRespondCast]!!.owner == TypeOwner.NONE
    }

    /**
     * @param player
     * @return
     */
    @JvmStatic
    fun checkWinner(player: Player?): Boolean {
        val countToWin = 3
        var count = 0
        if (player!!.storageWood >= 20) {
            count++
        }
        if (player.storageCoal >= 20) {
            count++
        }
        if (player.storageSeed >= 20) {
            count++
        }
        return count == countToWin
    }

    /**
     * Encuentra que casilla coincide con el valor del dado del jugador y aumentamos el almacén del jugador
     *
     * @param map        mapa del juego
     * @param resultDade para buscar en el mapa
     * @param player     tipo de jugador que realiza la acción
     */
    fun accionPlayer(map: Map?, resultDade: Int, player: Player?) {
        for (i in map!!.matrix.indices) {
            for (j in map.matrix[i].indices) {
                if (map.matrix[i][j]!!.randomValue == resultDade) {
                    if (player is Human && map.matrix[i][j]!!.owner == TypeOwner.HUMAN) {
                        if (map.matrix[i][j]!!.typeResource == TypeResource.WOOD) {
                            player.storageWood = player.storageWood + map.matrix[i][j]!!.randomValue
                        }
                        if (map.matrix[i][j]!!.typeResource == TypeResource.COAL) {
                            player.storageCoal = player.storageCoal + map.matrix[i][j]!!.randomValue
                        }
                        if (map.matrix[i][j]!!.typeResource == TypeResource.SEED) {
                            player.storageSeed = player.storageSeed + map.matrix[i][j]!!.randomValue
                        }
                    } else if (player is Computer && map.matrix[i][j]!!.owner == TypeOwner.COMPUTER) {
                        if (map.matrix[i][j]!!.typeResource == TypeResource.WOOD) {
                            player.storageWood = player.storageWood + map.matrix[i][j]!!.randomValue
                        }
                        if (map.matrix[i][j]!!.typeResource == TypeResource.COAL) {
                            player.storageCoal = player.storageCoal + map.matrix[i][j]!!.randomValue
                        }
                        if (map.matrix[i][j]!!.typeResource == TypeResource.SEED) {
                            player.storageSeed = player.storageSeed + map.matrix[i][j]!!.randomValue
                        }
                    }
                }
            }
        }
    }

    /**
     * Verificar que ya hemos asignado en todas las casillas propiedad
     *
     * @param map donde se verificará
     * @return true si están todas asignadas, false en caso contrario
     */
    @JvmStatic
    fun checkBoxesAssigment(map: Map?): Boolean {
        var countBoxNotOwner = 0
        for (i in map!!.matrix.indices) {
            for (j in map.matrix[i].indices) {
                if (map.matrix[i][j]!!.owner != TypeOwner.NONE) {
                    countBoxNotOwner++
                }
            }
        }
        return countBoxNotOwner == map.sizeRow * map.sizeCol
    }

    /**
     * Se asignará en una casilla la propiedad del humano
     *
     * @param map donde se seleccionará la casilla
     */
    @JvmStatic
    fun humanDecision(map: Map?, userRowRespond: String, userColumnRespond: String) {
        val userRowRespondCast = userRowRespond.toInt() - 1
        val userColumnRespondCast = userColumnRespond.toInt() - 1
        map!!.matrix[userRowRespondCast][userColumnRespondCast]!!.owner = TypeOwner.HUMAN
    }

    /**
     * Se asignará en una casilla la propiedad de la máquina que se ha elegido aleatoriamente
     *
     * @param map donde se seleccionará la casilla
     */
    fun computerDecision(map: Map?) {
        while (true) {
            // Repetimos hasta que elija una casilla sin propietario
            val randomRow = (Math.random() * map!!.sizeRow + 1).toInt() - 1
            val randomColumn = (Math.random() * map.sizeCol + 1).toInt() - 1
            if (checkBoxEmptyComputer(map, randomRow, randomColumn)) {
                map.matrix[randomRow][randomColumn]!!.owner = TypeOwner.COMPUTER
                break
            }
        }
    }

    /**
     * Verificar que la casilla esté sin dueño
     *
     * @param map          donde verificaremos
     * @param randomRow    elección de la máquina
     * @param randomColumn elección de la máquina
     * @return true si está vacía, false en caso contrario
     */
    @JvmStatic
    fun checkBoxEmptyComputer(map: Map?, randomRow: Int, randomColumn: Int): Boolean {
        return map!!.matrix[randomRow][randomColumn]!!.owner == TypeOwner.NONE
    }

    /**
     * Verificamos si existe la columna el valor que nos indican en el mapa
     *
     * @param map               mapa saber lo valores máximos
     * @param userColumnRespond entrada del usuario para verificar
     * @return true si la columna se encuentra dentro de los límites del mapa, false en caso contrario
     */
    @JvmStatic
    @Throws(InterruptedException::class)
    fun checkColumns(map: Map?, userColumnRespond: String): Boolean {

        // Verificamos primero que sea número
        if (!checkNumber(userColumnRespond)) {
            return false
        }

        // Verificamos que el valor se encuentre en el mapa
        val userRespondCast = userColumnRespond.toInt() - 1
        val limitColumn = map!!.sizeCol - 1
        return if (userRespondCast in 0..limitColumn) {
            true
        } else {
            println("LA COLUMNA SELECCIONADA NO EXISTE EN EL MAPA!")
            println()
            Thread.sleep(1200)
            false
        }
    }

    /**
     * Verificamos si existe la fila el valor que nos indican en el mapa
     *
     * @param map            mapa saber lo valores máximos
     * @param userRowRespond entrada del usuario para verificar
     * @return true si la fila se encuentra dentro de los límites del mapa, false en caso contrario
     */
    @JvmStatic
    @Throws(InterruptedException::class)
    fun checkRows(map: Map?, userRowRespond: String): Boolean {
        // Verificamos primero que sea número
        if (!checkNumber(userRowRespond)) {
            return false
        }

        // Verificamos que el valor se encuentre en el mapa
        val userRespondCast = userRowRespond.toInt() - 1
        val limitRow = map!!.sizeRow - 1
        return if (userRespondCast in 0..limitRow) {
            true
        } else {
            println("LA FILA SELECCIONADA NO EXISTE EN EL MAPA!")
            println()
            Thread.sleep(1200)
            false
        }
    }

    /**
     * Expresión regular para obligar que nos introduzcan un número
     *
     * @param userRespond la entrada del usuario
     * @return true si es número, false si no lo es
     */
    @JvmStatic
    @Throws(InterruptedException::class)
    fun checkNumber(userRespond: String): Boolean {
        val regex = "[0-9]*"
        if (!userRespond.matches(regex.toRegex())) {
            println("DEBE SER UN NÚMERO!")
            println()
            Thread.sleep(1500)
            return false
        }
        return true
    }

    /**
     * Se le presentará un mensaje al usuario y deberá introducir una respuesta que recogeremos
     *
     * @param message que se le muestra al usuario
     * @return la respuesta del usuario
     */
    fun userRespond(message: String?): String {
        println(message)
        val r = Scanner(System.`in`)
        return r.nextLine()
    }

    /**
     * Dado aleatorio pudiendo ser mínimo 1 y máximo 6
     *
     * @return int
     */
    @JvmStatic
    fun randomDade(): Int {
        return (Math.random() * 6 + 1).toInt()
    }
}