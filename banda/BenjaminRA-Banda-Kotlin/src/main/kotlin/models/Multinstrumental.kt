package models

import Interfaces.IBajista
import Interfaces.IPercusionista
import Interfaces.ITeclista

class Multinstrumental(nombreMultinstrumental: String?, anyosExperiencia: Int, numeroCuerdas: Int, cantidadTeclados: Int, tipoPercusion: String):
    Musico(nombreMultinstrumental, anyosExperiencia), IBajista, ITeclista, IPercusionista
{
    override fun tocarBajo() {
        println("Tocando bajo")
    }
    override fun tocarTeclado() {
        println("Tocando teclado")
    }
    override fun tocarPercusion() {
        println("Tocando percusion")
    }
    companion object {
        val salario = Musico.SALARIO_BASE * 1.45
    }
}