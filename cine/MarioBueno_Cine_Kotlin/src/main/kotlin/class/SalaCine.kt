package `class`

import arrayLetras
import opcionSeleccionada
import seleccionadorDeOpcion
import kotlin.math.round


//Clase principal con los métodos principales
class SalaCine(val nombre: String, val filas: Int, val columnas: Int, private val pelicula: Pelicula?) {
    private val arrayButacas = Array(filas) { arrayOfNulls<Butaca>(columnas) }
    private var numButacasStandardLibres = 0
    private var numButacasVIPLibres = 0
    private var numButacasReservadas = 0
    private var numButacasOcupadas = 0
    var balance = 0.0
    private var random: Int = 0


    //Init para el array principal de butacas, 2/5 son vip
    init {
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                arrayButacas[i][j] = Butaca()
                random = (1..10000).random()
                if (random in (1..2000)) {
                    arrayButacas[i][j]?.estado = EstadoButaca.VIPLIBRE
                    numButacasVIPLibres++
                } else {
                    arrayButacas[i][j]?.estado = EstadoButaca.STANDARLIBRE
                    numButacasStandardLibres++
                }
            }
        }
    }

    //Muestra las butacas disponibles de cada estado, las ocupadas y las reservadas
    fun mostrarEstado() {
        println("Pelicula: ${pelicula?.titulo}")
        println()
        println("Butacas Standard libres: $numButacasStandardLibres $GREEN     $RESET")
        println()
        println("Butacas VIP libres: $numButacasVIPLibres $BLUE     $RESET")
        println()
        println("Butacas reservadas: $numButacasReservadas $YELLOW     $RESET")
        println()
        println("Butacas ocupadas: $numButacasOcupadas $RED     $RESET")
        println()
    }

    //Método para reservar una única butaca, toma en cuanta si la butaca seleccionada es vip, normal, está reservada o está ocupada
    fun reservarButacaUnitaria (columna: Int, fila: Int) {
        when (arrayButacas[fila - 1][columna - 1]!!.estado) {
            EstadoButaca.STANDARLIBRE -> {
                seleccionadorDeOpcion("""Esta butaca es de Tipo Standard y está libre, ¿Quieres reservarla por 5.35 €?: 
                |1 - Si
                |2 - No
                """.trimMargin(), 1..2)
                when (opcionSeleccionada) {
                    1 -> {
                        println("La reserva se ha realizado correctamente, por favor ve al apartado 4 - (confirmar una reserva) para realizar el pago.")
                        arrayButacas[fila - 1][columna - 1]!!.estado = EstadoButaca.STANDARRESERVADA
                        numButacasStandardLibres--
                        numButacasReservadas++
                    }
                    2 -> println("La reserva se ha cancelado, volviendo al menú principal")
                }
            }

            EstadoButaca.VIPLIBRE -> {
                seleccionadorDeOpcion("""Esta butaca es de Tipo VIP y está libre, ¿Quieres reservarla por 8.5 €?: 
                |1 - Si
                |2 - No
            """.trimMargin(), 1..2)
                when (opcionSeleccionada) {
                    1 -> {
                        println("La reserva se ha realizado correctamente, por favor ve al apartado 4 - (confirmar una reserva) para realizar el pago.")
                        arrayButacas[fila - 1][columna - 1]!!.estado = EstadoButaca.VIPRESERVADA
                        numButacasVIPLibres--
                        numButacasReservadas++
                    }
                    2 -> println("La reserva se ha cancelado, volviendo al menú principal")
                }
            }
            else -> println("Butaca no disponible para reservar")
        }
    }

    //misma función que la unitaria pero para reservar más de una butaca a la vez
    fun reservarButacasContiguas(fila: Int, colInicial: Int, colFinal: Int) {
        var total = 0.0
        var error = 0
        for (i in colInicial until colFinal+1){
            when (arrayButacas[fila-1][i-1]?.estado) {
                EstadoButaca.VIPLIBRE -> {
                    println("La butaca [$i, $fila] es VIP y está disponible para reserva por 8.5 €")
                    total += 8.5
                }
                EstadoButaca.STANDARLIBRE -> {
                    println("La butaca [$i, $fila] es Standard y está disponible para reserva por 5.35 €")
                    total += 5.35
                }
                EstadoButaca.VIPRESERVADA -> {
                    println("La butaca [$i, $fila] está reservada pero aún no ha sido confirmada, ve al apartado 4 - (Confirmar reserva) para confirmarla")
                    error++
                    break
                }
                EstadoButaca.STANDARRESERVADA -> {
                    println("La butaca [$i, $fila] está reservada pero aún no ha sido confirmada, ve al apartado 4 - (Confirmar reserva) para confirmarla")
                    error++
                    break
                }
                EstadoButaca.STANDAROCUPADA -> {
                    println("La butaca [$i, $fila] está ya ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar reserva) y cancelala")
                    error++
                    break
                }
                EstadoButaca.VIPOCUPADA -> {
                    println("La butaca [$i, $fila] está ya ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar reserva) y cancelala")
                    error++
                    break
                }
                else -> error("Null")
            }
        }
        if (error == 0) {
            println("El valor de las reservas asciende a ${round(total)} €")
            seleccionadorDeOpcion("""¿Quieres reservar las butacas que están disponibles?:
                |1 - Si
                |2 - No
            """.trimMargin(), 1..2)
            when(opcionSeleccionada){
                1 -> {
                    for (i in colInicial until colFinal + 1) {
                        when (arrayButacas[fila-1][i-1]?.estado){
                            EstadoButaca.STANDARLIBRE -> {
                                arrayButacas[fila-1][i-1]?.estado = EstadoButaca.STANDARRESERVADA
                                println("Butaca de Tipo Standard (5.35 €) añadida a reservas por confirmar")
                                numButacasReservadas++
                                numButacasStandardLibres--
                            }
                            EstadoButaca.VIPLIBRE -> {
                                arrayButacas[fila-1][i-1]?.estado = EstadoButaca.VIPRESERVADA
                                println("Butaca de Tipo VIP (8.5 €) añadida a reservas por confirmar")
                                numButacasReservadas++
                                numButacasVIPLibres--
                            }
                            else -> error("Null")
                        }
                    }
                    println("El valor total de las reservas es ${round(total)} €, ve al apartado de confirmar reservas para confirmarlas")
                }
                2 -> println("La reserva se ha cancelado")
            }
        }
    }

    //Método para confirmar una reserva de una butaca
    fun confirmarReservaUnitaria (sala: SalaCine, columna: Int, fila: Int) {
        when (sala.arrayButacas[fila - 1][columna - 1]?.estado) {
            EstadoButaca.VIPRESERVADA -> {
                seleccionadorDeOpcion("""Esta butaca es VIP y confirmar su reserva tiene un coste de 8.5€, ¿quiere confirmar la reserva?:
                    |1 - Si
                    |2 - No
                    """.trimMargin(), 1..2)
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.VIPOCUPADA
                        println("La reserva de la butaca se ha confirmado")
                        sala.balance += 8.5
                        sala.numButacasOcupadas++
                        sala.numButacasReservadas--
                    }
                    2-> println("La reserva no se ha confirmado")
                }
            }
            EstadoButaca.STANDARRESERVADA -> {
                seleccionadorDeOpcion("""Esta butaca es Standard y confirmar su reserva tiene un coste de 5.35€, ¿quiere confirmar la reserva?:
                        |1 - Si
                        |2 - No
                        """.trimMargin(), 1..2)
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.STANDAROCUPADA
                        println("La reserva de la butaca se ha confirmado")
                        sala.balance += 5.35
                        sala.numButacasOcupadas++
                        sala.numButacasReservadas--
                    }
                    2-> println("La reserva no se ha confirmado")
                }
            }
            EstadoButaca.VIPLIBRE -> println("Esta butaca no tiene ninguna reserva por confirmar asignada")
            EstadoButaca.STANDARLIBRE -> println("Esta butaca no tiene ninguna reserva por confirmar asignada")
            EstadoButaca.VIPOCUPADA -> println("Esta butaca ya está ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar una reserva)")
            EstadoButaca.STANDAROCUPADA -> println("Esta butaca ya está ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar una reserva)")
            null -> error("Null")
        }
    }

    //Mísmo método que el anterior pero para más de una butaca
    fun confirmarReservasContiguas (fila: Int, colInicial: Int, colFinal: Int) {
        var total = 0.0
        var error = 0
        for (i in colInicial until colFinal+1){
            when (arrayButacas[fila-1][i-1]?.estado) {
                EstadoButaca.VIPRESERVADA -> {
                    println("La butaca [$i, $fila] es VIP y está disponible para confirmar por 8.5 €")
                    total += 8.5
                }
                EstadoButaca.STANDARRESERVADA -> {
                    println("La butaca [$i, $fila] es Standard y está disponible para confirmar por 5.35 €")
                    total += 5.35
                }
                EstadoButaca.VIPLIBRE -> {
                    println("La butaca [$i, $fila] no tiene ninguna reserva por confirmar, ve al apartado 3 - (Hacer una reserva) para realizar una reserva")
                    error++
                    break
                }
                EstadoButaca.STANDARLIBRE -> {
                    println("La butaca [$i, $fila] no tiene ninguna reserva por confirmar,  ve al apartado 3 - (Hacer una reserva) para realizar una reserva")
                    error++
                    break
                }
                EstadoButaca.STANDAROCUPADA -> {
                    println("La butaca [$i, $fila] está ya ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar reserva) y cancelala")
                    error++
                    break
                }
                EstadoButaca.VIPOCUPADA -> {
                    println("La butaca [$i, $fila] está ya ocupada, si quieres cancelar esta reserva ve al apartado 5 - (Cancelar reserva) y cancelala")
                    error++
                    break
                }
                else -> error("Null")
            }
        }
        if (error == 0) {
            println("El valor de la confirmación asciende a ${round(total)} €")
            seleccionadorDeOpcion("""¿Quieres confirmar las reservas de las butacas disponibles?:
                |1 - Si
                |2 - No
            """.trimMargin(), 1..2)
            when(opcionSeleccionada){
                1 -> {
                    for (i in colInicial until colFinal + 1) {
                        when (arrayButacas[fila-1][i-1]?.estado){
                            EstadoButaca.STANDARRESERVADA -> {
                                arrayButacas[fila-1][i-1]?.estado = EstadoButaca.STANDAROCUPADA
                                println("La reserva de la Butaca de Tipo Standard (5.35 €) ha sido confirmada")
                                balance += 5.35
                                numButacasReservadas--
                                numButacasOcupadas++
                            }
                            EstadoButaca.VIPRESERVADA -> {
                                arrayButacas[fila-1][i-1]?.estado = EstadoButaca.VIPOCUPADA
                                println("La reserva de la Butaca de Tipo VIP (8.5 €) ha sido confirmada")
                                balance += 8.5
                                numButacasReservadas--
                                numButacasOcupadas++
                            }
                            else -> error("Null")
                        }
                    }
                    println("Has confirmado tus reservas por un valor de ${round(total)}, muchas gracias por la compra.")
                }
                2 -> println("La reserva se ha cancelado")
            }
        }
    }

    //Método para cancelar una reserva ya esté confirmada o no
    fun cancelarReserva(sala: SalaCine, columna: Int, fila: Int) {
        when (arrayButacas[fila-1][columna-1]!!.estado) {
            EstadoButaca.STANDAROCUPADA -> {
                seleccionadorDeOpcion("""Esta Butaca de Tipo Standard tiene una reserva confirmada, si se cancela la reserva, no se devolverá el importe de 5.35 €. ¿Está segur@ de querer cancelar la reserva?
                        |1 - Si
                        |2 - No
                        """.trimMargin(), 1..2
                )
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.STANDARLIBRE
                        println("La cancelación de la reserva se ha completado")
                        sala.numButacasOcupadas--
                        sala.numButacasStandardLibres++
                    }
                    2-> println("La cancelación no se ha completado")
                }
            }
            EstadoButaca.VIPOCUPADA -> {
                seleccionadorDeOpcion("""Esta Butaca de Tipo VIP tiene una reserva confirmada, si se cancela la reserva, no se devolverá el importe de 8.5 €. ¿Está segur@ de querer cancelar la reserva?
                        |1 - Si
                        |2 - No
                        """.trimMargin(), 1..2
                )
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.VIPLIBRE
                        println("La cancelación de la reserva se ha completado")
                        sala.numButacasOcupadas--
                        sala.numButacasVIPLibres++
                    }
                    2-> println("La cancelación no se ha completado")
                }
            }
            EstadoButaca.STANDARLIBRE -> println("Esta butaca de Tipo Standard no está reservada todavía")
            EstadoButaca.VIPLIBRE -> println("Esta butaca de Tipo VIP no está reservada todavía")
            EstadoButaca.STANDARRESERVADA -> {
                seleccionadorDeOpcion("""Esta Butaca de Tipo Standard está reservada pero aún no ha sido confirmada. ¿Quieres cancelar esta reserva?: 
                        |1 - Si
                        |2 - No
                        """.trimMargin(), 1..2
                )
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.STANDARLIBRE
                        println("La reserva ha sido cancelada correctamente")
                        sala.numButacasReservadas--
                        sala.numButacasStandardLibres++
                    }
                    2-> println("La reserva no se ha cancelado")
                }
            }
            EstadoButaca.VIPRESERVADA -> {
                seleccionadorDeOpcion("""Esta Butaca de Tipo VIP está reservada pero aún no ha sido confirmada. ¿Quieres cancelar esta reserva?:
                        |1 - Si
                        |2 - No
                        """.trimMargin(), 1..2
                )
                when (opcionSeleccionada) {
                    1 -> {
                        sala.arrayButacas[fila - 1][columna - 1]?.estado = EstadoButaca.VIPLIBRE
                        println("La reserva ha sido cancelada correctamente")
                        sala.numButacasReservadas--
                        sala.numButacasVIPLibres++
                    }
                    2-> println("La reserva no se ha cancelado")
                }
            }

            else -> {println("null")}
        }
    }

    //Método para mostrar las butacas con los colores asignados a cada una
    fun mostrarButacas() {

        println()
        print("\t\t$BLACK\t\t$RESET")

        for (i in 0 until columnas)
            print("$BLACK     \t\t$RESET")

        println()
        println()
        println()

        for (i in filas - 1 downTo 0) {
            print("\t${arrayLetras[i]}\t\t")
            for (j in 0 until columnas) {
                when (arrayButacas[i][j]?.estado) {
                    EstadoButaca.VIPLIBRE -> print("\t$BLUE     $RESET\t")
                    EstadoButaca.STANDARLIBRE -> print("\t$GREEN     $RESET\t")
                    EstadoButaca.STANDARRESERVADA -> print("\t$YELLOW     $RESET\t")
                    EstadoButaca.STANDAROCUPADA -> print("\t$RED     $RESET\t")
                    EstadoButaca.VIPRESERVADA -> print("\t$YELLOW     $RESET\t")
                    EstadoButaca.VIPOCUPADA -> print("\t$RED     $RESET\t")
                    null -> {
                        println("Error")
                    }
                }
            }
            println()
            println()
        }
        print("\t\t\t")
        for (i in 0 until columnas) {
            if (i < 9)
                print("\t${i + 1}\t\t")
            else
                print("\t${i + 1}\t")
        }
        println()
        println()
    }
}