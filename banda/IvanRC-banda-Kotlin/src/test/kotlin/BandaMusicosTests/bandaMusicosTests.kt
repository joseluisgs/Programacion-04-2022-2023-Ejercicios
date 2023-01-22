package BandaMusicosTests

import modelsBandaMusicos.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class bandaMusicosTests {

    val b = Banda(8)

    @BeforeAll
    fun setUp(){
        b.arrayMusicos[0] = Trompetista("Iván", 1500.0, 24, 10)
        b.arrayMusicos[1] = Cantante("Iván", 1500.0, 24, "suave")
        b.arrayMusicos[2] = Guitarrista("Iván", 1500.0, 24, tipoGuitarra.ACUSTICA)
        b.arrayMusicos[3] = Bajista("Iván", 1500.0, 24, 10)
        b.arrayMusicos[4] = Teclista("Iván", 1500.0, 24, 10)
        b.arrayMusicos[5] = Percusionista("Iván", 1500.0, 24, tipoPercusion.TAMBOR)
        b.arrayMusicos[6] = CantanteGuitarrista("Iván", 1500.0, 24, "suave", tipoGuitarra.ACUSTICA)
        b.arrayMusicos[7] = Multinstrumental("Iván", 1500.0, 24, 10, 12,tipoPercusion.TAMBOR)
    }

    @Test
    fun cuantosTrompetistasHayTest(){
        assertEquals(1, b.contarTrompetistas())
    }

    @Test
    fun cuantosCantantesHayTest(){
        assertEquals(1, b.contarCantantes())
    }

    @Test
    fun cuantosGuitarristasHayTest(){
        assertEquals(1, b.contarGuitarristas())
    }

    @Test
    fun cuantosBajistasHayTest(){
        assertEquals(1, b.contarBajistas())
    }

    @Test
    fun cuantosTeclistasHayTest(){
        assertEquals(1, b.contarTeclistas())
    }

    @Test
    fun cuantosPercusionistasHayTest(){
        assertEquals(1, b.contarPercusionistas())
    }

    @Test
    fun cuantosCantantesGuitarristasHayTest(){
        assertEquals(1, b.contarCantantesGuitarristas())
    }

    @Test
    fun cuantosMultinstrumentalesHayTest(){
        assertEquals(1, b.contarMultinstrumentales())
    }

    @Test
    fun hallarSalarioTotalTest(){
        assertEquals(16650.0, b.hallarSalarioTotal())
    }

    @Test
    fun recalcularSalariosTest(){
        assertAll(
            {assertEquals(1800.0, (b.arrayMusicos[0] as Trompetista).recalcularSalario(1500.0))},
            {assertEquals(2100.0, (b.arrayMusicos[1] as Cantante).recalcularSalario(1500.0))},
            {assertEquals(2025.0000000000002, (b.arrayMusicos[2] as Guitarrista).recalcularSalario(1500.0))},
            {assertEquals(2250.0, (b.arrayMusicos[3] as Bajista).recalcularSalario(1500.0))},
            {assertEquals(1950.0, (b.arrayMusicos[4] as Teclista).recalcularSalario(1500.0))},
            {assertEquals(2025.0000000000002, (b.arrayMusicos[5] as Percusionista).recalcularSalario(1500.0))},
            {assertEquals(2250.0, (b.arrayMusicos[6] as CantanteGuitarrista).recalcularSalario(1500.0))},
            {assertEquals(2250.0, (b.arrayMusicos[7] as Multinstrumental).recalcularSalario(1500.0))},
        )
    }
}