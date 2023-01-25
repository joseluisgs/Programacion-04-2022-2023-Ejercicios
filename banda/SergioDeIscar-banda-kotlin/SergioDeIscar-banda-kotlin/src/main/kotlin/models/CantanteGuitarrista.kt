package bandamusical.models

import bandamusical.interfeces.ICantante
import bandamusical.interfeces.IGuitarrista

class CantanteGuitarrista(nombre:String,
                          override val experiencia: Int,
                          override val tono: TonoType,
                          override val guitarra: GuitarraType): Musician(nombre), ICantante, IGuitarrista {
    override val salario: Float = super.salario * 1.5f
    override fun cantar() {
        println("El cantanteGuitarrista $nombre canta con un tono $tono.")
    }

    override fun guitarrear() {
        println("El cantanteGuitarrista $nombre gitarrea, el tipo de gitarra utilizado es $guitarra.")
    }
}