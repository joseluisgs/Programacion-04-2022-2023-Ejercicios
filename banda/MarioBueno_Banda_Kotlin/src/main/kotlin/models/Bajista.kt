//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IBajista
import kotlin.math.round

class Bajista (override var nombre: String?, override var experiencia: Int, private var numeroDeCuerdas: Int): Musico(nombre, experiencia), IBajista {
    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarElBajo() {
        println("Estoy tocando el bajo con $numeroDeCuerdas cuerdas")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.3)
    }
}