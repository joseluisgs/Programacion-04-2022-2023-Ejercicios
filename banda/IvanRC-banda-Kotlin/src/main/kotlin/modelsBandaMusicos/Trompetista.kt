package modelsBandaMusicos

class Trompetista(nombre: String, salario: Double = 1500.00,añosExperiencia: Int, val capacidadPulmonal: Int):
    Musico(nombre, salario, añosExperiencia)
{

    override fun respirar(){
        println("Tropetista: respiro como un tromptista...")
    }

    /**
     * función que sirve para recalcular el salario base del músico según su especialización
     * @param salario es el salario base a recalcular
     * @return el salario recalculado según la ocupación
     */
    fun recalcularSalario(salario: Double): Double{
        val incremento = 1.2
        return (salario*incremento)
    }
}