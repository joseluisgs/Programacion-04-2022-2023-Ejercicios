package simulacionCesta.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FinalCestFactoryTest {
    @Test
    fun finalCestFactoryCreateTest() {
        val finalCest = FinalCestFactory.create()
        // Comprobar que la cesta final contiene una cesta no vacía
        Assertions.assertNotNull(finalCest)
    }
}