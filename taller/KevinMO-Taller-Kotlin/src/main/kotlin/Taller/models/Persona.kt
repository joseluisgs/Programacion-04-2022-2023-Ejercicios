package Taller.models

abstract class Persona (val nombre: String, val añosExperiencia: Int) {
    abstract fun saludar()

    override fun toString(): String {
        return "Persona(nombre='$nombre', añosExperiencia=$añosExperiencia)"
    }
}