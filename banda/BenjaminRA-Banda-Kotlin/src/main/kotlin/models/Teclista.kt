package models

class Teclista(nombreTeclista: String, anyosExperiencia: Int, var cantidadTeclados: Int):
    Musico(nombreTeclista, anyosExperiencia)
{
    companion object {
        val salario = Musico.SALARIO_BASE * 1.3
    }
}