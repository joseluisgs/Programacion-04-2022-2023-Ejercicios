package simulacionTaller.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class randomInfoTest {
    @Test
    fun randomNameTest() {
        val generateName = randomName()
        var contadorCorrecto = 0
        val catalogoNombresCorrectos = arrayOf(
            "Pedro", "Alexandra", "Angel", "José",
            "Elena", "Ricardo", "Domingo", "Patricia",
            "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
            "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
        )
        for (i in catalogoNombresCorrectos.indices) {
            if (catalogoNombresCorrectos[i].contains(generateName)) {
                Assertions.assertTrue(true)
            } else {
                contadorCorrecto++
            }
        }
        if (contadorCorrecto == 24) {
            Assertions.fail<Any>()
        }
        var contadorIncorrecto = 0
        val catalogoNombresIncorrectos = arrayOf("123", "...", ",", "??", "hola", "no es nombre", " ", "ç")
        for (i in catalogoNombresIncorrectos.indices) {
            if (!catalogoNombresIncorrectos[i].contains(generateName)) {
                Assertions.assertFalse(false)
                contadorIncorrecto++
            }
        }
        if (contadorIncorrecto != 8) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomAnnoTest() {
        for (i in 0..19) {
            val annoTest = randomAnno()
            if (annoTest < 1 || annoTest > 35) {
                Assertions.fail<Any>()
            }
        }
    }

    @Test
    fun randomSalaryTest() {
        for (i in 0..19) {
            val annoTest = randomSalary()
            if (annoTest < 1350 || annoTest > 1565) {
                Assertions.fail<Any>()
            }
        }
    }

    @Test
    fun randomDailyHoursTest() {
        for (i in 0..19) {
            val dailyHoursTest = randomDailyHours()
            if (dailyHoursTest != 35 && dailyHoursTest != 40 && dailyHoursTest != 30) {
                Assertions.fail<Any>()
            }
        }
    }
}