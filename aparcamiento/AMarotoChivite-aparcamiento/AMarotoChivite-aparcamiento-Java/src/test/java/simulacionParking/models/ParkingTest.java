package simulacionParking.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingTest {

    @Test
    void getSizeRowTest() {
        Vehiculo[][] matriz = new Vehiculo[3][4];
        Parking parking = new Parking(3, 4, matriz);

        int sizeRow = parking.getSizeRow();
        assertEquals(3, sizeRow);
    }

    @Test
    void getSizeColumnTest() {
        Vehiculo[][] matriz = new Vehiculo[3][4];
        Parking parking = new Parking(3, 4, matriz);

        int sizeColumn = parking.getSizeColumn();
        assertEquals(4, sizeColumn);
    }

    @Test
    void getParkingMatrixTest() {
        Vehiculo[][] matriz = new Vehiculo[3][4];
        Parking parking = new Parking(3, 4, matriz);

        assertEquals(matriz, parking.getParkingMatrix());
    }

}