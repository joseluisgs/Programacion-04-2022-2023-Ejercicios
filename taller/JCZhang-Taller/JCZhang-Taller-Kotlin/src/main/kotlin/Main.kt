import models.*
import models.Taller

const val NUM_PERSONAS_MAX = 50

var salir = false
fun main() {

    //Inicializo la matriz a nulos para poder rellenarla con Personas
    val arrayPersonas = Array<Persona?>(NUM_PERSONAS_MAX) { null }
    Taller().llenarMatrizConPersonas(arrayPersonas)

    do {
        when (Taller().seleccionarOpcion()) {
            1 -> Taller().numeroTotalDePersonas()
            2 -> Taller().numeroDeTrabajadoresNormales(arrayPersonas)
            3 -> Taller().numeroDeChapistas(arrayPersonas)
            4 -> Taller().numeroDeElectricistas(arrayPersonas)
            5 -> Taller().numeroJefeTaller(arrayPersonas)
            6 -> Taller().numeroNavajasSuizas(arrayPersonas)
            7 -> Taller().informeDeNominas()
            8 -> {
                println("Es una lastima que te vayas, nos vemos a la próxima")
            salir = true}
        }
    } while (!salir)

}

































