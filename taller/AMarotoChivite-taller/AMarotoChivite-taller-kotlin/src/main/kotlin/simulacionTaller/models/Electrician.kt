package simulacionTaller.models

class Electrician(name: String?, experienceYear: Int, salario: Double, dailyHours: Int, bossAssigment: BossAssigment) :
    Worker(name, experienceYear, salario, dailyHours, bossAssigment) {
    private val idElectrician = countElectrician

    init {
        autoCountElectrician()
    }

    /**
     * El electricista arreglará la electricidad
     *
     * @return mensaje del electricista arreglando
     */
    fun fixElectrician(): String {
        return "El electricista ha arreglado la electricidad... "
    }

    /**
     * El electricista está comiendo
     *
     * @return mensaje del comiendo
     */
    fun eatAsElectrician(): String {
        return "El electricista está comiendo... "
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private fun autoCountElectrician() {
        countElectrician++
    }

    override fun toString(): String {
        return "Trabajador " + (idElectrician + 1) + " Electricista " + (idElectrician + 1) + "{" +
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
        var countElectrician = 0
    }
}