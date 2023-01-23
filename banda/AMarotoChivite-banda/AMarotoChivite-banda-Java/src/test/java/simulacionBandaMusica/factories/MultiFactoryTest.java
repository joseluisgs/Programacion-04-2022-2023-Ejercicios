package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.MultiInstrumentista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MultiFactoryTest {

    @Test
    void createMultiTest() {
        MultiInstrumentista multi = MultiFactory.create();
        // MultiInstrumentista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(multi);
    }
}