//Mario Bueno López
//maarioo2525@gmail.com

import models.Taller

val tallerPrincipal: Taller = Taller(50)

fun main () {
    when (imputNum("""
        |
        |Bienvenido al menu del Taller, ¿Que deseas hacer?:
        |1 - Ver los Trabajadores del taller
        |2 - ver los salarios del taller
        |3 - Salir
    """.trimMargin(), 1..3)) {
        1 -> {
            tallerPrincipal.verTrabajadores()
            main()
        }
        2 -> {
            tallerPrincipal.verNominas()
            main()
        }
        3 -> println("Gracias por usar el menu del Taller")
    }
}

private fun imputNum (message: String, range: IntRange): Int{
    println(message)
    var eleccion : Int
    do {
        eleccion = readln().toIntOrNull() ?: (range.last - 1)
        if (eleccion !in range)
            println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (eleccion !in range)
    return eleccion
}