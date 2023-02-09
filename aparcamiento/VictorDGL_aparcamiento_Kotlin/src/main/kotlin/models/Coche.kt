package models

import Aparcamiento.colores
import java.util.*

class Coche (
    val matricula: String,
    val marca: String,
    val anyoFabricacion: Int,
    var propietario: Conductor?
) {
    val id = UUID.randomUUID()
    var plaza = ""

    override fun toString(): String {
        return "${colores.rojo}Coche${colores.reset} -> " +
                "${colores.morado}id:${colores.reset} $id, " +
                "${colores.morado}matrícula:${colores.reset} $matricula, " +
                "${colores.morado}marca:${colores.reset} $marca, " +
                "${colores.morado}año de fabricación:${colores.reset} $anyoFabricacion, " +
                "${colores.morado}plaza:${colores.reset} $plaza, " +
                "${colores.morado}dueño:${colores.reset} $propietario"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Coche) return false
        return this.id == other.id && this.matricula == other.matricula && this.marca == other.marca && this.anyoFabricacion == other.anyoFabricacion
    }

    override fun hashCode(): Int {
        var res = anyoFabricacion

        res = 31 * res + matricula.hashCode()
        res = 31 * res + marca.hashCode()
        res = 31 * res + anyoFabricacion.hashCode()
        res = 31 * res + id.hashCode()

        return res
    }

    fun hacerSonarMotor() {
        println("\n${colores.morado}Coche $marca con matricula $matricula hace BRUUUUM BRUUUUM${colores.reset}")
    }
}