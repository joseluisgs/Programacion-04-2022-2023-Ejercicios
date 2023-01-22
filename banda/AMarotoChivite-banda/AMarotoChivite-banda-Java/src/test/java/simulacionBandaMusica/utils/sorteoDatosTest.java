package simulacionBandaMusica.utils;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.enums.TipoGuitarra;
import simulacionBandaMusica.enums.TipoPercusion;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionBandaMusica.utils.sorteoDatos.*;

class sorteoDatosTest {

    @Test
    void randomNameTest() {
        String generateName = randomName();

        int contadorCorrecto = 0;
        String[] catalogoNombresCorrectos = {
                "Pedro", "Alexandra", "Angel", "José",
                "Elena", "Ricardo", "Domingo", "Patricia",
                "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
                "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
        };
        for (int i = 0; i < catalogoNombresCorrectos.length; i++) {
            if (catalogoNombresCorrectos[i].contains(generateName)) {
                assertTrue(true);
            } else {
                contadorCorrecto++;
            }
        }
        if (contadorCorrecto == 24) {
            fail();
        }

        int contadorIncorrecto = 0;
        String[] catalogoNombresIncorrectos = {"123", "...", ",", "??", "hola", "no es nombre", " ", "ç"};
        for (int i = 0; i < catalogoNombresIncorrectos.length; i++) {
            if (!catalogoNombresIncorrectos[i].contains(generateName)) {
                assertFalse(false);
                contadorIncorrecto++;
            }
        }
        if (contadorIncorrecto != 8) {
            fail();
        }
    }

    @Test
    void randomAnnoTest() {
        int annoTest = randomAnno();
        if (annoTest < 1 || annoTest > 35) {
            fail();
        }
    }

    @Test
    void randomPulmonarCapacityTest() {
        int pulomnarTest = randomPulmonarCapacity();
        if (pulomnarTest < 1 || pulomnarTest > 10) {
            fail();
        }
    }

    @Test
    void randomTipoGuitarraTest() {
        TipoGuitarra tipoTest = randomTipoGuitarra();
        if (!tipoTest.equals(TipoGuitarra.ACUSTICA) && !tipoTest.equals(TipoGuitarra.ELECTRICA)) {
            fail();
        }
    }

    @Test
    void randomNumCuerdasTest() {
        int numCuerdas = randomNumCuerdas();
        if (numCuerdas < 1 || numCuerdas > 6) {
            fail();
        }
    }

    @Test
    void randomNumTeclasTest() {
        int numTeclas = randomNumTeclas();
        if (numTeclas < 35 || numTeclas > 60) {
            fail();
        }
    }

    @Test
    void randomTipoPercusionTest() {
        TipoPercusion tipoTest = randomTipoPercusion();
        if (!tipoTest.equals(TipoPercusion.TAMBOR)
                && !tipoTest.equals(TipoPercusion.TIMBAL)
                && !tipoTest.equals(TipoPercusion.XILOFONO)
                && !tipoTest.equals(TipoPercusion.CAMPANA)
                && !tipoTest.equals(TipoPercusion.CROTALOS)
                && !tipoTest.equals(TipoPercusion.CELESTA)
                && !tipoTest.equals(TipoPercusion.CAJON)
                && !tipoTest.equals(TipoPercusion.TRIANGULO)) {
            fail();
        }
    }
}