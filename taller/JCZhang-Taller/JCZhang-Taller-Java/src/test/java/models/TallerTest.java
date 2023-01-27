package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TallerTest {

    Persona[] arrayPersonasTest = new Persona[6];
    Taller tallerTest = new Taller();

    @BeforeEach
    void setUp() {
        arrayPersonasTest[0] = new JefeTaller("pablo", 2);
        arrayPersonasTest[1] = new JefeTaller("Juana", 5);
        arrayPersonasTest[2] = new Electricista("Pepe", 2, 4);
        arrayPersonasTest[3] = new Chapista("Juan", 4, 6);
        arrayPersonasTest[4] = new Trabajador("Ramon", 6, 8);
        arrayPersonasTest[5] = new NavajaSuiza("Paco", 7,12);
        tallerTest.numeroDeTrabajadoresNormales(arrayPersonasTest);
    }

    @Test
    void numeroJefeTallerTest() {
        assertEquals(2, tallerTest.numeroJefeTaller(arrayPersonasTest));
    }

    @Test
    void numeroDeElectricistasTest() {
        assertEquals(1, tallerTest.numeroDeElectricistas(arrayPersonasTest));
    }

    @Test
    void numeroDeChapistasTest() {
        assertEquals(1, tallerTest.numeroDeChapistas(arrayPersonasTest));

    }

    @Test
    void numeroDeTrabajadoresNormalesTest() {

        assertEquals(1, tallerTest.numeroDeTrabajadoresNormales(arrayPersonasTest));
    }

    @Test
    void numeroNavajasSuizasTest() {
        assertEquals(1, tallerTest.numeroNavajasSuizas(arrayPersonasTest));

    }
}
