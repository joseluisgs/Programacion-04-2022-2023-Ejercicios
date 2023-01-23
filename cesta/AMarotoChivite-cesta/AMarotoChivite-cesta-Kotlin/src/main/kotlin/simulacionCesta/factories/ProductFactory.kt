package simulacionCesta.factories

import simulacionCesta.models.Product
import simulacionCesta.utils.randomData

object ProductFactory {
    @JvmStatic
    fun create(): Product {
        val name = randomData.randomProductName()
        val price = randomData.randomPrice()
        val quantity = randomData.randomQuantity()
        return Product(name, price, quantity)
    }
}