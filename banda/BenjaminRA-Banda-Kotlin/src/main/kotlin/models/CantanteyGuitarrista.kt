package models

import Interfaces.ICantante
import Interfaces.IGuitarrista

class CantanteyGuitarrista(nombreCantanteGuitarrista: String?, anyosExperiencia: Int, tono: String, tipoGuitarra: String):
    Musico(nombreCantanteGuitarrista, anyosExperiencia), ICantante, IGuitarrista
{
    override fun cantar() {
        println("Cantando")
    }
    override fun tocarGuitarra() {
        println("Tocando guitarra")
    }
    companion object {
        val salario = Musico.SALARIO_BASE * 1.5
    }
}