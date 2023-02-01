package factories

import Estado
import TipoDeCama
import models.Habitacion

object FactoryHabitacion {

    /**
     * función que crea una habitación individual con los datos pasados por parametros
     * @param numero es el numero de la habitacion, independiente a la planta
     * @param planta es el numero de la planta
     * @param estado es el estado en el que se encuentra la habitacion
     * @param tamañoCama es el tamaño de la cama
     * @return la habitación creada
     */
    fun createIndividual(
        numero: Int,
        planta: Int,
        estado: Estado,
        tamañoCama: Int
    ): Habitacion.Individual{
        return Habitacion.Individual(numero = numero, planta = planta, estado = estado, tamañoCama = tamañoCama)
    }

    /**
     * función que crea una habitación individual con los datos pasados por parametros
     * @param numero es el numero de la habitacion, independiente a la planta
     * @param planta es el numero de la planta
     * @param estado es el estado en el que se encuentra la habitacion
     * @param tipoCama es el tipo de la cama
     * @return la habitación creada
     */
    fun createDoble(
        numero: Int,
        planta: Int,
        estado: Estado,
        tipoCama: TipoDeCama
    ): Habitacion.Doble{
        return Habitacion.Doble(numero = numero, planta = planta, estado = estado, tipoCama = tipoCama)
    }

    /**
     * función que crea una habitación individual con los datos pasados por parametros
     * @param numero es el numero de la habitacion, independiente a la planta
     * @param planta es el numero de la planta
     * @param estado es el estado en el que se encuentra la habitacion
     * @param numeroCamas es el numero de camas
     * @return la habitación creada
     */
    fun createFamilia(
        numero: Int,
        planta: Int,
        estado: Estado,
        numeroCamas: Int
    ): Habitacion.Familia{
        return Habitacion.Familia(numero = numero, planta = planta, estado = estado, numeroCamas = numeroCamas)
    }

    /**
     * función que crea una habitación individual con los datos pasados por parametros
     * @param numero es el numero de la habitacion, independiente a la planta
     * @param planta es el numero de la planta
     * @param estado es el estado en el que se encuentra la habitacion
     * @param numeroBaños es el numero de baños
     * @return la habitación creada
     */
    fun createSuite(
        numero: Int,
        planta: Int,
        estado: Estado,
        numeroBaños: Int
    ): Habitacion.Suite{
        return Habitacion.Suite(numero = numero, planta = planta, estado = estado, numeroBaños = numeroBaños)
    }
}