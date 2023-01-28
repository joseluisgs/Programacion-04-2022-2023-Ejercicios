package factories

import models.Productos
import java.util.*

var contador: Int = 0

class ProductosFactory private constructor() {
    private val nombre = "Factory de productos + ${UUID.randomUUID()}"

    companion object {
        // Patron singleton
        private var producto: ProductosFactory? = null
        fun getProductos(): ProductosFactory {
            if (producto == null) {
                producto = ProductosFactory()
            }
            return producto!!
        }
    }

    fun createProduct(): Productos {
        contador++
        val nombreProductos: Array<String> = arrayOf(
            "",
            "COAL-Cola",
            "Pañales Dodo",
            "PS5",
            "PS4",
            "Wii U",
            "Jamón Ibérico",
            "Olympus OM-D E-M10 Mark III",
            "Barbie Rock Star Guitar",
            "Wilson Pro Staff RF 97 V13 Federer Autograph",
            "Rubber Duck Debugging",
            "NieR:Automata PS5 & PS4",
            "The Last of Us PS5 & PS4",
            "GOD of War PS5 & PS4",
            "Metal Gear Solid 3: Snake Eater PS3",
            "Castlevania anniversary collection PS4",
            "Stardew Valley",
            "Zelda BOTW",
            "Smash Bros",
            "Nintendo Switch",
            "Calcetines Git Kraken"
        )
        val precioProductos: Array<Double> = arrayOf(
            0.0,
            0.75,
            12.50,
            560.00,
            350.00,
            200.00,
            300.00,
            450.00,
            15.35,
            220.00,
            7.99,
            30.00,
            40.00,
            50.00,
            12.50,
            20.00,
            15.00,
            50.00,
            59.99,
            330.00,
            6.00
        )
        val nombreProducto: String = nombreProductos[contador]
        val precioProducto: Double = precioProductos[contador]
        return Productos(nombre = nombreProducto, precioUnitario = precioProducto)
    }

    override fun toString(): String {
        return "TenistasFactory(nombre='$nombre')"
    }

}