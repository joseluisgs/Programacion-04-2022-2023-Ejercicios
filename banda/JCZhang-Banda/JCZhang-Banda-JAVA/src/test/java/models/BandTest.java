package models;

import factories.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static models.Band.*;
import static org.junit.jupiter.api.Assertions.*;

class BandTest {
    static Person[] bandArrayTest = new Person[15];
    @BeforeAll
    /**
     * Meto a mano 15 personas en un array de prueba para hacer los test.
     * Lo hago antes de todos los test
     */
    static void setUp() {


        // 3 guitarristas
        bandArrayTest[0] = GuitaristFactory.createRandomGuitarist();
        bandArrayTest[1] = GuitaristFactory.createRandomGuitarist();
        bandArrayTest[2] = GuitaristFactory.createRandomGuitarist();
        // 2 cantantes guitarristas
        bandArrayTest[3] = SingerGuitaristFactory.createRandomSingerGuitarist();
        bandArrayTest[4] = SingerGuitaristFactory.createRandomSingerGuitarist();
        // 1 trompetista
        bandArrayTest[5] = TrumpeterFactory.createRandomTrumpeter();
        //2 Pianistas
        bandArrayTest[6] = PianistFactory.createRandomPianist();
        bandArrayTest[7] = PianistFactory.createRandomPianist();
        //1 Bajista
        bandArrayTest[8] = BassGuitaristFactory.createRandomBassGuitarist();
        // 2 MultiInstrumentalistas
        bandArrayTest[9] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist();
        bandArrayTest[10] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist();
        //2 Percusionista
        bandArrayTest[11] = PercussionistFactory.createRandomPercussionist();
        bandArrayTest[12] = PercussionistFactory.createRandomPercussionist();
        //2 Cantantes
        bandArrayTest[13] = SingerFactory.createRandomSinger();
        bandArrayTest[14] = SingerFactory.createRandomSinger();


    }

    @Test
    void numberOfTrumpetersTest() {
        assertEquals(1, numberOfTrumpeters(bandArrayTest));
    }

    @Test
    void numberOfGuitaristsTest() {
        assertEquals(3, numberOfGuitarists(bandArrayTest));
    }

    @Test
    void numberOfBassGuitaristsTest() {
        assertEquals(1, numberOfBassGuitarists(bandArrayTest));
    }

    @Test
    void numberOfPianistsTest() {
        assertEquals(2, numberOfPianists(bandArrayTest));
    }

    @Test
    void numberOfPercussionistsTest() {
        assertEquals(2, numberOfPercussionists(bandArrayTest));
    }

    @Test
    void numberOfSingerGutaristsTest() {
        assertEquals(2, numberOfSingerGutarists(bandArrayTest));
    }

    @Test
    void numberOfMultiInstrumentalistsTest() {
        assertEquals(2, numberOfMultiInstrumentalists(bandArrayTest));
    }

    @Test
    void numberOfSingersTest() {
        assertEquals(2, numberOfSingers(bandArrayTest));
    }

    @Test
    void calculateTrumpeterSalaryTest() {
        assertEquals(Math.round(1500.00 *1.2 * 1*100)/100.0, calculateTrumpeterSalary());
    }

    @Test
    void calculateGuitaristSalaryTest() {
        assertEquals(Math.round(1500.00 *1.35*3*100)/100.0, calculateGuitaristSalary());
    }

    @Test
    void calculatePianistSalaryTest() {
        assertEquals(Math.round(1500.00*1.3*2*100)/100.0, calculatePianistSalary());
    }

    @Test
    void calculatePercussionistSalaryTest() {
        assertEquals(Math.round(1500.00*1.35*2*100)/100.0, calculatePercussionistSalary());
    }

    @Test
    void calculateSingerSalaryTest() {
        assertEquals(Math.round(1500.00*1.4*2*100)/100.0, calculateSingerSalary());
    }

    @Test
    void calculateMultiInstrumentalistSalaryTest() {
        assertEquals(Math.round(1500.00*1.5*2*100)/100.0, calculateMultiInstrumentalistSalary());
    }

    @Test
    void calculateSingerGutaristSalaryTest() {
        assertEquals(Math.round(1500.00*1.5*2*100)/100.0, calculateSingerGutaristSalary());
    }

    @Test
    void calculateBassGuitaristSalaryTest() {
        assertEquals(Math.round(1500.00*1.5*1*100)/100.0, calculateBassGuitaristSalary());
    }

}