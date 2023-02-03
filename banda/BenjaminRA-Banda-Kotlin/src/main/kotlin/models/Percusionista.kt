package models

class Percusionista(nombrePercusionista: String, anyosExperiencia: Int, var tipoPercusion: String):
    Musico(nombrePercusionista, anyosExperiencia)
{
    companion object {
        val salario = Musico.SALARIO_BASE * 1.35
    }
}