package simulacionParking.models;

import org.junit.jupiter.api.Test;
import simulacionParking.enums.TipoVehiculo;
import simulacionParking.factories.VehiculoFactory;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {

    @Test
    void getEstadoTest() {

        Vehiculo vehiculoTest = VehiculoFactory.create();
        String[] correctStates = {"NO_APARCADO", "APARCADO"};

        int contadorStates = 0;
        for (int i = 0; i < correctStates.length; i++) {
            if (correctStates[i].contains(vehiculoTest.getEstado().toString())) {
                contadorStates++;
                assertTrue(true);
            }
        }
        if (contadorStates != 1) {
            fail();
        }
    }

    @Test
    void getTipoTest() {
        TipoVehiculo[] tiposCorrectos = {TipoVehiculo.CAMION, TipoVehiculo.COCHE, TipoVehiculo.MOTO, TipoVehiculo.BICI, TipoVehiculo.PATINETE, TipoVehiculo.VACIO};
        Vehiculo vehiculoTest = VehiculoFactory.create();

        int contadorTipo = 0;
        for (int i = 0; i < tiposCorrectos.length; i++) {
            if (tiposCorrectos[i].equals(vehiculoTest.getTipo())) {
                contadorTipo++;
                assertTrue(true);
            }
        }
        if (contadorTipo != 1) {
            fail();
        }
    }

    @Test
    void getMatriculaTest() {
        Vehiculo vehiculoTest = VehiculoFactory.create();

        // Debe haber 5 letras
        int contadorLetras = 0;
        //Debe haber un guión
        int contadorGuion = 0;
        // Debe haber 4 números
        int contadorNumeros = 0;
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";

        for (int i = 0; i < vehiculoTest.getMatricula().length(); i++) {
            if (alfabeto.contains(vehiculoTest.getMatricula().substring(i, (i + 1))) && contadorNumeros == 0 && contadorGuion == 0) {
                contadorLetras++;
            }
            if (vehiculoTest.getMatricula().substring(i, (i + 1)).equals("-") && contadorLetras == 5) {
                contadorGuion++;
            }
            if (numeros.contains(vehiculoTest.getMatricula().substring(i, (i + 1))) && contadorGuion == 1) {
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
    void getAnnoTest() {
        Vehiculo vehiculoTest = new Vehiculo("0", "0", "1990", TipoVehiculo.COCHE);

        if (!vehiculoTest.getAnno().equals("1990")) {
            fail();
        } else {
            assertTrue(true);
        }
    }

    @Test
    void setEstadoTest() {
        Vehiculo vehiculoTest = VehiculoFactory.create();

        vehiculoTest.setEstado(Vehiculo.EstadoVehiculo.NO_APARCADO);
        if (vehiculoTest.getEstado() != null) {
            if (vehiculoTest.getEstado().equals(Vehiculo.EstadoVehiculo.NO_APARCADO)) {
                assertTrue(true);
            } else {
                fail();
            }
        }

        vehiculoTest.setEstado(Vehiculo.EstadoVehiculo.APARCADO);
        if (vehiculoTest.getEstado() != null) {
            if (vehiculoTest.getEstado().equals(Vehiculo.EstadoVehiculo.APARCADO)) {
                assertTrue(true);
            } else {
                fail();
            }
        }
    }

    @Test
    void testToStringTest() {
        Vehiculo vehiculoTest = VehiculoFactory.create();

        String cadenaCorrecta = "Vehiculo{" +
                "id='" + vehiculoTest.getId() + '\'' +
                ", matricula='" + vehiculoTest.getMatricula() + '\'' +
                ", anno='" + vehiculoTest.getAnno() + '\'' +
                ", tipo=" + vehiculoTest.getTipo() +
                ", estado=" + vehiculoTest.getEstado() +
                '}';

        assertEquals(cadenaCorrecta, vehiculoTest.toString());
    }
}