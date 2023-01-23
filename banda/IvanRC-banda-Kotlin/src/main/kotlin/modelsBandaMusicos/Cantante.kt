package modelsBandaMusicos

class Cantante(nombre: String, salario: Double = 1500.00,añosExperiencia: Int, override val tono: String):
    Musico(nombre, salario, añosExperiencia),ICantante
{
    override fun respirar(){
        println("Cantante: respiro como cantante...")
    }
}