package Taller.Test

import Taller.factories.PersonaFactory
import Taller.models.Taller
import Taller.models.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class TallerTest {

    val personalDelTallerTest = Array(7){Array(1) { PersonaFactory.getInstance().crearPersona()} }

    @BeforeEach
    fun setUp(){
        personalDelTallerTest[0] = arrayOf(JefeDeTaller("LeBron", 15))
        personalDelTallerTest[1] = arrayOf(Trabajador(5, "Brown", 1 ))
        personalDelTallerTest[2] = arrayOf(Chapista(11, "Marcus", 7))
        personalDelTallerTest[3] = arrayOf(Electricista(1, "Bol", 3))
        personalDelTallerTest[4] = arrayOf(NavajaSuiza(3, "Thors", 5))
        personalDelTallerTest[5] = arrayOf(NavajaSuiza(5, "Einar", 2))
        personalDelTallerTest[6] = arrayOf(JefeDeTaller("Kevin", 9))

    }

    @Test
    fun calcularSalariosTest() {
        assertEquals(13000 , Taller().calcularSalarios(personalDelTallerTest))
    }

    @Test
    fun isNavajaTest() {
        var eleccion = 1
        assertEquals(false, Taller().isNavaja(eleccion, personalDelTallerTest))
        eleccion = 5
        assertEquals(true, Taller().isNavaja(eleccion, personalDelTallerTest))

    }
    @Test
    fun isChapistaTest() {
        var eleccion = 2
        assertEquals(false, Taller().isChapista(eleccion, personalDelTallerTest))
        eleccion = 3
        assertEquals(true, Taller().isChapista(eleccion, personalDelTallerTest))

    }
    @Test
    fun isElectricistaTest() {
        var eleccion = 4
        assertEquals(true, Taller().isElectricista(eleccion, personalDelTallerTest))
        eleccion = 5
        assertEquals(false, Taller().isElectricista(eleccion, personalDelTallerTest))

    }
    @Test
    fun isTrabajadorTest() {
        var eleccion = 2
        assertEquals(true, Taller().isTrabajador(eleccion, personalDelTallerTest))
        eleccion = 1
        assertEquals(false, Taller().isTrabajador(eleccion, personalDelTallerTest))

    }
    @Test
    fun isJefeTest() {
        var eleccion = 1
        assertEquals(true, Taller().isJefe(eleccion, personalDelTallerTest))
        eleccion = 2
        assertEquals(false, Taller().isJefe(eleccion, personalDelTallerTest))

    }


    @Test
    fun numeroTrabajadoresNormalesTest() {
        assertEquals(5, Taller().numeroTrabajadoresNormales(personalDelTallerTest))
    }

    @Test
    fun numeroElectricistasTest() {
        assertEquals(1, Taller().numeroElectricistas(personalDelTallerTest))
    }

    @Test
    fun numeroChapistasTest() {
        assertEquals(2, Taller().numeroChapistas(personalDelTallerTest))
    }

    @Test
    fun numeroJefesTest() {
        assertEquals(2, Taller().numeroJefes(personalDelTallerTest))
    }

    @Test
    fun numeroNavajasTest() {
        assertEquals(2, Taller().numeroNavajas(personalDelTallerTest))
    }
}