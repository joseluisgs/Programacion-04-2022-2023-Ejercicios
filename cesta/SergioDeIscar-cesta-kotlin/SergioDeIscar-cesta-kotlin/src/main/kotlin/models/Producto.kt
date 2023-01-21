package factura.models

data class Producto(
    val nombre: String, private var precio: Float){
    var stock: Int = 0
        private set

    constructor(name: String, precio: Float, stock: Int): this(name, precio){
        check(name.isNotEmpty() && name.isNotBlank())
        check(precio > 0)
        SetStock(stock)
    }

    fun SetStock(value: Int){
        require(value >= 0)
        stock = value
    }

    fun SetPrecio(value: Float){
        require(value > 0)
        precio = value
    }

    fun GetPrecio(): Float{
        return precio
    }

    override fun toString(): String {
        return "Producto -> Nombre: ${this.nombre}, Precio -> ${this.precio}, Stock -> ${this.stock}"
    }
}