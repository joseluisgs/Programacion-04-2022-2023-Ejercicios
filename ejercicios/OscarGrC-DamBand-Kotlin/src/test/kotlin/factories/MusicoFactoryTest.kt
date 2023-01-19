package factories

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MusicoFactoryTest {

    @Test
    fun getCantante() {
        val cantanteTest = MusicoFactory.getInstance().getCantante()
        assertAll(
            {assertEquals(cantanteTest.sueldo,2100)},
            {assertEquals(cantanteTest.sueldoBase,1500)},
            {assertEquals(cantanteTest.titulo,"Cantante")},
            {assertNotEquals(cantanteTest.experiencia,0)},
            {assertNotEquals(cantanteTest.nombre,"")},
            )
    }

    @Test
    fun getGuitarrista() {
        val guitarrista = MusicoFactory.getInstance().getGuitarrista()
        assertAll(
            {assertEquals(guitarrista.sueldo,1950)},
            {assertEquals(guitarrista.sueldoBase,1500)},
            {assertEquals(guitarrista.titulo,"Guitarrista")},
            {assertNotEquals(guitarrista.experiencia,0)},
            {assertNotEquals(guitarrista.nombre,"")},
        )
    }

    @Test
    fun getBajista() {
        val bajistaTest = MusicoFactory.getInstance().getBajista()
        assertAll(
            {assertEquals(bajistaTest.sueldo,1950)},
            {assertEquals(bajistaTest.sueldoBase,1500)},
            {assertEquals(bajistaTest.titulo,"Bajista")},
            {assertNotEquals(bajistaTest.experiencia,0)},
            {assertNotEquals(bajistaTest.nombre,"")},
        )
    }

    @Test
    fun getTeclista() {
        val teclistaTest = MusicoFactory.getInstance().getTeclista()
        assertAll(
            {assertEquals(teclistaTest.sueldo,1950)},
            {assertEquals(teclistaTest.sueldoBase,1500)},
            {assertEquals(teclistaTest.titulo,"Teclista")},
            {assertNotEquals(teclistaTest.experiencia,0)},
            {assertNotEquals(teclistaTest.nombre,"")},
        )
    }

    @Test

    fun getPercusionista() {
        val percusionistaTest = MusicoFactory.getInstance().getPercusionista()
        assertAll(
            {assertEquals(percusionistaTest.sueldo,2025)},
            {assertEquals(percusionistaTest.sueldoBase,1500)},
            {assertEquals(percusionistaTest.titulo,"Percusionista")},
            {assertNotEquals(percusionistaTest.experiencia,0)},
            {assertNotEquals(percusionistaTest.nombre,"")},
        )
    }

    @Test
    fun getTrompetista() {
        val trompetistaTest = MusicoFactory.getInstance().getTrompetista()
        assertAll(
            {assertEquals(trompetistaTest.sueldo,1800)},
            {assertEquals(trompetistaTest.sueldoBase,1500)},
            {assertEquals(trompetistaTest.titulo,"Trompetista")},
            {assertNotEquals(trompetistaTest.experiencia,0)},
            {assertNotEquals(trompetistaTest.nombre,"")},
        )
    }

    @Test
    fun getCantanteGuitarrista() {
        val cantanteGuitarristaTest = MusicoFactory.getInstance().getCantanteGuitarrista()
        assertAll(
            {assertEquals(cantanteGuitarristaTest.sueldo,2100)},
            {assertEquals(cantanteGuitarristaTest.sueldoBase,1500)},
            {assertEquals(cantanteGuitarristaTest.titulo,"Cantante y guitarrista")},
            {assertNotEquals(cantanteGuitarristaTest.experiencia,0)},
            {assertNotEquals(cantanteGuitarristaTest.nombre,"")},
        )
    }

    @Test
    fun getMultinstrumental() {
        val multimusicoTest = MusicoFactory.getInstance().getMultinstrumental()
        assertAll(
            {assertEquals(multimusicoTest.sueldo,2175)},
            {assertEquals(multimusicoTest.sueldoBase,1500)},
            {assertEquals(multimusicoTest.titulo,"Guitarrista, bajista y percusionista")},
            {assertNotEquals(multimusicoTest.experiencia,0)},
            {assertNotEquals(multimusicoTest.nombre,"")},
        )
    }

    @Test
    fun getBandaRandom() {
        val bandaTest = MusicoFactory.getInstance().getBandaRandom(50)
            assertEquals(bandaTest.size,50)

    }
}