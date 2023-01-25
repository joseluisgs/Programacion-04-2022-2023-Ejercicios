package simulacionCine;

import simulacionCine.enums.EstadoTicket;
import simulacionCine.models.*;

import java.util.Scanner;

import static java.lang.System.exit;
import static simulacionCine.utils.funcionesEsteticaDeConsola.falsoBorradoDeConsola;
import static simulacionCine.utils.funcionesEsteticaDeConsola.portadaCinesAngel;
import static simulacionCine.utils.funcionesMenuAdmin.isPassCorrect;
import static simulacionCine.utils.funcionesMenuAdmin.menuAdmin;
import static simulacionCine.utils.funcionesMenuCliente.menuCliente;

public class simulacionCine {
    public static final double PRECIO_ESTANDAR = 5.25;
    public static final double PRECIO_VIP = 8.5;
    public static final int BUTACAS_FILA_MAX = 6;
    public static final int BUTACAS_COLUMNA_MAX = 6;
    public static final int CLIENTES_MAX = 15;

    public static void main(String[] args) {
        // Inicialización de las películas que dispongamos
        Pelicula[] catalogoPeliculas = {
                new Pelicula("Avatar 2", "2022", "James Cameron", "Science Fiction"),
                new Pelicula("El viaje de Chihiro", "2001", "Hayao Miyazaki", "Anime-Fantasy"),
        };
        // Inicialización de las salas que dispongamos, con sus correspondientes butacas en estado libre por defecto
        Sala[] cine = {
                new Sala("001", "Sala 1", catalogoPeliculas[0], BUTACAS_FILA_MAX, BUTACAS_COLUMNA_MAX),
                new Sala("002", "Sala 2", catalogoPeliculas[1], BUTACAS_FILA_MAX, BUTACAS_COLUMNA_MAX)
        };

        // Inicializo contenedor de tamaño fijo de clientes/usuarios
        Cliente[] almacenClientes = new Cliente[CLIENTES_MAX];
        for (int i = 0; i < almacenClientes.length; i++) {
            almacenClientes[i] = new Cliente(" ", " ", " ", " ", " ", " ",
                    new Ticket(EstadoTicket.INACTIVO, " ", " ", " ",
                            new Butaca[BUTACAS_FILA_MAX * BUTACAS_COLUMNA_MAX]
                    )
            );
        }

        // Mostrar los menús
        menuEleccionUsuario(cine, almacenClientes);
    }

    /**
     * Muestra un menú que permite al usuario iniciar sesión como administrador o como usuario.
     * Si el usuario elige comenzar sesión como administrador, se le pedirá la contraseña y se le
     * mostrará el menú para administradores.
     * Si elige comenzar sesión como usuario, se le mostrará el menú para usuarios.
     * Si elige salir, se finaliza el programa.
     *
     * @param cine            Array de objetos de la clase Sala.
     * @param almacenClientes Array de objetos de la clase Cliente.
     */
    public static void menuEleccionUsuario(Sala[] cine, Cliente[] almacenClientes) {
        while (true) {
            int eleccion = eleccionTipoUsuario("Iniciar sesión como Administrador, Usuario, o Salir del programa (admin/user/salir):");
            if (eleccion == 1) {
                do {
                    String passCorrect = "1234";
                    if (isPassCorrect(passCorrect)) {
                        falsoBorradoDeConsola();
                        menuAdmin(cine, almacenClientes);
                        break;
                    }
                } while (repetir("¿Quieres volver a intentar introducir la contraseña? (S/N):"));
            }
            if (eleccion == 0) {
                falsoBorradoDeConsola();
                menuCliente(cine, almacenClientes);
            }
            if (eleccion == -1) {
                falsoBorradoDeConsola();
                System.out.println("Muchas gracias por disfrutar de CINES ANGEL! Nos volveremos a ver...");
                exit(0);
            }
        }
    }

    /**
     * Muestra un mensaje y espera a que el usuario ingrese "admin", "user" o "salir".
     * Si el usuario ingresa "admin", se retorna 1. Si ingresa "user", se retorna 0.
     * Si ingresa "salir", se retorna -1.
     * En caso contrario, se muestra un mensaje de error (temporal) sin romper la ejecución y se vuelve a intentar.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return 1 si el usuario ingresa "admin", 0 si ingresa "user", -1 si ingresa "salir".
     */
    public static int eleccionTipoUsuario(String mensaje) {
        while (true) {
            portadaCinesAngel();
            System.out.println(mensaje);
            Scanner sc = new Scanner(System.in);
            String entradaInicioSesion = sc.nextLine().toLowerCase();

            if (entradaInicioSesion.equals("admin")) {
                falsoBorradoDeConsola();
                return 1;
            }
            if (entradaInicioSesion.equals("user")) {
                falsoBorradoDeConsola();
                return 0;
            }
            if (entradaInicioSesion.equals("salir")) {
                falsoBorradoDeConsola();
                return -1;
            }
            falsoBorradoDeConsola();
            System.out.println("Debe introducir (admin/user/salir)!");
            try {
                Thread.sleep(1750);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            falsoBorradoDeConsola();
        }
    }

    /**
     * Pide al usuario que introduzca "S" o "N" para confirmar o cancelar una acción.
     *
     * @param mensaje El mensaje a mostrar al usuario al preguntar por la confirmación o cancelación.
     * @return 'true' si el usuario introduce "S", 'false' si el usuario introduce "N".
     */
    public static Boolean repetir(String mensaje) {
        while (true) {
            System.out.println();
            System.out.println(mensaje);
            Scanner sc = new Scanner(System.in);
            String entradaUsuario = sc.nextLine().toLowerCase();

            if (entradaUsuario.equals("s")) {
                falsoBorradoDeConsola();
                return true;
            }
            if (entradaUsuario.equals("n")) {
                falsoBorradoDeConsola();
                return false;
            }
            falsoBorradoDeConsola();
            System.out.println("Debe introducir (S/N)!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            falsoBorradoDeConsola();
        }
    }

    /**
     * Permite al usuario volver al menú principal.
     *
     * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
     */
    public static Boolean volverAlMenu() {
        System.out.println("Introduzca (menu), para volver al menú principal:");
        Scanner sc = new Scanner(System.in);
        String entradaDireccionMenu = sc.nextLine().toLowerCase();
        return entradaDireccionMenu.equals("menu");
    }
}
