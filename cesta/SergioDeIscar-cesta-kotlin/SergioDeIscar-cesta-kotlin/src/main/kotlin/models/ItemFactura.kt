package factura.models

class ItemFactura (val item: Producto){
    var cantidad: Int = 1
        set(value) {
            require(field > 0 && field <= item.stock)
            field = value
        }
    val precioUnitario: Float = item.GetPrecio()

    constructor(item: Producto, cantidad: Int): this(item){
        this.cantidad = cantidad
    }

    override fun toString(): String {
        return "ItemFactura -> Producto -> { $item }, Cantidad -> $cantidad, Precio Unitario -> $precioUnitario"
    }
}