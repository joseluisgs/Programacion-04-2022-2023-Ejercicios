package CestaTests

import FactoriesCestaDeCompra.FactoryCesta
import FactoriesCestaDeCompra.FactoryProducto
import ModelsCestaDeCompra.Colores
import ModelsCestaDeCompra.opcionValida
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class cestaTests {

    val cesta = FactoryCesta.getInstance()!!.crearCestaRandom()

    @BeforeEach
    fun setUp(){
        //Con el objetivo de poder testear las funciones de eliminar, actualizar, defragmentar, ..., coloco un producto en la posición 20 del array
        val nuevoProducto = FactoryProducto.getInstance()!!.crearProductoRandom()
        cesta.listaCesta.añadirProductos(19, nuevoProducto)
    }

    @Test
    fun opcionValidaTest(){
        val opcion1 = "0"
        val opcion2 = "5"
        assertAll(
            {assertTrue(opcionValida(opcion1))},
            {assertTrue(opcionValida(opcion2))}
        )
    }

    @Test
    fun opcionNoValidaTest(){
        val opcion1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion1) }
        val opcion2 = "-1"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion2) }
        val opcion3 = "6"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion3) }
        val opcion4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { opcionValida(opcion4) }
        assertAll(
            {assertEquals("${Colores.RED.color}La opción no puede ser nula, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:", mensaje2.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}La opción introducida no es válida, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun añadirProductosTest(){
        val nuevoProducto = FactoryProducto.getInstance()!!.crearProductoRandom()
        val cantidadYPrecioUnitario = "1-${nuevoProducto.precioUnitario}"
        cesta.listaCesta.añadirProductos(0, nuevoProducto)
        assertAll(
            { assertEquals(nuevoProducto, cesta.listaCesta.listaProductos[0]) },
            { assertEquals(cantidadYPrecioUnitario, cesta.listaCesta.cantidadPrecioDelProducto[0]) }
        )
    }

    @Test
    fun eliminarProductosTest(){
        val cantidadYPrecioUnitario = ""
        cesta.listaCesta.eliminarProducto(19)
        assertAll(
            { assertEquals(null, cesta.listaCesta.listaProductos[19]) },
            { assertEquals(cantidadYPrecioUnitario, cesta.listaCesta.cantidadPrecioDelProducto[19]) }
        )
    }

    @Test
    fun actualizarCantidadProductoTest(){
        val cantidadAAñadir = 4
        assertEquals(5, cesta.listaCesta.actualizarCantidadProducto(19, cantidadAAñadir))
        val cantidadARestar = -2
        assertEquals(3, cesta.listaCesta.actualizarCantidadProducto(19, cantidadARestar))
    }

    @Test
    fun eliminarProductoSiCantidad0Test(){
        val cantidadYPrecioUnitario = ""
        val cantidadARestar = -10
        cesta.listaCesta.actualizarCantidadProducto(19, cantidadARestar)
        cesta.listaCesta.eliminarProductoSiCantidad0()
        assertAll(
            { assertEquals(null, cesta.listaCesta.listaProductos[19]) },
            { assertEquals(cantidadYPrecioUnitario, cesta.listaCesta.cantidadPrecioDelProducto[19]) }
        )
    }

    @Test
    fun calcularTotalDineroDeCestaTest(){
        cesta.listaCesta.eliminarProducto(19)
        val nuevoProducto1 = FactoryProducto.getInstance()!!.crearProductoRandom()
        nuevoProducto1.precioUnitario = 5.0
        cesta.listaCesta.añadirProductos(0, nuevoProducto1)
        val nuevoProducto2 = FactoryProducto.getInstance()!!.crearProductoRandom()
        nuevoProducto2.precioUnitario = 10.0
        cesta.listaCesta.añadirProductos(1, nuevoProducto2)
        assertEquals(15.0, cesta.listaCesta.calcularTotalDineroDeCesta())
    }

    @Test
    fun defragmentarArrayTest(){
        val producto = cesta.listaCesta.listaProductos[19]
        assertEquals(null, cesta.listaCesta.listaProductos[0])
        cesta.listaCesta.defragmentarArray()
        assertEquals(producto, cesta.listaCesta.listaProductos[0])
    }

    @Test
    fun productoNoExistenteTest(){
        val productoABuscar1 = cesta.listaCesta.listaProductos[19]
        val productoABuscar2 = FactoryProducto.getInstance()!!.crearProductoRandom()
        assertAll(
            {assertEquals(19, cesta.listaCesta.productoNoExistente(productoABuscar1))},
            {assertEquals(-1, cesta.listaCesta.productoNoExistente(productoABuscar2))}
        )
    }

    @Test
    fun buscarPrimerNullTest(){
        assertEquals(0, cesta.listaCesta.buscarPrimerNull())
    }

    @Test
    fun buscarProductoPorNombreTest(){
        val nombre1 = cesta.listaCesta.listaProductos[19]!!.nombre
        val nombre2 = "agua"
        assertAll(
            {assertEquals(19, cesta.listaCesta.buscarProductoPorNombre(nombre1))},
            {assertEquals(-1, cesta.listaCesta.buscarProductoPorNombre(nombre2))}
        )
    }

    @Test
    fun ordenarListaDeLaCestaSegunPrecioTotalTest(){
        cesta.listaCesta.eliminarProducto(19)
        val producto1 = FactoryProducto.getInstance()!!.crearProductoRandom()
        producto1.precioUnitario = 5.0
        cesta.listaCesta.añadirProductos(0, producto1)
        val producto2 = FactoryProducto.getInstance()!!.crearProductoRandom()
        producto2.precioUnitario = 15.0
        cesta.listaCesta.añadirProductos(1, producto2)
        cesta.listaCesta.ordenarListaDeLaCestaSegunPrecioTotal()
        assertAll(
            {assertEquals(producto1, cesta.listaCesta.listaProductos[1])},
            {assertEquals(producto2, cesta.listaCesta.listaProductos[0])}
        )
    }

    @Test
    fun ordenarListaDeLaCestaSegunNombreProductoTest(){
        cesta.listaCesta.eliminarProducto(19)
        val producto1 = FactoryProducto.getInstance()!!.crearProductoRandom()
        producto1.nombre = "zebra"
        cesta.listaCesta.añadirProductos(0, producto1)
        val producto2 = FactoryProducto.getInstance()!!.crearProductoRandom()
        producto2.nombre = "anacardo"
        cesta.listaCesta.añadirProductos(1, producto2)
        cesta.listaCesta.ordenarListaDeLaCestaSegunNombreProducto()
        assertAll(
            {assertEquals(producto1, cesta.listaCesta.listaProductos[1])},
            {assertEquals(producto2, cesta.listaCesta.listaProductos[0])}
        )
    }

    @Test
    fun estaVaciaLaVistaTest(){
        assertFalse(cesta.listaCesta.estaVaciaLaLista())
        cesta.listaCesta.eliminarProducto(19)
        assertTrue(cesta.listaCesta.estaVaciaLaLista())
    }

    @Test
    fun cantidadProductoValidaTest(){
        val cantidad1 = "1"
        val cantidad2 = "10"
        assertAll(
            {assertTrue(cesta.listaCesta.cantidadProductoValida(cantidad1))},
            {assertTrue(cesta.listaCesta.cantidadProductoValida(cantidad2))}
        )
    }

    @Test
    fun cantidadProductoNoValidaTest(){
        val cantidad1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.cantidadProductoValida(cantidad1) }
        val cantidad2 = "0"
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.cantidadProductoValida(cantidad2) }
        val cantidad3 = "11"
        val mensaje3: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.cantidadProductoValida(cantidad3) }
        val cantidad4 = "hola"
        val mensaje4: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.cantidadProductoValida(cantidad4) }
        assertAll(
            {assertEquals("${Colores.RED.color}La cantidad de producto introducida no puede ser nula, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las cantidad de producto posible, debe estar entre 1 y 10, vuelve a probar:", mensaje2.message)},
            {assertEquals("${Colores.RED.color}No has elegido una de las cantidad de producto posible, debe estar entre 1 y 10, vuelve a probar:", mensaje3.message)},
            {assertEquals("${Colores.RED.color}La cantidad de producto introducida no es válida, porque no has introducido un número, vuelve a probar:", mensaje4.message)}
        )
    }

    @Test
    fun nombreValidoTest(){
        val nombre = "gato"
        assertTrue(cesta.listaCesta.nombreValido(nombre))
    }

    @Test
    fun nombreNoValidoTest(){
        val nombre1 = null
        val mensaje1: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.nombreValido(nombre1) }
        val nombre2 = ""
        val mensaje2: IllegalArgumentException = Assertions.assertThrows(IllegalArgumentException::class.java) { cesta.listaCesta.nombreValido(nombre2) }
        assertAll(
            {assertEquals("${Colores.RED.color}El nombre introducido no puede ser nulo, vuelve a probar:", mensaje1.message)},
            {assertEquals("${Colores.RED.color}El nombre introducido no puede estar vacio, vuelve a probar:", mensaje2.message)}
        )
    }
}