package modelsTaller

abstract class Persona(val nombre: String, val añosExperiencia: Int) {

    val id = nextId()

    companion object{
        var contador = 1
        fun nextId(): Int{
            return contador++
        }
    }

    abstract fun saludar()

}