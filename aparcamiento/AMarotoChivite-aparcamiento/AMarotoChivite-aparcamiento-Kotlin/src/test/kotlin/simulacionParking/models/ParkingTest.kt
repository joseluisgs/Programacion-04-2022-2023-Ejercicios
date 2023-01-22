package simulacionParking.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ParkingTest {
    @get:Test
    val sizeRowTest: Unit
        get() {
            val matriz = Array(3) { arrayOfNulls<Vehiculo>(4) }
            val (sizeRow) = Parking(3, 4, matriz)
            Assertions.assertEquals(3, sizeRow)
        }

    @get:Test
    val sizeColumnTest: Unit
        get() {
            val matriz = Array(3) { arrayOfNulls<Vehiculo>(4) }
            val (_, sizeColumn) = Parking(3, 4, matriz)
            Assertions.assertEquals(4, sizeColumn)
        }

    @get:Test
    val parkingMatrixTest: Unit
        get() {
            val matriz = Array(3) { arrayOfNulls<Vehiculo>(4) }
            val parking = Parking(3, 4, matriz)
            assertEquals(matriz, parking.getParkingMatrix())
        }
}