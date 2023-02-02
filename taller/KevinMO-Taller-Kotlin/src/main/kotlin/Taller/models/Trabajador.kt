package Taller.models

open class Trabajador(val horasDiarias: Int, nombre: String, añosExperiencia: Int) : Persona(nombre, añosExperiencia) {


    override fun saludar(){
        println("Hola buenos días o tardes, soy $nombre, soy un trabajador normal y llevo $añosExperiencia año/s trabajando aqui.")
    }

    fun trabajar(){
        println("Soy un trabajador trabajando...")
    }

    open fun descansar(){
        println("Trabajador descansando...")
    }

    open fun comer(){
        println("Trabajador comiendo...")
    }

    override fun toString(): String {
        return "Trabajador (nombre= '$nombre', añosExperiencia= $añosExperiencia, horasDiarias= $horasDiarias)"
    }
}