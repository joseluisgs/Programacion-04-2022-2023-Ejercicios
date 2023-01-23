package simulacionTaller.models

class Plater(name: String?, experienceYear: Int, salario: Double, dailyHours: Int, bossAssigment: BossAssigment) :
    Worker(name, experienceYear, salario, dailyHours, bossAssigment) {
    private val idPlater = countPlater

    init {
        autoCountPlater()
    }

    /**
     * El chapista arreglará la chapa
     *
     * @return mensaje de chapista arreglando
     */
    fun fixPlate(): String {
        return "El chapista ha arreglado la chapa... "
    }

    /**
     * El chapista está descansando
     *
     * @return mensaje del chapista descansando
     */
    fun restAsPlater(): String {
        return "El chapista está descansando... "
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private fun autoCountPlater() {
        countPlater++
    }

    override fun toString(): String {
        return "Trabajador " + (idPlater + 1 + Electrician.countElectrician - Multi.countMulti) + " Chapista " + (idPlater + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}"
    }

    companion object {
        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        // Campo de clase protected para mantener el incremento, también en Multi
        var countPlater = 0
    }
}