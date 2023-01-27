package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Percusionista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PercusionistaFactoryTest {

    @Test
    void createPercusionistaTest() {
        Percusionista Percusionista = PercusionistaFactory.create();
        // Percusionista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Percusionista);
    }
}