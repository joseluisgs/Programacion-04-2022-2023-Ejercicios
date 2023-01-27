package simulacionTaller.models

open class Worker(
    name: String?,
    experienceYear: Int,
    salario: Double,
    var dailyHours: Int,
    var bossAssigment: BossAssigment
) : PersonBrench(name, experienceYear, salario) {
    protected val id = countWorkerGeneral

    init {
        autoCountWorker()
    }

    /**
     * El trabajador trabajará
     *
     * @return mensaje de trabajo del trabajador
     */
    fun work(): String {
        return "El trabajador está trabajando... "
    }

    /**
     * El trabajador descansará
     *
     * @return mensaje de descanso del trabajador
     */
    fun restAsWorker(): String {
        return "El trabajador está descansando... "
    }

    /**
     * El trabajador nos saludará de una manera distinta a la de una persona normal
     *
     * @return saludo del trabajador
     */
    fun greet(): String {
        return "Soy $name Estoy saludando con respeto como trabajador... "
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private fun autoCountWorker() {
        countWorkerGeneral++
    }

    override fun toString(): String {
        return "Trabajador " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}"
    }

    enum class BossAssigment {
        WITH_BOSS, WITHOUT_BOSS
    }

    companion object {
        /**
         * Creamos un get, para encapsular el valor del contador y no poderlo manipular
         */
        // Campo de clase para mantener el incremento
        var countWorkerGeneral = 0
            private set
    }
}