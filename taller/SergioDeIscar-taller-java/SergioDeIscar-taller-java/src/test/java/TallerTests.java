import org.example.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.example.TallerMain.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TallerTests {
    Persona[] personas = new Persona[]{
            new Chapista("pepe", 10, 8),
            new Chapista("pepi", 10, 8),
            new Chapista("pepi", 10, 8),
            new Chapista("pepi", 10, 8),
            new Electricista("pepa", 10, 8),
            new Electricista("pepo", 10, 8),
            new Electricista("pepo", 10, 8),
            new Electricista("pepo", 10, 8),
            new Electricista("pepo", 10, 8)
    };

    @Test
    public void countType_Test(){
        assertAll(
            () -> assertEquals(4, countType(personas, Chapista.class)),
            () -> assertEquals(5, countType(personas, Electricista.class))
        );
    }

    @Test
    public void  findFirstType_Test(){
        assertAll(
            () -> assertEquals("pepe", findFirstType(personas, Chapista.class).getNombre()),
            () -> assertEquals("pepa", findFirstType(personas, Electricista.class).getNombre())
        );
    }

    @Test
    public void calculateNomina_Test(){
        int expected = 1800 * 5 + 1700 * 4;
        assertEquals(expected, calculateNomina(personas));
    }

    @Test
    public void jefeSizeTrabajadores_Test(){
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        JefeTaller jefeMedium = new JefeTaller("JefeMedium", 6);
        JefeTaller jefeBig = new JefeTaller("JefeBig", 16);
        assertAll(
            () -> assertEquals(5, jefeSmall.getSizeTrabajadores()),
            () -> assertEquals(15, jefeMedium.getSizeTrabajadores()),
            () -> assertEquals(25, jefeBig.getSizeTrabajadores())
        );
    }

    //region CRUD
    Chapista chapista = new Chapista("pepe", 7, 5);
    Electricista electricista = new Electricista("pepe", 10, 12);
    @Test
    public void addPersona_Test() throws Exception {
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        for (int i = 0; i < jefeSmall.getSizeTrabajadores(); i++) {
            jefeSmall.addTrabajador(new Chapista("Chapista", 10, 8));
        }
        JefeTaller jefeMedium = new JefeTaller("JefeMedium", 6);
        assertAll(
            () -> assertNull(jefeSmall.addTrabajador(new Chapista("Chapista", 10, 8))),
            () -> assertEquals(chapista, jefeMedium.addTrabajador(chapista)),
            () -> assertEquals(electricista, jefeMedium.addTrabajador(electricista))
        );
    }

    @Test
    public void removeTrabajador_Test() throws Exception {
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        for (int i = 0; i < jefeSmall.getSizeTrabajadores(); i++) {
            jefeSmall.addTrabajador(chapista);
        }
        assertAll(
            () -> assertTrue(jefeSmall.removeTrabajador(0)),
            () -> assertTrue(jefeSmall.removeTrabajador(chapista)),
            () -> assertFalse(jefeSmall.removeTrabajador(0)),
            () -> assertFalse(jefeSmall.removeTrabajador(100)),
            () -> assertFalse(jefeSmall.removeTrabajador(electricista))
        );
    }

    @Test
    public void updateTrabajador_Test() {
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        jefeSmall.addTrabajador(electricista);
        jefeSmall.addTrabajador(chapista);
        assertAll(
                () -> assertTrue(jefeSmall.updateTrabajador(0, new Electricista("pepa", 14, 12))),
                () -> assertTrue(jefeSmall.updateTrabajador(chapista, new Chapista("pepon", 7, 7))),

                () -> assertFalse(jefeSmall.updateTrabajador(100, chapista)),
                () -> assertFalse(jefeSmall.updateTrabajador(electricista, chapista))
        );
    }

    @Test
    public void findTrabajadorIndex_Test(){
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        jefeSmall.addTrabajador(electricista);
        jefeSmall.addTrabajador(chapista);
        assertAll(
                () -> assertEquals(0, jefeSmall.findTrabajadorIndex(electricista)),
                () -> assertEquals(1, jefeSmall.findTrabajadorIndex(chapista)),
                () -> assertEquals(-1, jefeSmall.findTrabajadorIndex(new Electricista("pepa", 14, 12)))
        );
    }

    @Test
    public void exitsTrabajador_Test(){
        JefeTaller jefeSmall = new JefeTaller("JefeSmall", 5);
        jefeSmall.addTrabajador(electricista);
        jefeSmall.addTrabajador(chapista);
        assertAll(
                () -> assertTrue(jefeSmall.exitsTrabajador(electricista)),
                () -> assertTrue(jefeSmall.exitsTrabajador(chapista)),
                () -> assertFalse(jefeSmall.exitsTrabajador(new Electricista("pepa", 14, 12)))
        );
    }
    //endregion
}
