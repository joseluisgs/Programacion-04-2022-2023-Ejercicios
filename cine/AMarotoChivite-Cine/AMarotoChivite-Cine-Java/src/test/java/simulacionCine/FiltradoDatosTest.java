package simulacionCine;

import org.junit.jupiter.api.Test;
import simulacionCine.models.Pelicula;
import simulacionCine.models.Sala;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static simulacionCine.utils.filtradoDatos.*;

class FiltradoDatosTest {

    @Test
    void filtroMaxLetrasTest() {
        String cadenasValidasUno = "abc";
        String cadenasValidasDos = "abcde";
        String cadenasValidasTres = "abcdefghijklmnopqrst";
        String cadenasInvalidasUno = "1";
        String cadenasInvalidasDos = "abcd5";
        String cadenasInvalidasTres = "---";

        assertTrue(filtroMaxLetras(cadenasValidasUno));
        assertTrue(filtroMaxLetras(cadenasValidasDos));
        assertTrue(filtroMaxLetras(cadenasValidasTres));
        assertFalse(filtroMaxLetras(cadenasInvalidasUno));
        assertFalse(filtroMaxLetras(cadenasInvalidasDos));
        assertFalse(filtroMaxLetras(cadenasInvalidasTres));
    }

    @Test
    void filtroTarjetaCreditoTest() {
        String cadenasValidasUno = "1234567890123456";
        String cadenasInvalidasUno = "123456789012345";
        String cadenasInvalidasDos = "abcdefghijklmnño";
        String cadenasInvalidasTres = "---";

        assertTrue(filtroTarjetaCredito(cadenasValidasUno));
        assertFalse(filtroTarjetaCredito(cadenasInvalidasUno));
        assertFalse(filtroTarjetaCredito(cadenasInvalidasDos));
        assertFalse(filtroTarjetaCredito(cadenasInvalidasTres));
    }

    @Test
    void filtroEmailTest() {
        String cadenasValidasUno = "xxx@xx.xx";
        String cadenasInvalidasUno = "xxx@xx";
        String cadenasInvalidasDos = "xxxxx";
        String cadenasInvalidasTres = "xxxxx.xx";

        assertTrue(filtroEmail(cadenasValidasUno));
        assertFalse(filtroEmail(cadenasInvalidasUno));
        assertFalse(filtroEmail(cadenasInvalidasDos));
        assertFalse(filtroEmail(cadenasInvalidasTres));
    }

    @Test
    void filtroTelefonoTest() {
        String cadenasValidasUno = "665808210";
        String cadenasInvalidasUno = "66580821";
        String cadenasInvalidasDos = "66580821a";
        String cadenasInvalidasTres = "m6658082a";
        String cadenasInvalidasCuatro = "abcd";

        assertTrue(filtroTelefono(cadenasValidasUno));
        assertFalse(filtroTelefono(cadenasInvalidasUno));
        assertFalse(filtroTelefono(cadenasInvalidasDos));
        assertFalse(filtroTelefono(cadenasInvalidasTres));
        assertFalse(filtroTelefono(cadenasInvalidasCuatro));
    }

    @Test
    void filtroDNITest() {
        String cadenasValidasUno = "47310216K";
        String cadenasValidasDos = "47310216k";
        String cadenasInvalidasUno = "47310216";
        String cadenasInvalidasDos = "7310216K";
        String cadenasInvalidasTres = "abcd";

        assertTrue(filtroDNI(cadenasValidasUno));
        assertTrue(filtroDNI(cadenasValidasDos));
        assertFalse(filtroDNI(cadenasInvalidasUno));
        assertFalse(filtroDNI(cadenasInvalidasDos));
        assertFalse(filtroDNI(cadenasInvalidasTres));
    }

    @Test
    void filtroCantidadEntradasTest() {
        int tamannoMaxButacas = 6 * 6;
        String cadenasValidasUno = "1";
        String cadenasValidasDos = Integer.toString(tamannoMaxButacas);
        String cadenasInvalidasUno = Integer.toString((tamannoMaxButacas + 1));
        String cadenasInvalidasDos = "0";
        String cadenasInvalidasTres = "abcd";

        assertTrue(filtroCantidadEntradas(cadenasValidasUno, tamannoMaxButacas));
        assertTrue(filtroCantidadEntradas(cadenasValidasDos, tamannoMaxButacas));
        assertFalse(filtroCantidadEntradas(cadenasInvalidasUno, tamannoMaxButacas));
        assertFalse(filtroCantidadEntradas(cadenasInvalidasDos, tamannoMaxButacas));
        assertFalse(filtroCantidadEntradas(cadenasInvalidasTres, tamannoMaxButacas));
    }

    @Test
    void filtradoButacasTest() {

        Pelicula peliTest = new Pelicula("Avatar 2", "2022", "James Cameron", "Science Fiction");
        Sala[] cineTest = {new Sala("001", "Sala 1", peliTest, 3, 3)};

        String cadenasValidasUno = "A1";
        String cadenasValidasDos = "B2";
        String cadenasInvalidasUno = "A2";
        cineTest[0].ocuparButaca(cadenasInvalidasUno);
        String cadenasInvalidasDos = "A3";
        cineTest[0].reservarButaca(cadenasInvalidasDos);
        String cadenasInvalidasTres = "A0";
        String cadenasInvalidasCuatro = "A4";
        String cadenasInvalidasCinco = "D1";
        String cadenasInvalidasSeis = "1A";
        String cadenasInvalidasSiete = "AS";
        String cadenasInvalidasOcho = "--";
        String cadenasInvalidasNueve = "12";

        assertTrue(filtradoButacas(cineTest, "001", cadenasValidasUno));
        assertTrue(filtradoButacas(cineTest, "001", cadenasValidasDos));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasUno));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasDos));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasTres));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasCuatro));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasCinco));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasSeis));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasSiete));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasOcho));
        assertFalse(filtradoButacas(cineTest, "001", cadenasInvalidasNueve));
    }
}