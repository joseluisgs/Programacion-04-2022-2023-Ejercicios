package simulacionParking.factories;

import simulacionParking.enums.TipoVehiculo;
import simulacionParking.models.Vehiculo;

import java.util.Random;

public class VehiculoFactory {

    /**
     * Creación de un objeto Vehiculo con ID auto incremental, y generación aleatoria de matrícula,
     * año de fábrica y el tipo de vehículo.
     *
     * @return vehiculo
     */
    public static Vehiculo create() {
        // Se pueden filtrar las generaciones aleatorias como precisemos, en este caso solo he filtrado en función
        // del annoFabrica, si es menos del 2015, no puede ser patinete al generar el tipo de Vehículo
        String matricula = generarMatricula();
        String annoFabrica = generarAnnoFabrica();
        TipoVehiculo tipo = generarTipoVehiculo(annoFabrica);
        String id_AUTO = IdGenerator.getNextId() + "";

        Vehiculo vehiculo = new Vehiculo(id_AUTO, matricula, annoFabrica, tipo);
        return vehiculo;
    }

    /**
     * Generación aleatoría del tipo de vehículo (camión, coche, moto, bici y patinete), en el caso de
     * patinete, solo será posible si su año de fábrica es del 2015 en adelante.
     *
     * @param annoFabrica para poder filtrar la creación de patinetes
     * @return TipoVehiculo, para poder asignarlo posteriormente a un vehiculo nuevo
     */
    public static TipoVehiculo generarTipoVehiculo(String annoFabrica) {
        while (true) {
            Random r = new Random();
            int num = r.nextInt(5);
            if (num == 0) {
                return TipoVehiculo.CAMION;
            }
            if (num == 1) {
                return TipoVehiculo.COCHE;
            }
            if (num == 2) {
                return TipoVehiculo.MOTO;
            }
            if (num == 3) {
                return TipoVehiculo.BICI;
            }
            if (num == 4 && Integer.parseInt(annoFabrica) >= 2015) {
                return TipoVehiculo.PATINETE;
            }
        }
    }

    /**
     * Generación aleatoria del año de fábrica de un vehículo, siendo desde 1990 hasta 2019 (incluídos)
     *
     * @return almacenAnnos[num]
     */
    public static String generarAnnoFabrica() {
        int indiceAlmacen = 0;
        // Almacén desde el 1990 hasta el 2019 = 29 años
        String[] almacenAnnos = new String[30];
        for (int i = 0; i < 10; i++) {
            String anno = "199" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        for (int i = 0; i < 10; i++) {
            String anno = "200" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        for (int i = 0; i < 10; i++) {
            String anno = "201" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        Random r = new Random();
        int num = r.nextInt(30);
        return almacenAnnos[num];
    }

    /**
     * Generación aleatoria de una matrícula que corresponda con 5 letras, 1 guión y 4 números, ej: (ABCDE-1234)
     *
     * @return matriculaFinal
     */
    public static String generarMatricula() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";

        Random r = new Random();
        StringBuilder matriculaFinal = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int sorteoAlfabeto = r.nextInt(26);
            matriculaFinal.append(alfabeto.charAt(sorteoAlfabeto));
        }
        matriculaFinal.append("-");
        for (int i = 0; i < 4; i++) {
            int sorteoNumeros = r.nextInt(10);
            matriculaFinal.append(numeros.charAt(sorteoNumeros));
        }
        return matriculaFinal.toString();
    }

    /**
     * Generación aleatoria de los vehículos que tenga un conductor, entre 1 y 4 vehículos
     *
     * @return vehiculosDeConductor
     */
    public static Vehiculo[] generacionAlmacenVehiculos() {
        Random r = new Random();
        int num = r.nextInt(3) + 1;

        Vehiculo[] vehiculosDeConductor = new Vehiculo[num];

        for (int i = 0; i < num; i++) {
            vehiculosDeConductor[i] = VehiculoFactory.create();
        }

        return vehiculosDeConductor;
    }

    /**
     * Clase static para auto incrementar el ID, cada vez que creemos un objeto, quería poner un 0,
     * delante del ID, para que en la matriz se vea ordenada, mientras el ID sea menor a 100
     */
    public class IdGenerator {

        /**
         * Campo de clase para mantener el incremento
         */
        private static int nextId = 1;

        /**
         * Cuando llamemos a la clase y su método único, aumentará nuestro ID
         *
         * @return nextId aumentado
         */
        public static String getNextId() {
            int contadorCantidadCifras = 0;
            String cifrasID = nextId + "";
            for (int i = 0; i < cifrasID.length(); i++) {
                contadorCantidadCifras++;
            }
            if (contadorCantidadCifras == 1) {
                return "0" + nextId++;
            } else {
                String finalID = nextId++ + "";
                return finalID;
            }
        }
    }
}
