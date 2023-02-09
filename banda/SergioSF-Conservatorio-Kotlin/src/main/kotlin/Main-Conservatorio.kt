import controllers.MusicosControllers
import repositories.MusicosRepositoriesMemory


val musicosControllers = MusicosControllers(MusicosRepositoriesMemory())

fun main() {
//    val resultado = musicosControllers.getAll()
//        println(resultado.indices)
//
//    for (i in resultado.indices) {
//        print("$i ")
//        println(resultado[i].instrumento)
//    }

    menu()
}

fun menu() {
    do {
        var salir = false
        println(
            """
            1. Ver el salario total de los músicos.
            2. Ver el salario de los músicos.
            3. Ver el salario de los músicos por especialidad.
            4. Conocer a los músicos.
            5. Buscar a los músicos por nombre.
            0. Salir
        """.trimIndent()
        )

        when (opcion()) {
            1 -> salarioTotal()
            2 -> salarioMusicos()
            3 -> salarioByEspecialidad()
            4 -> conocerMusicos()
            5 -> buscarByNombre()
            0 -> salir = salir()
        }
    } while (!salir)
}

fun opcion(): Int {
    var option = ""
    do {
        println("Introduce tu opción")
        option = readln()
        val isregexMatch: Boolean = compruebaOpcion(option)
    } while (!isregexMatch)
    return option.toInt()
}

fun compruebaOpcion(option: String): Boolean {
    val regex = Regex("\\d")
    if (option.matches(regex)) {
        return true
    }
    println("Opcion inválido")
    return false
}

fun salarioTotal() {
    val salarioTotal = musicosControllers.getSalarioTotal()
    println("$salarioTotal€")
}

fun salarioMusicos() {
    musicosControllers.getSalarioMusico()
}

fun salarioByEspecialidad() {
    musicosControllers.getSalarioByEspecialidad()
}

fun conocerMusicos() {
    musicosControllers.getConocerMusico()
}

fun buscarByNombre() {
    var nombre: String = ""
    do {
        println("Introduce un nombre")
        nombre = readln()
        val salir: Boolean = validarNombre(nombre)
    } while (!salir)
    musicosControllers.getBuscarByNombre(nombre)
}

fun validarNombre(nombre: String): Boolean {
    val regex = Regex(pattern = "[A-Z][a-z]*")
    if (regex.matches(nombre)) {
        return true
    }
    println("Nombre inválido")
    return false
}

fun salir(): Boolean {
    println("Adios")
    return true
}

