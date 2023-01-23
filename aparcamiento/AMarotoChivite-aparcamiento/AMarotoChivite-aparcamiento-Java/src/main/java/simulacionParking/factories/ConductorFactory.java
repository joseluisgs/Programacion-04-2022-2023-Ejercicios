package simulacionParking.factories;

import simulacionParking.models.Conductor;
import simulacionParking.models.Vehiculo;

import java.util.Random;

public class ConductorFactory {

    /**
     * Campo final del constructor, el cual una vez se genere un ID, no podremos reasignar
     */
    private static int id;

    /**
     * Segundo constructor para asignar un ID al ConductorFactory, que será el mismo que el Conductor
     */
    public ConductorFactory() {
        id = IdGenerator.getNextId();
    }

    /**
     * Creación de un objeto Conductor aleatorio
     *
     * @return conductorAleatorio
     */
    public static Conductor create() {
        String nombre = generarNombre();
        String DNI = generacionDNI();
        Vehiculo[] ownerVehicles = VehiculoFactory.generacionAlmacenVehiculos();

        // Lo único por defecto es la cantidad de coches aparcados que iremos incrementando después
        Conductor conductorAleatorio = new Conductor(IdGenerator.getNextId(), nombre, DNI, ownerVehicles, 0);
        return conductorAleatorio;
    }

    /**
     * Genera de manera aleatoria un nombre dentro de nuestro catálogo
     *
     * @return catalogoNombre[num], es el nombre aleatorio
     */
    public static String generarNombre() {
        Random r = new Random();
        int num = r.nextInt(7);
        String[] catalogoNombres = {"Pedro", "Alexandra", "Angel", "José", "Elena", "Ricardo", "Domingo", "Patricia"};
        return catalogoNombres[num];
    }

    /**
     * Genera de manera aleatoria un DNI, corresponde a 9 números y 1 letra
     *
     * @return DNI
     */
    public static String generacionDNI() {
        String alfabetoDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        // DNI completo
        StringBuilder DNI = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            // Genera un número entre 0 y 22 (incluidos)
            Random r = new Random();
            int num = r.nextInt(9);
            DNI.append(num);
        }

        Random r = new Random();
        int num = r.nextInt(23);
        DNI.append(alfabetoDNI.charAt(num));

        return DNI.toString();
    }

    /**
     * Devuelve el id de mi objeto
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Clase static para auto incrementar el ID, cada vez que creemos un objeto
     */
    public static class IdGenerator {
        /**
         * Campo de clase para mantener el incremento
         */
        public static int nextId = 1;

        /**
         * Cuando llamemos a la clase y su método único, aumentará nuestro ID
         *
         * @return nextId aumentado
         */
        public static int getNextId() {
            return nextId++;
        }
    }
}
