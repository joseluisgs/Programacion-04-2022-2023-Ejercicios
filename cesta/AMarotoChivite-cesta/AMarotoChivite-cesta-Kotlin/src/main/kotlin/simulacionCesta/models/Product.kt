package simulacionCesta.models

class Product(@JvmField var name: String?, @JvmField var unitaryPrice: Double, @JvmField var quantity: Int) {
    private val idProduct = countProduct

    init {
        autoCountProduct()
    }

    /**
     * Calcula el precio total de un producto
     *
     * @return precio total de un producto
     */
    fun calculateTotalPricePerProduct(): Double {
        return unitaryPrice * quantity
    }

    override fun toString(): String {
        return "Product{" +
                "idProduct=" + (idProduct + 1) +
                ", name='" + name + '\'' +
                ", unitaryPrice=" + unitaryPrice +
                ", quantity=" + quantity +
                ", Total= " + calculateTotalPricePerProduct() +
                '}'
    }

    /**
     * Aumentamos un ID por cada producto que hemos creado, para disponer de un contador
     */
    private fun autoCountProduct() {
        countProduct++
    }

    companion object {
        // Campo de clase para mantener el incremento
        private var countProduct = 0
    }
}