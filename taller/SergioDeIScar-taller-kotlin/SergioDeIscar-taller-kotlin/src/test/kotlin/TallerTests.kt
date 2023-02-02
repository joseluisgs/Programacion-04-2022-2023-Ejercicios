import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll
import taller.calculateNomina
import taller.countType
import taller.findFirstType
import taller.models.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
private class TallerTests {
    val personas: Array<Persona?> = arrayOf(
        Chapista("pepe", 10, 8),
        Chapista("pepe", 10, 8),
        Chapista("pepe", 10, 8),
        Chapista("pepe", 10, 8),
        Electricista("pepa", 10, 8),
        Electricista("pepa", 10, 8),
        Electricista("pepa", 10, 8),
        Electricista("pepa", 10, 8),
        Electricista("pepa", 10, 8)
    )

    @Test
    fun countType_Test() {
        assertAll(
            { assertEquals(4, countType(personas, 3)) },
            { assertEquals(5, countType(personas, 4)) },
            { assertEquals(9, countType(personas, 1)) },
            { assertEquals(0, countType(personas, 2)) }
        )
    }

    @Test
    fun findFirstType_Test(){
        val targetChapista = Chapista("target", 8, 7)
        val targetElectricista = Electricista("target", 8, 7)
        val personasTarget: Array<Persona?> = arrayOf(
            targetChapista,
            Chapista("pepe", 10, 8),
            Chapista("pepe", 10, 8),
            Chapista("pepe", 10, 8),
            targetElectricista,
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8)
        )

        assertAll(
            { assertEquals(targetChapista, findFirstType(personasTarget, 3)) },
            { assertEquals(targetElectricista, findFirstType(personasTarget, 4)) },
            { assertEquals(targetChapista, findFirstType(personasTarget, 1)) },
            { assertEquals(null, findFirstType(personasTarget, 2)) }
        )
    }

    /*@Test
    fun countType_Test() {
        assertAll(
            { assertEquals(4, countType<Chapista>(personas)) },
            { assertEquals(5, countType<Electricista>(personas)) },
            { assertEquals(9, countType<Trabajador>(personas)) }
        )
    }

    @Test
    fun findFirstType_Test(){
        val targetChapista = Chapista("target", 8, 7)
        val targetElectricista = Electricista("target", 8, 7)
        val personasTarget: Array<Persona?> = arrayOf(
            targetChapista,
            Chapista("pepe", 10, 8),
            Chapista("pepe", 10, 8),
            Chapista("pepe", 10, 8),
            targetElectricista,
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8),
            Electricista("pepa", 10, 8)
        )

        assertAll(
            { assertEquals(targetChapista, findFirstType<Chapista>(personasTarget)) },
            { assertEquals(targetElectricista, findFirstType<Electricista>(personasTarget)) },
            { assertEquals(targetChapista, findFirstType<Trabajador>(personasTarget)) }
        )
    }*/

    @Test
    fun calculateNomina_Test(){
        val expected = 1800 * 5 + 1700 * 4
        assertEquals(expected, calculateNomina(personas))
    }

    val jefeTallerSmall = JefeTaller("Jefe", 5)
    val jefeTallerMedium = JefeTaller("Jefe", 6)
    val jefeTallerBig = JefeTaller("Jefe", 16)

    val chapista = Chapista("pepe", 7, 5)
    val electricista = Electricista("pepe", 10, 12)

    @Test
    fun jefeSizeTrabajadores_Test(){
        assertAll(
            { assertEquals(5, jefeTallerSmall.getSizeTrabajadores()) },
            { assertEquals(15, jefeTallerMedium.getSizeTrabajadores()) },
            { assertEquals(25, jefeTallerBig.getSizeTrabajadores()) }
        )
    }

    //region CRUD
    @Test
    fun addTrabajador_Test(){
        for (i in 0 until  jefeTallerSmall.getSizeTrabajadores()){
            jefeTallerSmall.addTrabajador(electricista)
        }
        assertAll(
            { assertEquals(null, jefeTallerSmall.addTrabajador(electricista))},
            { assertEquals(electricista, jefeTallerMedium.addTrabajador(electricista))},
            { assertEquals(electricista, jefeTallerBig.addTrabajador(electricista))},
        )
    }

    @Test
    fun removeTrabajador_Test(){
        val jefeTaller = JefeTaller("pepe", 6)
        jefeTaller.addTrabajador(electricista)
        assertAll(
            { assertTrue { jefeTaller.removeTrabajador(0) }},
            { assertFalse { jefeTaller.removeTrabajador(0) } },

            { assertFalse { jefeTaller.removeTrabajador(100) }},
            { assertFalse { jefeTaller.removeTrabajador(chapista) }}
        )
    }

    @Test
    fun updateTrabajador_Test(){
        val jefeTaller = JefeTaller("pepe", 6)
        jefeTaller.addTrabajador(electricista)
        jefeTaller.addTrabajador(chapista)
        assertAll(
            { assertTrue { jefeTaller.updateTrabajador(0, Electricista("pepa", 14, 12)) }},
            { assertTrue { jefeTaller.updateTrabajador(chapista, Chapista("pepon", 7, 7)) } },

            { assertFalse { jefeTaller.updateTrabajador(100, chapista) }},
            { assertFalse { jefeTaller.updateTrabajador(electricista, chapista) }}
        )
    }

    @Test
    fun findTrabajadorIndex_Test(){
        val jefeTaller = JefeTaller("pepe", 6)
        jefeTaller.addTrabajador(electricista)
        assertAll(
            { assertEquals(0, jefeTaller.findTrabajadorIndex(electricista))},
            { assertEquals(-1, jefeTaller.findTrabajadorIndex(chapista))}
        )
    }

    @Test
    fun exitsTrabajador_Test(){
        val jefeTaller = JefeTaller("pepe", 6)
        jefeTaller.addTrabajador(electricista)
        assertAll(
            { assertTrue(jefeTaller.exitsTrabajador(electricista)) },
            { assertFalse(jefeTaller.exitsTrabajador(chapista)) }
        )
    }
    //endregion
}