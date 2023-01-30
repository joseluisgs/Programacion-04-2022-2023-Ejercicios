package models

data class Productos(var nombre: String, var precioUnitario: Double, var cantidad: Int = 0) {

    fun setCantidad(cantidad: Int): Int {
        this.cantidad = cantidad
        return cantidad
    }

    override fun toString(): String {
        return "Nombre: $nombre, Precio Unitario: $precioUnitario, Cantidad: $cantidad"
    }
}