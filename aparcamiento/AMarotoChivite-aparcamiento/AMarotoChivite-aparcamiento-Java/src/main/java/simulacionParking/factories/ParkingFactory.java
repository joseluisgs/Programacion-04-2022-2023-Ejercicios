package simulacionParking.factories;

import simulacionParking.enums.TipoVehiculo;
import simulacionParking.models.Parking;
import simulacionParking.models.Vehiculo;

import java.util.Random;

public class ParkingFactory {

    /**
     * Creación de un Parking con un tamaño de filas y columnas generadas aleatoriamente
     * con valor mínimo 8 y máximo 10
     *
     * @return Parking
     */
    public static Parking create() {
        // Genera de forma aleatoria una matriz mínima de tamaño 8 y máximo 10
        Random r = new Random(); //2 y 8
        int sizeRow = r.nextInt(2) + 8;
        int sizeColumn = r.nextInt(2) + 8;

        // Lo dejamos vacío, para evitar los nulos:
        Vehiculo[][] parkingMatrix = new Vehiculo[sizeRow][sizeColumn];

        for (int filas = 0; filas < parkingMatrix.length; filas++) {
            for (int columna = 0; columna < parkingMatrix[filas].length; columna++) {
                parkingMatrix[filas][columna] = new Vehiculo("0", "0", "0", TipoVehiculo.VACIO);
            }
        }
        return new Parking(sizeRow, sizeColumn, parkingMatrix);
    }
}
