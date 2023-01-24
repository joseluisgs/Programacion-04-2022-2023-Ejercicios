package models

import enums.ESTADOS


val FREE_SEAT = Butaca(estado = ESTADOS.LIBRE)
val RESERVED_SEAT = Butaca(estado = ESTADOS.RESERVADO)
val SOLD_SEAT = Butaca(estado = ESTADOS.OCUPADO)


var totalCash: Double = 0.0
var soldSeatsCount = 0
var reservedSeatsCount = 0

data class Sala(val nombre: String){
    /**
     * @author JiaCheng Zhang
     * @param roomName Es el nombre de la sala de cine, se pide por consola al usuario al iniciar el programa
     * Es una función que imprime por pantalla un informe de la situación actual de cine
     */
    fun generateReport(roomName: String) {
        println("ESTE ES EL INFORME DEL CINE")
        println(" - La película reproducida es ${Pelicula()}")
        println(" - Está siendo reproducida en la sala ${Sala(nombre = roomName)}")
        println(" - El dinero total recolectado es de $totalCash €")
        println(" - En este momento hay un total de $reservedSeatsCount asientos reservados y un total de $soldSeatsCount asientos vendidos")
    }


    /**
     * @author JiaCheng Zhang
     * @return El return por defecto de esta función es que devuelva 0, pero nunca se llega hasta ese punto, ya que hay early returns dentro de un bucle y no se puede salir de ese bucle.
     * Es una Función que filtra las entradas por teclado e imprime un menú.
     */
    fun selectOption(): Int {

        println("***¡¡BIENVENIDO AL CINE!!***")
        println("Seleccione la opción que necesite")
        println()
        println("1 -> RESERVAR ASIENTO (PALOMITAS DE REGALO)")
        println("2 -> FORMALIZAR RESERVA (RESERVA REQUERIDA)")
        println("3 -> CANCELAR RESERVA (RESERVA REQUERIDA)")
        println("4 -> COMPRAR ASIENTO")
        println("5 -> GENERAR INFORME DEL CINE")
        println("6 -> SALIR")
        do {
            print("Opción seleccionada: ")
            val option = readln()
            if (option.toInt() > 6 || option.toInt() < 1) {
                println("Opción no valida")
            } else {
                return option.toInt()
            }
        } while (option.toInt() > 6 || option.toInt() < 1)
        return 0
    }

    /**
     * @param soldSeat Es el asiento que ha elegido el usuario para comprarlo y que ya ha sido filtrada anteriormente para que no contengan errores
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la compra
     */
    fun processPucharse(soldSeat: String, seatsMatrix: Array<Array<Butaca?>>) {
        val pucharsedSeat = soldSeat.split(":").toTypedArray()
        val rowLetter = pucharsedSeat[0]
        val processedRow = rowLetterToNumber(rowLetter)
        val selectedColumn = pucharsedSeat[1]
        changeSeatStatusToOccupied(seatsMatrix, selectedColumn, processedRow)
        printSeats(seatsMatrix)
    }


    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca por consola el asiento que quiere comprar.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return devuelve el asiento deseado.
     */
    fun buySeat(seatsMatrix: Array<Array<Butaca?>>, row: Int, column: Int): String {
        println()
        var soldSeat = ""
        val regex = """[A-Z][:][0-9]+""".toRegex()

        println("Hola! Bienvenido al cine! Estos son los asientos disponibles (Los que aparecen con una 💺) ")
        printSeats(seatsMatrix)
        do {
            println("Introduce el asiento que quieres comprar: ")
            do {
                soldSeat = readln()
                if (!regex.matches(soldSeat.uppercase())) {
                    println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ")
                }
                if (regex.matches(soldSeat.uppercase())) {
                    if (!doesColumnExist(soldSeat, column)){
                        println("La columna que has elegido no existe, elige otro asiento.")
                    }
                }
                if (regex.matches(soldSeat.uppercase())) {
                    if (!doesRowExist(soldSeat, row)){
                        println("La fila que has elegido no existe, elige otro asiento.")
                    }
                }

            } while (!regex.matches(soldSeat.uppercase()) || !doesColumnExist(soldSeat, column))


            if (isSeatReserved(soldSeat, seatsMatrix)){
                println("El asiento que has elegido, ha sido reservado anteriormente, elige otro: ")
            }

        }while (isSeatReserved(soldSeat, seatsMatrix))
        println("El asiento ha sido comprado correctamente")
        println("Se te ha hecho el cobre de 5.25€ automáticamente.")
        totalCash += 5.25
        soldSeatsCount++
        return soldSeat
    }

