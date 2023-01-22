package simulacionBandaMusica.models

abstract class Person(var name: String?) {
    init {
        autoContadorPerson()
    }

    /**
     * Aumentamos un ID por cada persona que hemos creado, para disponer de un contador
     */
    private fun autoContadorPerson() {
        contadorPerson++
    }

    /**
     * La persona nos informa que está respirando, la asigno como filan, para que no me
     * sobreescriban esta función sus hijos
     *
     * @return el mensaje de la persona respirando
     */
    fun respirar(): String {
        return "Estoy respirando..."
    }

    companion object {
        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        var contadorPerson = 0
            private set
    }
}