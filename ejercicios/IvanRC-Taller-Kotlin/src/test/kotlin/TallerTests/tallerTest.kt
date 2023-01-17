package TallerTests

import modelsTaller.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class tallerTest {

    val taller = Taller(4)

    @BeforeAll
    fun setUp(){
        taller.arrayTaller[0] = JefeTaller("Iván", 34, 70)
        taller.arrayTaller[1] = Trabajador("Roberto", 14, 8)
        taller.arrayTaller[2] = Chapista("Manuel", 38, 9)
        taller.arrayTaller[3] = Electricista("Nefer", 0, 0)
    }

    @Test
    fun calcularNominaTotalTest(){
        assertEquals((taller.JEFE_TALLER+taller.TRABAJADOR+taller.CHAPISTA+taller.ELECTRICISTA), taller.calcularNominaTotal())
    }

    @Test
    fun calcularNumeroDeTrabajadoresTest(){
        assertEquals(1, taller.calcularNumeroDeTrabajadores())
    }

    @Test
    fun calcularNumeroDeChapistasTest(){
        assertEquals(1, taller.calcularNumeroDeChapistas())
    }

    @Test
    fun calcularNumeroDeElectricistasTest(){
        assertEquals(1, taller.calcularNumeroDeElectricistas())
    }

    @Test
    fun calcularNumeroDeJefesTallerTest(){
        assertEquals(1, taller.calcularNumeroDeJefesTaller())
    }
}