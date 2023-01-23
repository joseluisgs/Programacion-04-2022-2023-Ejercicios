package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Trompetista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrompetistaFactoryTest {

    @Test
    void createTrompetistaTest() {
        Trompetista Trompetista = TrompetistaFactory.create();
        // Trompetista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Trompetista);
    }
}