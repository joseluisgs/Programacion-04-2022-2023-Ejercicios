package simulacionCesta.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class FinalCestTest {
    @Test
    fun calculateTotalPriceTest() {
        val dateCreation = LocalDate.now()
        val product1 = Product("Agua", 1.0, 2)
        val product2 = Product("Pan", 2.0, 1)
        val products = arrayOf<Product?>(product1, product2)
        val cestList = CestList(2, products)
        val finalCest = FinalCest(dateCreation, cestList)
        Assertions.assertEquals(4.0, finalCest.calculateTotalPrice())
    }

    @Test
    fun calculateQuantityProductsTest() {
        val dateCreation = LocalDate.now()
        val product1 = Product("Agua", 1.0, 2)
        val product2 = Product("Pan", 2.0, 1)
        val products = arrayOf<Product?>(product1, product2)
        val cestList = CestList(2, products)
        val finalCest = FinalCest(dateCreation, cestList)
        Assertions.assertEquals(3, finalCest.calculateQuantityProducts())
    }
}