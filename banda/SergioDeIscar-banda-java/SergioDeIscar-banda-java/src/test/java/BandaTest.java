import org.example.enums.GuitarraType;
import org.example.enums.PercussionType;
import org.example.enums.TonoType;
import org.example.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.example.BandaMain.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BandaTest {
    Musician[] musicians = {
        new Bajista("Pepe", 15, 4),
        new Bajista("Pepe2", 15, 4),
        new Cantante("Pepo", 15, TonoType.BARITONO),
        new CantanteGuitarrista("Pepa", 15, TonoType.BARITONO, GuitarraType.FLAMENCA),
        new Guitarrista("Pepi", 15, GuitarraType.FLAMENCA),
        new Multinstrumentista("Pepu", 15, 4,
                PercussionType.ALTURA_INDETERMINADA, 4),
        new Percusionista("Pepo", 15, PercussionType.ALTURA_INDETERMINADA),
        new Teclista("Pepa", 15, 4),
        new Trompetista("Pepi", 15, 4)
    };

    @Test
    public void countType_Test() {
        assertAll(
            () -> assertEquals(2, countType(musicians, Bajista.class)),
            () -> assertEquals(1, countType(musicians, Cantante.class)),
            () -> assertEquals(1, countType(musicians, CantanteGuitarrista.class)),
            () -> assertEquals(1, countType(musicians, Guitarrista.class)),
            () -> assertEquals(1, countType(musicians, Multinstrumentista.class)),
            () -> assertEquals(1, countType(musicians, Percusionista.class)),
            () -> assertEquals(1, countType(musicians, Teclista.class)),
            () -> assertEquals(1, countType(musicians, Trompetista.class))
        );
    }

    @Test
    public void findFist_Test() {
        assertAll(
            () -> assertEquals("Pepe", findFirstType(musicians, Bajista.class).getNombre()),
            () -> assertEquals("Pepo", findFirstType(musicians, Cantante.class).getNombre()),
            () -> assertEquals("Pepa", findFirstType(musicians, CantanteGuitarrista.class).getNombre()),
            () -> assertEquals("Pepi", findFirstType(musicians, Guitarrista.class).getNombre()),
            () -> assertEquals("Pepu", findFirstType(musicians, Multinstrumentista.class).getNombre()),
            () -> assertEquals("Pepo", findFirstType(musicians, Percusionista.class).getNombre()),
            () -> assertEquals("Pepa", findFirstType(musicians, Teclista.class).getNombre()),
            () -> assertEquals("Pepi", findFirstType(musicians, Trompetista.class).getNombre())
        );
    }

    @Test
    public void calculateNomina_Test(){
        float expected = (1500.0f * 1.3f) * 2 +    // Bajista
                1500.0f * 1.4f +                        // Cantante
                1500.0f * 1.5f +                        // CantanteGuitarist
                1500.0f * 1.35f +                       // Guitarrista
                1500.0f * 1.45f +                       // Multinstrumentista
                1500.0f * 1.35f +                       // Percusionista
                1500.0f * 1.3f +                        // Teclista
                1500.0f * 1.2f;                         // Trompetista
        assertEquals(expected, calculateNomina(musicians));
    }
}
