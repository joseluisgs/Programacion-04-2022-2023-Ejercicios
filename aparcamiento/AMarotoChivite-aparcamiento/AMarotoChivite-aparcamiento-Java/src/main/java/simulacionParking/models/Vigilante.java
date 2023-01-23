package simulacionParking.models;

import simulacionCine.enums.Color;
import simulacionParking.enums.TipoVehiculo;

public class Vigilante {
    // No queremos cambiar el nombre del Vigilante, por ello final
    public static final String name = "Angel";

    /**
     * Imprime en pantalla el Vigilante presentándose, donde puede aparcar el cliente/conductor
     *
     * @param tipo     para especificar al cliente/conductor que tipo de vehículo puede aparcar
     * @param filas    para especificar al cliente/conductor en que fila puede aparcar
     * @param columnas para especificar al cliente/conductor en que columna puede aparcar
     */
    public static void indicarDondeAparcar(TipoVehiculo tipo, int filas, int columnas) {
        System.out.println(Color.PURPLE_UNDERLINED.get() + "VIGILANTE" + Color.RESET.get() + "-> Hola soy " + name + " puedes aparcar tu " + tipo.get() + " en el parking fila:" + (filas + 1) + " columna:" + (columnas + 1) +
                " por un precio de 3.75€");
    }

    /**
     * Verifica que si está lleno el parking, si está lleno, el Vigilante avisará
     *
     * @param parking, para poder verificar en qué parking
     * @return false = si no está completo, true = está completo
     */
    public static boolean parkingCompleto(Parking parking) {
        for (int filas = 0; filas < parking.matriz().length; filas++) {
            for (int columnas = 0; columnas < parking.matriz()[filas].length; columnas++) {
                if (parking.matriz()[filas][columnas].getTipo().equals(TipoVehiculo.VACIO)) {
                    return false;
                }
            }
        }

        System.out.println(parking);
        System.out.println(Color.PURPLE_UNDERLINED.get() + "VIGILANTE" + Color.RESET.get() + "-> Hola soy " + name + ", no puedes aparcar, tenemos el Parking completo!");
        return true;
    }

    /**
     * El vigilante ha terminado su jornada y ha acabado el programa sin ninguna incidencia
     */
    public static void trabajoTerminado() {
        System.out.println(name + " ha hecho un buen trabajo de vigilante y ha terminado su jornada");
    }
}
