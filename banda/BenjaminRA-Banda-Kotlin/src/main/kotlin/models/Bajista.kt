package models

import Interfaces.IBajista

class Bajista(nombreBajista: String, anyosExperiencia: Int, var numeroCuerdas: Int):
    Musico(nombreBajista, anyosExperiencia), IBajista
{
    override fun tocarBajo() {
        println("Tocando bajo")
    }
    companion object {
        val salario: Double = Musico.SALARIO_BASE * 1.3
    }
}