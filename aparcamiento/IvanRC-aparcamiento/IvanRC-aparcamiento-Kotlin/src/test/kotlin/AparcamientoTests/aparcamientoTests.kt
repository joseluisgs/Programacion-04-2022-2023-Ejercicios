package AparcamientoTests

import FactoriesAparcamiento.FactoryConductor
import FactoriesAparcamiento.FactoryVehiculo
import ModelsAparcamiento.Aparcamiento
import ModelsAparcamiento.Conductor
import ModelsAparcamiento.Vehiculo
import ModelsAparcamiento.tipoVehiculo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class aparcamientoTests {

    val RED = "\u001b[31m"

    var aparcamiento = Aparcamiento()
    var vehiculo = FactoryVehiculo.getInstance()!!
        .create("7493-AAA", 2020, tipoVehiculo.coche, Conductor("Iván", "53907345M"))

    @BeforeEach
    fun setup() {
        for (i in aparcamiento.aparcamientos.indices) {
            for (j in aparcamiento.aparcamientos[i].indices) {
                aparcamiento.aparcamientos[i][j] = null
            }
        }
        aparcamiento.aparcamientos[0][0] = vehiculo
    }

    @Test
    fun opcionValidaAparcamientoTest() {
        val opcion = "1"
        Assertions.assertTrue(aparcamiento.opcionValida(opcion))
    }

    @Test
    fun opcionNoValidaAparcamientoTest() {
        val opcion1 = "-1"
        val exception1: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.opcionValida(opcion1) }
        val actualMessage1 = exception1.message
        val opcion2 = ""
        val exception2: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.opcionValida(opcion2) }
        val actualMessage2 = exception2.message
        val opcion3: String? = null
        val exception3: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.opcionValida(opcion3) }
        val actualMessage3 = exception3.message
        assertAll(
            { Assertions.assertEquals("${RED}La opción seleccionada es inválida, vuelva a probar:", actualMessage1) },
            { Assertions.assertEquals("${RED}La opción seleccionada no puede estar vacia, vuelva a probar:", actualMessage2) },
            { Assertions.assertEquals("${RED}La opción seleccionada no puede ser nula, vuelva a probar:", actualMessage3) }
        )
    }

    @Test
    fun dniValidoTest() {
        val dni = "53907934M"
        Assertions.assertTrue(aparcamiento.dniValido(dni))
    }

    @Test
    fun dniNoValidoTest() {
        val dni1 = "899989898"
        val exception1: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.dniValido(dni1) }
        val actualMessage1 = exception1.message
        val dni2 = ""
        val exception2: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.dniValido(dni2) }
        val actualMessage2 = exception2.message
        val dni3: String? = null
        val exception3: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.dniValido(dni3) }
        val actualMessage3 = exception3.message
        assertAll(
            {Assertions.assertEquals("${RED}El dni introducido no es válido, vuelve a probar:", actualMessage1)},
            {Assertions.assertEquals("${RED}El dni introducido no puede estar vacio, vuelva a probar:", actualMessage2)},
            {Assertions.assertEquals("${RED}El dni introducido no puede ser nulo, vuelva a probar:", actualMessage3)}
        )
    }

    @Test
    fun nombreValidoTest() {
        val nombre = "Iván"
        Assertions.assertTrue(aparcamiento.nombreValido(nombre))
    }

    @Test
    fun nombreNoValidoTest() {
        val nombre1 = "899989898"
        val exception1: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.nombreValido(nombre1) }
        val actualMessage1 = exception1.message
        val nombre2 = ""
        val exception2: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.nombreValido(nombre2) }
        val actualMessage2 = exception2.message
        val nombre3: String? = null
        val exception3: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.nombreValido(nombre3) }
        val actualMessage3 = exception3.message
        assertAll(
            {Assertions.assertEquals("${RED}El nombre introducido no es válido, vuelve a probar:", actualMessage1)},
            {Assertions.assertEquals("${RED}El nombre introducido no puede estar vacio, vuelva a probar:", actualMessage2)},
            {Assertions.assertEquals("${RED}El nombre introducido no puede ser nulo, vuelva a probar:", actualMessage3)}
        )
    }

    @Test
    fun matriculaValidaTest() {
        val matricula = "4657-BFS"
        Assertions.assertTrue(aparcamiento.matriculaValida(matricula))
    }

    @Test
    fun matriculaNOValidaTest() {
        val matricula1 = "899989898"
        val exception1: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.matriculaValida(matricula1) }
        val actualMessage1 = exception1.message
        val matricula2 = ""
        val exception2: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.matriculaValida(matricula2) }
        val actualMessage2 = exception2.message
        val matricula3: String? = null
        val exception3: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.matriculaValida(matricula3) }
        val actualMessage3 = exception3.message
        assertAll(
            {Assertions.assertEquals("${RED}La matrícula introducida no es válida, vuelve a probar:", actualMessage1)},
            {Assertions.assertEquals("${RED}La matricula introducida no puede estar vacia, vuelva a probar:", actualMessage2)},
            {Assertions.assertEquals("${RED}La matricula introducida no puede ser nula, vuelva a probar:", actualMessage3)}
        )
    }

    @Test
    fun añoFabricacionValidoTest() {
        val añoFabricacion = "1955"
        Assertions.assertTrue(aparcamiento.añoFabricacionValido(añoFabricacion))
    }

    @Test
    fun añoFabricacionNOValidoTest() {
        val añoFabricacion1 = "1949"
        val exception1: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.añoFabricacionValido(añoFabricacion1) }
        val actualMessage1 = exception1.message
        val añoFabricacion2 = "2023"
        val exception2: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.añoFabricacionValido(añoFabricacion2) }
        val actualMessage2 = exception2.message
        val añoFabricacion3 = ""
        val exception3: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.añoFabricacionValido(añoFabricacion3) }
        val actualMessage3 = exception3.message
        val añoFabricacion4: String? = null
        val exception4: Exception = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { aparcamiento.añoFabricacionValido(añoFabricacion4) }
        val actualMessage4 = exception4.message
        assertAll(
            {Assertions.assertEquals("${RED}El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:", actualMessage1)},
            {Assertions.assertEquals("${RED}El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:", actualMessage2)},
            {Assertions.assertEquals("${RED}El año de fabricacion introducido no puede estar vacio, vuelva a probar:", actualMessage3)},
            {Assertions.assertEquals("${RED}El año de fabricacion introducido no puede ser nulo, vuelva a probar:", actualMessage4)}
        )
    }

    @Test
    fun tipoValidoTest() {
        val tipo = "coche"
        Assertions.assertTrue(aparcamiento.tipoValido(tipo))
    }

    @Test
    fun tipoNOValidoTest() {
        val tipo1 = "899989898"
        val exception1: Exception = Assertions.assertThrows(IllegalArgumentException::class.java) { aparcamiento.tipoValido(tipo1) }
        val actualMessage1 = exception1.message
        val tipo2 = ""
        val exception2: Exception = Assertions.assertThrows(IllegalArgumentException::class.java) { aparcamiento.tipoValido(tipo2) }
        val actualMessage2 = exception2.message
        val tipo3: String? = null
        val exception3: Exception = Assertions.assertThrows(IllegalArgumentException::class.java) { aparcamiento.tipoValido(tipo3) }
        val actualMessage3 = exception3.message
        assertAll(
            {Assertions.assertEquals("${RED}El tipo introducido no es ni un coche, ni una moto, ni un patinete, por lo que no está permitido en el aparcamiento, vuelve a probar:", actualMessage1)},
            {Assertions.assertEquals("${RED}El tipo introducido no puede estar vacio, vuelva a probar:", actualMessage2)},
            {Assertions.assertEquals("${RED}El tipo introducido no puede ser nulo, vuelva a probar:", actualMessage3)}
        )
    }

    @Test
    fun createConductorTest() {
        val conductor = Conductor("Iván", "53907934M")
        assertEquals(conductor, FactoryConductor.getInstance()!!.create("Iván", "53907934M"))
    }

    @Test
    fun createVehiculoTest() {
        val conductor = Conductor("Iván", "53907934M")
        val vehiculo = Vehiculo("5463-TRE", 1970, tipoVehiculo.coche, conductor)
        assertEquals(vehiculo, FactoryVehiculo.getInstance()!!.create("5463-TRE", 1970, tipoVehiculo.coche,
            FactoryConductor.getInstance()!!.create("Iván", "53907934M")))
    }

    @Test
    fun aparcarVehiculoTest() {
        val vehiculo: Vehiculo = FactoryVehiculo.getInstance()!!.createVehiculoRandom()
        aparcamiento.aparcar(vehiculo, "0-1")
        Assertions.assertEquals(vehiculo, aparcamiento.aparcamientos[0][1])
    }

    @Test
    fun eliminarVehiculoTest() {
        aparcamiento.eliminarCocheDeAparcamiento("0-0")
        Assertions.assertEquals(null, aparcamiento.aparcamientos[0][0])
    }

    @Test
    fun dondeAparcarTest() {
        Assertions.assertEquals("0-1", aparcamiento.buscarPrimeraPosicionLibre())
    }

    @Test
    fun cuantosVehiculosHayAparcadosTest() {
        Assertions.assertEquals(1, aparcamiento.cuantosVehiculosHayAparcados())
    }

    @Test
    fun buscarVehiculoPorMatriculaTest() {
        Assertions.assertEquals("0-0", aparcamiento.buscarVehiculoSegunMatricula("7493-AAA"))
    }

    @Test
    fun cuantosVehiculosTieneUnConductroAparcadosTest() {
        Assertions.assertEquals(1, aparcamiento.contarVehiculosAparcadosDeConductor("53907345M"))
    }

    @Test
    fun calcularRecaudacionTest() {
        aparcamiento.contadorVehiculosAparcados = 1
        Assertions.assertEquals(3.75, aparcamiento.calcularRecaudacion())
    }

    @Test
    fun matrizNoVaciaTest() {
        Assertions.assertTrue(aparcamiento.matrizNoEstaVacia())
        aparcamiento.aparcamientos[0][0] = null
        Assertions.assertFalse(aparcamiento.matrizNoEstaVacia())
    }

    @Test
    fun pasarMatrizAVectorTest() {
        val vector = arrayOf(aparcamiento.aparcamientos[0][0])
        Assertions.assertArrayEquals(vector, aparcamiento.pasarMatrizAVector(1))
    }

    @Test
    fun ordenarMetodoBurbujaDescendenteTest() {
        val vehiculo = FactoryVehiculo.getInstance()!!
            .create("7493-AAA", 2022, tipoVehiculo.coche, Conductor("Iván", "53907345M"))
        val vector = arrayOf(aparcamiento.aparcamientos[0][0], vehiculo)
        aparcamiento.ordenarMetodoBurbujaDescendente(vector)
        assertAll(
            {Assertions.assertEquals(aparcamiento.aparcamientos[0][0], vector[1])},
            {Assertions.assertEquals(vehiculo, vector[0])}
        )
    }

    companion object {
        private const val RED = "\u001b[31m"
    }
}