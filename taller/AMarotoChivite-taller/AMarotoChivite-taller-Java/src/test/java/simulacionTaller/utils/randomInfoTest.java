package simulacionTaller.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionTaller.utils.randomInfo.*;

class randomInfoTest {

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
        for (int i = 0; i < 20; i++) {
            int annoTest = randomAnno();
            if (annoTest < 1 || annoTest > 35) {
                fail();
            }
        }
    }

    @Test
    void randomSalaryTest() {
        for (int i = 0; i < 20; i++) {
            int annoTest = randomSalary();
            if (annoTest < 1350 || annoTest > 1565) {
                fail();
            }
        }
    }

    @Test
    void randomDailyHoursTest() {
        for (int i = 0; i < 20; i++) {
            int dailyHoursTest = randomDailyHours();
            if (!(dailyHoursTest == 35) && !(dailyHoursTest == 40) && !(dailyHoursTest == 30)) {
                fail();
            }
        }
    }
}