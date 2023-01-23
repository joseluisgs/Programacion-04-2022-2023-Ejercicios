package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.Cantante;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CantanteFactoryTest {

    @Test
    void createCantanteTest() {
        Cantante Cantante = CantanteFactory.create();
        // Cantante no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(Cantante);
    }
}