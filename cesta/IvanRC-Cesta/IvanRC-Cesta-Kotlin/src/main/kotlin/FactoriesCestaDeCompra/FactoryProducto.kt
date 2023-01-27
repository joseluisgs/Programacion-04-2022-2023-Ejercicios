package FactoriesCestaDeCompra

import ModelsCestaDeCompra.Producto

class FactoryProducto {

    companion object{
        private var instance: FactoryProducto? = null

        fun getInstance(): FactoryProducto?{
            if(instance == null){
                instance = FactoryProducto()
            }
            return instance
        }
        var contadorProductos = 1
        fun nextId():Int{
            return contadorProductos++
        }
    }

    /**
     * función que sirve para crear un producto aleatoriamente
     * @return el producto cuyas propiedades se crearon al azar
     */
    fun crearProductoRandom(): Producto {
        val precioUnitario = arrayOf(12.0,2.32,4.3,4.56,76.44,22.0,12.43,24.3,8.56,7.44,16.0, 34.32,4.44,7.54,7.84,9.74,8.45,3.24,15.98,6.09,4.99)
        val nombreProductos = arrayOf("gasolina", "coche", "moto", "camión", "mira", "telefono", "gato", "deberes", "sofa", "silla", "chalet", "garrafa", "garra", "portatil", "procesador", "rueda", "carrusel", "pinguino", "pera", "manzana", "aguacate")
        return Producto(nextId(), precioUnitario.random(), nombreProductos.random())
    }
}