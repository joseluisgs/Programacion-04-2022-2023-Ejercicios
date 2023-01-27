package simulacionBandaMusica.models;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.factories.TrompetistaFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrompetistaTest {

    @Test
    void respirarTrompetista() {
        Trompetista trompetistaTest = TrompetistaFactory.create();
        String correctoString = "Estoy respirando como trompetista con una capacidad pulmonar de " + trompetistaTest.capacidadPulomar;
        assertEquals(correctoString, trompetistaTest.respirarTrompetista());
    }
}