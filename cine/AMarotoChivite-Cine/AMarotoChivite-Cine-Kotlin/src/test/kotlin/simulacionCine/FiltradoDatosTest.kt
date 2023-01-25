package simulacionCine

import org.junit.jupiter.api.Test
import simulacionCine.models.Pelicula
import simulacionCine.models.Sala
import simulacionCine.utils.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class FiltradoDatosTest {
    @Test
    fun filtroMaxLetrasTest() {
        val cadenasValidasUno = "abc"
        val cadenasValidasDos = "abcde"
        val cadenasValidasTres = "abcdefghijklmnopqrst"
        val cadenasInvalidasUno = "1"
        val cadenasInvalidasDos = "abcd5"
        val cadenasInvalidasTres = "---"
        assertTrue(filtroMaxLetras(cadenasValidasUno))
        assertTrue(filtroMaxLetras(cadenasValidasDos))
        assertTrue(filtroMaxLetras(cadenasValidasTres))
        assertFalse(filtroMaxLetras(cadenasInvalidasUno))
        assertFalse(filtroMaxLetras(cadenasInvalidasDos))
        assertFalse(filtroMaxLetras(cadenasInvalidasTres))
    }

    @Test
    fun filtroTarjetaCreditoTest() {
        val cadenasValidasUno = "1234567890123456"
        val cadenasInvalidasUno = "123456789012345"
        val cadenasInvalidasDos = "abcdefghijklmnño"
        val cadenasInvalidasTres = "---"
        assertTrue(filtroTarjetaCredito(cadenasValidasUno))
        assertFalse(filtroTarjetaCredito(cadenasInvalidasUno))
        assertFalse(filtroTarjetaCredito(cadenasInvalidasDos))
        assertFalse(filtroTarjetaCredito(cadenasInvalidasTres))
    }

    @Test
    fun filtroEmailTest() {
        val cadenasValidasUno = "xxx@xx.xx"
        val cadenasInvalidasUno = "xxx@xx"
        val cadenasInvalidasDos = "xxxxx"
        val cadenasInvalidasTres = "xxxxx.xx"
        assertTrue(filtroEmail(cadenasValidasUno))
        assertFalse(filtroEmail(cadenasInvalidasUno))
        assertFalse(filtroEmail(cadenasInvalidasDos))
        assertFalse(filtroEmail(cadenasInvalidasTres))
    }

    @Test
    fun filtroTelefonoTest() {
        val cadenasValidasUno = "665808210"
        val cadenasInvalidasUno = "66580821"
        val cadenasInvalidasDos = "66580821a"
        val cadenasInvalidasTres = "m6658082a"
        val cadenasInvalidasCuatro = "abcd"
        assertTrue(filtroTelefono(cadenasValidasUno))
        assertFalse(filtroTelefono(cadenasInvalidasUno))
        assertFalse(filtroTelefono(cadenasInvalidasDos))
        assertFalse(filtroTelefono(cadenasInvalidasTres))
        assertFalse(filtroTelefono(cadenasInvalidasCuatro))
    }

    @Test
    fun filtroDNITest() {
        val cadenasValidasUno = "47310216K"
        val cadenasValidasDos = "47310216k"
        val cadenasInvalidasUno = "47310216"
        val cadenasInvalidasDos = "7310216K"
        val cadenasInvalidasTres = "abcd"
        assertTrue(filtroDNI(cadenasValidasUno))
        assertTrue(filtroDNI(cadenasValidasDos))
        assertFalse(filtroDNI(cadenasInvalidasUno))
        assertFalse(filtroDNI(cadenasInvalidasDos))
        assertFalse(filtroDNI(cadenasInvalidasTres))
    }

    @Test
    fun filtroCantidadEntradasTest() {
        val tamannoMaxButacas = 6 * 6
        val cadenasValidasUno = "1"
        val cadenasValidasDos = Integer.toString(tamannoMaxButacas)
        val cadenasInvalidasUno = Integer.toString(tamannoMaxButacas + 1)
        val cadenasInvalidasDos = "0"
        val cadenasInvalidasTres = "abcd"
        assertTrue(filtroCantidadEntradas(cadenasValidasUno, tamannoMaxButacas))
        assertTrue(filtroCantidadEntradas(cadenasValidasDos, tamannoMaxButacas))
        assertFalse(filtroCantidadEntradas(cadenasInvalidasUno, tamannoMaxButacas))
        assertFalse(filtroCantidadEntradas(cadenasInvalidasDos, tamannoMaxButacas))
        assertFalse(filtroCantidadEntradas(cadenasInvalidasTres, tamannoMaxButacas))
    }

    @Test
    fun filtradoButacasTest() {
        val peliTest = Pelicula("Avatar 2", "2022", "James Cameron", "Science Fiction")
        val cineTest: Array<Sala> = arrayOf(Sala("001", "Sala 1", peliTest, 3, 3, 2))
        val cadenasValidasUno = "A1"
        val cadenasValidasDos = "B2"
        val cadenasInvalidasUno = "A2"
        cineTest[0].ocuparButaca(cadenasInvalidasUno)
        val cadenasInvalidasDos = "A3"
        cineTest[0].reservarButaca(cadenasInvalidasDos)
        val cadenasInvalidasTres = "A0"
        val cadenasInvalidasCuatro = "A4"
        val cadenasInvalidasCinco = "D1"
        val cadenasInvalidasSeis = "1A"
        val cadenasInvalidasSiete = "AS"
        val cadenasInvalidasOcho = "--"
        val cadenasInvalidasNueve = "12"
        assertTrue(filtradoButacas(cineTest, "001", cadenasValidasUno))
        assertTrue(filtradoButacas(cineTest, "001", cadenasValidasDos))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasUno)) //debe ser assertFalse
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasDos)) //debe ser assertFalse
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasTres))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasCuatro))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasCinco))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasSeis))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasSiete))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasOcho))
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasNueve))
    }
}