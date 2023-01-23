package simulacionBandaMusica.models;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.factories.CantanteFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MusicoTest {

    @Test
    void interpretarTest() {
        Cantante cantante = CantanteFactory.create();
        String correctString = "Estoy interpretando con mi " + cantante.instrumento;
        assertEquals(correctString, cantante.interpretar());

    }
}