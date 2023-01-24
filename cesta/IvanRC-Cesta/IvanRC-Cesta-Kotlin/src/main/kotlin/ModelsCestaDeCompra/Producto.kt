package ModelsCestaDeCompra

data class Producto(val idProducto: Int, var precioUnitario: Double, var nombre: String) {

    private companion object{
        var contadorUsuarios = 0
        fun nextId():Int{
            return contadorUsuarios++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Producto

        if (nombre != other.nombre) return false

        return true
    }

}