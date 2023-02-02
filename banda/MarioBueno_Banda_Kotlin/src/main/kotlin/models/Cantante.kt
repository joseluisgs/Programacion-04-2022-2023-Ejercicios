//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.ICantante
import kotlin.math.round

class Cantante(override var nombre: String?, override var experiencia: Int, private var tono: String): Musico(nombre, experiencia), ICantante {
    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun cantar() {
        println("Estoy cantando con el tono: $tono")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.4)
    }
}