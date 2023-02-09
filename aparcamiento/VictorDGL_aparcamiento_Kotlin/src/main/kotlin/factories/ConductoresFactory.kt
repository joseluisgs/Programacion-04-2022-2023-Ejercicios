package factories

import Aparcamiento.agregarItem
import Aparcamiento.itemExiste
import models.Conductor

object ConductoresFactory {

    val nombre = "Fábrica de conductores"

    val nombres = arrayOf(
        "Lucas",
        "Sonia",
        "Pedro",
        "Jose Miguel",
        "Rebeca",
        "Natalia",
        "Lucía",
        "Fernando",
        "Víctor",
        "Juan",
        "Hernán",
        "Nuria",
        "Pablo",
        "Rosa",
        "Pedro"
    )
    val apellidos = arrayOf(
        "Pérez",
        "Martín",
        "Dominguez",
        "González",
        "Paz",
        "Maestre",
        "Poza",
        "Gulán",
        "Díaz",
        "Solis",
        "Fuente",
        "Gómez",
        "Mirlo",
        "Quintana",
        "Pérez"
    )
    val rangoCoches = 1..3 // Cuando creamos un conductor, puede tener de 1 a 3 coches como máximo
    var dnis = Array<String> (0) { "" }

    /**
     * Función que crea un conductor aleatorio inicial
     * @return conductor inicial creado
     */

    fun crearConductorInicial(): Conductor {
        val conductor = Conductor(nombres.random(), apellidos.random(), generarDniRandom(), rangoCoches.random())
        for (i in 0 until conductor.cochesEnParking.size) {
            conductor.cochesEnParking[i] = CochesFactory.crearCoche(conductor)
        }
        return conductor
    }

    /**
     * Función que crea un conductor nuevo
     * @return conductor creado
     */

    fun crearConductorNuevo(): Conductor {
        return Conductor(nombres.random(), apellidos.random(), generarDniRandom(), 1)
    }

    /**
     * Función que genera un DNI aleatorio
     * @return un dni aleatorio
     */

    fun generarDniRandom(): String {

        var dni = ""

        do {
            repeat(8) { dni += (1..9).random().toString() }
            dni += (65..90).random().toChar()
        } while (itemExiste(dni))

        agregarItem(dni)

        return dni
    }
}