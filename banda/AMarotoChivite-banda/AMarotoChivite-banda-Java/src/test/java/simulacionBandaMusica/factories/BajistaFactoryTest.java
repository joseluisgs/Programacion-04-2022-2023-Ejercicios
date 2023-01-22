package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Bajista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BajistaFactoryTest {

    @Test
    void createBajistaTest() {
        Bajista Bajista = BajistaFactory.create();
        // Bajista no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Bajista);
    }
}