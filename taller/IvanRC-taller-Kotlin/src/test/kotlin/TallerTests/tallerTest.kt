package TallerTests

import modelsTaller.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class tallerTest {

    val taller = Taller(5)

    @BeforeAll
    fun setUp(){
        taller.arrayTaller[0] = Persona.JefeTaller("Iván", 34, 70)
        taller.arrayTaller[1] = Persona.Trabajador("Roberto", 14, 8)
        taller.arrayTaller[2] = Persona.Chapista("Manuel", 38, 9)
        taller.arrayTaller[3] = Persona.Electricista("Nefer", 0, 0)
        taller.arrayTaller[4] = Persona.NavajaSuiza("Bob", 23, 12)
    }

    @Test
    fun calcularNominaTotalTest(){
        assertEquals((taller.JEFE_TALLER+taller.TRABAJADOR+taller.CHAPISTA+taller.ELECTRICISTA+taller.NAVAJA_SUIZA), taller.calcularNominaTotal())
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

    @Test
    fun calcularNumeroDeNavajasSuizasTest(){
        assertEquals(1, taller.calcularNumeroDeNavajasSuizas())
    }
}