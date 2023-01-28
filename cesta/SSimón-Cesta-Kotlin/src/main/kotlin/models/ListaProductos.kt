package models

import factories.ProductosFactory

class ListaProductos {
    companion object {
        val listaProductos: Array<Productos> = Array(20) { ProductosFactory.getProductos().createProduct() }

        fun leerListaProductos() {
            var contador = 1
            for (i in 0..19) {
                println(contador.toString() + ". Nombre: " + listaProductos[i].nombre + "\n    Precio: " + listaProductos[i].precioUnitario + "€")
                contador++
            }
        }
    }
}