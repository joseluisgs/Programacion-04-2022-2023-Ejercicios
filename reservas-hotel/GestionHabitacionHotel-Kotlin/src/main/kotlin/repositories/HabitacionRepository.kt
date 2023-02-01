package repositories

import models.Habitacion

interface HabitacionRepository {

    fun getAllRooms(): Array<Habitacion>

    fun getRoomByFloorAndNumber(numero: Int, planta: Int): Habitacion?

    fun buyRoom(numero: Int, planta: Int): Habitacion?

    fun preorderRoom(numero: Int, planta: Int): Habitacion?

    fun freeRoom(numero: Int, planta: Int): Habitacion?

    fun keepRoom(numero: Int, planta: Int): Habitacion?

    fun formalizeRoom(numero: Int, planta: Int): Habitacion?

    fun getTotalMoney(): Double
}