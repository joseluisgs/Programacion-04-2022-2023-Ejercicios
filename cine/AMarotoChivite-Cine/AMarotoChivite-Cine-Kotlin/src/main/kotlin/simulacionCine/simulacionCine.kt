package simulacionCine

import simulacionCine.enums.Color
import simulacionCine.enums.EstadoButaca
import simulacionCine.enums.EstadoTicket
import simulacionCine.models.*
import simulacionCine.utils.*
import kotlin.system.exitProcess

const val PRECIO_ESTANDAR: Double = 5.25
const val PRECIO_VIP: Double = 8.5

// BB. DD. volátil de clientes con un tamaño fijo máximo
const val CLIENTES_MAX: Int = 15

fun main(args: Array<String>) {

    // Control de argumentos iniciales
    // Comentar esta sección para ejecutar sin argumentos...
    // ===========================
    if (args.isEmpty()) {
        salirPrograma()
    }
    if (args[0] != "-fila") {
        salirPrograma()
    }
    if (args[2] != "-columna") {
        salirPrograma()
    }
    if (args[4] != "-vip") {
        salirPrograma()
    }
    // ===========================

    // En la sección de valores, asignar unos por defecto en caso de no querer argumentos...
    // ===========================
    val filasMax = args[1].toIntOrNull() // Valor por defecto, ejemplo: 6
    val columnasMax = args[3].toIntOrNull() // Valor por defecto, ejemplo: 6
    val cantidadButacasVip = args[5].toIntOrNull() // Valor por defecto, ejemplo: 10
    // ===========================


    if (filasMax == null) {
        salirPrograma()
    }
    if (filasMax != null && filasMax > 27) {
        salirPrograma()
    }
    // Mínimo puede haber una fila
    if (filasMax != null && filasMax < 1) {
        salirPrograma()
    }
    if (columnasMax == null) {
        salirPrograma()
    }
    // Mínimo puede haber una columna
    if (columnasMax != null && columnasMax < 1) {
        salirPrograma()
    }
    if (cantidadButacasVip == null) {
        salirPrograma()
    }
    // Mínima butaca VIP siendo cero
    if (cantidadButacasVip != null && cantidadButacasVip < 0) {
        salirPrograma()
    }
    // Máximo de butacas VIP son el máximo de butacas en una sala
    val maxButacasVip: Int = filasMax!! * columnasMax!!
    if ((cantidadButacasVip != null) && (cantidadButacasVip > maxButacasVip)) {
        salirPrograma()
    }
    // Si supera el filtro de argumentos se ejecutará el programa...

    // Inicialización de las películas que dispongamos, y por si queremos introducir más películas.
    val catalogoPeliculas: Array<Pelicula> = arrayOf(
        Pelicula("Avatar 2", "2022", "James Cameron", "Ciencia Ficción"),
        Pelicula("El viaje de Chihiro", "2001", "Hayao Miyazaki", "Anime-Fantasia"),
    )

    // Inicialización de las salas que dispongamos, con sus correspondientes butacas en estado libre por defecto,
    // y por si queremos generar más salas.
    val cine: Array<Sala> = arrayOf(
        Sala("001", "Sala 1", catalogoPeliculas[0], filasMax, columnasMax, cantidadButacasVip!!),
        Sala("002", "Sala 2", catalogoPeliculas[1], filasMax, columnasMax, cantidadButacasVip)
    )

    // Inicializo contenedor de tamaño fijo de clientes/usuarios
    val almacenClientes: Array<Cliente> = Array(CLIENTES_MAX) {
        Cliente(" ", " ", " ", " ", " ", " ",
            Ticket(EstadoTicket.INACTIVO, " ", " ", " ",
                Array(filasMax * columnasMax) { Butaca(EstadoButaca.LIBRE, "A", "0", false) }
            )
        )
    }
    // Mostrar los menús
    menuEleccionUsuario(cine, almacenClientes)
}


/**
 * Control de argumentos al iniciar el programa, si son erróneos llamaremos a esta función
 */
