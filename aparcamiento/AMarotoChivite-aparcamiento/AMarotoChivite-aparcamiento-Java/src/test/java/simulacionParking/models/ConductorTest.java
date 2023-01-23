package simulacionParking.models;

import org.junit.jupiter.api.Test;
import simulacionParking.enums.TipoVehiculo;
import simulacionParking.factories.ConductorFactory;
import simulacionParking.factories.VehiculoFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ConductorTest {

    @Test
    void getOwnerVehicleTest() {

        Conductor conductorTest = ConductorFactory.create();
        Vehiculo vehiculoExpectedInterior = VehiculoFactory.create();
        conductorTest.setOwnerVehicle(0, vehiculoExpectedInterior);

        int contadorVehiculoEncontrado = 0;
        for (int i = 0; i < conductorTest.getOwnerVehicle().length; i++) {
            if (conductorTest.getOwnerVehicle()[i].equals(vehiculoExpectedInterior)) {
                contadorVehiculoEncontrado++;
                assertTrue(true);
            }
        }
        if (contadorVehiculoEncontrado != 1) {
            fail();
        }
    }

    @Test
    void setOwnerVehicleTest() {
        Conductor conductorTest = ConductorFactory.create();
        Vehiculo vehiculoExpectedInterior = new Vehiculo("1", "XXXXX-1111", "2010", TipoVehiculo.BICI);

        conductorTest.setOwnerVehicle(0, vehiculoExpectedInterior);
        if (conductorTest.getOwnerVehicle()[0].equals(vehiculoExpectedInterior)) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}