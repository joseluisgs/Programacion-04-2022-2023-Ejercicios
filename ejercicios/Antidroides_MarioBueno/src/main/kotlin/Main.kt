import models.Cuadricula

fun main() {
    println("Bienvenido al sistema de apuntado de la nave X-wing T-65B")
    do {
        val numColumnas: Int = inputNum("Introduce el número de columnas que quieres que tenga la cuadrícula [5-9]: ", 5..9)
        val numDroides = when (numColumnas) {
            5 -> inputNum("Introduce el número de droides que quieres que haya en la cuadrícula [5-20]: ", 5..20)
            6 -> inputNum("Introduce el número de droides que quieres que haya en la cuadrícula [5-25]: ", 5..25)
            else -> inputNum("Introduce el número de droides que quieres que haya en la cuadrícula [5-30]: ", 5..30)
        }
        val cuadricula = Cuadricula(5, numColumnas, numDroides)
        //Realiza una simulación con,os valores recividos
        cuadricula.simulacion()
        //Realiza un informe de la simulación anterior
        cuadricula.informe()
        val eleccion = inputNum("""¿Quieres realizar otra simulación?:
            |1 - Si
            |2 - No
        """.trimMargin(), 1..2)
    } while(eleccion != 2)
    println("Gracias por salvar la galaxia, que la fuerza te acompañe...")
}

//Evita un input inválido
fun inputNum(mensaje: String, rango: IntRange = -999..999): Int{
    println(mensaje)
    var respuesta: Int?
    do {
        respuesta = readln().toIntOrNull()
        if (respuesta !in rango) println("Error: Introduce un número entre ${rango.first}-${rango.last}.")
    }while (respuesta !in rango)
    return respuesta ?: -1
}
