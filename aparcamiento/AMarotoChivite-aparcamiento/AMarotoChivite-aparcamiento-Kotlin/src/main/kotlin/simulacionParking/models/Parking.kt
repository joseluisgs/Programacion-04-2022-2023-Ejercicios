package simulacionParking.models

import simulacionParking.enums.Color
import simulacionParking.enums.TipoVehiculo

data class Parking(val sizeRow: Int?, val sizeColumn: Int?, val matriz: Array<Array<Vehiculo?>>) {
    override fun toString(): String {
        print(matriz)
        return ""
    }

    /**
     * Devuelve el tamaño de las filas del parking
     *
     * @return matriz.length
     */
    fun getSizeRow(): Int {
        return matriz.size
    }

    /**
     * Devuelve el tamaño de las columnas del parking
     *
     * @return matriz[0].length
     */
    fun getSizeColumn(): Int {
        return matriz[0].size
    }

    /**
     * Devuelve la matriz completa del parking que está almacenada en la clase Parking
     *
     * @return matriz
     */
    fun getParkingMatrix(): Array<Array<Vehiculo?>> {
        return matriz
    }

    companion object {
        /**
         * Imprimimos en pantalla el parking, en mayor detalle posible
         *
         * @param matrizParking la matriz para poder imprimir
         */
        fun print(matrizParking: Array<Array<Vehiculo?>>) {
            println(
                """
    ======================= LEYENDA =======================
    Camión (${Color.RED.get()}N${Color.RESET.get()}), Coche (${Color.BLUE.get()}C${Color.RESET.get()}), Moto (${Color.YELLOW.get()}M${Color.RESET.get()}), Bici (${Color.CYAN.get()}B${Color.RESET.get()}), Patinete (${Color.GREEN.get()}P${Color.RESET.get()})
    Espacio vacío: (--)
    ID Vehículo: (TipoVehiculo ${Color.PURPLE.get()}nº${Color.RESET.get()})
    ======================= PARKING =======================
    """.trimIndent()
            )
            for (filas in matrizParking.indices) {
                for (columnas in matrizParking[filas].indices) {
                    if (columnas == 0) {
                        val cantidadColumnas = matrizParking[0].size
                        val espacioVisual = (55 - cantidadColumnas * 4) / 2
                        for (i in 1..espacioVisual) {
                            print(" ")
                        }
                    }
                    if (columnas == matrizParking[filas].size - 1) {
                        if (matrizParking[filas][columnas]!!.tipo == TipoVehiculo.VACIO) {
                            println("---")
                        } else {
                            if (matrizParking[filas][columnas]!!.tipo == TipoVehiculo.CAMION) {
                                println(
                                    (Color.RED.get() + "N" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.COCHE) {
                                println(
                                    (Color.BLUE.get() + "C" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.MOTO) {
                                println(
                                    (Color.YELLOW.get() + "M" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.BICI) {
                                println(
                                    (Color.PURPLE.get() + "B" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.PATINETE) {
                                println(
                                    (Color.GREEN.get() + "P" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                        }
                    } else {
                        if (matrizParking[filas][columnas]!!.tipo == TipoVehiculo.VACIO) {
                            print("--- ")
                        } else {
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.CAMION) {
                                print(
                                    (Color.RED.get() + "N" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.COCHE) {
                                print(
                                    (Color.BLUE.get() + "C" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.MOTO) {
                                print(
                                    (Color.YELLOW.get() + "M" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.BICI) {
                                print(
                                    (Color.PURPLE.get() + "B" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                            if (matrizParking[filas][columnas]!!.tipo === TipoVehiculo.PATINETE) {
                                print(
                                    (Color.GREEN.get() + "P" + Color.RESET.get()
                                            ).toString() + matrizParking[filas][columnas]!!.id + " "
                                )
                            }
                        }
                    }
                }
            }
            println("======================================================")
        }
    }
}