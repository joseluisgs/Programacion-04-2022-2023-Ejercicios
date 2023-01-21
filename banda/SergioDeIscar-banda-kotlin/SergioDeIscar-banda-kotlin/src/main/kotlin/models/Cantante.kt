package bandamusical.models

import bandamusical.interfeces.ICantante

class Cantante(nombre:String,
               override val experiencia: Int,
               override val tono: TonoType): Musician(nombre), ICantante {
    override val salario: Float = super.salario * 1.4f
    override fun respirar() {
        "El músico cantante $nombre respira."
    }

    override fun cantar() {
        println("El cantante $nombre canta con un tono $tono.")
    }
}

enum class TonoType{
    CONTRALTO,
    MEZZOSOPRANO,
    SOPRANO,
    BAJO,
    BARITONO, //BARÍTONO
    TENOR,
    CONTRATENOR
}