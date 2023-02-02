package Taller
//un taller con un array de 50 trabajadores de varios tipo, generado aleatoriamente.
//Cada trabajador tiene sus metodos y comportamientos, como comer, descansar y saludar.
//Los metodos del main son. Ver lista de trabajadores(array), ver el gasto total en sueldos, elegir un trabajador para ver que está haciendo
// En este ultimo el trabajador se presenta y dice si esta descansado, trabajamdo o los que sea.
//me queda: saber generar el array aleatorio con las probabilidades y todoeso, crear los metodos, los del salario y nosequemas ya veremos.
import Taller.models.Taller
import kotlin.system.exitProcess

fun main() {

    val taller = Taller()
    menu(taller)
}

/**
 * Función que imprime el menú con las opciones del ejercicio
 * y luego llama a otra función para la eleccion del menú.
 * @param taller: Taller
 */
fun menu(taller: Taller) {
    val eleccion = 0
    do {
        println("1. Ver lista de trabajadores")
        println("2. Ver gasto en salarios")
        println("3. Ver estado de trabajador")
        println("4. Ver numero de trabajadores")
        println("5. Salir del taller")
        println()
        eleccionMenu(taller)
    } while (eleccion == 0)
}

/**
 * Función que selecciona la opción del menú con una entrada de usuario
 * @param taller: Taller
 */
fun eleccionMenu(taller: Taller) {
    val regex = Regex("[1-5]")
    do {
        println("Selecciona una opcion del menu")
        val eleccionMenu = readln().toInt()
        if (!regex.matches(eleccionMenu.toString())) {
            println("El valor introducido no está permitido")
        }
        if (eleccionMenu == 1) {
            taller.mostrarPersonal()
        }
        if (eleccionMenu == 2) {
            taller.mostrarSalarios()
        }
        if (eleccionMenu == 3) {
            taller.estadoTrabajador()
        }
        if (eleccionMenu == 4) {
            taller.numeroDeTrabajadores()
        }
        if (eleccionMenu == 5) {
            println("Hasta luego!")
            exitProcess(0)
        }
    }while(!regex.matches(eleccionMenu.toString()))
}