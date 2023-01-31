package models

import factories.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.math.roundToInt

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BandTest {

    var bandArrayTest = Array<Person?>(15){null}



    @BeforeAll
            /**
             * Meto a mano 15 personas en un array de prueba para hacer los test.
             * Lo hago antes de todos los test
             */
    fun setUp() {


        // 3 guitarristas
        bandArrayTest[0] = GuitaristFactory.createRandomGuitarist()
        bandArrayTest[1] = GuitaristFactory.createRandomGuitarist()
        bandArrayTest[2] = GuitaristFactory.createRandomGuitarist()
        // 2 cantantes guitarristas
        bandArrayTest[3] = SingerGuitaristFactory.createRandomSingerGuitarist()
        bandArrayTest[4] = SingerGuitaristFactory.createRandomSingerGuitarist()
        // 1 trompetista
        bandArrayTest[5] = TrumpeterFactory.createRandomTrumpeter()
        //2 Pianistas
        bandArrayTest[6] = PianistFactory.createRandomPianist()
        bandArrayTest[7] = PianistFactory.createRandomPianist()
        //1 Bajista
        bandArrayTest[8] = BassGuitaristFactory.createRandomBassGuitarist()
        // 2 MultiInstrumentalistas
        bandArrayTest[9] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist()
        bandArrayTest[10] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist()
        //2 Percusionista
        bandArrayTest[11] = PercussionistFactory.createRandomPercussionist()
        bandArrayTest[12] = PercussionistFactory.createRandomPercussionist()
        //2 Cantantes
        bandArrayTest[13] = SingerFactory.createRandomSinger()
        bandArrayTest[14] = SingerFactory.createRandomSinger()
    }

    @Test
    fun numberOfTrumpetersTest() {
        assertEquals(1, Band().numberOfTrumpeters(bandArrayTest))
    }

    @Test
    fun numberOfGuitaristsTest() {
        assertEquals(3, Band().numberOfGuitarists(bandArrayTest))
    }

    @Test
    fun numberOfBassGuitaristsTest() {
        assertEquals(1, Band().numberOfBassGuitarists(bandArrayTest))
    }

    @Test
    fun numberOfPianistsTest() {
        assertEquals(2, Band().numberOfPianists(bandArrayTest))
    }

    @Test
    fun numberOfPercussionistsTest() {
        assertEquals(2, Band().numberOfPercussionists(bandArrayTest))
    }

    @Test
    fun numberOfSingerGutaristsTest() {
        assertEquals(2, Band().numberOfSingerGutarists(bandArrayTest))
    }

    @Test
    fun numberOfMultiInstrumentalistsTest() {
        assertEquals(2, Band().numberOfMultiInstrumentalists(bandArrayTest))
    }

    @Test
    fun numberOfSingersTest() {
        assertEquals(2, Band().numberOfSingers(bandArrayTest))
    }

    @Test
    fun calculateTrumpeterSalaryTest() {
        assertEquals((1500.00 * 1.2 * 1 * 100).roundToInt() / 100.0, Band().calculateTrumpeterSalary())
    }

    @Test
    fun calculateGuitaristSalaryTest() {
        assertEquals((1500.00 * 1.35 * 3 * 100).roundToInt() / 100.0, Band().calculateGuitaristSalary())
    }

    @Test
    fun calculatePianistSalaryTest() {
        assertEquals((1500.00 * 1.3 * 2 * 100).roundToInt() / 100.0, Band().calculatePianistSalary())
    }

    @Test
    fun calculatePercussionistSalaryTest() {
        assertEquals((1500.00 * 1.35 * 2 * 100).roundToInt() / 100.0, Band().calculatePercussionistSalary())
    }

    @Test
    fun calculateSingerSalaryTest() {
        assertEquals((1500.00 * 1.4 * 2 * 100).roundToInt() / 100.0, Band().calculateSingerSalary())
    }

    @Test
    fun calculateMultiInstrumentalistSalaryTest() {
        assertEquals((1500.00 * 1.5 * 2 * 100).roundToInt() / 100.0, Band().calculateMultiInstrumentalistSalary())
    }

    @Test
    fun calculateSingerGutaristSalaryTest() {
        assertEquals((1500.00 * 1.5 * 2 * 100).roundToInt() / 100.0, Band().calculateSingerGutaristSalary())
    }

    @Test
    fun calculateBassGuitaristSalaryTest() {
        assertEquals((1500.00 * 1.5 * 1 * 100).roundToInt() / 100.0, Band().calculateBassGuitaristSalary())
    }



}
