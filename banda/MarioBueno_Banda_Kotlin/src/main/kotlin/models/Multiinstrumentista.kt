//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.IBajista
import interfaces.IPercusionista
import interfaces.IPianista
import kotlin.math.round

class Multiinstrumentista(override var nombre: String?, override var experiencia: Int, private var numTeclas: Int, private var tipoDePercusion: String, private var numCuerdas: Int): Musico(nombre, experiencia), IBajista, IPianista, IPercusionista {

    override fun respirar() {
        println("Soy $nombre y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarElBajo() {
        println("Estoy tocando el bajo con $numCuerdas cuerdas")
    }
    override fun tocarElPiano() {
        println("Estoy tocando el piano con $numTeclas teclas")
    }
    override fun tocarPercusion() {
        println("Estoy tocando $tipoDePercusion")
    }
    companion object {
        var salario: Double = round(Musico.salario * 1.45)
    }
}