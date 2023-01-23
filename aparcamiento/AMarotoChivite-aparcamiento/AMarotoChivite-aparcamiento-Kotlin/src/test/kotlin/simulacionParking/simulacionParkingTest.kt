package simulacionParking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import simulacionParking.enums.TipoVehiculo
import simulacionParking.factories.ParkingFactory
import simulacionParking.factories.VehiculoFactory
import simulacionParking.models.Conductor
import simulacionParking.models.Parking
import simulacionParking.models.Vehiculo
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class simulacionParkingTest {
    @Test
    fun introducirCamionEnSiguienteFilaTest() {
        val parkingTest: Parking = ParkingFactory.create()
        val almacenConductores: Array<Conductor?> = arrayOf<Conductor?>(
            Conductor(
                1, "test", "test", arrayOf<Vehiculo?>(
                    Vehiculo("01", "test", "test", TipoVehiculo.CAMION)
                ), 1
            )
        )
        // Introducimos vehículos hasta dejar un espacio libre al final
        for (columnas in 0 until parkingTest.matriz[0].size - 1) {
            parkingTest.matriz[0][columnas] = VehiculoFactory.create()
        }

        // El actual conductor para testear del almacén, se encuentra en índice 0, y su camión en índice 0
        introducirCamionEnSiguienteFila(parkingTest, almacenConductores, 0, 0, 0)
        if (parkingTest.matriz[1][0]!!.tipo == TipoVehiculo.CAMION
            && parkingTest.matriz[1][1]!!.tipo == TipoVehiculo.CAMION
            && parkingTest.matriz[1][2]!!.tipo == TipoVehiculo.CAMION
            && parkingTest.matriz[1][3]!!.tipo == TipoVehiculo.CAMION
        ) {
            assertTrue(true)
        } else {
            fail<Any>()
        }
    }

    @Test
    fun introducirCocheEnSiguienteFilaTest() {
        val parkingTest: Parking = ParkingFactory.create()
        val almacenConductores: Array<Conductor?> = arrayOf<Conductor?>(
            Conductor(
                1, "test", "test", arrayOf<Vehiculo?>(
                    Vehiculo("01", "test", "test", TipoVehiculo.COCHE)
                ), 1
            )
        )
        // Introducimos vehículos hasta dejar un espacio libre al final
        for (columnas in 0 until parkingTest.matriz[0].size - 1) {
            parkingTest.matriz[0][columnas] = VehiculoFactory.create()
        }

        // El actual conductor para testear del almacén, se encuentra en índice 0, y su coche en índice 0
        introducirCocheEnSiguienteFila(parkingTest, almacenConductores, 0, 0, 0)
        if (parkingTest.matriz[1][0]!!.tipo == TipoVehiculo.COCHE
            && parkingTest.matriz[1][1]!!.tipo == TipoVehiculo.COCHE
        ) {
            assertTrue(true)
        } else {
            fail<Any>()
        }
    }

    @Test
    fun recuentoFinalTest() {
        val precioParking = 3.75
        val matrizTest: Array<Array<Vehiculo?>> = ParkingFactory.create().matriz
        val biciTest = Vehiculo("0", "0", "0", TipoVehiculo.BICI)
        matrizTest[0][0] = biciTest
        val cocheTest = Vehiculo("0", "0", "0", TipoVehiculo.COCHE)
        // El coche se asigna en dos posiciones, al ser más grande
        matrizTest[0][1] = cocheTest
        matrizTest[0][2] = cocheTest

        assertEquals((precioParking * 2), recuentoFinal(matrizTest))
    }

    @Test
    fun contadorVehiculosEnParkingTest() {
        val matrizTest: Array<Array<Vehiculo?>> = ParkingFactory.create().matriz
        val biciTest = Vehiculo("0", "0", "0", TipoVehiculo.BICI)
        matrizTest[0][0] = biciTest
        assertEquals(1, contadorVehiculosEnParking(matrizTest))
        val cocheTest = Vehiculo("0", "0", "0", TipoVehiculo.COCHE)
        // El coche se asigna en dos posiciones, al ser más grande
        matrizTest[0][1] = cocheTest
        matrizTest[0][2] = cocheTest
        assertEquals(2, contadorVehiculosEnParking(matrizTest))
        val camionTest = Vehiculo("0", "0", "0", TipoVehiculo.CAMION)
        // El camión se asigna en cuatro posiciones, al ser más grande
        matrizTest[0][3] = camionTest
        matrizTest[0][4] = camionTest
        matrizTest[0][5] = camionTest
        matrizTest[0][6] = camionTest
        assertEquals(3, contadorVehiculosEnParking(matrizTest))
    }

    @Test
    @Throws(InterruptedException::class)
    fun encontrarVehiculoTest() {
        val parkingTest: Parking = ParkingFactory.create()
        parkingTest.matriz[0][0] = Vehiculo("0", "XXX", "0", TipoVehiculo.BICI)
        val entradaUsuarioTest = "XXX"
        assertTrue(encontrarVehiculo(parkingTest.matriz, entradaUsuarioTest))
    }

    @Test
    fun bubbleSortTest() {
        val vehiculoAnnoViejo = Vehiculo("0", "0", "1990", TipoVehiculo.BICI)
        val vehiculoAnnoNuevo = Vehiculo("0", "0", "2000", TipoVehiculo.PATINETE)
        // Primero introducimos el nuevo, ya que queremos que nos ordene primero lso más antiguos
        val storagedToTest: Array<Vehiculo?> = arrayOf<Vehiculo?>(vehiculoAnnoNuevo, vehiculoAnnoViejo)
        bubbleSort(storagedToTest)
        if (storagedToTest[0] == vehiculoAnnoViejo) {
            assertTrue(true)
        } else {
            fail<Any>()
        }
    }
}