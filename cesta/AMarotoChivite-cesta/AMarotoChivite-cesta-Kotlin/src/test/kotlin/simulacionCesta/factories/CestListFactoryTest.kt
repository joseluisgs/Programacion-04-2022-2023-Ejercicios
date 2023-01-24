package simulacionCesta.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CestListFactoryTest {
    @Test
    fun cestListFactoryCreateTest() {
        val cestList = CestListFactory.create()
        // Comprobar que la longitud de la lista de la cesta es 10
        Assertions.assertEquals(10, cestList.storageProducts.size)
    }

    @Test
    fun checkProductNoRepeatTest() {
        val cestList = CestListFactory.create()
        val productsStorage = cestList.storageProducts
        var noRepeat = true
        for (i in productsStorage.indices) {
            for (j in i + 1 until productsStorage.size) {
                if (productsStorage[i]!!.name == productsStorage[j]!!.name) {
                    noRepeat = false
                    break
                }
            }
        }
        Assertions.assertTrue(noRepeat)
    }
}