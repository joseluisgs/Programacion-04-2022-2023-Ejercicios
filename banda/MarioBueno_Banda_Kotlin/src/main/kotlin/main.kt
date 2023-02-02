//Mario Bueno López
//maarioo2525@gmail.com

import models.Banda

val banda = Banda(50)
fun main () {
    when (imputNum("""
        |
        |Bienvenido al menu de las bandas, ¿Que deseas hacer?:
        |1 - Ver los integrantes de una banda
        |2 - ver los salarios de una banda
        |3 - Salir
    """.trimMargin(), 1..3)) {
        1 -> {
            //Llama al método de la clase banda contarMusicos()
            banda.contarMusicos()
            main()
        }
        2 -> {
            //Llama al método de la clase banda salarios()
            banda.salarios()
            main()
        }
        3 -> println("Gracias por usar el menu de las bandas")
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