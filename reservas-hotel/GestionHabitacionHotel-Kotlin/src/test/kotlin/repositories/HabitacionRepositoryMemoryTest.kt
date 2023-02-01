package repositories

import factories.FactoryHabitacion
import models.Habitacion
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class HabitacionRepositoryMemoryTest {

    private lateinit var repository: HabitacionRepository

    private lateinit var array: Array<Habitacion>

    private val misHabitaciones: Array<Habitacion> = arrayOf(
        FactoryHabitacion.createIndividual(1, 1, Estado.LIBRE, 10),
        FactoryHabitacion.createDoble(2, 1, Estado.COMPRADO, TipoDeCama.XL),
        FactoryHabitacion.createFamilia(3, 1, Estado.RESERVADO, 4),
        FactoryHabitacion.createSuite(4, 1, Estado.LIBRE, 10)
    )

    @BeforeEach
    fun setUp(){
        repository = HabitacionRepositoryMemory()
        (repository as HabitacionRepositoryMemory).habitaciones[0] = misHabitaciones[0]
        (repository as HabitacionRepositoryMemory).habitaciones[1] = misHabitaciones[1]
        (repository as HabitacionRepositoryMemory).habitaciones[2] = misHabitaciones[2]
        (repository as HabitacionRepositoryMemory).habitaciones[3] = misHabitaciones[3]
        array = repository.getAllRooms()
    }

    @Test
    fun getAllRooms() {
        assertAll(
            { assertEquals(20, array.size)},
            { assertEquals(misHabitaciones[0], array[0])},
            { assertEquals(misHabitaciones[1], array[1])},
            { assertEquals(misHabitaciones[2], array[2])},
            { assertEquals(misHabitaciones[3], array[3])}
        )
    }

    @Test
    fun getRoomByFloorAndNumber() {
        val numero = 1
        val planta = 1
        val habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(habitacion, array[0])
    }

    @Test
    fun getRoomByFloorAndNumberButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun buyRoom() {
        val numero = 1
        val planta = 1
        var habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(Estado.LIBRE, habitacion!!.estado)

        habitacion = repository.buyRoom(numero, planta)
        assertEquals(Estado.COMPRADO, habitacion!!.estado)
    }

    @Test
    fun buyRoomButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun preorderRoom() {
        val numero = 1
        val planta = 1
        var habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(Estado.LIBRE, habitacion!!.estado)

        habitacion = repository.preorderRoom(numero, planta)
        assertEquals(Estado.RESERVADO, habitacion!!.estado)
    }

    @Test
    fun preorderRoomButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun freeRoom() {
        val numero = 2
        val planta = 1
        var habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(Estado.COMPRADO, habitacion!!.estado)

        habitacion = repository.freeRoom(numero, planta)
        assertEquals(Estado.LIBRE, habitacion!!.estado)
    }

    @Test
    fun freeRoomButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun keepRoom() {
        val numero = 1
        val planta = 1
        var habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(Estado.LIBRE, habitacion!!.estado)

        habitacion = repository.keepRoom(numero, planta)
        assertEquals(Estado.MANTENIMIENTO, habitacion!!.estado)
    }

    @Test
    fun keepRoomButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun formalizeRoom() {
        val numero = 3
        val planta = 1
        var habitacion = repository.getRoomByFloorAndNumber(numero, planta)
        assertEquals(Estado.RESERVADO, habitacion!!.estado)

        habitacion = repository.formalizeRoom(numero, planta)
        assertEquals(Estado.COMPRADO, habitacion!!.estado)
    }

    @Test
    fun formalizeRoomButNotFound(){
        val numero = 6
        val planta = 8
        assertNull(repository.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun getTotalMoney() {
        //Solo calculamos el dinero total con aquellas habitaciones que estén compradas o reservadas
        val resultado = 500.0 + 750.0
        assertEquals(resultado, repository.getTotalMoney())
    }
}