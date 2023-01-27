package models

open class Trabajador(nombre: String, aniosExp: Int, var horasDiarias: Int ) : Persona(id, nombre, aniosExp) {

    fun Trabajador(nombre: String, aniosExp: Int, horasDiaras: Int) {
        this.nombre = nombre
        this.aniosExp = aniosExp
        this.horasDiarias = horasDiaras
    }

    override fun saludar() {
        println("Trabajador: Hola! Mi nombre es $nombre y soy un humilde trabajador ")
    }
    fun trabajar(){
        println("Trabajador: Hola soy $nombre y estoy trabajando")
    }
    fun descansar(){
        println("Trabajador: Hola soy $nombre estoy descansando")
    }
    open fun comer(){}
    override fun toString(): String {
        return "Trabajador( $nombre con $aniosExp años de experiencia trabaja $horasDiarias horas al dia)"
    }


}