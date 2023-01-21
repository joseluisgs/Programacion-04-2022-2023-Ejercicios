package salacine

import salacine.enums.FilmGenero
import salacine.models.*

fun main(){
    println("Bienvenido al editor de salas de cine:")
    val sala = setInitialValuesSala()
    val sizeSala = sala.getSize()
    do {
        clear()
        when (menu()) {
            1 -> sala.mostrarSala()
            2 -> mostrarResultado(sala.reservaButaca(inputPos("Introduce la posición donde quieres hacer la reserva", sizeSala, sala)),
                "La butaca se a reservado correctamente.", "Error: No se ha podido reservar la butaca.")
            3 -> mostrarResultado(sala.formalizarReserva(inputPos("Introduce la posición donde quieres formalizar la reserva", sizeSala, sala)),
                "Se ha formalizado la reserva correctamente.", "Error: No se ha podido formalizar la reserva.")
            4 -> mostrarResultado(sala.anularReserva(inputPos("Introduce la posición donde quieres anular la reserva", sizeSala, sala)),
                "La reserva se ha anulado correctamente.", "Error: No se ha podido anular la reserva.")
            5 -> println("El resumen del estado de la sala es el siguiente:\n" + sala.countEstadosText())
            6 -> println("El balance de la sala es de ${sala.balanceSala()}€.")
            else -> break
        }
        Thread.sleep(2500)
    }while (true)
    sala.mostrarSala()
}

fun mostrarResultado(resultado: Boolean, good: String, bad: String) {
    println( if (resultado) good else bad )
}

private fun setInitialValuesSala() = Sala(
    inputString("Introduce el nombre de la sala:"),
    Film(
        inputString("Introduce el nombre de la película que se va ha ver en la sala:"),
        inputYear("Introduce el año en el que se estreno la película:"),
        inputString("Introduce el nombre del director que dirigió la película:"),
        inputFilmGenero("Introduce el genero de la película:")
    ),
    Pair(
        inputNumber("Introduce cuantas columnas quieres que tenga la sala:", 3..50),
        inputNumber("Introduce cuantas filas quieres que tenga la sala:", 5..50)
    ),
    40      // 40% -> 2 de cada 5
)

private fun menu(): Int{
    val message = "¿Qué quieres hacer con la sala ahora?\n" +
            "1 -> Mostrar estado de la sala\n" +
            "2 -> Reservar butaca\n" +
            "3 -> Formalizar reserva\n" +
            "4 -> Anular reserva\n" +
            "5 -> Número de butacas libres, reservadas y ocupadas\n" +
            "6 -> Balance de la sala\n" +
            "7 -> Salir"
    return inputNumber(message, 1..7)
}

/**
 * Función para pasar un string compuesto por varios caracteres en mayúsculas a su valor en el alfabeto
 * Por ejemplo:
 *      A   ->   0;
 *      Ñ   ->   14
 *      Z   ->   26;
 *      AA  ->   27;
 *      BA  ->   54;
 * @param toTranslate Texto compuesto por caracteres en mayúsculas a traducir
 */
fun stringToAlphabetNumber(toTranslate: String): Int{
    val plusEnie = if ((toTranslate[0].code - 'A'.code) > 13) 1 else 0
    if (toTranslate.length == 1) return if (toTranslate[0] == 'Ñ') 14 else toTranslate[0].code - 'A'.code + plusEnie
    return ((toTranslate[0].code - 'A'.code + 1) * 26) + (stringToAlphabetNumber(toTranslate[1].toString()) + 1) + (toTranslate[0].code - 'A'.code)
}

// region Inputs Simples
private fun inputNumber(message: String, range: IntRange = -999..999): Int{
    println(message)
    var response: Int?
    do {
        response = readln().toIntOrNull()
        if (response !in range) println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (response !in range)
    return response ?: -1
}

/**
 * Función encargada de registrar el input del usuario verificando/transformando a su valor en el enum de tipos de películas.
 * Para ello hago uso de un pequeño mapeo, ya que si no tendría que ir comprobando todos los valores en String y de esta
 * manera es más ¨nativo¨.
 * @param message Mensaje que se va a mostrar al usuario
 * @see FilmGenero Enum con todos los tipos de películas
 */
private fun inputFilmGenero(message: String): FilmGenero {
    println(message)
    println(FilmGenero.values().joinToString())
    var responseString: String
    do {
        responseString = readln().uppercase()
        if (responseString !in enumValues<FilmGenero>().map { it.name }) println("Error: Introduce uno de estos valores, ${FilmGenero.values().joinToString()}:")
    }while (responseString !in enumValues<FilmGenero>().map { it.name })
    return FilmGenero.valueOf(responseString)
}

private fun inputYear(message: String): UShort {
    println(message)

    var response: String
    do {
        response = readln()
        if (!response.matches(Regex("^\\d{4}\$")) || response.toInt() !in 1900..2022)
            println("Error: Introduce un valor numérico entero de 4 dígitos entre 1900-2022.")
    }while (!response.matches(Regex("^\\d{4}\$")) || response.toInt() !in 1900..2022)
    return response.toUShort()
}

private fun inputString(message: String): String {
    println(message)
    var response: String
    do {
        response = readln()
        if (response.isEmpty())
            println("Error: Introduce algún texto.")
    }while (response.isEmpty())
    return response
}

private fun inputPos(message: String, size: Pair<Int,Int>, sala: Sala? = null): Pair<Int,Int>{
    sala?.mostrarButacas()
    var responseSplit: List<String>
    do {
        val response = inputString(message)
        if (!response.matches(Regex("^[A-Z]{1,2}:\\d{1,2}\$")))
        {
            println("Error: Introduce la posición con el siguiente formato A:1")
        }else{
            responseSplit = response.split(":")
            if ( stringToAlphabetNumber(responseSplit[0]) in 0..size.second && (responseSplit[1].toInt()-1) in 0..size.first ) break
            else println("Error: introduce una posición dentro del tamaño.")
        }
    }while (true)

    return Pair((responseSplit[1].toInt()-1), stringToAlphabetNumber(responseSplit[0]))
}
// endregion

private fun clear(size: Int = 25){
    for (i in 0..size){
        println()
    }
}