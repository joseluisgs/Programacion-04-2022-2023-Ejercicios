package models

import Interfaces.ICantante

open class Cantante(nombreCantante: String, anyosExperiencia: Int, var tono: String):
    Musico(nombreCantante, anyosExperiencia), ICantante
{
    override fun cantar() {
        println("Cantando")
    }
    override fun respirar() {
        println("Hola, soy $nombrePersona y estoy respirando como cantante.")
    }
    companion object {
        val salario = Musico.SALARIO_BASE * 1.4
    }
}