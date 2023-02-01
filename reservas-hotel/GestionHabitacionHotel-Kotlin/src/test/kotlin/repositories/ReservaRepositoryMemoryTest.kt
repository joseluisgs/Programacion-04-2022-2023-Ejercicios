package repositories

import factories.FactoryHabitacion
import factories.FactoryReserva
import models.Reserva
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.time.LocalDate
import java.util.*

internal class ReservaRepositoryMemoryTest {

    private val ID = UUID.fromString("34e6a53e-c816-43e3-ac60-b64b507e029d")

    private lateinit var repository: ReservaRepository

    private lateinit var array: Array<Reserva?>

    val misReservas: Array<Reserva?> = arrayOf(
        FactoryReserva.create("Iván", FactoryHabitacion.createIndividual(1,1,Estado.COMPRADO,4), LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27)),
        FactoryReserva.create("Manuel", FactoryHabitacion.createDoble(4,1,Estado.COMPRADO,TipoDeCama.XL), LocalDate.of(2023, 1, 18), LocalDate.of(2023, 1, 27)),
        FactoryReserva.create("Belén", FactoryHabitacion.createFamilia(2,3,Estado.COMPRADO,4), LocalDate.of(2023, 1, 4), LocalDate.of(2023, 1, 29)),
        FactoryReserva.create("Robeto", FactoryHabitacion.createSuite(2,2,Estado.COMPRADO,4), LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 30)),
        FactoryReserva.create("Julia", FactoryHabitacion.createIndividual(2,4,Estado.COMPRADO,4), LocalDate.of(2023, 1, 8), LocalDate.of(2023, 2, 3))
    )

    @BeforeEach
    fun setUp(){
        misReservas[0]!!.id = ID
        repository = ReservaRepositoryMemory()
        repository.safeAll(misReservas)
        array = repository.getAllReservas()
    }

    @Test
    fun getAllReservas() {
        assertAll(
            {assertEquals(misReservas.size, array.size)},
            {assertEquals(misReservas[0], array[0])},
            {assertEquals(misReservas[1], array[1])},
            {assertEquals(misReservas[2], array[2])},
            {assertEquals(misReservas[3], array[3])},
            {assertEquals(misReservas[4], array[4])}
        )
        //Ahora compruebo cuando el array está vacio
        repository.deleteAll()
        array = repository.getAllReservas()
        assertEquals(0, array.size)
    }

    @Test
    fun create() {
        //comprobaos que se redimensionará el array
        assertEquals(5, array.size)

        val r1 =  FactoryReserva.create("Juan",
            FactoryHabitacion.createIndividual(4,3,Estado.COMPRADO,2),
            LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27))

        val reserva = repository.create(r1)
        array = repository.getAllReservas()

        assertAll(
            {assertEquals(6, array.size)},
            {assertEquals(reserva, r1)}
        )
    }

    @Test
    fun createButRepeatedReserva(){
        assertNull(repository.create(misReservas[0] as Reserva))
    }

    @Test
    fun update() {
        assertEquals(misReservas[0], array[0])

        val reservaUpdate = FactoryReserva.create("Juan",
            FactoryHabitacion.createIndividual(4,3,Estado.COMPRADO,2),
            LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27)
        )
        repository.update(ID, reservaUpdate)
        array = repository.getAllReservas()
        assertEquals(reservaUpdate, array[0])
    }

    @Test
    fun updateButNotFound(){
        val reservaUpdate = FactoryReserva.create("Juan",
            FactoryHabitacion.createIndividual(4,3,Estado.COMPRADO,2),
            LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27)
        )
        assertNull(repository.update(UUID.randomUUID(), reservaUpdate))
    }

    @Test
    fun delete() {
        val r1 =  FactoryReserva.create("Juan",
            FactoryHabitacion.createIndividual(4,3,Estado.COMPRADO,2),
            LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27))

        val reserva = repository.create(r1)

        array = repository.getAllReservas()
        assertEquals(6, array.size)

        val reservaEliminada = repository.delete(ID)
        array = repository.getAllReservas()
        assertAll(
            { assertEquals(5, array.size)},
            { assertEquals(reservaEliminada, misReservas[0])}
        )
    }

    @Test
    fun deleteButNotFound(){
        assertNull(repository.delete(UUID.randomUUID()))
    }

    @Test
    fun safeAll() {
        assertEquals(5, array.size)

        val misReservas2: Array<Reserva?> = arrayOf(
            FactoryReserva.create("Rocio", FactoryHabitacion.createIndividual(4,1,Estado.COMPRADO,4), LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 27)),
            FactoryReserva.create("Miguel", FactoryHabitacion.createDoble(4,2,Estado.COMPRADO,TipoDeCama.XL), LocalDate.of(2023, 1, 18), LocalDate.of(2023, 1, 27)),
            FactoryReserva.create("Josefina", FactoryHabitacion.createFamilia(5,3,Estado.COMPRADO,4), LocalDate.of(2023, 1, 4), LocalDate.of(2023, 1, 29)),
            FactoryReserva.create("Mario", FactoryHabitacion.createSuite(5,2,Estado.COMPRADO,4), LocalDate.of(2023, 1, 24), LocalDate.of(2023, 1, 30)),
            FactoryReserva.create("María", FactoryHabitacion.createIndividual(1,2,Estado.COMPRADO,4), LocalDate.of(2023, 1, 8), LocalDate.of(2023, 2, 3))
        )
        repository.safeAll(misReservas2)
        array = repository.getAllReservas()

        assertAll(
            {assertEquals(10, array.size)},
            {assertEquals(misReservas2[0], array[5])},
            {assertEquals(misReservas2[1], array[6])},
            {assertEquals(misReservas2[2], array[7])},
            {assertEquals(misReservas2[3], array[8])},
            {assertEquals(misReservas2[4], array[9])}
        )

    }

    @Test
    fun deleteAll() {
        assertEquals(5, array.size)

        repository.deleteAll()
        array = repository.getAllReservas()

        assertEquals(0 ,array.size)
    }
}