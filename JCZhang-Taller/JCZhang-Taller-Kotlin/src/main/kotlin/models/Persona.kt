package models

abstract class Persona(
    val id: Int = nextId(),
    var nombre: String,
    var aniosExp: Int,
) {


    companion object {
        var id = 0
        fun nextId(): Int {
            return id++
        }
    }

    abstract fun saludar()

}