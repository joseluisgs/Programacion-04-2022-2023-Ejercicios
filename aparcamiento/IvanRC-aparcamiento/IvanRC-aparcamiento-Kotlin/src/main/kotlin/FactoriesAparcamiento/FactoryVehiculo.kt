package FactoriesAparcamiento

import ModelsAparcamiento.Conductor
import ModelsAparcamiento.Vehiculo
import ModelsAparcamiento.tipoVehiculo

class FactoryVehiculo {

    companion object {
        private var instance: FactoryVehiculo? = null
        fun getInstance(): FactoryVehiculo? {
            if (instance == null) instance = FactoryVehiculo()
            return instance
        }
    }

    /**
     * función que sirve para crear el objeto vehiculo
     * @param matricula la matricula con la que se creará el vehiculo
     * @param añoFabricacion el año de fabircacion con el que se creará el vehiculo
     * @param tipo el tipo con el que se creará el vehiculo
     * @param conductor el conductor con el que se creará el vehiculo
     * @return el objeto vehiculo creado a traves de los valores por parametros
     */
    fun create(matricula: String?, añoFabricacion: Int, tipo: tipoVehiculo?, conductor: Conductor?): Vehiculo {
        return Vehiculo(matricula!!, añoFabricacion, tipo!!, conductor!!)
    }

    /**
     * función que sirve para crear un vehículo con datos aleatorios
     * @return el vehículo generado aleatoriamente
     */
    fun createVehiculoRandom(): Vehiculo {
        val matriculas = arrayOf("5463-HGR", "4673-DEF", "4673-GED", "8495-GRE", "7684-ASD")
        val añoFabricacion = (1990..2023).random()
        val tipo = tipoVehiculo.values().random()
        return Vehiculo(
            matriculas.random(),
            añoFabricacion,
            tipo,
            FactoryConductor.getInstance()!!.createConductorRandom()
        )
    }
}