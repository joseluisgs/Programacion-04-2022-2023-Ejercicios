package simulacionParking.models

import org.junit.jupiter.api.Test
import simulacionParking.factories.ParkingFactory
import simulacionParking.factories.VehiculoFactory
import kotlin.test.assertTrue

internal class VigilanteTest {
    @Test
    fun parkingCompletoTest() {
        val parking = ParkingFactory.create()
        for (filas in 0 until parking.matriz.size) {
            for (columnas in 0 until parking.matriz[filas].size) {
                parking.matriz[filas][columnas] = VehiculoFactory.create()
            }
        }

        assertTrue(Vigilante.parkingCompleto(parking))
    }
}