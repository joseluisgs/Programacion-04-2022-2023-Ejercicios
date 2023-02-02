package Taller.models

import Taller.models.interfaces.IChapista

class Chapista (horasDiarias: Int, nombre: String, añosExperiencia: Int): Trabajador(horasDiarias, nombre, añosExperiencia), IChapista {

    override fun saludar() {
        println("Hola soy $nombre, llevo $añosExperiencia años trabajando como Chapista")
    }

    override fun descansar(){
        println("Chapista descansando...")
    }

    override fun toString(): String {
        return "Chapista(nombre= '$nombre', añosExperiencia= $añosExperiencia, horasDiarias= $horasDiarias)"
    }

    override fun arreglarChapa() {
        println("Arreglando chapa...")
    }
}