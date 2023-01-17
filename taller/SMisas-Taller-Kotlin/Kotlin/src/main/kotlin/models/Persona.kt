package models

import java.util.UUID

abstract class Persona(open val nombre: String, open val experiencia: Int, open val salario: Double) {
    val id: UUID = UUID.randomUUID()
    abstract fun saludar()
}