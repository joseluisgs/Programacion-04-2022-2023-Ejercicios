package simulacionParking;

import org.junit.jupiter.api.Test;
import simulacionParking.enums.TipoVehiculo;
import simulacionParking.factories.ParkingFactory;
import simulacionParking.factories.VehiculoFactory;
import simulacionParking.models.Conductor;
import simulacionParking.models.Parking;
import simulacionParking.models.Vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionParking.simulacionParking.*;

class simulacionParkingTest {
    
    @Test
    void introducirCamionEnSiguienteFilaTest() {
        Parking parkingTest = ParkingFactory.create();
        Conductor[] almacenConductores = {
                new Conductor(1, "test", "test",
                        new Vehiculo[]{
                                new Vehiculo("01", "test", "test", TipoVehiculo.CAMION)
                        }
                        , 1
                )
        };
        // Introducimos vehículos hasta dejar un espacio libre al final
        for (int columnas = 0; columnas < parkingTest.matriz()[0].length - 1; columnas++) {
            parkingTest.matriz()[0][columnas] = VehiculoFactory.create();
        }

        // El actual conductor para testear del almacén, se encuentra en índice 0, y su camión en índice 0
        introducirCamionEnSiguienteFila(parkingTest, almacenConductores, 0, 0, 0);
        if (parkingTest.matriz()[1][0].getTipo().equals(TipoVehiculo.CAMION)
                && parkingTest.matriz()[1][1].getTipo().equals(TipoVehiculo.CAMION)
                && parkingTest.matriz()[1][2].getTipo().equals(TipoVehiculo.CAMION)
                && parkingTest.matriz()[1][3].getTipo().equals(TipoVehiculo.CAMION)) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    void introducirCocheEnSiguienteFilaTest() {
        Parking parkingTest = ParkingFactory.create();
        Conductor[] almacenConductores = {
                new Conductor(1, "test", "test",
                        new Vehiculo[]{
                                new Vehiculo("01", "test", "test", TipoVehiculo.COCHE)
                        }
                        , 1
                )
        };
        // Introducimos vehículos hasta dejar un espacio libre al final
        for (int columnas = 0; columnas < parkingTest.matriz()[0].length - 1; columnas++) {
            parkingTest.matriz()[0][columnas] = VehiculoFactory.create();
        }

        // El actual conductor para testear del almacén, se encuentra en índice 0, y su coche en índice 0
        introducirCocheEnSiguienteFila(parkingTest, almacenConductores, 0, 0, 0);
        if (parkingTest.matriz()[1][0].getTipo().equals(TipoVehiculo.COCHE)
                && parkingTest.matriz()[1][1].getTipo().equals(TipoVehiculo.COCHE)) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    void recuentoFinalTest() {
        final double precioParking = 3.75;

        Vehiculo[][] matrizTest = ParkingFactory.create().matriz();
        Vehiculo biciTest = new Vehiculo("0", "0", "0", TipoVehiculo.BICI);
        matrizTest[0][0] = biciTest;

        Vehiculo cocheTest = new Vehiculo("0", "0", "0", TipoVehiculo.COCHE);
        // El coche se asigna en dos posiciones, al ser más grande
        matrizTest[0][1] = cocheTest;
        matrizTest[0][2] = cocheTest;

        assertEquals(precioParking * 2, recuentoFinal(matrizTest));

    }

    @Test
    void contadorVehiculosEnParkingTest() {
        Vehiculo[][] matrizTest = ParkingFactory.create().matriz();
        Vehiculo biciTest = new Vehiculo("0", "0", "0", TipoVehiculo.BICI);
        matrizTest[0][0] = biciTest;
        assertEquals(1, contadorVehiculosEnParking(matrizTest));

        Vehiculo cocheTest = new Vehiculo("0", "0", "0", TipoVehiculo.COCHE);
        // El coche se asigna en dos posiciones, al ser más grande
        matrizTest[0][1] = cocheTest;
        matrizTest[0][2] = cocheTest;
        assertEquals(2, contadorVehiculosEnParking(matrizTest));

        Vehiculo camionTest = new Vehiculo("0", "0", "0", TipoVehiculo.CAMION);
        // El camión se asigna en cuatro posiciones, al ser más grande
        matrizTest[0][3] = camionTest;
        matrizTest[0][4] = camionTest;
        matrizTest[0][5] = camionTest;
        matrizTest[0][6] = camionTest;
        assertEquals(3, contadorVehiculosEnParking(matrizTest));
    }

    @Test
    void encontrarVehiculoTest() throws InterruptedException {
        Parking parkingTest = ParkingFactory.create();
        parkingTest.matriz()[0][0] = new Vehiculo("0", "XXX", "0", TipoVehiculo.BICI);
        String entradaUsuarioTest = "XXX";
        assertTrue(encontrarVehiculo(parkingTest.matriz(), entradaUsuarioTest));
    }

    @Test
    void bubbleSortTest() {
        Vehiculo vehiculoAnnoViejo = new Vehiculo("0", "0", "1990", TipoVehiculo.BICI);
        Vehiculo vehiculoAnnoNuevo = new Vehiculo("0", "0", "2000", TipoVehiculo.PATINETE);
        // Primero introducimos el nuevo, ya que queremos que nos ordene primero lso más antiguos
        Vehiculo[] storagedToTest = {vehiculoAnnoNuevo, vehiculoAnnoViejo};

        bubbleSort(storagedToTest);

        if (storagedToTest[0].equals(vehiculoAnnoViejo)) {
            assertTrue(true);
        } else {
            fail();
        }

    }
}