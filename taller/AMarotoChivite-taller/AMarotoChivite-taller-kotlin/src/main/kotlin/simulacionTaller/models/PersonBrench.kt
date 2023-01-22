package simulacionTaller.models

abstract class PersonBrench(var name: String?, var experienceYear: Int, var salario: Double) {
    init {
        autoCountPerson()
    }

    /**
     * La persona nos informa que está saludando
     *
     * @return el mensaje de la persona saludando
     */
    fun greetAsPerson(): String {
        return "Estoy saludando como persona... "
    }

    /**
     * Aumentamos un ID por cada persona que hemos creado, para disponer de un contador
     */
    private fun autoCountPerson() {
        personCount++
    }

    companion object {
        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        var personCount = 0
            private set
    }
}