package factura.factories

import factura.models.Producto
import java.util.*
import kotlin.math.roundToInt

class ProductoFactory {
    companion object {
        private var instance: ProductoFactory? = null
        fun getInstance(): ProductoFactory {
            if (instance == null) {
                instance = ProductoFactory()
            }
            return instance!!
        }
    }

    private val random = Random()
    fun getPrecioRandom(): Float{
        val randomFloat = random.nextFloat(1f,500f)
        return ((randomFloat * 100f).roundToInt() / 100f)
    }

    fun createProductoRandom(): Producto {
        val nombres = arrayOf("Mavic Air 2", "Mavic Mini 2", "Mavic Mini 3", "Mavic Mini 3 Pro", "Dji Avata", "Mavic 3", "Mavic 3 Classic")
        val precio = getPrecioRandom()

        return Producto(nombres.random(), precio, (1..25).random())
    }

    fun createProductoRandom(arry: Array<Producto>) {
        for (i in arry.indices){
            var repetir = false
            var newProduct: Producto
            do {
                newProduct = createProductoRandom()
                for (j in arry){
                    if (j == newProduct)
                        repetir = true
                }
            }while (repetir)
            arry[i] = newProduct
        }

    }
}