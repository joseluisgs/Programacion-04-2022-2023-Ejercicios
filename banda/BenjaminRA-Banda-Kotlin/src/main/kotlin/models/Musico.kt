package models

open class Musico(nombreMusico: String?, var anyosExperiencia: Int):
    Persona(nombreMusico) {
    companion object {
        const val SALARIO_BASE = 1500.00
    }
    fun interpretar(){
        println("Hola, soy $nombrePersona y estoy interpretando como músico.")
    }
}