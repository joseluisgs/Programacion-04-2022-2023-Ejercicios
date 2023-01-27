package simulacionBandaMusica.models;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.factories.CantanteFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CantanteTest {

    @Test
    void respirarCantanteTest() {
        Cantante cantanteTest = CantanteFactory.create();
        String correctMessage = "Estoy respirando como cantante con una capacidad pulmonar de " + cantanteTest.capacidadPulomar;
        assertEquals(correctMessage, cantanteTest.respirarCantante());
    }

}