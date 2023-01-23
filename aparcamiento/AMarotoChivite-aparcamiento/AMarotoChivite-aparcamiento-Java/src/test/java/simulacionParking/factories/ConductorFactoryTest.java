package simulacionParking.factories;

import simulacionParking.models.Conductor;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionParking.factories.ConductorFactory.generacionDNI;
import static simulacionParking.factories.ConductorFactory.generarNombre;

class ConductorFactoryTest {

    @org.junit.jupiter.api.Test
    void createConductorFactoryTest() {
        Conductor conductorNoNulo = ConductorFactory.create();
        // Conductor no nulo, para ver si se han asignado correctamente los datos
        assertNotNull(conductorNoNulo);
    }

    @org.junit.jupiter.api.Test
    void generarNombreTest() {
        String generateName = generarNombre();

        int contadorCorrecto = 0;
        String[] catalogoNombresCorrectos = {"Pedro", "Alexandra", "Angel", "José", "Elena", "Ricardo", "Domingo", "Patricia"};
        for (int i = 0; i < catalogoNombresCorrectos.length; i++) {
            if (catalogoNombresCorrectos[i].contains(generateName)) {
                assertTrue(true);
            } else {
                contadorCorrecto++;
            }
        }
        if (contadorCorrecto == 8) {
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

    @org.junit.jupiter.api.Test
    void generacionDNITest() {
        String generateDNI = generacionDNI();

        // Debe haber 8 números
        int contadorNumeros = 0;
        // Debe haber 1 letra
        int contadorLetra = 0;

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";

        for (int i = 0; i < generateDNI.length(); i++) {
            for (int j = 0; j < numeros.length(); j++) {
                if (generateDNI.substring(i, (i + 1)).equals(numeros.substring(j, (j + 1)))) {
                    contadorNumeros++;
                }
            }
        }
        for (int j = 0; j < alfabeto.length(); j++) {
            if (contadorNumeros == 9
                    && generateDNI.substring(9, 10).equals(alfabeto.substring(j, (j + 1)))) {
                contadorLetra++;
            }
        }

        if (contadorNumeros == 9 && contadorLetra == 1) {
            assertTrue(true);
        } else {
            fail();
        }
    }
}