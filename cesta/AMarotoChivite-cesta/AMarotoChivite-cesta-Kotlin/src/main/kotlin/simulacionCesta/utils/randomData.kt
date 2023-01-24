package simulacionCesta.utils

import java.util.*

object randomData {
    /**
     * Genera de manera aleatoria un producto dentro de nuestro catálogo
     *
     * @return storageProductos[num], es el producto aleatorio
     */
    @JvmStatic
    fun randomProductName(): String {
        val r = Random()
        val num = r.nextInt(24)
        val storageProductos = arrayOf(
            "Pan", "Leche", "Miel", "Chocolate",
            "Manzana", "Melocotón", "Sandía", "Cereal",
            "Harina", "Agua", "Zumo", "Patata", "Zanahoria",
            "Papel", "Mantequilla", "Queso",
            "Jamón", "Yogur", "Flan", "Avellanas", "Sal",
            "Azúcar", "Lechuga", "Canónigos"
        )
        return storageProductos[num]
    }

    /**
     * Genera aleatoriamente un número entre decimal
     *
     * @return precio con decimales
     */
    @JvmStatic
    fun randomPrice(): Double {
        // Estaremos en bucle hasta que un precio tenga x.xx€ para evitar decimales muy largos
        while (true) {
            val intPart = Math.round(Math.random()).toDouble()
            val decimalPart = Math.round(Math.random() * 100.0) / 100.0
            val checkPrice = java.lang.Double.toString(intPart + decimalPart)
            if (checkPrice.length == 4) {
                // sumo 0.35 por si da el caso que me da un resultado 0
                return intPart + decimalPart + 0.35
            }
        }
    }

    /**
     * Genera aleatoriamente un número entre 1 y 5 (incluidos)
     *
     * @return cantidad de un producto
     */
    @JvmStatic
    fun randomQuantity(): Int {
        return Math.round(Math.random() * 4 + 1).toInt()
    }
}