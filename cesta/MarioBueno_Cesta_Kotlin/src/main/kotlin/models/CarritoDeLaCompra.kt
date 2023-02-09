package models

import productosALaVenta

class CarritoDeLaCompra(val maxQuantity: Int) {

    //Init
    val arrayCesta = Array(8) { ProductoCarrito() }

    //Función para añadir un producto en el array inicializado, primero revisa que el producto introducido exista en el array, si existe, le cambia la cantidad, sino existe, lo crea.
    fun add (producto: ProductoDisponible, cantidad: Int) {
        if (arrayCesta[producto.id-1].id != producto.id) {
            arrayCesta[producto.id - 1].id = productosALaVenta[producto.id - 1].id
            arrayCesta[producto.id - 1].nombre = productosALaVenta[producto.id - 1].nombre
            arrayCesta[producto.id - 1].precio = productosALaVenta[producto.id - 1].precio
            arrayCesta[producto.id - 1].cantidad = cantidad
        }else {
            arrayCesta[producto.id-1].cantidad += (cantidad)
        }
        println("$cantidad unidad/es de ${producto.nombre} añadida/s al carrito")
    }

    //Función para quitar un objeto del carrito, revisa que la cantidad introducida no sea mayor de la que hay en el carrito.
    fun remove(producto: ProductoDisponible, cantidad: Int) {
        for (i in arrayCesta) {
                if (i.id == producto.id)
                    when {
                        i.cantidad > cantidad ->{
                            i.cantidad -= cantidad
                            println("Se han quitado $cantidad unidad/es de ${producto.nombre} del carrito.")
                        }
                        i.cantidad < cantidad -> {
                            println("Error: La cantidad introducida es mayor a la que hay del producto")
                        }
                        else -> {
                            i.id = 0
                            i.nombre = ""
                            i.precio = 0.0
                            i.cantidad = 0
                            println("Se ha eliminado el producto ${producto.nombre} del carrito")
                        }
                    }
            }
    }

    //Recorre el array para imprimir en pantalla el id, el nombre, el precio y la cantidad que hay de un producto en el carrito de la compra
    fun imprimirProductos() {
        for (i in arrayCesta){
            if (i.id != 0) {
                println("ID: ${i.id}, Nombre: ${i.nombre}, Precio: ${i.precio} €, Cantidad: ${i.cantidad}")
            }
        }
    }

    //Hace la suma del precio total de los articulos añadidos al carrito de la compra
    fun precioTotal(): Double {
        var total = 0.0
        for (i in arrayCesta) {
            if (i.id != 0) {
                val suma = i.cantidad * i.precio
                total += suma
            }
        }
        return total
    }
}
