//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IPianista
import kotlin.math.round

class Pianista (override var nombre: String?, override var experiencia: Int, private var numTeclas: Int): Musico(nombre, experiencia), IPianista {
    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarElPiano() {
        println("Estoy tocando el piano con $numTeclas teclas")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.3)
    }
}