package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Guitarrista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GuitarristaFactoryTest {

    @Test
    void createGuitarristaTest() {
        Guitarrista Guitarrista = GuitarristaFactory.create();
        // Guitarrista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Guitarrista);
    }
}