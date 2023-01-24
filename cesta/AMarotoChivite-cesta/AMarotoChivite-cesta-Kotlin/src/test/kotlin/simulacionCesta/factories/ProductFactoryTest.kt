package simulacionCesta.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ProductFactoryTest {
    @Test
    fun prodcutFactoryCreateTest() {
        val product = ProductFactory.create()
        // Comprobar que la cesta final contiene una cesta no vacía
        Assertions.assertNotNull(product)
    }
}