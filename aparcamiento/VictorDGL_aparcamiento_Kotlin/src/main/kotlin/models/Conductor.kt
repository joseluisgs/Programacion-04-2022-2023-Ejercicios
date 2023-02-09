package models

import Aparcamiento.colores
import java.util.*

class Conductor(
    val nombre: String,
    val apellido: String,
    val dni: String,
    var numCoches: Int
) {
    val id: UUID = UUID.randomUUID()
    var cochesEnParking = Array<Coche?>(numCoches) {null}

    override fun toString(): String {
        return "${colores.rojo}Persona${colores.reset} -> " +
                "${colores.morado}id:${colores.reset} $id, " +
                "${colores.morado}nombre:${colores.reset} $nombre $apellido, " +
                "${colores.morado}dni:${colores.reset} $dni, " +
                "${colores.morado}número de coches:${colores.reset} $numCoches"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Conductor) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.dni == other.dni
    }

    override fun hashCode(): Int {
        var res = numCoches

        res = 31 * res + nombre.hashCode()
        res = 31 * res + apellido.hashCode()
        res = 31 * res + dni.hashCode()
        res = 31 * res + id.hashCode()

        return res
    }

    fun presentarse() {
        println("${colores.morado}Soy $nombre $apellido, con dni: $dni${colores.reset}")
    }
}