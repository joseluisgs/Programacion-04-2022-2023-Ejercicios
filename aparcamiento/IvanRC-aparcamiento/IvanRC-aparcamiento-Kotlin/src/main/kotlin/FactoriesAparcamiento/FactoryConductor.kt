package FactoriesAparcamiento

import ModelsAparcamiento.Conductor

class FactoryConductor {

    companion object {
        private var instance: FactoryConductor? = null
        fun getInstance(): FactoryConductor? {
            if (instance == null) instance = FactoryConductor()
            return instance
        }
    }

    /**
     * función que sirve para crear el objeto conductor
     * @param nombre el nombre con el que se creará el conductor
     * @param dni el dni con el que se creará el conductor
     * @return el objeto conductor creado a traves de los valores por parametros
     */
    fun create(nombre: String?, dni: String?): Conductor {
        return Conductor(nombre!!, dni!!)
    }

    /**
     * función que sirve para crear un conductor con datos aleatorios
     * @return el conductor creado con datos aleatorios
     */
    fun createConductorRandom(): Conductor {
        val nombres = arrayOf("Jorge", "Iván", "Ramón", "Roberto", "Martina")
        val dnis = arrayOf("53749873M", "64536475J", "75534869J", "87264953H", "75026584M")
        return Conductor(nombres.random(), dnis.random())
    }
}