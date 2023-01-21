package taller.models

abstract class Persona(val nombre: String, var experiencia: Int) {
    val id = contador++
    abstract val salario: Int
    companion object{
        var contador = 0
    }

    abstract fun saludar()
}