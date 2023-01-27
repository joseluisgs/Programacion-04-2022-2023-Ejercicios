package modelsBandaMusicos

interface ICantante {
    open fun respirar()
    val tono: String

    /**
     * función que sirve para recalcular el salario base del músico según su especialización
     * @param salario es el salario base a recalcular
     * @return el salario recalculado según la ocupación
     */
    fun recalcularSalario(salario: Double): Double{
        val incremento = 1.4
        return (salario*incremento)
    }
}