package simulacionTaller.models

import simulacionTaller.interfaces.InterfaceElectrician
import simulacionTaller.interfaces.InterfacePlater

class Multi(name: String?, experienceYear: Int, salario: Double, dailyHours: Int, bossAssigment: BossAssigment) :
    Worker(name, experienceYear, salario, dailyHours, bossAssigment), InterfacePlater, InterfaceElectrician {
    private val idMulti = countMulti

    init {
        autoCountMulti()
        init()
    }

    /**
     * Aumentamos la cantidad de electricistas y chapistas que hay, ya que el multi cuenta como uno de cada
     */
    fun init() {
        Plater.Companion.countPlater += 1
        Electrician.Companion.countElectrician += 1
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private fun autoCountMulti() {
        countMulti++
    }

    /**
     * El multi actuará como electricista y arreglará la electricidad
     *
     * @return mensaje del multi como eletricista arreglando
     */
    override fun fixElectrician(): String {
        return "El multi ha arreglado la electricidad..."
    }

    /**
     * El multi comerá
     *
     * @return mensaje del multi comiendo
     */
    override fun eatAsElectrician(): String {
        return "El multi está comiendo..."
    }

    /**
     * El multi actuará como chapista y arreglará la chapa
     *
     * @return mensaje del multi como chapista arreglando
     */
    override fun fixPlate(): String {
        return "El multi ha arreglado la chapa..."
    }

    /**
     * El multi descansará
     *
     * @return mensaje del multi descansando
     */
    override fun restAsPlater(): String {
        return "El multi está descansado..."
    }

    override fun toString(): String {
        return "Trabajador " + (idMulti + 1 + (Electrician.countElectrician + Plater.countPlater) - countMulti * 2) + " Multi " + (idMulti + 1) + "{" +
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
        // Campo de clase para mantener el incremento
        var countMulti = 0
            private set
    }
}