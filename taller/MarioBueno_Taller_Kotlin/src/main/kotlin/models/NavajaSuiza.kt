//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IChapista
import interfaces.IElectricista

class NavajaSuiza(nombre: String, experiencia: Int, horasTrabajadas: Int): Trabajador(nombre, experiencia, horasTrabajadas), IChapista, IElectricista {
    override fun chapista() {
        println("Soy chapista con $experiencia años de experiencia, trabajo $horasDiarias horas al día y sé arreglar chapas")
    }
    override fun electricista() {
        println("Soy electricista con $experiencia años de experiencia, trabajo $horasDiarias horas al día y sé arreglar cables")
    }
    override fun trabajar() {
        println("Me llamo $nombre y estoy trabajando")
    }
}