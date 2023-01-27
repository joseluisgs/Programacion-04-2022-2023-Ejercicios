package bandamusical.models

import bandamusical.interfeces.IPercusionista

class Percusionista(nombre:String,
                    override val experiencia: Int,
                    override val percussion: PercussionType): Musician(nombre), IPercusionista {
    override val salario: Float = super.salario * 1.35f
}

enum class PercussionType{
    ALTURA_DETERMINADA,
    ALTURA_INDETERMINADA
}