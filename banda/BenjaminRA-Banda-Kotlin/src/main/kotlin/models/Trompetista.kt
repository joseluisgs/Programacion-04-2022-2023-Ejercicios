package models

class Trompetista(nombreTrompetista: String, anyosExperiencia: Int, var capacidadPulmonar: String):
    Musico(nombreTrompetista, anyosExperiencia)
{
    override fun respirar() {
        println("Hola, soy $nombrePersona y estoy respirando como trompetista.")
    }
    companion object {
        val salario = Musico.SALARIO_BASE * 1.2
    }
}