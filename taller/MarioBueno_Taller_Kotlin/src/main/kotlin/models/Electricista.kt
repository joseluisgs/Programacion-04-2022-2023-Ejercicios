//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IElectricista

class Electricista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias), IElectricista {
    override fun electricista() {
        println("Soy electricista con $experiencia años de experiencia, trabajo $horasDiarias horas al día y sé arreglar cables")
    }
    override fun trabajar() {
        println("Me llamo $nombre y estoy trabajando")
    }
}