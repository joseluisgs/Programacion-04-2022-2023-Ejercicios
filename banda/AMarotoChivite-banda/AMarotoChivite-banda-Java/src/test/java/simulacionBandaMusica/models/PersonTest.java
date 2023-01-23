package simulacionBandaMusica.models;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.factories.CantanteFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void respirarTest() {
        Cantante cantanteTest = CantanteFactory.create();
        String correctString = "Estoy respirando...";
        assertEquals(correctString, cantanteTest.respirar());
    }
}