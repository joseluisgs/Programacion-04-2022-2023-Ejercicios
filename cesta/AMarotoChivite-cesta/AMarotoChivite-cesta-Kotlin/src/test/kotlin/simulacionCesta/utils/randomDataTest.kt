package simulacionCesta.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionCesta.utils.randomData.randomPrice
import simulacionCesta.utils.randomData.randomProductName
import simulacionCesta.utils.randomData.randomQuantity

internal class randomDataTest {
    @Test
    fun randomProductNameTest() {
        val productName = randomProductName()
        // Comprobar que el producto devuelto está dentro del catálogo
        val storageProductos = arrayOf(
            "Pan", "Leche", "Miel", "Chocolate",
            "Manzana", "Melocotón", "Sandía", "Cereal",
            "Harina", "Agua", "Zumo", "Patata", "Zanahoria",
            "Papel", "Mantequilla", "Queso",
            "Jamón", "Yogur", "Flan", "Avellanas", "Sal",
            "Azúcar", "Lechuga", "Canónigos"
        )
        var isInCatalog = false
        for (i in storageProductos) {
            if (i == productName) {
                isInCatalog = true
                break
            }
        }
        Assertions.assertTrue(isInCatalog)
    }

    @Test
    fun randomPriceTest() {
        // Comprobar que el precio generado está entre 0.35 y 2.34 = (1.99+0.35)
        for (i in 0..19) {
            val priceTest = randomPrice()
            Assertions.assertTrue(priceTest >= 0.35 && priceTest <= 2.34)
        }
    }

    @Test
    fun randomQuantityTest() {
        // Comprobar que la cantidad devuelta está entre 1 y 5 (incluidos)
        for (i in 0..19) {
            val quantity = randomQuantity()
            Assertions.assertTrue(quantity >= 1 && quantity <= 5)
        }
    }
}