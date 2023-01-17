package utils

import models.Persona
import kotlin.system.exitProcess

// Aquí están agrupados los métodos referentes al menú

/**
 * Ejecuta el bucle infinito que es el menú del programa
 * @param taller el array de personas que conforman el taller
 */
fun menu(taller: Array<Persona?>) {
    // Ponemos aquí cositas para que sea visualmente más atractivo
    println("Bienvenid@ al taller")
    println()
    var opcion = -1
    do {
        // Display del menú, con alguna cosilla para que quede más bonito
        println("Menu")
        println("--------------------------------")
        println("[1] Imprimir listado de trabajadores")
        println("[2] Numero de trabajadores por ocupación")
        println("[3] Nominas del taller")
        println("[0] Salir del programa")
        println("--------------------------------")
        opcion = entradaOpcion()
        // La única forma de salir del bucle es seleccionar la opción 0
        ejecutarOpcion(taller, opcion)
    } while (opcion in 1..4)
}

/**
 * Recibe la opción de la entrada introducida por el usuario
 * @return el número de la opción
 */
fun entradaOpcion(): Int {
    val opcion = readln().toIntOrNull() ?: -1
    if (opcion !in 0..3) {
        return 4
    }
    return opcion
}

/**
 * Ejecuta una función dependiendo de la opción recibida
 * @param taller el array de personas que conforman el taller
 * @param opcion el número de opción seleccionada
 */
fun ejecutarOpcion(taller: Array<Persona?>, opcion: Int) {
    // Con un when queda limpio
    when (opcion) {
        1 -> imprimirTaller(taller)
        2 -> enumeracionTrabajadores(taller)
        3 -> contabilidadTaller(taller)
        4 -> {
            println("Opción no válida, introduzca una nueva")
            println()
        }

        0 -> exitProcess(0)
    }
}

