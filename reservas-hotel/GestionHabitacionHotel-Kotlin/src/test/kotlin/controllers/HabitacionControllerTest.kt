package controllers

import exceptions.*
import factories.FactoryHabitacion
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import models.Habitacion
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import repositories.HabitacionRepository

internal class HabitacionControllerTest {

    @MockK
    private lateinit var repository: HabitacionRepository

    @InjectMockKs
    private lateinit var controller: HabitacionController

    private val misHabitaciones: Array<Habitacion> = arrayOf(
        FactoryHabitacion.createIndividual(1, 1, Estado.LIBRE, 10),
        FactoryHabitacion.createDoble(2, 1, Estado.COMPRADO, TipoDeCama.XL),
        FactoryHabitacion.createFamilia(3, 1, Estado.RESERVADO, 4),
        FactoryHabitacion.createSuite(4, 1, Estado.LIBRE, 10)
    )

    init{
        MockKAnnotations.init(this)
    }

    @Test
    fun comprobarNumeroPlantaTest(){
        val numero = 1
        val plantaI = 7
        val res1 = assertThrows<HabitacionBadRequest> {controller.getRoomByFloorAndNumber(numero, plantaI)}
        val numeroI = 7
        val planta = 1
        val res2 = assertThrows<HabitacionBadRequest> {controller.getRoomByFloorAndNumber(numeroI, planta)}
        assertAll(
            { assertEquals("Error del sistema: La planta de sala introducida debe estar entre 1 y 4.", res1.message)},
            { assertEquals("Error del sistema: El numero de sala introducido debe estar entre 1 y 5.", res2.message)}
        )
    }

    @Test
    fun isRoomEmptyTest(){
        val numero = 1
        val planta = 1
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[1]

        val res = assertThrows<RoomNotEmpty> { controller.buyRoom(numero, planta)}
        assertEquals("Error del sistema: La habitacion no está vacia, por lo que la acción deseada no se puede realizar.", res.message)
    }

    @Test
    fun canIEmptyRoomTest(){
        val numero = 1
        val planta = 1
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        val res = assertThrows<RoomCannotBeEmpty> { controller.freeRoom(numero, planta)}
        assertEquals("Error del sistema: La habitación ya está libre por lo que no se puede liberar.", res.message)
    }

    @Test
    fun canIFormalizaeRoomTest(){
        val numero = 1
        val planta = 1
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[1]

        val res = assertThrows<RoomCannorBeFormalize> { controller.formalizeRoom(numero, planta)}
        assertEquals("Error del sistema: La habitación no está reservada, por lo que no se puede formalizar.", res.message)
    }

    @Test
    fun getRoomByFloorAndNumber() {
        val numero = 1
        val planta = 1
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        assertEquals(misHabitaciones[0], controller.getRoomByFloorAndNumber(numero, planta))
    }

    @Test
    fun getRoomByFloorAndNumberButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns null

        val res = assertThrows<HabitacionNotFound> {controller.getRoomByFloorAndNumber(numero, planta)}

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun buyRoom() {
        val numero = 1
        val planta = 1
        misHabitaciones[0].estado = Estado.COMPRADO
        every { repository.buyRoom(numero, planta) } returns misHabitaciones[0]

        assertEquals(misHabitaciones[0], controller.buyRoom(numero, planta))
    }

    @Test
    fun buyRoomButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.buyRoom(numero, planta) } returns null
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        val res = assertThrows<HabitacionNotFound> {controller.buyRoom(numero, planta) }

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun preorderRoom() {
        val numero = 1
        val planta = 1
        misHabitaciones[1].estado = Estado.RESERVADO
        every { repository.preorderRoom(numero, planta) } returns misHabitaciones[1]
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        assertEquals(misHabitaciones[1], controller.preorderRoom(numero, planta))
    }

    @Test
    fun preorderRoomButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.preorderRoom(numero, planta) } returns null
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        val res = assertThrows<HabitacionNotFound> {controller.preorderRoom(numero, planta) }

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun freeRoom() {
        val numero = 1
        val planta = 1
        every { repository.freeRoom(numero, planta) } returns misHabitaciones[0]
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[2]

        assertEquals(misHabitaciones[0], controller.freeRoom(numero, planta))
    }

    @Test
    fun freeRoomButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.freeRoom(numero, planta) } returns null
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[1]

        val res = assertThrows<HabitacionNotFound> {controller.freeRoom(numero, planta) }

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun keepRoom() {
        val numero = 1
        val planta = 1
        misHabitaciones[1].estado = Estado.MANTENIMIENTO
        every { repository.keepRoom(numero, planta) } returns misHabitaciones[1]
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        assertEquals(misHabitaciones[1], controller.keepRoom(numero, planta))
    }

    @Test
    fun keepRoomButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.keepRoom(numero, planta) } returns null
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[0]

        val res = assertThrows<HabitacionNotFound> {controller.keepRoom(numero, planta) }

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun formalizeRoom() {
        val numero = 1
        val planta = 1
        every { repository.formalizeRoom(numero, planta) } returns misHabitaciones[1]
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[2]

        assertEquals(misHabitaciones[1], controller.formalizeRoom(numero, planta))
    }

    @Test
    fun formalizeRoomButNotFound() {
        val numero = 1
        val planta = 1
        every { repository.formalizeRoom(numero, planta) } returns null
        every { repository.getRoomByFloorAndNumber(numero, planta) } returns misHabitaciones[2]

        val res = assertThrows<HabitacionNotFound> {controller.formalizeRoom(numero, planta) }

        assertEquals("Error del sistema: No se ha encontrado ninguna habitación con ese número y planta.", res.message)
    }

    @Test
    fun getTotalMoneyTest(){
        every { repository.getTotalMoney() } returns 1250.0

        val resultado = 500.0 + 750.0

        assertEquals(resultado, controller.getTotalMoney())
    }
}