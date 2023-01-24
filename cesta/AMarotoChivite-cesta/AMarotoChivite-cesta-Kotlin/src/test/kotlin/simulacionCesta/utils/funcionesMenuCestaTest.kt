package simulacionCesta.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionCesta.models.CestList
import simulacionCesta.models.FinalCest
import simulacionCesta.models.Product
import java.time.LocalDate
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class funcionesMenuCestaTest {
    @Test
    fun listByNameTest() {
        val product1 = Product("Manzana", 2.0, 4)
        val product2 = Product("Cereal", 2.5, 2)
        val product3 = Product("Zanahoria", 1.5, 1)
        val product4 = Product("Agua", 1.0, 2)
        val productsTest = arrayOf<Product?>(product1, product2, product3, product4)
        val cestListTest = CestList(4, productsTest)
        val finalCestTest = FinalCest(LocalDate.now(), cestListTest)
        listByNameAscendent(finalCestTest)

        // Verificar que los productos están ordenados correctamente
        Assertions.assertEquals("Agua", finalCestTest.productsStorage!!.storageProducts[0]!!.name)
        Assertions.assertEquals("Cereal", finalCestTest.productsStorage!!.storageProducts[1]!!.name)
        Assertions.assertEquals("Manzana", finalCestTest.productsStorage!!.storageProducts[2]!!.name)
        Assertions.assertEquals("Zanahoria", finalCestTest.productsStorage!!.storageProducts[3]!!.name)
    }

    @Test
    fun listByPriceTest() {
        val product1 = Product("Manzana", 2.0, 4)
        val product2 = Product("Cereal", 2.5, 6)
        val product3 = Product("Zanahoria", 1.5, 1)
        val product4 = Product("Agua", 1.0, 2)
        val productsTest = arrayOf<Product?>(product1, product2, product3, product4)
        val cestListTest = CestList(4, productsTest)
        val finalCestTest = FinalCest(LocalDate.now(), cestListTest)
        listByPriceDescendent(finalCestTest)

        // Verificar que los productos están ordenados correctamente
        Assertions.assertEquals("Cereal", finalCestTest.productsStorage!!.storageProducts[0]!!.name)
        Assertions.assertEquals("Manzana", finalCestTest.productsStorage!!.storageProducts[1]!!.name)
        Assertions.assertEquals("Agua", finalCestTest.productsStorage!!.storageProducts[2]!!.name)
        Assertions.assertEquals("Zanahoria", finalCestTest.productsStorage!!.storageProducts[3]!!.name)
    }

    @Test
    @Throws(InterruptedException::class)
    fun deleteProductTest() {
        // Creamos una cesta de prueba
        val productsStorage = arrayOfNulls<Product>(2)
        productsStorage[0] = Product("Manzana", 1.0, 3)
        productsStorage[1] = Product("Leche", 2.0, 1)
        val cestList = CestList(2, productsStorage)
        val cest = FinalCest(LocalDate.now(), cestList)

        // Eliminamos el primer producto (Manzana)
        deleteProduct(cest, 0)

        // Comprobamos que se ha eliminado correctamente
        Assertions.assertEquals("Leche", cest.productsStorage!!.storageProducts[0]!!.name)
        Assertions.assertEquals(1, cest.productsStorage!!.storageProducts[0]!!.quantity)
        Assertions.assertEquals(2.0, cest.productsStorage!!.storageProducts[0]!!.unitaryPrice)
    }

    @Test
    @Throws(InterruptedException::class)
    fun newCestTest() {
        // Crear una cesta de prueba
        val product1 = Product("Agua", 1.0, 2)
        val products = arrayOf<Product?>(product1)
        val products2 = products.clone()
        val cestList = CestList(1, products)
        val cestList2 = CestList(1, products2)
        val cest = FinalCest(LocalDate.now(), cestList)
        newCest(cest)
        Assertions.assertNotEquals(cestList2, cest.productsStorage)
    }

    @Test
    @Throws(InterruptedException::class)
    fun checkIntegerTest() {
        val correctAnswer1: String = "1"
        val correctAnswer2: String = "5"
        val correctAnswer3: String = "10"
        val correctAnswer4: String = "50"
        val incorrectAnswer1: String = "."
        val incorrectAnswer2: String = "a"
        assertTrue(checkInteger(correctAnswer1))
        assertTrue(checkInteger(correctAnswer2))
        assertTrue(checkInteger(correctAnswer3))
        assertTrue(checkInteger(correctAnswer4))
        assertFalse(checkInteger(incorrectAnswer1))
        assertFalse(checkInteger(incorrectAnswer2))
    }
}