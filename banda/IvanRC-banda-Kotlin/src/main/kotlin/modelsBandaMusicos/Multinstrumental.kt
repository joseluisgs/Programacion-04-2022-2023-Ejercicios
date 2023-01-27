package modelsBandaMusicos

class Multinstrumental(nombre: String, salario: Double = 1500.00, añosExperiencia: Int,
                       override val numeroCuerdas: Int, override val cantidadTeclas: Int,
                       override val tipoDePercusion: tipoPercusion):
    Musico(nombre, salario, añosExperiencia), IBajista, ITeclista, IPercusionista
{
    override fun recalcularSalario(salario: Double): Double {
        val incremento = 1.5
        return (salario*incremento)
    }

}