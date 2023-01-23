package simulacionParking.factories;

import org.junit.jupiter.api.Test;
import simulacionParking.enums.TipoVehiculo;
import simulacionParking.models.Vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import static simulacionParking.factories.VehiculoFactory.*;

class VehiculoFactoryTest {

    @Test
    void create() {
        String matricula = generarMatricula();
        String annoFabrica = generarAnnoFabrica();
        TipoVehiculo tipo = generarTipoVehiculo(annoFabrica);
        String id_AUTO = VehiculoFactory.IdGenerator.getNextId() + "";

        Vehiculo vehiculo = new Vehiculo(id_AUTO, matricula, annoFabrica, tipo);

        // Comprobamos que se cree sin nulos
        assertNotNull(vehiculo);
    }

    @Test
    void generarTipoVehiculoTest() {
        TipoVehiculo[] tiposCorrectos = {TipoVehiculo.CAMION, TipoVehiculo.COCHE, TipoVehiculo.MOTO, TipoVehiculo.BICI, TipoVehiculo.PATINETE};
        String annoFabrica = generarAnnoFabrica(); //Ya testeado en las líneas de abajo
        TipoVehiculo generateTipo = generarTipoVehiculo(annoFabrica);

        int contadorTipoCorrecto = 0;
        for (int i = 0; i < tiposCorrectos.length; i++) {
            if (tiposCorrectos[i].equals(generateTipo)) {
                contadorTipoCorrecto++;
                assertTrue(true);
            }
        }
        if (contadorTipoCorrecto != 1) {
            fail();
        }
    }

    @Test
    void generarAnnoFabricaTest() {
        // Almacén desde el 1990 hasta el 2019 = 29 años
        int annoCorrectoLimiteInferior = 1990;
        int annoCorrectoLimiteSuperior = 2019;

        int annoFabrica = Integer.parseInt(generarAnnoFabrica());

        if (annoFabrica < annoCorrectoLimiteInferior || annoFabrica > annoCorrectoLimiteSuperior) {
            fail();
        } else {
            assertTrue(true);
        }
    }

    @Test
    void generarMatriculaTest() {
        String generateMatricula = generarMatricula();

        // Debe haber 5 letras
        int contadorLetras = 0;
        //Debe haber un guión
        int contadorGuion = 0;
        // Debe haber 4 números
        int contadorNumeros = 0;
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";

        for (int i = 0; i < generateMatricula.length(); i++) {
            if (alfabeto.contains(generateMatricula.substring(i, (i + 1))) && contadorNumeros == 0 && contadorGuion == 0) {
                contadorLetras++;
            }
            if (generateMatricula.substring(i, (i + 1)).equals("-") && contadorLetras == 5) {
                contadorGuion++;
            }
            if (numeros.contains(generateMatricula.substring(i, (i + 1))) && contadorGuion == 1) {
                contadorNumeros++;
            }
        }
        if (contadorLetras == 5 && contadorNumeros == 4 && contadorGuion == 1) {
            assertEquals(5, contadorLetras);
            assertEquals(4, contadorNumeros);
            assertEquals(1, contadorGuion);
        }
    }

    @Test
    void generacionAlmacenVehiculosTest() {
        // Comprobaremos que nos devuelva correctamente un vector de vehiculos, entre 1 y 4
        Vehiculo[] almacenVehiculos = VehiculoFactory.generacionAlmacenVehiculos();
        int contadorVehiculos = 0;

        for (int i = 0; i < almacenVehiculos.length; i++) {
            contadorVehiculos++;
        }

        if (contadorVehiculos >= 1 && contadorVehiculos <= 4) {
            assertTrue(true);
        } else {
            fail();
        }
    }

}