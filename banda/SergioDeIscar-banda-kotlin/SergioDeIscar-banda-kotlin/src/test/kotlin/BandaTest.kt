import bandamusical.calculateNomina
import bandamusical.countType
import bandamusical.findFirstType
import bandamusical.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BandaTest {
    private val musicians = arrayOf(
        Bajista("pepe", 15, 4),
        Bajista("pepe2", 15, 4),
        Cantante("pepo", 15, TonoType.TENOR),
        CantanteGuitarrista("pepa", 12, TonoType.BARITONO, GuitarraType.CLASICA),
        Guitarrista("pepi", 2, GuitarraType.FLAMENCA),
        Multinstrumentista("pepu", 25, 6, PercussionType.ALTURA_DETERMINADA, 4),
        Percusionista("repepe", 23, PercussionType.ALTURA_INDETERMINADA),
        Teclista("repepo", 7, 3),
        Trompetista("repopa", 9, 0..5)
    )

    @Test
    fun countType_Test() {
        assertAll(
            { assertEquals(2, countType<Bajista>(musicians)) },
            { assertEquals(1, countType<Cantante>(musicians)) },
            { assertEquals(1, countType<Multinstrumentista>(musicians)) }
        )
    }

    @Test
    fun findFirstType_Test(){
        val targetCantante = Cantante("target", 8, TonoType.SOPRANO)
        val targetTeclista = Teclista("target", 8, 7)
        val personasTarget: Array<Musician> = arrayOf(
            targetCantante,
            Cantante("pepe", 10, TonoType.CONTRALTO),
            Cantante("pepe", 10, TonoType.BAJO),
            Cantante("pepe", 10, TonoType.SOPRANO),
            targetTeclista,
            Teclista("pepa", 10, 8),
            Teclista("pepa", 10, 8),
            Teclista("pepa", 10, 8),
            Teclista("pepa", 10, 8)
        )

        assertAll(
            { assertEquals(targetCantante, findFirstType<Cantante>(personasTarget)) },
            { assertEquals(targetTeclista, findFirstType<Teclista>(personasTarget)) },
            { assertEquals(targetCantante, findFirstType<Musician>(personasTarget)) }
        )
    }

    @Test
    fun calculateNomina_Test(){
        val expected = (1500.0f * 1.3f) * 2 +    // Bajista
                1500.0f * 1.4f +                        // Cantante
                1500.0f * 1.5f +                        // CantanteGuitarist
                1500.0f * 1.35f +                       // Guitarrista
                1500.0f * 1.45f +                       // Multinstrumentista
                1500.0f * 1.35f +                       // Percusionista
                1500.0f * 1.3f +                        // Teclista
                1500.0f * 1.2f                          // Trompetista
        assertEquals(expected, calculateNomina(musicians))
    }
}