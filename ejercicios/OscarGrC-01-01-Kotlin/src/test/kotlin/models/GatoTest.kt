package models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GatoTest {

    @Test
    fun vacunar() {
        val miGatoTest= Gato()
        miGatoTest.nombre="Mirmidon"
        miGatoTest.raza="Siames"
        assertEquals(miGatoTest.vacunar(),"Mirmidon el Siames esta en el veterinario. Siendo vacunado.")
    }

    @Test
    fun comer() {
        val miGatoTest= Gato()
        miGatoTest.nombre="Mirmidon"
        miGatoTest.raza="Siames"
        assertEquals(miGatoTest.comer(),"Mirmidon el Siames esta comiendo")
    }

    @Test
    fun dormir() {
        val miGatoTest= Gato()
        miGatoTest.nombre="Mirmidon"
        miGatoTest.raza="Siames"
        assertEquals(miGatoTest.dormir(),"Mirmidon el Siames esta durmiendo")
    }

    @Test
    fun toserBolaPelo() {
        val miGatoTest= Gato()
        miGatoTest.nombre="Mirmidon"

        assertEquals(miGatoTest.toserBolaPelo(),"Mirmidon escupio una bola de pelo \n No parece muy efectivo ")
    }

    @Test
    fun testToString() {
        val miGatoTest= Perro()
        miGatoTest.nombre="Mirmidon"
        miGatoTest.raza="Siames"
        miGatoTest.peso=4
        miGatoTest.color="Negro"
        assertEquals(miGatoTest.toString(),"Nombre=Mirmidon, Raza=Siames, Peso=4, Color=Negro.")
    }
}