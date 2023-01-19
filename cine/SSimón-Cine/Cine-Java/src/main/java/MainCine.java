import models.Sala;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase principal
 * Permite mediante un menu utilizar el programa
 * @author Sergio Simón Fernández
 */
public class MainCine {
    private static final Scanner sc = new Scanner(System.in);
    static Boolean isSalaReservada = false;

    public static void main(String[] args) {
        menuCine();
    }

    /**
     * Menu
     * Menu que permite manejar el Cine
     */
    private static void menuCine() {

        var menu = """
                1. Mostrar sala
                2. Comprar una entrada
                3. Reservar una sala
                4. Reservar una butaca
                5. Formalizar reserva
                6. Anular reserva/compra
                7. Informe
                8. Caja
                0. Salir
                """.trim();
        do {
            System.out.println(menu);
            var menuOption = compruebaEntero();
            switch (menuOption) {
                case 1 -> mostrarSala();
                case 2 -> comprarEntrada();
                case 3 -> reservarSala();
                case 4 -> reservarButaca();
                case 5 -> formalizarReserva();
                case 6 -> anularReservaCompra();
                case 7 -> informe();
                case 8 -> caja();
                case 0 -> salir();
                default -> System.out.println("Opción no válida");
            }
        } while (true);
    }

    /**
     * Muestra la sala
     * Imprime la matriz para mostrar la sala
     */
    private static void mostrarSala() {
        if (isSalaReservada) {
            Sala.mostrarSala();
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Comprar una entrada
     * Pide el nombre de la butaca que se quiere comprar y cambia su estado a comprada
     */
    private static void comprarEntrada() {
        if (isSalaReservada) {
            int indice = -1;
            String nombre;
            do {
                System.out.println("Introduce el nombre de la butaca");
                nombre = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("([A-Z][0-9]?[0-9])");
                if (pattern.matcher(nombre).matches()) {
                    indice = Sala.getButacaIdByNombre(nombre);
                }
            } while (indice == -1);
            Sala.comprarButaca(indice);
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Reservar una sala
     * Inicializa la sala con sus butacas y clases.
     */
    private static void reservarSala() {
        Sala.iniciarSala();
        isSalaReservada = true;
    }

    /**
     * Reserva butacas
     * Pide el nombre de la butaca que se quiere reservar y cambia su estado a reservado
     */
    private static void reservarButaca() {
        if (isSalaReservada) {
            int indice = -1;
            String nombre;
            do {
                System.out.println("Introduce el nombre de la butaca");
                nombre = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("([A-Z][0-9]?[0-9])");
                if (pattern.matcher(nombre).matches()) {
                    indice = Sala.getButacaIdByNombre(nombre);
                }
            } while (indice == -1);
            Sala.reservarButaca(indice);
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Formulario de reserva
     * Permite comprar una reserva comprada
     */
    private static void formalizarReserva(){
        if (isSalaReservada) {
            int indice = -1;
            String nombre;
            do {
                System.out.println("Introduce el nombre de la butaca");
                nombre = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("([A-Z][0-9]?[0-9])");
                if (pattern.matcher(nombre).matches()) {
                    indice = Sala.getButacaIdByNombre(nombre);
                }
            } while (indice == -1);
            Sala.comprarButacaReservada(indice);
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Anular reserva/compra
     * Pide el nombre de la butaca a reservar y cambia su estado a libre
     */
    private static void anularReservaCompra() {
        if (isSalaReservada) {
            int indice = -1;
            String nombre;
            do {
                System.out.println("Introduce el nombre de la butaca");
                nombre = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("([A-Z][0-9]?[0-9])");
                if (pattern.matcher(nombre).matches()) {
                    indice = Sala.getButacaIdByNombre(nombre);
                }
            } while (indice == -1);
            Sala.anularCompraReservaButaca(indice);
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Informe de la sala
     * Genera un informe separando las butacas libre reservadas y ocupadas dentro de cada una de estas estan separadas entre VIP y normales
     */
    private static void informe() {
        if (isSalaReservada) {
            Sala.mostrarClaseButacasByTipo();
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Muestra el dienro recogida
     * Suma el dinero recogido dependiendo el número de butacas ocupadas y su tipo
     */
    private static void caja() {
        if (isSalaReservada) {
            Sala.caja();
        }else {
            System.out.println("Primero debes de reservar una sala para continuar");
        }
    }

    /**
     * Salir del menú
     * Cierra el menú
     */
    private static void salir() {
        System.out.println("Adios.");
        System.exit(0);
    }

    /**
     * Regex para el menú
     * Solo permite la entrada de números que sean compatibles con las opciones disponibles
     */
    private static int compruebaEntero() {
        var input = sc.nextLine();
        var regex = "\\d";
        if (input.matches(regex)) {
            return Integer.parseInt(input);
        } else {
//            System.out.println("No es un número entero");
            return -1;
        }
    }
}