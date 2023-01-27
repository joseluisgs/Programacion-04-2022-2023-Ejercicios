package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Teclista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TeclistaFactoryTest {

    @Test
    void createTeclistaaTest() {
        Teclista Teclista = TeclistaFactory.create();
        // Teclista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Teclista);
    }
}