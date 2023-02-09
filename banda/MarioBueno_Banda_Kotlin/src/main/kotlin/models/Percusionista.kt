//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IPercusionista
import kotlin.math.round

class Percusionista (override var nombre: String?, override var experiencia: Int, private var tipoDePercusion: String): Musico(nombre, experiencia), IPercusionista {
    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarPercusion() {
        println("Estoy tocando $tipoDePercusion")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.35)
    }
}