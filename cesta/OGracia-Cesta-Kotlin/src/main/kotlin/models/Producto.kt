package models

import factories.UsuarioFactory

class Producto (
    val nombre:String,
    val precioUnitario:Int
        ){
    val vendedor:String = ""

    override fun toString(): String {
        val precioComoArray:CharArray = precioUnitario.toString().toCharArray()
        if(precioComoArray.size>2){
            val longArrayEntero:Int = precioComoArray.size-2
            return "$nombre, Precio: ${precioUnitario.toString().substring(0,longArrayEntero)}," +
                    "${precioUnitario.toString().substring(longArrayEntero,longArrayEntero+2)}€"}
        return "-$nombre, Precio:0,$precioUnitario € "
    }

}