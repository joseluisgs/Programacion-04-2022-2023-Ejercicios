package taller.models

abstract class Trabajador(nombre: String, experiencia: Int, val horasDiarias: Int): Persona(nombre, experiencia) {
    fun descansar(){
        println("El trabajador $nombre descansa, con un horario de $horasDiarias horas.")
    }
    override fun saludar() {
        println("Trabajador $nombre saluda con respeto.")
    }
    abstract fun comer()

    override fun equals(other: Any?): Boolean {
        if (other !is Trabajador) return false
        val trabajador = other as Trabajador
        if (trabajador === this) return true
        return trabajador.nombre == this.nombre &&
                trabajador.experiencia == this.experiencia &&
                trabajador.horasDiarias == this.horasDiarias &&
                trabajador.salario == this.salario
    }
}