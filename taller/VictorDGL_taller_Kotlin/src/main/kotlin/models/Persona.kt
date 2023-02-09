package models

import java.util.UUID

abstract class Persona(
    val nombre: String,
    val apellido: String,
    val experiencia: Int
) {
    val id: UUID = UUID.randomUUID()
    open var salario: Int = 0

    open fun saludar() {
        println("Soy $nombre $apellido, con id: $id, y tengo $experiencia años de experiencia.")
    }

    override fun hashCode(): Int {
        var res = salario

        res = 31 * res + nombre.hashCode()
        res = 31 * res + apellido.hashCode()
        res = 31 * res + experiencia.hashCode()
        res = 31 * res + salario.hashCode()
        res = 31 * res + id.hashCode()

        return res
    }
}