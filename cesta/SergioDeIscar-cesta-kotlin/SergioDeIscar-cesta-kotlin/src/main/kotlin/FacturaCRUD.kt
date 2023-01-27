package factura

import factura.factories.ProductoFactory
import factura.models.Factura
import factura.models.ItemFactura
import factura.models.Producto
import java.time.LocalDate
import kotlinx.coroutines.*

fun main(){
    val productos = Array((1..15).random()){ Producto("name", 1f, 1) }
    ProductoFactory.getInstance().createProductoRandom(productos)

    val nombreUsuario = inputString("Introduce el nombre del propietario de la compra: ")

    //Coroutine para simular el cambio de precio
    //val simMercado = simularMercado(productos, 1000)

    // Lo hago así para que al hacer un readln no pare la ejecución de la coroutine que simula el mercado
    //runBlocking {
        val factura = Factura(nombreUsuario, LocalDate.now())
        do {
            when(menu()){
                1 -> { println(factura); /*delay(4000)*/ Thread.sleep(4000) }
                2 -> addItemAlCarro(factura, productos)
                3 -> factura.deleteItem(
                        inputNumber("Introduce la posición del carrito donde quieres eliminar:",
                            1..20) -1)
                4 -> {
                    val producto = inputProducto(productos)
                    factura.updateItem(
                    inputNumber("Introduce la posición del carrito donde quieres eliminar:",
                    1..20) -1,
                    ItemFactura(producto ?: continue, inputNumber("Introduce la cantidad de producto que quieres comprar: ", 1..producto.stock)))
                }
                5 -> factura.findItem(
                    inputNumber("Introduce la posición del carrito donde quieres eliminar:",
                    1..20) -1)
                6 -> { println(mostrarProductos(productos)); /*delay(4000)*/ Thread.sleep(4000) }
                else -> break
            }
        }while (true)
        //simMercado.cancelAndJoin()

        println(factura)
    //}
}

private fun addItemAlCarro(factura: Factura, opciones: Array<Producto>){
    val producto = inputProducto(opciones)
    if (producto == null){
        printError("No se ha encontrado el producto")
        return
    }
    val cantidad = inputNumber("Introduce la cantidad de producto que quieres comprar: ", 1..producto.stock)

    val index = opciones.indexOf(producto)

    val item = ItemFactura(producto, cantidad)
    factura.addItem(item)

    opciones[index].SetStock(opciones[index].stock - cantidad)

    println("Se ha añadido:\n\t$item")
}

fun mostrarProductos(productos: Array<Producto>): String {
    val stringBuilder = StringBuilder("Lista de productos disponibles:")
    for (i in productos.indices){
        stringBuilder.append("\n\t${i+1}-> ").append(productos[i])
    }
    return stringBuilder.toString()
}

private fun menu(): Int{
    return inputNumber("¿Qué quieres hacer?\n" +
            "1->\tMostrar carrito\n" +
            "2->\tAñadir producto al carrito\n" +
            "3->\tBorrar producto del carrito\n" +
            "4->\tCambiar producto del carrito\n" +
            "5->\tBuscar producto buscar del carrito\n" +
            "6->\tMostrar todos los productos disponibles\n" +
            "7->\tFinalizar compra\n",
        1..7)
}

//region Input
//region Producto
private fun inputProducto(opciones: Array<Producto>): Producto?{
    if (inputNumber(mostrarProductos(opciones) + "\n\n\n" + "¿Como quieres seleccionar el producto?\n" +
                "1->\tSeleccionar por nombre\n" +
                "2->\tSeleccionar por número de lista", 1..2) == 1)
        return inputProductoByName(opciones)
    return inputProductoByIndex(opciones)
}
private fun inputProductoByName(opciones: Array<Producto>): Producto?{
    val nombreFind = inputString(mostrarProductos(opciones) + "\n\n\n" + "Introduce el nombre del producto que vas a añadir:")
    for (i in opciones){
        if (i.nombre.lowercase().trim() == nombreFind.lowercase().trim())
            return i
    }
    return null
}
private fun inputProductoByIndex(opciones: Array<Producto>): Producto{
    return opciones[inputNumber(mostrarProductos(opciones) + "\n\n\n" + "Introduce el número del producto que vas a añadir:", 1..opciones.size) - 1]
}
//endregion
//region Simple
fun inputNumber(message: String, range: IntRange = 0..999): Int{
    clearConsole()
    println(message)
    var response: Int
    do {
        response = readln().toIntOrNull()?: -1
        if (response !in range) println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (response !in range)
    return response
}
fun inputString(message: String): String {
    clearConsole()
    println(message)
    return readln()
}
//endregion
//endregion

private fun printError(error: String){
    println("Error: $error")
    Thread.sleep(1500)
}

/**
 * Coroutine que se encarga de simular el cambio de precio aleatorio de los productos
 * @param productos Productos que se van ha estar actualizando
 * @param delay Espacio de tiempo entre actualización y actualización
 * @see Producto
 * @see Factura
 */
/*fun simularMercado(productos: Array<Producto>, delay: Long = 5000) = GlobalScope.launch{
    do {
        delay(delay)
        for (i in productos.indices){
            productos[i].SetPrecio(ProductoFactory.getInstance().getPrecioRandom())
        }
    }while (true)
}*/

fun clearConsole(count: Int = 30){
    for (i in 0..count){
        println()
    }
}