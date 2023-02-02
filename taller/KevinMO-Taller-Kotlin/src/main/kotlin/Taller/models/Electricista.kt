package Taller.models

import Taller.models.interfaces.IElectricista

class Electricista(horasDiarias: Int, nombre: String, añosExperiencia: Int): Trabajador (horasDiarias, nombre, añosExperiencia
), IElectricista{

    override fun saludar() {
        println("Hola soy $nombre, llevo $añosExperiencia años como electricista en este taller")
    }

    override fun descansar(){
        println("Electricista descansando...")
    }

    override fun comer(){
    }

    override fun toString(): String {
        return "Electricista(nombre= '$nombre', añosExperiencia= $añosExperiencia, horasDiarias= $horasDiarias)"
    }


    override fun arreglarLuz() {
        println("Arreglando la luz...")
    }
}