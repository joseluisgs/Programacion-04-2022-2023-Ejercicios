package modelsBandaMusicos

class CantanteGuitarrista(nombre: String, salario: Double = 1500.00, añosExperiencia: Int, override var tono: String,
                          override val tipoDeGuitarra: tipoGuitarra): Musico(nombre, salario, añosExperiencia), ICantante, IGuitarrista
{
    override fun recalcularSalario(salario: Double): Double {
        val incremento = 1.5
        return (salario*incremento)
    }
}