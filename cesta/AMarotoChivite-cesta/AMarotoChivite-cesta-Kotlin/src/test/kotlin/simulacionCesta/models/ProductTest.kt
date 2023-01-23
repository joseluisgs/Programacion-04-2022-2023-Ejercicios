package simulacionCesta.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionCesta.factories.ProductFactory

internal class ProductTest {
    @Test
    fun calculateTotalPricePerProductTest() {
        val productTest = ProductFactory.create()
        productTest.unitaryPrice = 2.0
        productTest.quantity = 2
        Assertions.assertEquals(4.0, productTest.calculateTotalPricePerProduct())
    }
}