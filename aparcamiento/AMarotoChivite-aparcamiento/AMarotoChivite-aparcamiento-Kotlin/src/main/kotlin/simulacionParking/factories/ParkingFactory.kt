package simulacionParking.factories

import simulacionParking.enums.TipoVehiculo
import simulacionParking.models.Parking
import simulacionParking.models.Vehiculo
import java.util.*

object ParkingFactory {
    /**
     * Creación de un Parking con un tamaño de filas y columnas generadas aleatoriamente
     * con valor mínimo 8 y máximo 10
     *
     * @return Parking
     */
    fun create(): Parking {
        // Genera de forma aleatoria una matriz mínima de tamaño 8 y máximo 10
        val r = Random() //2 y 8
        val sizeRow = r.nextInt(2) + 8
        val sizeColumn = r.nextInt(2) + 8

        // Lo dejamos con TipoVacío, para evitar los nulos:
        val parkingMatrix: Array<Array<Vehiculo?>> = Array(sizeRow) { Array(sizeColumn) { null } }
        for (filas in parkingMatrix.indices) {
            for (columna in parkingMatrix[filas].indices) {
                parkingMatrix[filas][columna] = Vehiculo("0", "0", "0", TipoVehiculo.VACIO)
            }
        }
        return Parking(sizeRow, sizeColumn, parkingMatrix)
    }
}