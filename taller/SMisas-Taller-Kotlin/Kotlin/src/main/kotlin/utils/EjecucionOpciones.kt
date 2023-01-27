package utils

import models.*

/**
 * Imprime datos de cada persona del taller
 * @param taller el array de personas que conforman el taller
 */
fun imprimirTaller(taller: Array<Persona>) {
    for (persona in taller) {
        println()
        println("Nombre: ${persona.nombre} - Experiencia: ${persona.experiencia} años - Id: ${persona.id}")
    }
    println()
}

/**
 * Muestra el número de trabajadores de cada tipo
 * @param taller el array de personas que conforman el taller
 */
fun enumeracionTrabajadores(taller: Array<Persona>) {
    val arrayNumeroTrabajadores = busquedaTrabajadores(taller)
    mensajeEnumeracion(arrayNumeroTrabajadores)
}

/**
 * Busca cada tipo de trabajador para llevar un recuento por tipo en forma de array
 * @param taller el array de personas que conforman el taller
 * @return array con el número de trabajadores por función
 */
fun busquedaTrabajadores(taller: Array<Persona>): IntArray {
    // Demasiadas variables, hacer con un array de enteros directamente en futuras versiones
    var trabajadores = 0
    var jefesDeTaller = 0
    var chapistas = 0
    var electricistas = 0
    for (persona in taller) {
        when (persona.salario) {
            1200.00 -> trabajadores++
            1700.00 -> chapistas++
            1800.00 -> electricistas++
            2500.00 -> jefesDeTaller++
        }
    }
    val trabajadoresGeneral = trabajadores + electricistas + chapistas
    return arrayOf(jefesDeTaller, trabajadoresGeneral, trabajadores, chapistas, electricistas).toIntArray()
}

/**
 * Imprime un mensaje para informar del número de trabajadores por función
 * @param arrayNumeroTrabajadores el array con el número de trabajadores por función
 */
fun mensajeEnumeracion(arrayNumeroTrabajadores: IntArray) {
    println("Hay ${arrayNumeroTrabajadores[0]} jefes de taller")
    println("Hay ${arrayNumeroTrabajadores[1]} trabajadores en el taller, de los cuales...")
    println("${arrayNumeroTrabajadores[2]} son trabajadores sin especialidad,")
    println("${arrayNumeroTrabajadores[3]} son chapistas,")
    println("${arrayNumeroTrabajadores[4]} son electricistas")
    println()
}

/**
 * Muestra el costo de la plantilla
 * @param taller el array de personas que conforman el taller
 */
fun contabilidadTaller(taller: Array<Persona>) {
    val arrayTrabajadores = busquedaTrabajadores(taller)
    mensajeContabilidad(arrayTrabajadores)
}

/**
 * Imprime un informe del total de euros que cuesta un grupo de trabajadores
 * @param arrayTrabajadores el array con el número de trabajadores por función
 */
fun mensajeContabilidad(arrayTrabajadores: IntArray) {
    // Es mejor tener el total calculado así es mucho más limpio implementarlo al mensaje
    val totalSueldos = calcularTotalSueldos(arrayTrabajadores)

    println("Los jefes de taller cobran en total ${(arrayTrabajadores[0] * 2500.00)} euros")
    println("Los trabajadores sin especialidad cobran en total ${(arrayTrabajadores[2] * 1200.00)} euros")
    println("Los chapistas cobran en total ${(arrayTrabajadores[3] * 1700.00)} euros")
    println("Los electricistas cobran en total ${(arrayTrabajadores[4] * 1800.00)} euros")
    println("El gasto total en sueldos es de $totalSueldos euros")
    println()
}

/**
 * Calcula el total del gasto de plantilla
 * @param arrayTrabajadores el array con el número de trabajadores por función
 * @return total del gasto de plantilla
 */
fun calcularTotalSueldos(arrayTrabajadores: IntArray): Double {
    return ((arrayTrabajadores[0] * 2500.00) + (arrayTrabajadores[2] * 1200.00)
            + (arrayTrabajadores[3] * 1700.00) + (arrayTrabajadores[4] * 1800.00))
}
