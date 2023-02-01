package controllers

import Estado
import exceptions.*
import models.Habitacion
import repositories.HabitacionRepository

class HabitacionController(
    private val repository: HabitacionRepository
) {

    /**
     * función que busca una habitacion segun su numero y planta
     * @param numero el numero de la habitacion a buscar
     * @param planta la planta de la habitación a buscar
     * @return la habitacion encontrada o un null si no se encontro la habitacion
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun getRoomByFloorAndNumber(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        return repository.getRoomByFloorAndNumber(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para comprar una habitación
     * @param numero el numero de la habitacion a comprar
     * @param planta la planta de la habitación a comprar
     * @return la habitación comprada
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun buyRoom(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        isRoomEmpty(getEstadoRoom(numero, planta))
        return repository.buyRoom(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para reservar una habitación
     * @param numero el numero de la habitacion a reservar
     * @param planta la planta de la habitación a reservar
     * @return la habitación reservada
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun preorderRoom(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        isRoomEmpty(getEstadoRoom(numero, planta))
        return repository.preorderRoom(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para liberar una habitación
     * @param numero el numero de la habitacion a liberar
     * @param planta la planta de la habitación a liberar
     * @return la habitación liberada
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun freeRoom(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        canIEmptyRoom(getEstadoRoom(numero, planta))
        return repository.freeRoom(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para poner una habitacion en matenimiento
     * @param numero el numero de la habitacion a poner en matenimiento
     * @param planta la planta de la habitación a poner en matenimiento
     * @return la habitación que se está manteniendo
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun keepRoom(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        isRoomEmpty(getEstadoRoom(numero, planta))
        return repository.keepRoom(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para comprar una habitación que está reservada
     * @param numero el numero de la habitacion a comprar
     * @param planta la planta de la habitación a comprar
     * @return la habitación comprada
     * @throws HabitacionNotFound si no se encuentra una habitacion con el numero y planta especificado
     */
    fun formalizeRoom(numero: Int, planta: Int): Habitacion {
        comprobarNumeroPlanta(numero, planta)
        canIFormalizaRoom(getEstadoRoom(numero, planta))
        return repository.formalizeRoom(numero, planta) ?: throw HabitacionNotFound("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.")
    }

    /**
     * función que sirve para calcular la recaudacion total del hotel
     * @return la recaudación total
     */
    fun getTotalMoney(): Double {
        return repository.getTotalMoney()
    }

    /**
     * función que sirve para comprobar si el numero y la planta de la sala son correctos
     * @throws HabitacionBadRequest si el numero o la planta no son válidos
     */
    private fun comprobarNumeroPlanta(numero: Int, planta: Int){
        require(numero in (1..5)){ throw HabitacionBadRequest("Error del sistema: El numero de sala introducido debe estar entre 1 y 5.")}
        require(planta in (1..4)){ throw HabitacionBadRequest("Error del sistema: La planta de sala introducida debe estar entre 1 y 4.")}
    }

    /**
     * función que sirve para hallar el estado de una habitación según su número y planta
     * @return el estado de la habitación
     */
    private fun getEstadoRoom(numero: Int, planta: Int): Estado{
        val habitacion = this.getRoomByFloorAndNumber(numero, planta)
        return habitacion.estado
    }

    /**
     * función que nos permite saber si la habitación está vacia
     * @throws RoomNotEmpty si la habitacion no está vacia
     */
    private fun isRoomEmpty(estado: Estado){
        require(estado == Estado.LIBRE){ throw RoomNotEmpty("Error del sistema: La habitacion no está vacia, por lo que la acción deseada no se puede realizar.") }
    }

    /**
     * función que nos permite saber si se puede liberar una habitación
     * @throws RoomCannotBeEmpty si la habitación no se puede liberar
     */
    private fun canIEmptyRoom(estado: Estado){
        require(estado != Estado.LIBRE){ throw RoomCannotBeEmpty("Error del sistema: La habitación ya está libre por lo que no se puede liberar.")}
    }

    private fun canIFormalizaRoom(estado: Estado){
        require(estado == Estado.RESERVADO){ throw RoomCannorBeFormalize("Error del sistema: La habitación no está reservada, por lo que no se puede formalizar.")}
    }
}