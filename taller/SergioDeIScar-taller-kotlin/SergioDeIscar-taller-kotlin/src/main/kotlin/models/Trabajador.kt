package taller.models

abstract class Trabajador(nombre: String, experiencia: Int, val horasDiarias: Int): Persona(nombre, experiencia) {
    fun descansar(){
        println("El trabajador $nombre descansa, con un horario de $horasDiarias horas.")
    }
    override fun saludar() {
        println("Trabajador $nombre saluda con respeto.")
    }
    abstract fun comer()
}