import models.Cesta
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Caja_MainKtTest {

    private val cestaTest: Cesta = Cesta

    @BeforeEach
    fun setUp() {
        val cestaTest: Cesta = Cesta
    }

    @Test
    fun menuRegexTest() {
        // TRUE
        val option0T = 0
        val option1T = 1
        val option2T = 2
        val option3T = 3
        val option4T = 4
        val option5T = 5

        // FALSE
        val option0F = -1
        val option1F = 6
        val option2F = 10
        val option3F = "Esto es una prueba"

        assertAll(
            {
                assertTrue(menuRegex(option0T.toString()))
                assertTrue(menuRegex(option1T.toString()))
                assertTrue(menuRegex(option2T.toString()))
                assertTrue(menuRegex(option3T.toString()))
                assertTrue(menuRegex(option4T.toString()))
                assertTrue(menuRegex(option5T.toString()))
                assertFalse(menuRegex(option0F.toString()))
                assertFalse(menuRegex(option1F.toString()))
                assertFalse(menuRegex(option2F.toString()))
                assertFalse(menuRegex(option3F))
            }
        )
    }

    @Test
    fun compruebaIDTest() {
        // TRUE
        val option0T = 10
        val option1T = 1
        val option2T = 20
        val option3T = 13
        val option4T = 4
        val option5T = 5


        // FALSE
        val option0F = 0
        val option1F = 50
        val option2F = -1
        val option3F = "Esto es una prueba"

        assertAll(
            {
                assertTrue(compruebaID(option0T.toString()))
                assertTrue(compruebaID(option1T.toString()))
                assertTrue(compruebaID(option2T.toString()))
                assertTrue(compruebaID(option3T.toString()))
                assertTrue(compruebaID(option4T.toString()))
                assertTrue(compruebaID(option5T.toString()))
                assertFalse(compruebaID(option0F.toString()))
                assertFalse(compruebaID(option1F.toString()))
                assertFalse(compruebaID(option2F.toString()))
                assertFalse(compruebaID(option3F))
            }
        )
    }

    @Test
    fun agregarProductosTest() {

        val producto1 = "COAL-Cola"
        val producto2 = "Pañales Dodo"
        val producto3 = "PS5"
        val producto4 = "PS4"

        val resCantidad = 1

        val res1 = cestaTest.agregarProductos(0, 1)
        val res2 = cestaTest.agregarProductos(1, 1)
        val res3 = cestaTest.agregarProductos(2, 1)
        val res4 = cestaTest.agregarProductos(3, 1)

        assertEquals(producto1, res1?.nombre)
        assertEquals(resCantidad, res1?.cantidad)
        assertEquals(producto2, res2?.nombre)
        assertEquals(resCantidad, res2?.cantidad)
        assertEquals(producto3, res3?.nombre)
        assertEquals(resCantidad, res3?.cantidad)
        assertEquals(producto4, res4?.nombre)
        assertEquals(resCantidad, res4?.cantidad)
    }

    @Test
    fun disminuirDisponibilidadTest() {
        val res0 = cestaTest.disminuirDisponibilidad()

        var res1 = cestaTest.disminuirDisponibilidad()
        res1 = cestaTest.disminuirDisponibilidad()

        assertEquals(1, res0)
        assertEquals(3, res1)
    }

    @Test
    fun isHuecoDisponibleTest() {
        var disponibilidadCestaTest = 0

        assertTrue(cestaTest.isHuecoDisponible())
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        cestaTest.disminuirDisponibilidad()
        assertTrue(cestaTest.isHuecoDisponible())
        cestaTest.disminuirDisponibilidad()
        assertFalse(cestaTest.isHuecoDisponible())
        disponibilidadCestaTest = cestaTest.disminuirDisponibilidad()
    }

    @Test
    fun isElMismoProductoTest() {
        cestaTest.agregarProductos(0, 1)

        assertTrue(cestaTest.isElMismoProducto(0))
        assertFalse(cestaTest.isElMismoProducto(1))
    }

    @Test
    fun sumarUnProductoTest() {
        var producto1 = cestaTest.agregarProductos(0, 0)
        producto1 = cestaTest.sumarUnProducto(0)
        assertEquals(1, producto1?.cantidad)
        producto1 = cestaTest.sumarUnProducto(0)
        assertEquals(2, producto1?.cantidad)
    }

    @Test
    fun eliminarProductos() {
        var producto1 = cestaTest.agregarProductos(0, 0)
        producto1 = cestaTest.eliminarProductos(0)
        assertEquals(null, producto1)
    }

    @Test
    fun actualizarProductoTest(){
        cestaTest.agregarProductos(0, 0)
        val producto1 = cestaTest.actualizarProducto(idProducto = 0, cantidad = 15)
        val producto2 = cestaTest.actualizarProducto(idProducto = 0, cantidad = 0)
        val producto3 = cestaTest.actualizarProducto(idProducto = 0, cantidad = -1)
        assertEquals(15, producto1)
        assertEquals(0, producto2)
        assertEquals(-1, producto3)
    }
}