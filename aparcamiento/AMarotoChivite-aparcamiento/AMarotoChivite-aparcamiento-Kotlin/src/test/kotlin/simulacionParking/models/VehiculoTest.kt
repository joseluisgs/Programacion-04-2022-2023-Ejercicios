package simulacionParking.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionParking.enums.TipoVehiculo
import simulacionParking.factories.VehiculoFactory

internal class VehiculoTest {

    @Test
    fun tipoTest() {
        val tiposCorrectos = arrayOf(
            TipoVehiculo.CAMION,
            TipoVehiculo.COCHE,
            TipoVehiculo.MOTO,
            TipoVehiculo.BICI,
            TipoVehiculo.PATINETE,
            TipoVehiculo.VACIO
        )
        val vehiculoTest = VehiculoFactory.create()
        var contadorTipo = 0
        for (i in tiposCorrectos.indices) {
            if (tiposCorrectos[i] == vehiculoTest!!.tipo) {
                contadorTipo++
                Assertions.assertTrue(true)
            }
        }
        if (contadorTipo != 1) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun matriculaTest() {
        val vehiculoTest = VehiculoFactory.create()

        // Debe haber 5 letras
        var contadorLetras = 0
        //Debe haber un guión
        var contadorGuion = 0
        // Debe haber 4 números
        var contadorNumeros = 0
        val alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val numeros = "1234567890"
        for (i in 0 until vehiculoTest!!.matricula.length) {
            if (alfabeto.contains(
                    vehiculoTest.matricula.substring(
                        i,
                        i + 1
                    )
                ) && contadorNumeros == 0 && contadorGuion == 0
            ) {
                contadorLetras++
            }
            if (vehiculoTest.matricula.substring(i, i + 1) == "-" && contadorLetras == 5) {
                contadorGuion++
            }
            if (numeros.contains(vehiculoTest.matricula.substring(i, i + 1)) && contadorGuion == 1) {
                contadorNumeros++
            }
        }
        if (contadorLetras == 5 && contadorNumeros == 4 && contadorGuion == 1) {
            Assertions.assertEquals(5, contadorLetras)
            Assertions.assertEquals(4, contadorNumeros)
            Assertions.assertEquals(1, contadorGuion)
        }
    }

    @Test
    fun annoTest() {
        val vehiculoTest = Vehiculo("0", "0", "1990", TipoVehiculo.COCHE)
        if (vehiculoTest.anno != "1990") {
            Assertions.fail<Any>()
        } else {
            Assertions.assertTrue(true)
        }
    }

    @Test
    fun setEstadoTest() {
        val vehiculoTest = VehiculoFactory.create()
        vehiculoTest!!.setEstadoVehiculo(Vehiculo.EstadoVehiculo.NO_APARCADO)
        if (vehiculoTest.estado == Vehiculo.EstadoVehiculo.NO_APARCADO) {
            Assertions.assertTrue(true)
        } else {
            Assertions.fail<Any>()
        }
        vehiculoTest.setEstadoVehiculo(Vehiculo.EstadoVehiculo.APARCADO)
        if (vehiculoTest.estado == Vehiculo.EstadoVehiculo.APARCADO) {
            Assertions.assertTrue(true)
        } else {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun testToStringTest() {
        val vehiculoTest = VehiculoFactory.create()
        val cadenaCorrecta = "Vehiculo{" +
                "id='" + vehiculoTest!!.id + '\'' +
                ", matricula='" + vehiculoTest.matricula + '\'' +
                ", anno='" + vehiculoTest.anno + '\'' +
                ", tipo=" + vehiculoTest.tipo +
                ", estado=" + vehiculoTest.estado +
                '}'
        Assertions.assertEquals(cadenaCorrecta, vehiculoTest.toString())
    }
}