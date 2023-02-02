//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IChapista

class Chapista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias), IChapista {
    override fun chapista() {
        println("Soy chapista con $experiencia años de experiencia, trabajo $horasDiarias horas al día y sé arreglar chapas")
    }
    override fun trabajar() {
        println("Me llamo $nombre y estoy trabajando")
    }
}