package simulacionParking.models;

import org.junit.jupiter.api.Test;
import simulacionParking.factories.ParkingFactory;
import simulacionParking.factories.VehiculoFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VigilanteTest {

    @Test
    void parkingCompletoTest() {
        Parking parking = ParkingFactory.create();

        for (int filas = 0; filas < parking.matriz().length; filas++) {
            for (int columnas = 0; columnas < parking.matriz()[filas].length; columnas++) {
                parking.matriz()[filas][columnas] = VehiculoFactory.create();
            }
        }

        assertTrue(Vigilante.parkingCompleto(parking));
    }
}