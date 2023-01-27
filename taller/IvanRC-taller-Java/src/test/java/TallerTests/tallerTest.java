package TallerTests;

import modelsTaller.Persona;
import modelsTaller.Taller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tallerTest {

    static Taller taller = new Taller(5);

    @BeforeAll
    public static void setUp(){
        taller.inicializarArray();
        taller.arrayTaller[0] = new Persona.JefeTaller("Iván", 34, 70);
        taller.arrayTaller[1] = new Persona.Trabajador("Roberto", 14, 8);
        taller.arrayTaller[2] = new Persona.Chapista("Manuel", 38, 9);
        taller.arrayTaller[3] = new Persona.Electricista("Nefer", 0, 0);
        taller.arrayTaller[4] = new Persona.NavajaSuiza("Bob", 23, 12);
    }

    @Test
    public void calcularNominaTotalTest(){
        assertEquals((taller.JEFE_TALLER+taller.TRABAJADOR+taller.CHAPISTA+taller.ELECTRICISTA+taller.NAVAJA_SUIZA), taller.calcularNominaTotal());
    }

    @Test
    public void calcularNumeroDeTrabajadoresTest(){
        assertEquals(1, taller.calcularNumeroDeTrabajadores());
    }

    @Test
    public void calcularNumeroDeChapistasTest(){
        assertEquals(1, taller.calcularNumeroDeChapistas());
    }

    @Test
    public void calcularNumeroDeElectricistasTest(){
        assertEquals(1, taller.calcularNumeroDeElectricistas());
    }

    @Test
    public void calcularNumeroDeJefesTallerTest(){
        assertEquals(1, taller.calcularNumeroDeJefesTaller());
    }

    @Test
    public void calcularNumeroDeNavajasSuizasTest(){
        assertEquals(1, taller.calcularNumeroDeTrabajadores());
    }
}
