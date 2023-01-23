package simulacionTaller.models

open class Boss(name: String?, experienceYear: Int, salario: Double, var dependents: Array<Worker?>) :
    PersonBrench(name, experienceYear, salario) {
    private val id = countBoss

    init {
        autoCountBoss()
    }

    /**
     * El jefe dará latigazos de manera aleatoria a un miembro de su plantilla
     *
     * @return mensaje de los látigos del jefe
     */
    fun lashes(): String {
        val randomLashes = (Math.random() * 10 + 1).toInt()
        val randomMember = (Math.random() * dependents.size + 1).toInt()
        val dependentLashed = dependents[randomMember - 1]
        return """El jefe ha dado $randomLashes latigazos a ${dependentLashed!!.name}
Y NADIE COBRA HOY!"""
    }

    /**
     * El jefe pagará a los empleados, se imprimirá en pantalla
     */
    fun printPayWorkers() {
        println("El jefa va a pagar el salario de cada empleado...")
        for (i in dependents.indices) {
            println(dependents[i]!!.name + " ha cobrado " + dependents[i]!!.salario)
            Thread.sleep(500)
        }
    }

    /**
     * El jefe nos saludará de una manera distinta a la de una persona normal
     *
     * @return saludo del jefe
     */
    fun greetAsBoss(): String {
        return "Soy $name: Estoy saludando de forma chulesca como jefe... "
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private fun autoCountBoss() {
        countBoss++
    }

    override fun toString(): String {
        return "Jefe de Taller " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", trabajadores a cargo = " + dependents.size +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}"
    }

    companion object {

        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        // Campo de clase para mantener el incremento
        var countBoss = 0
            private set
    }
}