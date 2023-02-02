package Taller.models

import Taller.models.interfaces.IChapista
import Taller.models.interfaces.IElectricista

class NavajaSuiza (horasDiarias: Int, nombre: String, añosExperiencia: Int) : Trabajador (horasDiarias, nombre,
    añosExperiencia), IChapista, IElectricista{

    override fun saludar() {
        println("Aqui $nombre, el NavajaSuiza. Buemmas tardes!")
    }

    override fun arreglarChapa() {
       println("El navaja arreglando chapa...")
    }

    override fun arreglarLuz() {
        println("El navaja arreglando la luz...")
    }

    override fun toString(): String {
        return "NavajaSuiza(Horas: $horasDiarias, Nombre: $nombre, añosExperiencia: $añosExperiencia)"
    }
}