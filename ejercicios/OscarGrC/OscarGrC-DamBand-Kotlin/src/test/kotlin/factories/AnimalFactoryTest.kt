package factories

import models.TipoAnimal
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AnimalFactoryTest {

    @Test
    fun getRandomPerroTest() {
        assertAll(
            {assertNotEquals(AnimalFactory.getInstance().getRandomPerro().nombre,"")},
            {assertNotEquals(AnimalFactory.getInstance().getRandomPerro().raza,"")},
            {assertNotEquals(AnimalFactory.getInstance().getRandomPerro().peso,0)},
            {assertNotEquals(AnimalFactory.getInstance().getRandomPerro().color,"")},
            {assertEquals(AnimalFactory.getInstance().getRandomPerro().tipoAnimal,TipoAnimal.Perro)}
        )
    }

    @Test
    fun getRandomGato() {
        assertAll(
            {assertNotEquals(AnimalFactory.getInstance().getRandomGato().nombre,"")},
            {assertNotEquals(AnimalFactory.getInstance().getRandomGato().raza,"")},
            {assertNotEquals(AnimalFactory.getInstance().getRandomGato().peso,0)},
            {assertNotEquals(AnimalFactory.getInstance().getRandomGato().color,"")},
            {assertEquals(AnimalFactory.getInstance().getRandomGato().tipoAnimal,TipoAnimal.Gato)}
        )
    }
}