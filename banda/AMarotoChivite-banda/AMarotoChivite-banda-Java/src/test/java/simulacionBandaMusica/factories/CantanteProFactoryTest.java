package simulacionBandaMusica.factories;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.models.CantantePro;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CantanteProFactoryTest {

    @Test
    void createCantanteProTest() {
        CantantePro CantantePro = CantanteProFactory.create();
        // CantantePro no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(CantantePro);
    }
}