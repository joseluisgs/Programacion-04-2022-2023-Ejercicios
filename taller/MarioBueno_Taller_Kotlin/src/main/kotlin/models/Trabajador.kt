//Mario Bueno López
//maarioo2525@gmail.com

package models

abstract class Trabajador(nombre: String, experiencia: Int, var horasDiarias: Int): Persona(id, nombre, experiencia) {
    override fun saludar() {
        println("Hola soy una persona y te saludo")
    }
    abstract fun trabajar()

    fun descansar() {
        println("Me llamo $nombre, estoy descansando")
    }
    fun comer() {
        println("Me llamo $nombre y estoy comiendo")
    }
}