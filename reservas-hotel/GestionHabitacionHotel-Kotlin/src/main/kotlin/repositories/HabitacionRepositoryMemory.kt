package repositories

import TipoDeCama
import factories.FactoryHabitacion
import models.Habitacion

class HabitacionRepositoryMemory: HabitacionRepository {

    var habitaciones: Array<Habitacion?> = Array<Habitacion?>(20){null}

    init{
        inicializarArray()
    }

    /**
     * función que sirve para conseguir un listado de todas las habitaciones existentes
     * @return la lista que contiene solo habitaciones existentes
     */
    override fun getAllRooms(): Array<Habitacion> {
        return habitaciones as Array<Habitacion>
    }

    /**
     * función que busca una habitacion segun su numero y planta
     * @param numero el numero de la habitacion a buscar
     * @param planta la planta de la habitación a buscar
     * @return la habitacion encontrada o un null si no se encontro la habitacion
     */
    override fun getRoomByFloorAndNumber(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        for(i in habitaciones.indices){
            if(habitaciones[i] != null && habitaciones[i]!!.numero == numero && habitaciones[i]!!.planta == planta){
                habitacion = habitaciones[i]
                break
            }
        }
        return habitacion
    }

    /**
     * función que sirve para comprar una habitación
     * @param numero el numero de la habitacion a comprar
     * @param planta la planta de la habitación a comprar
     * @return la habitación comprada
     */
    override fun buyRoom(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        val posicion = findRoomByFloorAndNumber(numero, planta)
        if(posicion != -1){
            habitaciones[posicion]!!.estado = Estado.COMPRADO
            habitacion = habitaciones[posicion]
        }
        return habitacion
    }

    /**
     * función que sirve para reservar una habitación
     * @param numero el numero de la habitacion a reservar
     * @param planta la planta de la habitación a reservar
     * @return la habitación reservada
     */
    override fun preorderRoom(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        val posicion = findRoomByFloorAndNumber(numero, planta)
        if(posicion != -1){
            habitaciones[posicion]!!.estado = Estado.RESERVADO
            habitacion = habitaciones[posicion]
        }
        return habitacion
    }

    /**
     * función que sirve para liberar una habitación
     * @param numero el numero de la habitacion a liberar
     * @param planta la planta de la habitación a liberar
     * @return la habitación liberada
     */
    override fun freeRoom(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        val posicion = findRoomByFloorAndNumber(numero, planta)
        if(posicion != -1){
            habitaciones[posicion]!!.estado = Estado.LIBRE
            habitacion = habitaciones[posicion]
        }
        return habitacion
    }

    /**
     * función que sirve para poner una habitacion en matenimiento
     * @param numero el numero de la habitacion a poner en matenimiento
     * @param planta la planta de la habitación a poner en matenimiento
     * @return la habitación que se está manteniendo
     */
    override fun keepRoom(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        val posicion = findRoomByFloorAndNumber(numero, planta)
        if(posicion != -1){
            habitaciones[posicion]!!.estado = Estado.MANTENIMIENTO
            habitacion = habitaciones[posicion]
        }
        return habitacion
    }

    /**
     * función que sirve para comprar una habitación que está reservada
     * @param numero el numero de la habitacion a comprar
     * @param planta la planta de la habitación a comprar
     * @return la habitación comprada
     */
    override fun formalizeRoom(numero: Int, planta: Int): Habitacion? {
        var habitacion: Habitacion? = null
        val posicion = findRoomByFloorAndNumber(numero, planta)
        if(posicion != -1){
            habitaciones[posicion]!!.estado = Estado.COMPRADO
            habitacion = habitaciones[posicion]
        }
        return habitacion
    }

    /**
     * función que sirve para calcular la recaudacion total del hotel
     * @return la recaudación total
     */
    override fun getTotalMoney(): Double {
        var dinero: Double = 0.0
        for(habitacion in habitaciones){
            if(habitacion!!.estado == Estado.COMPRADO || habitacion.estado == Estado.RESERVADO) {
                when (habitacion) {
                    is Habitacion.Individual -> dinero += habitacion.precio
                    is Habitacion.Doble -> dinero += habitacion.precio
                    is Habitacion.Familia -> dinero += habitacion.precio
                    is Habitacion.Suite -> dinero += habitacion.precio
                    else -> {}
                }
            }
        }
        return dinero
    }

    /**
     * función que sirve para introducir habitaciones random al array
     */
    private fun inicializarArray() {
        var contadorPlanta = 1
        var contadorNumero = 1
        for(i in habitaciones.indices){
            if(i != 0 && i % 5 == 0) {
                contadorPlanta++
                contadorNumero = 1
            }
            when((1..4).random()){
                1 -> habitaciones[i] = FactoryHabitacion.createIndividual(contadorNumero, contadorPlanta, Estado.LIBRE, (1..10).random())
                2 -> habitaciones[i] = FactoryHabitacion.createDoble(contadorNumero, contadorPlanta, Estado.LIBRE, TipoDeCama.values().random())
                3 -> habitaciones[i] = FactoryHabitacion.createFamilia(contadorNumero, contadorPlanta, Estado.LIBRE, (1..4).random())
                4 -> habitaciones[i] = FactoryHabitacion.createSuite(contadorNumero, contadorPlanta, Estado.LIBRE, (1..10).random())
            }
            contadorNumero++
        }
    }

    /**
     * función que busca una habitacion segun su numero y planta
     * @param numero el numero de la habitacion a buscar
     * @param planta la planta de la habitación a buscar
     * @return la posicion de la habitacion encontrada o un -1 si no se encontro la habitacion
     */
    private fun findRoomByFloorAndNumber(numero: Int, planta: Int): Int {
        var posicion = -1
        for(i in habitaciones.indices){
            if(habitaciones[i] != null && habitaciones[i]!!.numero == numero && habitaciones[i]!!.planta == planta){
                posicion = i
                break
            }
        }
        return posicion
    }
}