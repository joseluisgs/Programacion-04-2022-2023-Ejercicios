package bandamusical.models

import bandamusical.interfeces.IBajista

class Bajista(nombre:String,
              override val experiencia: Int,
              override val numCuerdas: Int): Musician(nombre), IBajista {
    override val salario: Float = super.salario * 1.3f
}