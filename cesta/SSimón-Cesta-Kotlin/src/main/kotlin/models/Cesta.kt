package models

import models.ListaProductos.Companion.listaProductos

open class Cesta {
    var listaCesta: Array<Productos?> = Array(10) { null }
    private var disponibilidadCesta: Int = 0

    fun verCesta() {
        var precioTotal: Double = 0.0
        var isProductos: Boolean = false
        var contador = 0
        for (i in listaCesta.indices) {
            if (listaCesta[i] != null) {
                println()
                println("${i + 1}. " + listaCesta[i])
                val cantidad: Int? = listaCesta[i]?.cantidad
                val coste: Double? = listaCesta[i]?.precioUnitario
                if (coste != null && cantidad != null) {
                    precioTotal += (coste * cantidad)
                }
                isProductos = true
            }
        }
        if (isProductos) {
            println()
            println("Precio Total: $precioTotal")
            println("La cesta posee $disponibilidadCesta productos de ${listaCesta.size}")
        } else {
            println("La cesta esta vaciá")
        }
    }

    fun agregarProductos(idProducto: Int, cantidad: Int): Productos? {
        for (i in listaCesta.indices) {
            if (listaCesta[i] == null) {
                listaCesta[i] = listaProductos[idProducto]
                listaCesta[i]?.setCantidad(cantidad)
                return listaCesta[i]
            }
        }
        return listaCesta[0]
    }

    fun disminuirDisponibilidad(): Int {
        disponibilidadCesta++
        println("La cesta posee $disponibilidadCesta productos de ${listaCesta.size}")
        return disponibilidadCesta
    }

    fun isHuecoDisponible(): Boolean {
        return disponibilidadCesta < listaCesta.size
    }

    fun isElMismoProducto(idProducto: Int): Boolean {
        for (i in listaCesta.indices) {
            if (listaCesta[i] == listaProductos[idProducto]) {
                sumarUnProducto(i)
                return true
            }
        }
        return false
    }

    fun sumarUnProducto(idProducto: Int): Productos? {
        val numeroProductos: Int? = listaCesta[idProducto]?.cantidad
        if (numeroProductos != null) {
            listaCesta[idProducto]?.setCantidad(numeroProductos + 1)
            return listaCesta[idProducto]
        }
        return listaCesta[idProducto]
    }

    fun eliminarProductos(idProducto: Int): Productos? {
        if (listaCesta[idProducto] != null) {
            listaCesta[idProducto] = null
            disponibilidadCesta--
            ordenarCesta(idProducto)
            println("Producto eliminado")
            return listaCesta[idProducto]
        } else {
            println("No se puede eliminar un producto que no existe")
        }
        return listaCesta[idProducto]
    }

    fun ordenarCesta(idProducto: Int) {
        for (i in (idProducto until listaCesta.size - 1)) {
            listaCesta[i] = listaCesta[i + 1]
        }
    }

    fun actualizarProducto(idProducto: Int, cantidad: Int): Int? {
        if (listaCesta[idProducto] != null) {
            listaCesta[idProducto]?.setCantidad(cantidad)
            return listaCesta[idProducto]?.cantidad
        } else {
            println("Producto no seleccionado")
            return listaCesta[idProducto]?.cantidad
        }
    }
}
