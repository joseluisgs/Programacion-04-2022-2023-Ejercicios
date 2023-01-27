package simulacionParking;

import simulacionParking.enums.TipoVehiculo;
import simulacionParking.factories.ConductorFactory;
import simulacionParking.factories.ParkingFactory;
import simulacionParking.models.Conductor;
import simulacionParking.models.Parking;
import simulacionParking.models.Vehiculo;
import simulacionParking.models.Vigilante;

import java.util.Scanner;

import static java.lang.System.exit;
import static simulacionParking.models.Parking.print;

public class simulacionParking {
    public static void main(String[] args) throws InterruptedException {

        // Inicializamos un parking:
        Parking parking = ParkingFactory.create();

        // 10 conductores
        Conductor[] almacenConductores = new Conductor[10];
        for (int i = 0; i < almacenConductores.length; i++) {
            almacenConductores[i] = ConductorFactory.create();
        }

        int actualVehiculo = 0;
        int actualConductor = 0;

        for (int filas = 0; filas < parking.matriz().length; filas++) {
            for (int columnas = 0; columnas < parking.matriz()[filas].length; columnas++) {
                // Recorremos todos los coches del conductor
                if (parking.matriz()[filas][columnas].getTipo().equals(TipoVehiculo.VACIO)) {
                    // Aumentamos el contador de vehíulos aparcados
                    almacenConductores[actualConductor].quantityParking_AUTO++;

                    if (almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo().equals(TipoVehiculo.CAMION)) {
                        for (int i = 0; i < 4; i++) {
                            // Si entra un camión lo introducimos en la fila que nos encontremos
                            if (columnas + 4 < parking.matriz()[filas].length) {
                                // Y cambiamos el estado del vehículo aparcado:
                                almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].setEstado(Vehiculo.EstadoVehiculo.APARCADO);
                                // Introducimos el vehículo en el parking
                                parking.matriz()[filas][columnas + i] = almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo];
                            } else {
                                introducirCamionEnSiguienteFila(parking, almacenConductores, actualVehiculo, actualConductor, filas);
                            }
                        }
                        // Interaccion Vigilante - Conductor
                        almacenConductores[actualConductor].presentarse();
                        Vigilante.indicarDondeAparcar(almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo(), filas, columnas);
                    } else if (almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo().equals(TipoVehiculo.COCHE)) {
                        for (int i = 0; i < 2; i++) {
                            // Si entra un coche lo introducimos en la fila que nos encontremos
                            if (columnas + 2 < parking.matriz()[filas].length) {
                                // Y cambiamos el estado del vehículo aparcado:
                                almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].setEstado(Vehiculo.EstadoVehiculo.APARCADO);
                                // Introducimos el vehículo en el parking
                                parking.matriz()[filas][columnas + i] = almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo];
                            } else {
                                introducirCocheEnSiguienteFila(parking, almacenConductores, actualVehiculo, actualConductor, filas);
                            }
                        }
                        // Interaccion Vigilante - Conductor
                        almacenConductores[actualConductor].presentarse();
                        Vigilante.indicarDondeAparcar(almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo(), filas, columnas);

                    } else if (almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo().equals(TipoVehiculo.MOTO)
                            || almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo().equals(TipoVehiculo.BICI)
                            || almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo().equals(TipoVehiculo.PATINETE)) {
                        // Introducimos bici,moto o patinete
                        parking.matriz()[filas][columnas] = almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo];

