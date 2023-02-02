//Mario Bueno López
//maarioo2525@gmail.com

package models

abstract class Persona (var id: Int = nextId(), var nombre: String, var experiencia: Int){
    companion object {
        var id = 0
        fun nextId(): Int {
            return id++
        }
    }
    abstract fun saludar()
}