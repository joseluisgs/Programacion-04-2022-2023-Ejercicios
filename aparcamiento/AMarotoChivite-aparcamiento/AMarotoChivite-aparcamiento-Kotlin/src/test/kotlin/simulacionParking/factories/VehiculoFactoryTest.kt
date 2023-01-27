package simulacionParking.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionParking.enums.TipoVehiculo
import simulacionParking.factories.VehiculoFactory.Companion.generarAnnoFabrica
import simulacionParking.factories.VehiculoFactory.Companion.generarMatricula
import simulacionParking.factories.VehiculoFactory.Companion.generarTipoVehiculo
import simulacionParking.models.Vehiculo

internal class VehiculoFactoryTest {
    @Test
    fun create() {
        val matricula: String = generarMatricula()
        val annoFabrica: String? = generarAnnoFabrica()
        val tipo: TipoVehiculo = generarTipoVehiculo(annoFabrica)
        val id_AUTO: String = VehiculoFactory.getNextIdVehiculo()
        val vehiculo = Vehiculo(id_AUTO, matricula, annoFabrica, tipo)

        // Comprobamos que se cree sin nulos
        Assertions.assertNotNull(vehiculo)
    }

    @Test
    fun generarTipoVehiculoTest() {
        val tiposCorrectos = arrayOf(
            TipoVehiculo.CAMION,
            TipoVehiculo.COCHE,
            TipoVehiculo.MOTO,
            TipoVehiculo.BICI,
            TipoVehiculo.PATINETE
        )
        val annoFabrica: String? = generarAnnoFabrica() //Ya testeado en las líneas de abajo
        val generateTipo: TipoVehiculo = generarTipoVehiculo(annoFabrica)
        var contadorTipoCorrecto = 0
        for (i in tiposCorrectos.indices) {
            if (tiposCorrectos[i] == generateTipo) {
                contadorTipoCorrecto++
                Assertions.assertTrue(true)
            }
        }
        if (contadorTipoCorrecto != 1) {
            Assertions.fail<Any>()
        }
    }

    @Test
    fun generarAnnoFabricaTest() {
        // Almacén desde el 1990 hasta el 2019 = 29 años
        val annoCorrectoLimiteInferior = 1990
        val annoCorrectoLimiteSuperior = 2019
        val annoFabrica: Int = generarAnnoFabrica()!!.toInt()
        if (annoFabrica < annoCorrectoLimiteInferior || annoFabrica > annoCorrectoLimiteSuperior) {
            Assertions.fail<Any>()
        } else {
            Assertions.assertTrue(true)
        }
    }

    @Test
    fun generarMatriculaTest() {
        val generateMatricula: String = generarMatricula()

        // Debe haber 5 letras
        var contadorLetras = 0
        //Debe haber un guión
        var contadorGuion = 0
        // Debe haber 4 números
        var contadorNumeros = 0
        val alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val numeros = "1234567890"
        for (i in 0 until generateMatricula.length) {
            if (alfabeto.contains(
                    generateMatricula.substring(
                        i,
                        i + 1
                    )
                ) && contadorNumeros == 0 && contadorGuion == 0
            ) {
                contadorLetras++
            }
            if (generateMatricula.substring(i, i + 1) == "-" && contadorLetras == 5) {
                contadorGuion++
            }
            if (numeros.contains(generateMatricula.substring(i, i + 1)) && contadorGuion == 1) {
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
    fun generacionAlmacenVehiculosTest() {
        // Comprobaremos que nos devuelva correctamente un vector de vehiculos, entre 1 y 4
        val almacenVehiculos = VehiculoFactory.generacionAlmacenVehiculos()
        var contadorVehiculos = 0
        for (i in almacenVehiculos.indices) {
            contadorVehiculos++
        }
        if (contadorVehiculos in 1..4) {
            Assertions.assertTrue(true)
        } else {
            Assertions.fail<Any>()
        }
    }
}