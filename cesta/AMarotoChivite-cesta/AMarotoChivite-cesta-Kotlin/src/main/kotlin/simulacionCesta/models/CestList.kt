package simulacionCesta.models

class CestList(var maxSizeStorage: Int, @JvmField var storageProducts: Array<Product?>) {

    fun printProducts() {
        for (i in storageProducts.indices) {
            println(storageProducts[i])
        }
    }
}