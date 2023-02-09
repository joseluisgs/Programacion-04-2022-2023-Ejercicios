//Mario Bueno López
//maarioo2525@gmail.com

package models

import interfaces.ITrompetista
import kotlin.math.round

class Trompetista (override var nombre: String?, override var experiencia: Int, private var capacidadPulmonar: Int): Musico(nombre, experiencia), ITrompetista{
    override fun respirar() {
        println("Soy $nombre, trompetista y estoy respirando.")
    }
    override fun interpretar() {
        println("Soy $nombre, músico profesional durante $experiencia años, y estoy interpretando")
    }
    override fun tocarLaTrompeta() {
        println("Estoy tocando la trompeta y tengo una capacidad pulmonar de: $capacidadPulmonar")
    }
    companion object {
        var salario = round(Musico.salario * 1.2)
    }
}