package simulacionCesta.factories

import simulacionCesta.models.CestList
import simulacionCesta.models.Product

object CestListFactory {
    @JvmStatic
    fun create(): CestList {
        // Por defecto presenta un tamaño 10 de máximo
        val randomSize = 10
        val productsStorage = arrayOfNulls<Product>(randomSize)
        do {
            // Introducimos productos aleatorios en la línea de cesta
            for (i in productsStorage.indices) {
                productsStorage[i] = ProductFactory.create()
            }
            // No saldremos hasta que genere por cada línea de producto un producto distinto
        } while (!checkProductNoRepeat(productsStorage))
        return CestList(randomSize, productsStorage)
    }

    /**
     * Verificamos que se generen por cada línea de producto un producto distinto
     *
     * @param productsStorage el almacén que ha generado productos para verificar
     * @return true si no hay productos iguales, false en caso contrario
     */
    fun checkProductNoRepeat(productsStorage: Array<Product?>): Boolean {
        for (i in productsStorage.indices) {
            for (j in i + 1 until productsStorage.size) {
                if (productsStorage[i]!!.name == productsStorage[j]!!.name) {
                    return false
                }
            }
        }
        return true
    }
}