private fun salirPrograma() {
    println()
    println("Debes ejecutar el programa con un número de filas, columnas y butacas VIP que necesites!")
    println("======================================================================")
    println("Las ${Color.RED.color}filas${Color.RESET.color} deben comprender entre ${Color.RED.color}1 y 27 (incluídos)${Color.RESET.color}")
    println("Las ${Color.RED.color}columnas${Color.RESET.color} deben ser como ${Color.RED.color}mínimo 1${Color.RESET.color}")
    println("Las ${Color.RED.color}butacas VIP${Color.RESET.color} deben ser como ${Color.RED.color}máximo el tamaño máximo de las salas${Color.RESET.color}")
    println("======================================================================")
    println("Ejemplo: ${Color.PURPLE.color}java -jar paquete.jar -fila 6 -columna 4 -vip 10${Color.RESET.color}")
    println()
    exitProcess(1)
}

/**
 * Muestra un menú que permite al usuario iniciar sesión como administrador o como usuario.
 * Si el usuario elige comenzar sesión como administrador, se le pedirá la contraseña y se le
 * mostrará el menú para administradores.
 * Si elige comenzar sesión como usuario, se le mostrará el menú para usuarios.
 * Si elige salir, se finaliza el programa.
 *
 * @param cine Array de objetos de la clase Sala.
 * @param almacenClientes Array de objetos de la clase Cliente.
 */
fun menuEleccionUsuario(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    while (true) {
        val eleccion: Int =
            eleccionTipoUsuario(
                "Iniciar sesión como Administrador, " +
                        "Usuario, o Salir del programa " +
                        "\n(${Color.PURPLE_BRIGHT.color}admin${Color.RESET.color}/${Color.YELLOW_BRIGHT.color}user${Color.RESET.color}/${Color.RED.color}salir${Color.RESET.color}):"
            )
        if (eleccion == 1) {
            do {
                val passCorrect: String = "1234"
                if (isPassCorrect(passCorrect)) {
                    falsoBorradoDeConsola()
                    menuAdmin(cine)
                    break
                }
            } while (repetir("¿Quieres volver a intentar introducir la contraseña? (S/N):"))
        }
        if (eleccion == 0) {
            falsoBorradoDeConsola()
            menuCliente(cine, almacenClientes)
        }
        if (eleccion == -1) {
            falsoBorradoDeConsola()
            print("Muchas gracias por disfrutar de CINES ANGEL! Nos volveremos a ver...")
            break
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
fun eleccionTipoUsuario(mensaje: String): Int {
    while (true) {
        portadaCinesAngel()
        println(mensaje)
        val entradaInicioSesion: String = readln().lowercase()
        if (entradaInicioSesion == "admin") {
            falsoBorradoDeConsola()
            return 1
        }
        if (entradaInicioSesion == "user") {
            falsoBorradoDeConsola()
            return 0
        }
        if (entradaInicioSesion == "salir") {
            falsoBorradoDeConsola()
            return -1
        }
        falsoBorradoDeConsola()
        println("Debe introducir (admin/user/salir)!")
        Thread.sleep(1750)
        falsoBorradoDeConsola()
    }
}

/**
 * Pide al usuario que introduzca "S" o "N" para confirmar o cancelar una acción.
 *
 * @param mensaje El mensaje a mostrar al usuario al preguntar por la confirmación o cancelación.
 * @return 'true' si el usuario introduce "S", 'false' si el usuario introduce "N".
 */
fun repetir(mensaje: String): Boolean {
    while (true) {
        println("")
        println(mensaje)
        val entradaUsuario: String = readln().lowercase()
        if (entradaUsuario == "s") {
            falsoBorradoDeConsola()
            return true
        }
        if (entradaUsuario == "n") {
            falsoBorradoDeConsola()
            return false
        }
        falsoBorradoDeConsola()
        println("Debe introducir (S/N)!")
        Thread.sleep(1500)
        falsoBorradoDeConsola()
    }
}

/**
 * Permite al usuario volver al menú principal.
 *
 * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
 */
fun volverAlMenu(): Boolean {
    println("Introduzca (${Color.RED_BRIGHT.color}menu${Color.RESET.color}), para volver al menú principal:")
    val entradaDireccionMenu: String = readln().lowercase()
    if (entradaDireccionMenu == "menu") {
        return true
    }
    return false
}