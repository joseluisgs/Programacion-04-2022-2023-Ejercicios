package simulacionParking.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionParking.enums.TipoVehiculo
import simulacionParking.models.Vehiculo

internal class ParkingFactoryTest {
    @Test
    fun create() {
        var contadorFailRow = 0
        // Verificamos que no sea nulo
        val generateParking = ParkingFactory.create()
        Assertions.assertNotNull(generateParking)

        // Verificamos que el tamaño se haya asignado correctamente en los valores mínimo y máximo
        val correctSizeRow = intArrayOf(8, 9, 10)
        val expectedSizeRow = generateParking.sizeRow
        for (i in correctSizeRow.indices) {
            if (correctSizeRow[i] == expectedSizeRow) {
                Assertions.assertTrue(true)
            } else {
                contadorFailRow++
            }
        }
        if (contadorFailRow == 3) {
            Assertions.fail<Any>()
        }
        var contadorFailColumn = 0
        val correctSizeColumn = intArrayOf(8, 9, 10)
        val expectedSizeColumn = generateParking.sizeColumn
        for (i in correctSizeColumn.indices) {
            if (correctSizeColumn[i] == expectedSizeColumn) {
                Assertions.assertTrue(true)
            } else {
                contadorFailColumn++
            }
        }
        if (contadorFailColumn == 3) {
            Assertions.fail<Any>()
        }

        // Comprobamos inicialización todas las celdas con vehículos vacíos
        val parkingMatrix: Array<Array<Vehiculo?>> = generateParking.getParkingMatrix()
        for (i in parkingMatrix.indices) {
            for (j in parkingMatrix[i].indices) {
                Assertions.assertEquals("0", parkingMatrix[i][j]!!.id)
                Assertions.assertEquals("0", parkingMatrix[i][j]!!.matricula)
                Assertions.assertEquals("0", parkingMatrix[i][j]!!.anno)
                Assertions.assertEquals(TipoVehiculo.VACIO, parkingMatrix[i][j]!!.tipo)
            }
        }
    }
}