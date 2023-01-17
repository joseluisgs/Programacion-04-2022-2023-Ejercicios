package FactoriesCestaDeCompra

import ModelsCestaDeCompra.Cesta
import ModelsCestaDeCompra.ListaCesta
import java.time.LocalDate

class FactoryCesta {

    companion object{
        private var instance: FactoryCesta? = null

        fun getInstance(): FactoryCesta?{
            if(instance == null){
                instance = FactoryCesta()
            }
            return instance
        }
        var contadorCestas = 1
        fun nextId():Int{
            return contadorCestas++
        }
    }

    /**
     * función que srive para crear una cesta random
     * @return la cesta creada aleatoriamente
     */
    fun crearCestaRandom(): Cesta {
        val fechas = arrayOf("2023-12-03", "2003-02-23", "2023-12-03", "2023-12-03", "2023-12-03", "2023-12-03", "2023-12-03")
        return Cesta(nextId(), LocalDate.parse(fechas.random()), FactoryUsuario.getInstance()!!.crearUsuarioRandom(), ListaCesta())
    }
}