                        // Y cambiamos el estado del vehículo aparcado:
                        almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].setEstado(Vehiculo.EstadoVehiculo.APARCADO);

                        // Interaccion Vigilante - Conductor
                        almacenConductores[actualConductor].presentarse();
                        Vigilante.indicarDondeAparcar(almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].getTipo(), filas, columnas);
                    }
                    System.out.println(parking);
                    // Reiniciamos el recorrido del parking, para optimizar el espacio y almacenar en todo el parking
                    filas = 0;
                    columnas = 0;
                    // Y pasamos al siguiente coche del conductor
                    actualVehiculo += 1;
                    // Y desplegamos el menú de elección
                    menuParking(parking.matriz());
                }

                // Verificamos que hemos introducido todos los coches de un conductor
                if (almacenConductores[actualConductor].getOwnerVehicle().length == actualVehiculo) {
                    // Si ya hemos recorrido el almacen de coches que va a aparcar el conductor, reiniciamos los coches,
                    actualVehiculo = 0;
                    // y pasamos al siguiente conductor
                    actualConductor += 1;
                }

                // Verificar que ya hemos almacenado a todos los conductores
                if (almacenConductores.length == actualConductor) {
                    System.out.println(parking);
                    Vigilante.trabajoTerminado();
                    exit(0);
                }

                // Vigilante verifica que no esté lleno el parking, para cerrar el parking!
                if (Vigilante.parkingCompleto(parking)) {
                    exit(0);
                }
            }
        }
    }

    /**
     * Introducimos un camión en la siguiente fila del parking, en caso de que no se puede introducir
     * en la que previamente nos encontrábamos
     *
     * @param parking                donde estamos aparcando vehículos
     * @param almacenConductores     para saber que conductor y que vehículo aparcar
     * @param actualConductor        para saber en qué posición del almacenConductores nos encontramos
     * @param actualVehiculo         para saber en qué posición del almacenConductores y su vehículo nos encontramos
     * @param filaDondeNoEntraCamion para saber en qué fila, es donde no entra el camión
     */
    public static void introducirCamionEnSiguienteFila(Parking parking, Conductor[] almacenConductores, int actualVehiculo, int actualConductor, int filaDondeNoEntraCamion) {
        if (filaDondeNoEntraCamion + 1 <= parking.matriz().length) {
            // En caso contrario, si al pasar a la siguiente fila, esta fila existe, sin salirnos de la matriz!
            // Pasamos la siguiente fila, y empezamos a introducir ahí, si está vacío
            for (int columnaSiguiente = 0; columnaSiguiente < 4; columnaSiguiente++) {
                if (parking.matriz()[filaDondeNoEntraCamion + 1][columnaSiguiente].getTipo().equals(TipoVehiculo.VACIO)) {
                    // Y cambiamos el estado del vehículo aparcado:
                    almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].setEstado(Vehiculo.EstadoVehiculo.APARCADO);
                    // Introducimos el vehículo en el parking
                    parking.matriz()[filaDondeNoEntraCamion + 1][columnaSiguiente] = almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo];
                }
            }
        }
    }

    /**
     * Introducimos un coche en la siguiente fila del parking, en caso de que no se puede introducir
     * en la que previamente nos encontrábamos
     *
     * @param parking               donde estamos aparcando vehículos
     * @param almacenConductores    para saber que conductor y que vehículo aparcar
     * @param actualConductor       para saber en qué posición del almacenConductores nos encontramos
     * @param actualVehiculo        para saber en qué posición del almacenConductores y su vehículo nos encontramos
     * @param filaDondeNoEntraCoche para saber en qué fila, es donde no entra el coche
     */
    public static void introducirCocheEnSiguienteFila(Parking parking, Conductor[] almacenConductores, int actualVehiculo, int actualConductor, int filaDondeNoEntraCoche) {
        if (filaDondeNoEntraCoche + 1 <= parking.matriz().length) {
            // En caso contrario, si al pasar a la siguiente fila, esta fila existe, sin salirnos de la matriz!
            // Pasamos la siguiente fila, y empezamos a introducir ahí, si está vacío
            for (int columnaSiguiente = 0; columnaSiguiente < 2; columnaSiguiente++) {
                if (parking.matriz()[filaDondeNoEntraCoche + 1][columnaSiguiente].getTipo().equals(TipoVehiculo.VACIO)) {
                    // Y cambiamos el estado del vehículo aparcado:
                    almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo].setEstado(Vehiculo.EstadoVehiculo.APARCADO);
                    // Introducimos el vehículo en el parking
                    parking.matriz()[filaDondeNoEntraCoche + 1][columnaSiguiente] = almacenConductores[actualConductor].getOwnerVehicle()[actualVehiculo];
                }
            }
        }
    }

    /**
     * Recuento del parking, en función de loa vehículo que haya multiplicamos por el precio por aparcar (3.75€)
     *
     * @param matriz es el parking donde hacemos la lectura de vehículos
     * @return recaudacionTotal
     */
    public static double recuentoFinal(Vehiculo[][] matriz) {
        final double precioParking = 3.75;
        int contadorVehiculos = contadorVehiculosEnParking(matriz);

        double recaudacionTotal = contadorVehiculos * precioParking;
        System.out.println("La recaudación total actual es de: " + recaudacionTotal + "€");
        return recaudacionTotal;
    }

    /**
     * Contamos los vehículos que hay en el Parking
     *
     * @param matriz parking donde están aparcados los vehículos
     * @return contadorCoches + contadorCamiones + contadorIndividual, es la suma de los vehículos
     */
    public static int contadorVehiculosEnParking(Vehiculo[][] matriz) {
        int contadorCamiones = 0;
        int contadorCoches = 0;
        int contadorIndividual = 0;

        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
                if (matriz[filas][columnas].getTipo().equals(TipoVehiculo.CAMION)) {
                    contadorCamiones++;
                }
            }
        }
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
                if (matriz[filas][columnas].getTipo().equals(TipoVehiculo.COCHE)) {
                    contadorCoches++;
                }
            }
        }
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz[filas].length; columnas++) {
                if (matriz[filas][columnas].getTipo().equals(TipoVehiculo.MOTO)
                        || matriz[filas][columnas].getTipo().equals(TipoVehiculo.BICI)
                        || matriz[filas][columnas].getTipo().equals(TipoVehiculo.PATINETE)) {
                    contadorIndividual++;
                }
            }
        }
        contadorCoches = contadorCoches / 2;
        contadorCamiones = contadorCamiones / 4;
        return contadorCoches + contadorCamiones + contadorIndividual;
    }

    /**
     * Crea una sensación de borrado de la consola.
     * Mediante una impresión de varias líneas en blanco.
     */
    public static void falsoBorradoDeConsola() {
        // Para crear una senación de borrado en consola
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    /**
     * Para preguntar al usuario si quiere continuar, en caso de errar la entrada se encuentra en un
     * bucle hasta dar con una respuesta válida (S/N)
     *
     * @param mensaje para poder informar al usuario
     * @return true = si quiere continuar, false = si no quiere continuar
     * @throws InterruptedException
     */
    public static boolean continuar(String mensaje) throws InterruptedException {
        while (true) {
            String entradaUsuario = pedirEntradaSinFiltro(mensaje);

            if (entradaUsuario.equals("S")) {
                falsoBorradoDeConsola();
                return true;
            }
            if (entradaUsuario.equals("N")) {
                falsoBorradoDeConsola();
                return false;
            }
            falsoBorradoDeConsola();
            System.out.println("Debe introducir (S)!");
            Thread.sleep(1500);
            falsoBorradoDeConsola();
        }
    }

    /**
     * Menú para tener información extra del parking
     *
     * @param parking para poder calcular distintas funciones dentro del menú
     * @throws InterruptedException
     */
    public static void menuParking(Vehiculo[][] parking) throws InterruptedException {
        boolean deplegarMenu = continuar("¿Quieres desplegar un menú interactivo? (S/N)");

        while (deplegarMenu) {
            System.out.println("(USUARIO) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Continuar simulación");
            System.out.println("2: Listado Parking (ordenados: antigüedad ascendete)");
            System.out.println("3: Recaudación total (caja actual del Parking)");
            System.out.println("4: Encontrar tu vehículo (matricula)");
            System.out.println("0: Finalizar simulación");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()) {

                case "1" -> {
                    falsoBorradoDeConsola();
                    deplegarMenu = false;
                    falsoBorradoDeConsola();
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    listadoParking(parking);
                    System.out.println();
                    continuar("Volver al menú (S)");
                    falsoBorradoDeConsola();
                }
                case "3" -> {
                    falsoBorradoDeConsola();
                    recuentoFinal(parking);
                    System.out.println();
                    continuar("Volver al menú (S)");
                    falsoBorradoDeConsola();
                }
                case "4" -> {
                    falsoBorradoDeConsola();
                    boolean salirBucle = false;
                    while (!salirBucle) {
                        String entrada = pedirEntradaSinFiltro("Puedes realizar la búsqueda de tu vehículo mediante -> matrícula: ");
                        encontrarVehiculo(parking, entrada);
                        salirBucle = !continuar("¿Quieres realizar de nuevo la búsqueda? (S/N)");
                    }
                    falsoBorradoDeConsola();
                }
                // Salir
                case "0" -> {
                    falsoBorradoDeConsola();
                    exit(0);
                }
            }
        }
    }

    /**
     * Encuentra un vehícula en función de su matrícula, si lo encuentra indica la fila y columna donde se encuentre
     *
     * @param parking para poder encontrar el vehículo
     * @param entrada matrícula que introduce el usuario para buscar
     * @return true = si matrícula existe en el parking, false = si no encuentra
     * @throws InterruptedException
     */
    public static boolean encontrarVehiculo(Vehiculo[][] parking, String entrada) throws InterruptedException {

        boolean encontrado = false;

        for (int filas = 0; filas < parking.length; filas++) {
            for (int columnas = 0; columnas < parking[filas].length; columnas++) {
                if (parking[filas][columnas].matricula.equals(entrada)) {
                    System.out.println("Tu vehículo se encuentra en la fila " + (filas + 1) + " columna " + (columnas + 1));
                    System.out.println(" ");
                    encontrado = true;
                    return true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay ningún vehículo con la matrícula que nos proporcionas!");
            System.out.println();
            return false;
        }

        return false;
    }

    /**
     * Para pedir al usuario una entrada, no presentan filtro, ya que las introduzco en bucles, hasta que
     * favorezca a las condiciones
     *
     * @param mensaje para informar al usuario sobre que debe introducir
     * @return scanner la entrada que ha proporcionado el usuario
     */
    public static String pedirEntradaSinFiltro(String mensaje) {
        System.out.println(mensaje);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Imprime en pantalla un listado ordenados de más viejos a más nuevos los vehículos, y el parking actual
     *
     * @param parking para poder listar e imprimir
     */
    public static void listadoParking(Vehiculo[][] parking) {
        int contadorVehiculos = contadorVehiculosEnParking(parking);
        Vehiculo[] almacenVehiculosAparcados = new Vehiculo[80];

        System.out.println("Disponemos de un total actual de: " + contadorVehiculos + " vehículos");

        for (int filas = 0; filas < parking.length; filas++) {
            for (int columnas = 0; columnas < parking[filas].length; columnas++) {
                if (!parking[filas][columnas].getId().equals("0")) {
                    // Recorremos el almacén e introducimos un coche
                    for (int i = 0; i < almacenVehiculosAparcados.length; i++) {
                        // Introducimos donde no haya coche
                        if (almacenVehiculosAparcados[i] == null) {
                            almacenVehiculosAparcados[i] = parking[filas][columnas];
                            break;
                        }
                    }
                }
            }
        }
        // Ordenamos los coches
        bubbleSort(almacenVehiculosAparcados);
        // Imprimimos
        for (int i = 0; i < almacenVehiculosAparcados.length; i++) {
            if (!(almacenVehiculosAparcados[i] == null)) {
                System.out.println(almacenVehiculosAparcados[i].toString());
            }
        }
        print(parking);
    }

    /**
     * Ordenación de Vehículos en función de la vejez del año de fabricación del vehículo
     *
     * @param vector almacén de los vehículos que queremos ordenar
     */
    public static void bubbleSort(Vehiculo[] vector) {
        int annoActual = 0;
        int annoSiguiente = 0;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - 1; j++) {
                if ((vector[j] != null && vector[j + 1] != null)) {
                    annoActual = Integer.parseInt(vector[j].anno);
                    annoSiguiente = Integer.parseInt(vector[j + 1].anno);

                    if (annoActual > annoSiguiente) {
                        Vehiculo aux = vector[j];
                        vector[j] = vector[j + 1];
                        vector[j + 1] = aux;
                    }
                }
            }
        }
    }
}