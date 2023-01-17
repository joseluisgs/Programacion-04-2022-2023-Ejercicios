package models

class LineaCesta (var producto:Producto, var cantidadEnCesta:Int  ){

    val cantidadMaximaPermitidaLinea = 10


    override fun toString(): String {
        var precioTotalLinea = producto.precioUnitario*cantidadEnCesta
        val precioComoArray:CharArray = precioTotalLinea.toString().toCharArray()
        if(precioComoArray.size>2){
            val longArrayEntero:Int = precioComoArray.size-2
            return "${producto.toString()} Cantidad:$cantidadEnCesta Precio Total: " +
                    "${precioTotalLinea.toString().substring(0,longArrayEntero)}," +
                    "${precioTotalLinea.toString().substring(longArrayEntero,longArrayEntero+2)}€"}
        return "${producto.toString()} Cantidad:$cantidadEnCesta Precio Total:  Precio:0,$precioTotalLinea € "
    }

    fun checkMax(){
        if(cantidadEnCesta>cantidadMaximaPermitidaLinea){
            println(RegexyMensajes.getInstance().mensajeErrorExcesoAdd)
        cantidadEnCesta =cantidadMaximaPermitidaLinea
    }}
}


