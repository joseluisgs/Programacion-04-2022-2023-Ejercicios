import models.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TallerKtTest {

    val arrayPersonasTest = Array<Persona?>(6){ null}

    @BeforeEach
    fun setUp() {
        arrayPersonasTest[0] = JefeTaller("pablo", 2)
        arrayPersonasTest[1] = JefeTaller("Juana", 5)
        arrayPersonasTest[2] = Electricista("Pepe", 2, 4)
        arrayPersonasTest[3] = Chapista("Juan", 4, 6)
        arrayPersonasTest[4] = Trabajador("Ramon", 6, 8)
        arrayPersonasTest[5] = NavajaSuiza("Paco", 7, 14)
    }

    @Test
    fun numeroJefeTaller() {
        assertEquals(2, Taller().numeroJefeTaller(arrayPersonasTest))
    }

    @Test
    fun numeroDeElectricistas() {
        assertEquals(1, Taller().numeroDeElectricistas(arrayPersonasTest))
    }

    @Test
    fun numeroDeChapistas() {
        assertEquals(1, Taller().numeroDeChapistas(arrayPersonasTest))
    }

    @Test
    fun numeroDeTrabajadoresNormales() {
        assertEquals(1, Taller().numeroDeTrabajadoresNormales(arrayPersonasTest))
    }
    @Test
    fun numeroNavajasSuizasTest(){
        assertEquals(1, Taller().numeroNavajasSuizas(arrayPersonasTest))
    }


}