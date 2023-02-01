package controllers

import exceptions.ReservaAlreadyExisting
import exceptions.ReservaBadRequest
import exceptions.ReservaEmpty
import exceptions.ReservaNotFound
import factories.FactoryHabitacion
import factories.FactoryReserva
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import models.Reserva
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import repositories.ReservaRepository
import java.time.LocalDate
import java.util.*

internal class ReservaControllerTest {

    private val ID = UUID.fromString("34e6a53e-c816-43e3-ac60-b64b507e029d")

    @MockK
    private lateinit var repository: ReservaRepository

    @InjectMockKs
    private lateinit var controller: ReservaController

    init {
        MockKAnnotations.init(this)
    }

    val misReservas: Array<Reserva?> = arrayOf(
        FactoryReserva.create("Iván", FactoryHabitacion.createIndividual(1,1,Estado.COMPRADO,4), LocalDate.of(2029, 1, 24), LocalDate.of(2029, 1, 27)),
        FactoryReserva.create("Manuel", FactoryHabitacion.createDoble(4,1,Estado.COMPRADO,TipoDeCama.XL), LocalDate.of(2029, 1, 18), LocalDate.of(2029, 1, 27)),
        FactoryReserva.create("Belén", FactoryHabitacion.createFamilia(2,3,Estado.COMPRADO,4), LocalDate.of(2029, 1, 4), LocalDate.of(2029, 1, 29)),
        FactoryReserva.create("Robeto", FactoryHabitacion.createSuite(2,2,Estado.COMPRADO,4), LocalDate.of(2029, 1, 24), LocalDate.of(2029, 1, 30)),
        FactoryReserva.create("Julia", FactoryHabitacion.createIndividual(2,4,Estado.COMPRADO,4), LocalDate.of(2029, 1, 8), LocalDate.of(2029, 2, 3))
    )

    val misReservas2: Array<Reserva?> = arrayOf(null, null, null, null)

    @BeforeEach
    fun setUp(){
        misReservas[0]!!.id = ID
    }

    @Test
    fun ArrayEmpty(){
        every { repository.getAllReservas() } returns misReservas2

        val res = assertThrows<ReservaEmpty>{
            controller.getReservaById(ID)
        }
        assertEquals("Error del sistema: No hay reservas en el repositorio.", res.message)
    }

    @Test
    fun checkReservaInfo(){
        val reserva1 = FactoryReserva.create("", FactoryHabitacion.createIndividual(1,1,Estado.COMPRADO,4), LocalDate.of(2029, 1, 24), LocalDate.of(2029, 1, 27))
        val res1 = assertThrows<ReservaBadRequest> { controller.create(reserva1) }
        val reserva2 = FactoryReserva.create("Iván", FactoryHabitacion.createIndividual(1,1,Estado.COMPRADO,4), LocalDate.of(2030, 1, 24), LocalDate.of(2029, 1, 27))
        val res2 = assertThrows<ReservaBadRequest> { controller.create(reserva2) }
        val reserva3 = FactoryReserva.create("Iván", FactoryHabitacion.createIndividual(1,1,Estado.COMPRADO,4), LocalDate.of(2022, 1, 24), LocalDate.of(2022, 1, 27))
        val res3 = assertThrows<ReservaBadRequest> { controller.create(reserva3) }

        assertAll(
            { assertEquals("Error del sistema: El nombre de la persona no puede ser nulo.", res1.message)},
            { assertEquals("Error del sistema: No se ha introducido una fecha de entrada válida.", res2.message)},
            { assertEquals("Error del sistema: No se ha introducido una fecha de salida válida.", res3.message)}
        )
    }

    @Test
    fun getReservaById() {
        every { repository.getAllReservas() } returns misReservas
        every { repository.getReservaById(ID) } returns misReservas[0]

        val res = controller.getReservaById(ID)

        assertAll(
            { assertNotNull(res) },
            { assertEquals(misReservas[0], res) },
        )

        verify { repository.getReservaById(ID) }
    }

    @Test
    fun getReservaByIdButNotFound(){
        every { repository.getAllReservas() } returns misReservas
        every { repository.getReservaById(ID) } returns null

        val res = assertThrows<ReservaNotFound> {
            controller.getReservaById(ID)
        }

        assertEquals("Error del sistema: No se ha encontrado la reserva pedida.", res.message)

    }

    @Test
    fun getAllReservas() {
        every { repository.getAllReservas() } returns misReservas

        val res = controller.getAllReservas()

        assertArrayEquals(res, misReservas)
    }

    @Test
    fun create() {
        every { repository.create(misReservas[0] as Reserva) } returns misReservas[0]

        assertEquals(misReservas[0], controller.create(misReservas[0] as Reserva))
    }

    @Test
    fun createBuAlreadyExisting() {
        every { repository.create(misReservas[0] as Reserva) } returns null

        val res = assertThrows<ReservaAlreadyExisting> { controller.create(misReservas[0] as Reserva) }

        assertEquals("Error del sistema: La reserva introducida ya existía.", res.message)
    }

    @Test
    fun update() {
        every { repository.getAllReservas() } returns misReservas
        every { repository.update(ID ,misReservas[1] as Reserva) } returns misReservas[1]

        assertEquals(misReservas[1], controller.update(ID, misReservas[1] as Reserva))
    }

    @Test
    fun updateButNotFound() {
        every { repository.getAllReservas() } returns misReservas
        every { repository.update(ID ,misReservas[1] as Reserva) } returns null

        val res = assertThrows<ReservaNotFound> { controller.update(ID, misReservas[1] as Reserva) }

        assertEquals("Error del sistema: No se ha encontrado la reserva pedida.", res.message)
    }

    @Test
    fun delete() {
        every { repository.getAllReservas() } returns misReservas
        every { repository.delete(ID) } returns misReservas[0]

        assertEquals(misReservas[0], controller.delete(ID))
    }

    @Test
    fun deleteButNotFound() {
        every { repository.getAllReservas() } returns misReservas
        every { repository.delete(ID) } returns null

        val res = assertThrows<ReservaNotFound> {controller.delete(ID)}

        assertEquals("Error del sistema: No se ha encontrado la reserva pedida", res.message)
    }
}