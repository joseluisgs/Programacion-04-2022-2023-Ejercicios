package simulacionParking.models;

import simulacionCine.enums.Color;
import simulacionParking.enums.TipoVehiculo;

public record Parking(int sizeRow, int sizeColumn, Vehiculo[][] matriz) {

    /**
     * Imprimimos en pantalla el parking, en mayor detalle posible
     *
     * @param matrizParking la matriz para poder imprimir
     */
    public static void print(Vehiculo[][] matrizParking) {
        System.out.println("======================= LEYENDA =======================\n" +
                "Camión (" + Color.RED.get() + "N" + Color.RESET.get() + "), " +
                "Coche (" + Color.BLUE.get() + "C" + Color.RESET.get() + "), " +
                "Moto (" + Color.YELLOW.get() + "M" + Color.RESET.get() + "), " +
                "Bici (" + Color.CYAN.get() + "B" + Color.RESET.get() + "), " +
                "Patinete (" + Color.GREEN.get() + "P" + Color.RESET.get() + ")\n" +
                "Espacio vacío: " + "(--)\n" +
                "ID Vehículo: (TipoVehiculo " + Color.PURPLE.get() + "nº" + Color.RESET.get() + ")\n" +
                "======================= PARKING =======================");

        for (int filas = 0; filas < matrizParking.length; filas++) {
            for (int columnas = 0; columnas < matrizParking[filas].length; columnas++) {
                if (columnas == 0) {
                    int cantidadColumnas = matrizParking[0].length;
                    int espacioVisual = (55 - (cantidadColumnas * 4)) / 2;
                    for (int i = 1; i <= espacioVisual; i++) {
                        System.out.print(" ");
                    }
                }
                if (columnas == matrizParking[filas].length - 1) {
                    if (matrizParking[filas][columnas].getTipo().equals(TipoVehiculo.VACIO)) {
                        System.out.println("---");
                    } else {
                        if (matrizParking[filas][columnas].getTipo().equals(TipoVehiculo.CAMION)) {
                            System.out.println(Color.RED.get() + "N" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.COCHE) {
                            System.out.println(Color.BLUE.get() + "C" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.MOTO) {
                            System.out.println(Color.YELLOW.get() + "M" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.BICI) {
                            System.out.println(Color.PURPLE.get() + "B" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.PATINETE) {
                            System.out.println(Color.GREEN.get() + "P" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                    }
                } else {
                    if (matrizParking[filas][columnas].getTipo().equals(TipoVehiculo.VACIO)) {
                        System.out.print("--- ");
                    } else {
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.CAMION) {
                            System.out.print(Color.RED.get() + "N" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.COCHE) {
                            System.out.print(Color.BLUE.get() + "C" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.MOTO) {
                            System.out.print(Color.YELLOW.get() + "M" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.BICI) {
                            System.out.print(Color.PURPLE.get() + "B" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                        if (matrizParking[filas][columnas].getTipo() == TipoVehiculo.PATINETE) {
                            System.out.print(Color.GREEN.get() + "P" + Color.RESET.get()
                                    + matrizParking[filas][columnas].getId() + " ");
                        }
                    }
                }
            }
        }
        System.out.println("======================================================");
    }

    @Override
    public String toString() {
        print(matriz);
        return "";
    }

    /**
     * Devuelve el tamaño de las filas del parking
     *
     * @return matriz.length
     */
    public int getSizeRow() {
        return matriz.length;
    }

    /**
     * Devuelve el tamaño de las columnas del parking
     *
     * @return matriz[0].length
     */
    public int getSizeColumn() {
        return matriz[0].length;
    }

    /**
     * Devuelve la matriz completa del parking que está almacenada en la clase Parking
     *
     * @return matriz
     */
    public Vehiculo[][] getParkingMatrix() {
        return matriz;
    }
}
