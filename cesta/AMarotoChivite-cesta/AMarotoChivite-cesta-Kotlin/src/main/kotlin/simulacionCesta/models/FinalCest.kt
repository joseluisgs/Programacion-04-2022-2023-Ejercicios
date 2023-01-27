package simulacionCesta.models

import java.time.LocalDate

class FinalCest(var creationDate: LocalDate, @JvmField var productsStorage: CestList?) {
    private val idFinalCest = countFinalCest

    init {
        autoCountFinalCest()
    }

    /**
     * Imprime en pantalla la cesta completa en detalle
     */
    fun printCompleteCest() {
        println("==============================================================")
        println("====== |CESTA " + (idFinalCest + 1) + "| |CREADA = " + creationDate + "| ======")
        println("==============================================================")
        productsStorage!!.printProducts()
        println("==============================================================")
        println("Cantidad de productos a comprar: " + calculateQuantityProducts())
        println("Por un precio de: " + calculateTotalPrice() + " €")
        println("==============================================================")
    }

    /**
     * Calcula el precio total que nos costará comprar todos los productos de la cesta
     *
     * @return totalQuantity cantidad de productos en total
     */
    fun calculateTotalPrice(): Double {
        var totalPrice = 0.0
        for (i in productsStorage!!.storageProducts.indices) {
            if (productsStorage!!.storageProducts[i] != null) {
                totalPrice += productsStorage!!.storageProducts[i]!!.calculateTotalPricePerProduct()
            }
        }
        return totalPrice
    }

    /**
     * Calcula la cantidad de productos en total que disponemos en la cesta
     *
     * @return totalQuantity cantidad de productos en total
     */
    fun calculateQuantityProducts(): Int {
        var totalQuantity = 0
        for (i in productsStorage!!.storageProducts.indices) {
            if (productsStorage!!.storageProducts[i] != null) {
                totalQuantity += productsStorage!!.storageProducts[i]!!.quantity
            }
        }
        return totalQuantity
    }

    /**
     * Aumentamos un ID por cada producto que hemos creado, para disponer de un contador
     */
    private fun autoCountFinalCest() {
        countFinalCest++
    }

    companion object {
        // Campo de clase para mantener el incremento
        private var countFinalCest = 0
    }
}