package simulacionBandaMusica.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.enums.TipoGuitarra
import simulacionBandaMusica.enums.TipoPercusion
import simulacionBandaMusica.utils.sorteoDatos.randomAnno
import simulacionBandaMusica.utils.sorteoDatos.randomName
import simulacionBandaMusica.utils.sorteoDatos.randomNumCuerdas
import simulacionBandaMusica.utils.sorteoDatos.randomNumTeclas
import simulacionBandaMusica.utils.sorteoDatos.randomPulmonarCapacity
import simulacionBandaMusica.utils.sorteoDatos.randomTipoGuitarra
import simulacionBandaMusica.utils.sorteoDatos.randomTipoPercusion

internal class sorteoDatosTest {
    @Test
    fun randomNameTest() {
        val generateName: String = randomName()
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
        val annoTest: Int = randomAnno()
        if (annoTest < 1 || annoTest > 35) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomPulmonarCapacityTest() {
        val pulomnarTest: Int = randomPulmonarCapacity()
        if (pulomnarTest < 1 || pulomnarTest > 10) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomTipoGuitarraTest() {
        val tipoTest: TipoGuitarra = randomTipoGuitarra()
        if (tipoTest != TipoGuitarra.ACUSTICA && tipoTest != TipoGuitarra.ELECTRICA) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomNumCuerdasTest() {
        val numCuerdas: Int = randomNumCuerdas()
        if (numCuerdas < 1 || numCuerdas > 6) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomNumTeclasTest() {
        val numTeclas: Int = randomNumTeclas()
        if (numTeclas < 35 || numTeclas > 60) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun randomTipoPercusionTest() {
        val tipoTest: TipoPercusion = randomTipoPercusion()
        if (tipoTest != TipoPercusion.TAMBOR
            && tipoTest != TipoPercusion.TIMBAL
            && tipoTest != TipoPercusion.XILOFONO
            && tipoTest != TipoPercusion.CAMPANA
            && tipoTest != TipoPercusion.CROTALOS
            && tipoTest != TipoPercusion.CELESTA
            && tipoTest != TipoPercusion.CAJON
            && tipoTest != TipoPercusion.TRIANGULO
        ) {
            Assertions.fail<Any>()
        }
    }
}