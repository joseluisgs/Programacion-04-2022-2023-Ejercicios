package models

import Interfaces.IGuitarrista

open class Guitarrista(nombreGuitarrista: String, anyosExperiencia: Int, var tipoGuitarra: String):
    Musico(nombreGuitarrista, anyosExperiencia), IGuitarrista
{
    override fun tocarGuitarra() {
                println("Tocando guitarra")
    }
    companion object {
        val salario = Musico.SALARIO_BASE * 1.35
    }
}