    /**
     * @param formalizedReservation Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la formalización de la reserva del asiento
     */
    fun processFormalization(formalizedReservation: String, seatsMatrix: Array<Array<Butaca?>>) {
        val processedFormalization = formalizedReservation.split(":").toTypedArray()
        val selectedRow = processedFormalization[0]
        val selectedColumn = processedFormalization[1]
        val processedRow = rowLetterToNumber(selectedRow)


        changeSeatStatusToOccupied(seatsMatrix, selectedColumn, processedRow)
        printSeats(seatsMatrix)
    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "OCUPADO"
     */
    fun changeSeatStatusToOccupied(seatsMatrix: Array<Array<Butaca?>>, selectedColumn: String, processedRow: Int): Butaca {
        seatsMatrix[processedRow][selectedColumn.toInt()-1] = SOLD_SEAT
        return SOLD_SEAT


    }


    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca el asiento qye ha reservado anteriormente para poder formalizar la reserva.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos
     * @return Devuelve el asiento deseado
     */
    fun formalizeReservation(seatsMatrix: Array<Array<Butaca?>>, column: Int, row: Int): String {
        println()
        var toBeFormalizedReservation = ""
        val regex = """[A-Z][:][0-9]+""".toRegex()

        println("Introduce el asiento que has reservado, para que podamos formalizar la reserva por usted y finalizar la compra de esta: ")
        do {

            do {
                toBeFormalizedReservation = readln()
                if (!regex.matches(toBeFormalizedReservation.uppercase())) {
                    println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ")
                }
                if (regex.matches(toBeFormalizedReservation.uppercase())) {
                    if (!doesColumnExist(toBeFormalizedReservation, column)){
                        println("La columna que has elegido no existe, elige otro asiento.")
                    }
                }
                if (regex.matches(toBeFormalizedReservation.uppercase())) {
                    if (!doesRowExist(toBeFormalizedReservation, row)){
                        println("La fila que has elegido no existe, elige otro asiento.")
                    }
                }

            } while (!regex.matches(toBeFormalizedReservation.uppercase()) || !doesColumnExist(toBeFormalizedReservation, column))

            // Desde aquí hacia arriba, nos aseguramos de que el asiento que el usuario ha elegido está escrito de la manera que queremos y que está dentro de los límites de la matriz de asientos.
            if (!isSeatReserved(toBeFormalizedReservation, seatsMatrix)){
                println("El asiento que has elegido, no ha sido reservado anteriormente, elige otro: ")
            }

        }while (!isSeatReserved(toBeFormalizedReservation, seatsMatrix))
        println("Has formalizado la reserva correctamente! Ya se te ha hecho el cobro de los 4€ restantes. Muchas gracias! ")
        totalCash += 4
        reservedSeatsCount--
        soldSeatsCount++
        return toBeFormalizedReservation

    }


    /**
     * @param toBeCancelledSeat Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la formalización de la reserva del asiento
     */
    fun processCancellation(toBeCancelledSeat: String, seatsMatrix: Array<Array<Butaca?>>) {
        val processedCancellation = toBeCancelledSeat.split(":").toTypedArray()
        val selectedRow = processedCancellation[0]
        val selectedColumn = processedCancellation[1]
        val processedRow = rowLetterToNumber(selectedRow)


        changeSeatStatusToFree(seatsMatrix, selectedColumn, processedRow)
        printSeats(seatsMatrix)
    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "LIBRE"
     */
    fun changeSeatStatusToFree(seatsMatrix: Array<Array<Butaca?>>, selectedColumn: String, processedRow: Int): Butaca {

        seatsMatrix[processedRow][selectedColumn.toInt()-1] = FREE_SEAT
        return FREE_SEAT
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca el asiento qye ha reservado anteriormente para poder cancelar la reserva.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return Devuelve el asiento elegido
     */
    fun cancelReservation(seatsMatrix: Array<Array<Butaca?>>, column: Int, row: Int): String {
        println()
        var toBeCancelledSeat = ""
        val regex = """[A-Z][:][0-9]+""".toRegex()

        println("Introduce el asiento que has reservado, para que podamos cancelar la reserva por usted: ")
        do {

            do {
                toBeCancelledSeat = readln()
                if (!regex.matches(toBeCancelledSeat.uppercase())) {
                    println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ")
                }
                if (regex.matches(toBeCancelledSeat.uppercase())) {
                    if (!doesColumnExist(toBeCancelledSeat, column)){
                        println("La columna que has elegido no existe, elige otro asiento.")
                    }
                }
                if (regex.matches(toBeCancelledSeat.uppercase())) {
                    if (!doesRowExist(toBeCancelledSeat, row)){
                        println("La fila que has elegido no existe, elige otro asiento.")
                    }
                }

            } while (!regex.matches(toBeCancelledSeat.uppercase()) || !doesColumnExist(toBeCancelledSeat, column))

            // Desde aquí hacia arriba, nos aseguramos de que el asiento que el usuario ha elegido está escrito de la manera que queremos y que está dentro de los límites de la matriz de asientos.
            if (!isSeatReserved(toBeCancelledSeat, seatsMatrix)){
                println("El asiento que has elegido, no ha sido reservado anteriormente, elige otro: ")
            }

        }while (!isSeatReserved(toBeCancelledSeat, seatsMatrix))
        println("Has cancelado la reserva correctamente")
        totalCash -= 1.25
        println("Se te ha devuelto 1.25€")
        reservedSeatsCount--
        return toBeCancelledSeat
    }

    /**
     * @author JiaCheng Zhang
     * @param toBeCancelledSeat Es el asiento que ha introducido el usuario por teclado
     * @param seatsMatrix Es la matriz de asientos.
     * La función comprueba el asiento ha sido reservado realmente
     * @return Devuelve true si el asiento está reservado y false si no lo está
     */
     fun isSeatReserved(toBeCancelledSeat: String, seatsMatrix: Array<Array<Butaca?>>):Boolean {
        val aux = toBeCancelledSeat.split(":").toTypedArray()
        val auxRow = aux[0]
        val processedRow = rowLetterToNumber(auxRow)
        val auxColumn = aux[1]
        return seatsMatrix[processedRow][auxColumn.toInt()-1] == RESERVED_SEAT

    }


    /**
     * @param reservation Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la reserva del asiento
     */
    fun processReservation(reservation: String, seatsMatrix: Array<Array<Butaca?>>) {
        val processedReservation = reservation.split(":").toTypedArray()
        val selectedRow = processedReservation[0]
        val selectedColumn = processedReservation[1]
        val processedRow = rowLetterToNumber(selectedRow)
        changeSeatStatusToReserved(seatsMatrix, selectedColumn, processedRow)
        printSeats(seatsMatrix)


    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "RESERVADO"
     * @return Devuelve un asiento reservado
     */
    fun changeSeatStatusToReserved(seatsMatrix: Array<Array<Butaca?>>, selectedColumn: String, processedRow: Int): Butaca {

        seatsMatrix[processedRow][selectedColumn.toInt() - 1] = RESERVED_SEAT
        return RESERVED_SEAT
    }

    /**
     * @author JiaCheng Zhang
     * @param selectedRow Es la fila que ha elegido el usuario (se ha exigido que sea una letra)
     * La función cambia las letras de las filas por los números correspondientes a la matriz
     * @return Devuelve los números correspondientes a sus letras
     */
     fun rowLetterToNumber(selectedRow: String): Int {
        when (selectedRow.uppercase()) {
            "A" -> return 0
            "B" -> return 1
            "C" -> return 2
            "D" -> return 3
            "E" -> return 4
            "F" -> return 5
            "G" -> return 6
            "H" -> return 7
            "I" -> return 8
            "J" -> return 9
            "K" -> return 10
            "L" -> return 11
            "M" -> return 12
            "N" -> return 13
            "O" -> return 14
            "P" -> return 15
            "Q" -> return 16
            "R" -> return 17
            "S" -> return 18
            "T" -> return 19
            "U" -> return 20
            "V" -> return 21
            "W" -> return 22
            "X" -> return 23
            "Y" -> return 24
            "Z" -> return 25
        }
        return -1
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca un asiento para que pueda ser reservado.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return Devuelve el asiento deseado
     */
    fun reverseSeat(seatsMatrix: Array<Array<Butaca?>>, column: Int, row: Int): String {
        println()
        var reservedSeat = ""
        val regex = """[A-Z][:][0-9]+""".toRegex()
        printSeats(seatsMatrix)
        println("Hola! ¿Que asiento quieres reservar? Estas son las butacas disponibles.")
        println("Las filas se ordenan con las letras del abecedario y las columnas con números, un ejemplo de asiento seria B:4")
        println("que representaría el asiento de la segunda fila y la cuarta columna")
        println("Introduce el asiento: ")

        do {
            reservedSeat = readln()
            if (!regex.matches(reservedSeat.uppercase())) {
                println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ")
            }
            if (regex.matches(reservedSeat.uppercase())) {
                if (!doesColumnExist(reservedSeat, column)){
                    println("La columna que has elegido no existe, elige otro asiento.")
                }
            }
            if (regex.matches(reservedSeat.uppercase())) {
                if (!doesRowExist(reservedSeat, row)){
                    println("La fila que has elegido no existe, elige otro asiento.")
                }
            }

        } while (!regex.matches(reservedSeat.uppercase()) || !doesColumnExist(reservedSeat, column))
        totalCash += 1.25
        reservedSeatsCount++
        println("El precio de la reserva es de 1.25€, cuando formalice la reserva se le cobrarán 4 euros para completar el precio de la entrada que es de 5.25")
        println("Se te ha cobrado $totalCash")
        return reservedSeat
    }


    /**
     * @param reservedSeat Esa la siento que he introducido el usuario por teclado en la función anterior
     * @param row Es la fila que entre reducido el usuario por teclado
     * La función comprueba que la fila que ha introducido el usuario por teclado está dentro de los límites de la matriz, cuyas dimensiones han sido establecidas al principio del programa
     * @return Devuelve true si la fila está dentro de la matriz y false si la fila está afuera
     */
    fun doesRowExist(reservedSeat: String, row: Int): Boolean {
        val filteredRow = reservedSeat.split(":").toTypedArray()
        val rowNumber = rowLetterToNumber(filteredRow[0])
        return rowNumber <= row
    }

    /**
     * @param reservedSeat Esa la siento que he introducido el usuario por teclado en la función anterior
     * @param column Es la columna que entre reducido el usuario por teclado
     * La función comprueba que la columna que ha introducido el usuario por teclado está dentro de los límites de la matriz, cuyas dimensiones han sido establecidas al principio del programa
     * @return Devuelve true si la columna existe, false si no
     */
    fun doesColumnExist(reservedSeat: String, column: Int): Boolean {
        val filteredColumn = reservedSeat.split(":").toTypedArray()
        return filteredColumn[1].toInt() <= column

    }


    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * La función llena la matriz de butacas libres
     */
    fun placeSeats(seatsMatrix: Array<Array<Butaca?>>) {
        for (i in seatsMatrix.indices) {
            for (j in seatsMatrix[i].indices) {
                seatsMatrix[i][j] = Butaca()
            }
        }
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * La función imprime por pantalla la matriz de asientos
     */
    fun printSeats(seatsMatrix: Array<Array<Butaca?>>) {
        for (i in seatsMatrix.indices) {
            println(seatsMatrix[i].contentToString())
        }

    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca por teclado el nombre de la sala
     * @return devuelve el nombre
     */
    fun requestRoomName(): String {
        println("Introduce el nombre de la sala de cine:")
        var roomName = ""
        roomName = readln()
        return roomName
    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca la columna deseada
     * @return devuelve la columna, siempre que cumpla los requisitos
     */
    fun requestColumnSize(): Int {
        val regexColumn = """\d+""".toRegex()
        val minColumnSize = 1
        var column = ""
        do {
            println("¿Cuántas columnas de butacas quieres?")
            column = readln()
            if (!regexColumn.matches(column) || column.toInt() < minColumnSize) {
                println("¡EL VALOR INTRODUCIDO DEBER SER UN NUMERO ENTERO")
            }
        } while (!regexColumn.matches(column) || column.toInt() < minColumnSize)
        return column.toInt()
    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca la fila deseada
     * @return devuelve la fila, siempre que cumpla los requisitos
     */
    fun requestRowSize(): Int {
        val regexRow = """\d+""".toRegex()
        /*
        Vamos a nombrar las butacas con letras en la fila, por lo que el máximo valor permitido en la fila es de 26
        por ejemplo, el asiento A:1 sería la posición 1:1 en la matriz de las butacas.
         */
        val maxRowSize = 26
        val minRowSize = 1
        var fila = ""
        do {
            println("¿Cuántas filas de butacas quieres?")
            fila = readln()
            if (!regexRow.matches(fila) || fila.toInt() > maxRowSize || fila.toInt() < minRowSize) {
                println("¡EL VALOR INTRODUCIDO DEBER SER UN NUMERO ENTERO ENTRE 1 Y 26!")
            }
        } while (!regexRow.matches(fila) || fila.toInt() > maxRowSize || fila.toInt() < minRowSize)
        return fila.toInt()

    }

}