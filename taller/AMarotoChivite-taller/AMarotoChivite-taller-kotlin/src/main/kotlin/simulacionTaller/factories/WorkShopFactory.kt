package simulacionTaller.factories

import simulacionTaller.models.PersonBrench
import simulacionTaller.utils.setDependentsOfBosses

object WorkShopFactory {
    /**
     * Creará un taller con los porcentajes dados de cada miembro, el resto serán trabajadores normales,
     * y una pequeña probabilidad de aparecer un MultiTrabajador (chapista y electricista)
     *
     * @return taller con todos los miembros
     */
    @JvmStatic
    fun create(
        quantityPerson: Int, bossPercent: Int, electricianPercent: Int,
        platerPercent: Int
    ): Array<PersonBrench?> {
        val workShop = arrayOfNulls<PersonBrench>(quantityPerson)
        val quantityBoss = quantityPerson * bossPercent / 100
        val quantityElectrician = quantityPerson * electricianPercent / 100
        val quantityPlater = quantityPerson * platerPercent / 100
        val noWorkerAssign = (quantityPerson
                - quantityBoss
                - quantityElectrician
                - quantityPlater)
        val quantityMulti = getQuantityMulti(noWorkerAssign)
        for (i in workShop.indices) {
            if (i < quantityBoss) {
                workShop[i] = BossFactory.create()
            } else if (i < quantityBoss + quantityElectrician) {
                workShop[i] = ElectricianFactory.create()
            } else if (i < quantityBoss + quantityElectrician + quantityPlater) {
                workShop[i] = PlaterFactory.create()
            } else if (i < quantityBoss + quantityElectrician + quantityPlater + quantityMulti) {
                workShop[i] = MultiFactory.create()
            } else {
                workShop[i] = WorkerFactory.create()
            }
        }
        // Establecemos a cada jefe sus trabajadores
        setDependentsOfBosses(workShop)
        return workShop
    }

    @JvmStatic
    fun getQuantityMulti(restNoWorkerAssign: Int): Int {
        var quantityMulti = 0
        for (i in 1..restNoWorkerAssign) {
            // Probabilidad de que salga un multi será de 10%
            val random = (Math.random() * 10 + 1).toInt()
            if (random == 1) {
                quantityMulti++
            }
        }
        return quantityMulti
    }
}