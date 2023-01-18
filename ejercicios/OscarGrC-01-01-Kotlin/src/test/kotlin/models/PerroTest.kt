package models

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class PerroTest {

    @Test
    fun vacunarTest() {
        val miPerroTest= Perro()
        miPerroTest.nombre="Firulais"
        miPerroTest.raza="Labrador"
        assertEquals(miPerroTest.vacunar(),"Firulais el Labrador esta en el veterinario. Siendo vacunado.")
    }

    @Test
    fun comer() {
        val miPerroTest= Perro()
        miPerroTest.nombre="Firulais"
        miPerroTest.raza="Labrador"
        assertEquals(miPerroTest.comer(),"Firulais el Labrador esta comiendo")
    }

    @Test
    fun dormir() {
        val miPerroTest= Perro()
        miPerroTest.nombre="Firulais"
        miPerroTest.raza="Labrador"
        assertEquals(miPerroTest.dormir(),"Firulais el Labrador esta durmiendo")
    }

    @Test
    fun salirPaseo() {
        val miPerroTest= Perro()
        miPerroTest.nombre="Firulais"
        assertEquals(miPerroTest.salirPaseo(),"Firulais esta paseando")
    }

    @Test
    fun testToString() {
        val miPerroTest= Perro()
        miPerroTest.nombre="Firulais"
        miPerroTest.raza="Labrador"
        miPerroTest.peso=15
        miPerroTest.color="Negro"
        assertEquals(miPerroTest.toString(),"Nombre=Firulais, Raza=Labrador, Peso=15, Color=Negro.")
    }
}