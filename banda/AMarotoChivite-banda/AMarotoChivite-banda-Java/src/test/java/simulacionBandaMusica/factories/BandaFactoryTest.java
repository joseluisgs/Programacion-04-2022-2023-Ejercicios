package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Banda;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BandaFactoryTest {

    @Test
    void createBandaTest() {
        Banda banda = BandaFactory.create();
        // Banda no nulo, para ver si se han asignado correctamente los datos
        for (int i = 0; i < banda.vectorMusicos().length; i++) {
            assertNotNull(banda.vectorMusicos()[i]);
        }
    }
}