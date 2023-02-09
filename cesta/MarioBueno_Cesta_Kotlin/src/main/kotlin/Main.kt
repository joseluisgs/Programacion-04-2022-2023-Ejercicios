import models.CarritoDeLaCompra
import models.ProductoDisponible
import kotlin.math.round

val productosALaVenta = arrayOf(
    ProductoDisponible(1, "Camiseta Nike", 20.00),
    ProductoDisponible(2, "Zapatillas Jordan One Retro", 130.00),
    ProductoDisponible(3, "Sudadera Snipes Gris", 60.00),
    ProductoDisponible(4, "Calcetines Jordan", 10.00),
    ProductoDisponible(5, "Bandolera Adidas", 20.00),
    ProductoDisponible(6, "Camiseta Adidas", 10.00),
    ProductoDisponible(7, "Sudadera Adidas", 30.00),
    ProductoDisponible(8, "Gorro Nike", 20.00)
)

val carritoPrincipal: CarritoDeLaCompra = CarritoDeLaCompra(20)

fun main() {
    when (imputNum("""
        |
        |¿Qué deseas hacer?:
        |1 - Mostrar productos a la venta
        |2 - Añadir producto al carrito
        |3 - Quitar un producto del carrito
        |4 - Ver productos añadidos al carrito carrito
        |5 - Salir
    """.trimMargin(),1..5)){
        1 -> mostrarProductosDisponibles()
        2 -> addProducto()
        3 -> quitarProducto()
        4 -> verCarrito()
        5 -> println("Gracias por utilizar el carrito de la compra")
    }
}

//fución que llama al método add de la clase CarritoDeLaCompra
fun addProducto () {
    val producto: Int = (imputNum("Introduce el ID del producto que quieres añadir al carrito: ", 1..8))
    val cantidad: Int = imputNum("Introduce la cantidad que quieras añadir: ", 1..20)
    if (cantidadDeProductosEnElCarrito()+ cantidad <= carritoPrincipal.maxQuantity)
        carritoPrincipal.add(productosALaVenta[producto-1], cantidad)
    else
        println("La cantidad que quieres añadir supera el límite del carrito")
    main()
}

//fución que llama al método remove de la clase CarritoDeLaCompra
fun quitarProducto () {
    if (cantidadDeProductosEnElCarrito() == 0)
        println("El carrito está vacío")
    else {
        carritoPrincipal.imprimirProductos()
        carritoPrincipal.remove(productosALaVenta[imputNum("Introduce el ID del objeto que quieras quitar: ",1..8)-1], imputNum("Introduce la cantidad que quieres quitar: ",1..20))
    }
    main()
}

//fución que llama al método imprimirProductos de la clase CarritoDeLaCompra
fun verCarrito() {
    if (cantidadDeProductosEnElCarrito() == 0)
        println("El carrito está vacío")
    else {
        carritoPrincipal.imprimirProductos()
        println("Total: ${round(carritoPrincipal.precioTotal())} €")
    }
    main()
}

//Muestra los productos a la venta
fun mostrarProductosDisponibles() {
    println ("""Estos son los productos que están disponibles ahora mismo:
            |ID: ${productosALaVenta[0].id} - ${productosALaVenta[0].nombre} - ${productosALaVenta[0].precio}€
            |ID: ${productosALaVenta[1].id} - ${productosALaVenta[1].nombre} - ${productosALaVenta[1].precio}€
            |ID: ${productosALaVenta[2].id} - ${productosALaVenta[2].nombre} - ${productosALaVenta[2].precio}€
            |ID: ${productosALaVenta[3].id} - ${productosALaVenta[3].nombre} - ${productosALaVenta[3].precio}€
            |ID: ${productosALaVenta[4].id} - ${productosALaVenta[4].nombre} - ${productosALaVenta[4].precio}€
            |ID: ${productosALaVenta[5].id} - ${productosALaVenta[5].nombre} - ${productosALaVenta[5].precio}€
            |ID: ${productosALaVenta[6].id} - ${productosALaVenta[6].nombre} - ${productosALaVenta[6].precio}€
            |ID: ${productosALaVenta[7].id} - ${productosALaVenta[7].nombre} - ${productosALaVenta[7].precio}€
        """.trimMargin())
    main()
}

//función que revisa que el carrito tenga algún producto
private fun cantidadDeProductosEnElCarrito(): Int {
    var x = 0
    for (i in carritoPrincipal.arrayCesta) {
        if (i.id != 0)
            x += i.cantidad
    }
    return x
}

//función para evitar imputs que no sean Int
private fun imputNum (message: String, range: IntRange): Int{
    println(message)
    var eleccion : Int
    do {
        eleccion = readln().toIntOrNull() ?: (range.last - 1)
        if (eleccion !in range)
            println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (eleccion !in range)
    return eleccion
}
