//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IGuitarrista
import kotlin.math.round

class Guitarrista (override var nombre: String?, override var experiencia: Int, private var tipoDeGuitarra: String): Musico(nombre, experiencia), IGuitarrista {
    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarLaGuitarra() {
        println("Estoy tocando un $tipoDeGuitarra")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.5)
    }
}