import models.Cesta
import models.ListaProductos
import models.ListaProductos.Companion.listaProductos

val Cesta = Cesta()

fun main() {
    menu()
}

fun menu() {
    val menu = """
1. Agregar producto
2. Eliminar producto 
3. Actualizar producto
4. Ver cesta
5. Ver productos disponibles
0. Salir
    """.trim()
    do {
        var option: String
        do {
            println(menu)
            option = readln()
            val isRegexValido: Boolean = menuRegex(option)
        } while (!isRegexValido)
        when (option.toInt()) {
            1 -> agregarProductos()
            2 -> eliminarProducto()
            3 -> actualizarProducto()
            4 -> verCesta()
            5 -> verProductos()
            0 -> println("Adios!!")
        }
    } while (option.toInt() != 0)
}

fun menuRegex(option: String): Boolean {
    val regex = "[0-5]".toRegex()
    return if (option.matches(regex)) {
        true
    } else {
        println("No es una opción valida");
        false
    }
}

fun compruebaID(idProducto: String): Boolean {
    val regex = "\\d|\\d{2}".toRegex()
    return if (idProducto.matches(regex) && idProducto.toInt() <= listaProductos.size && idProducto.toInt() != 0) {
        true
    } else {
        println("No es una opción valida");
        false
    }
}

fun agregarProductos() {
    var cantidad: Int = 1
    var idProducto: String
    do {
        println("Introduce el número del producto que deseas agregar")
        idProducto = readln()
        val isRegexValido: Boolean = compruebaID(idProducto)
    } while (!isRegexValido)

//    do {
//        println("¿Cuantos productos quieres agregar?")
//        cantidad = cuantosProductos()
//    } while (cantidad == -1)

    if (Cesta.isHuecoDisponible()) {
        if (!Cesta.isElMismoProducto(idProducto.toInt() - 1)) {
            Cesta.agregarProductos(idProducto.toInt() + 1, cantidad)
            Cesta.disminuirDisponibilidad()
        }
    } else {
        println("No se pueden añadir más productos")
    }
}

fun cuantosProductos(): Int {
    val cantidad: String = readln()
    val regex = "\\d{1,3}".toRegex()
    return if (cantidad.matches(regex) && cantidad.toInt() != 0) {
        cantidad.toInt()
    } else {
        println("No es una cantidad valida");
        return -1
    }
}

fun eliminarProducto() {
    var idProducto: String = ""
    do {
        println("Introduce el número del producto que deseas eliminar")
        idProducto = readln()
        val isRegexValido: Boolean = compruebaID(idProducto)
    } while (!isRegexValido)
    Cesta.eliminarProductos(idProducto.toInt() - 1)
}

fun actualizarProducto() {
    var idProducto: String = ""
    var cantidad: Int = -1
    do {
        println("Introduce el número del producto que deseas modificar su cantidad")
        idProducto = readln()
        val isRegexValido: Boolean = compruebaID(idProducto)
    } while (!isRegexValido)
    do {
        println("¿Cuantos productos quieres agregar?")
        cantidad = cuantosProductos()
    } while (cantidad == -1)
//    println("Product $idProducto Cantidad: $cantidad")
    Cesta.actualizarProducto(idProducto.toInt() - 1, cantidad)
}

fun verCesta() {
    Cesta.verCesta()
}

private fun verProductos() {
    ListaProductos.leerListaProductos()
}