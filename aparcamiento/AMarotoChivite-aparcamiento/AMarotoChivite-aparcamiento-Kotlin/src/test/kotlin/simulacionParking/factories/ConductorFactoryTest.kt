package simulacionParking.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionParking.factories.ConductorFactory.Companion.generacionDNI
import simulacionParking.factories.ConductorFactory.Companion.generarNombre

internal class ConductorFactoryTest {
    @Test
    fun createConductorFactoryTest() {
        val conductorNoNulo = ConductorFactory.create()
        // Conductor no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(conductorNoNulo)
    }

    @Test
    fun generarNombreTest() {
        val generateName: String = generarNombre()
        var contadorCorrecto = 0
        val catalogoNombresCorrectos =
            arrayOf("Pedro", "Alexandra", "Angel", "José", "Elena", "Ricardo", "Domingo", "Patricia")
        for (i in catalogoNombresCorrectos.indices) {
            if (catalogoNombresCorrectos[i].contains(generateName)) {
                Assertions.assertTrue(true)
            } else {
                contadorCorrecto++
            }
        }
        if (contadorCorrecto == 8) {
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
    fun generacionDNITest() {
        val generateDNI: String = generacionDNI()

        // Debe haber 8 números
        var contadorNumeros = 0
        // Debe haber 1 letra
        var contadorLetra = 0
        val alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val numeros = "1234567890"
        for (i in 0 until generateDNI.length) {
            for (j in 0 until numeros.length) {
                if (generateDNI.substring(i, i + 1) == numeros.substring(j, j + 1)) {
                    contadorNumeros++
                }
            }
        }
        for (j in 0 until alfabeto.length) {
            if (contadorNumeros == 9 && generateDNI.substring(9, 10) == alfabeto.substring(j, j + 1)) {
                contadorLetra++
            }
        }
        if (contadorNumeros == 9 && contadorLetra == 1) {
            Assertions.assertTrue(true)
        } else {
            Assertions.fail<Any>()
        }
    }
}