package simulacionParking.factories;

import org.junit.jupiter.api.Test;
import simulacionParking.enums.TipoVehiculo;
import simulacionParking.models.Parking;
import simulacionParking.models.Vehiculo;

import static org.junit.jupiter.api.Assertions.*;

class ParkingFactoryTest {

    @Test
    void create() {
        int contadorFailRow = 0;
        // Verificamos que no sea nulo
        Parking generateParking = ParkingFactory.create();
        assertNotNull(generateParking);

        // Verificamos que el tamaño se haya asignado correctamente en los valores mínimo y máximo
        int[] correctSizeRow = {8, 9, 10};
        int expectedSizeRow = generateParking.getSizeRow();
        for (int i = 0; i < correctSizeRow.length; i++) {
            if (correctSizeRow[i] == expectedSizeRow) {
                assertTrue(true);
            } else {
                contadorFailRow++;
            }
        }
        if (contadorFailRow == 3) {
            fail();
        }

        int contadorFailColumn = 0;
        int[] correctSizeColumn = {8, 9, 10};
        int expectedSizeColumn = generateParking.getSizeColumn();
        for (int i = 0; i < correctSizeColumn.length; i++) {
            if (correctSizeColumn[i] == expectedSizeColumn) {
                assertTrue(true);
            } else {
                contadorFailColumn++;
            }
        }
        if (contadorFailColumn == 3) {
            fail();
        }

        // Comprobamos inicialización todas las celdas con vehículos vacíos
        Vehiculo[][] parkingMatrix = generateParking.getParkingMatrix();

        for (int i = 0; i < parkingMatrix.length; i++) {
            for (int j = 0; j < parkingMatrix[i].length; j++) {
                assertEquals("0", parkingMatrix[i][j].getId());
                assertEquals("0", parkingMatrix[i][j].getMatricula());
                assertEquals("0", parkingMatrix[i][j].getAnno());
                assertEquals(TipoVehiculo.VACIO, parkingMatrix[i][j].getTipo());
            }
        }
    }
}