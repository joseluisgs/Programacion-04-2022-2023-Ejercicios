package simulacionCesta.utils

import simulacionCesta.factories.FinalCestFactory
import simulacionCesta.models.FinalCest
import java.util.*


fun menuCest(cest: FinalCest?) {
    // Presentamos la cesta inicial
    println("CARGANDO SU CESTA DE LA COMPRA...")
    Thread.sleep(2000)
    falsoBorradoDeConsola()
    cest!!.printCompleteCest()
    val scanner = Scanner(System.`in`)
    while (true) {
        println("(USUARIO COMPRADOR) -> Selecciona la opción deseada: ")
        println()
        println("1: Listar cesta de compra por nombre ascendente")
        println("2: Listar cesta de compra por precio descendente")
        println("3: Actualizar un producto")
        println("4: Sortear una nueva compra (esto eliminará la anterior compra)")
        println("0: Salir")
        val option = scanner.nextLine()
        when (option) {
            "1" -> {
                falsoBorradoDeConsola()
                listByNameAscendent(cest)
                falsoBorradoDeConsola()
                menuCest(cest)
            }

            "2" -> {
                falsoBorradoDeConsola()
                listByPriceDescendent(cest)
                falsoBorradoDeConsola()
                menuCest(cest)
            }

            "3" -> {
                falsoBorradoDeConsola()
                updateProduct(cest)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "4" -> {
                falsoBorradoDeConsola()
                newCest(cest)
            }

            "0" -> {
                falsoBorradoDeConsola()
                System.exit(0)
            }
        }
    }
}

/**
 * BubbleSort ordenado por nombre en orden ascendente (a-z)
 *
 * @param cest donde se encuentran los productos
 */

fun listByNameAscendent(cest: FinalCest?) {
    for (i in cest!!.productsStorage!!.storageProducts.indices) {
        for (j in i + 1 until cest.productsStorage!!.storageProducts.size) {

            // Comparar un String con el siguiente String
            if (cest.productsStorage!!.storageProducts[i]!!.name!!.compareTo(cest.productsStorage!!.storageProducts[j]!!.name!!) > 0) {
                // Cambiamos
                val aux = cest.productsStorage!!.storageProducts[i]
                cest.productsStorage!!.storageProducts[i] = cest.productsStorage!!.storageProducts[j]
                cest.productsStorage!!.storageProducts[j] = aux
            }
        }
    }
}

/**
 * BubbleSort ordenado por precio de mayor a menor, descendente (9-1)
 *
 * @param cest donde se encuentran los productos
 */

fun listByPriceDescendent(cest: FinalCest?) {
    for (i in cest!!.productsStorage!!.storageProducts.indices) {
        for (j in 0 until cest.productsStorage!!.storageProducts.size - 1) {
            if (cest.productsStorage!!.storageProducts[j] != null
                && cest.productsStorage!!.storageProducts[j + 1] != null
            ) {
                if (cest.productsStorage!!.storageProducts[j]!!.calculateTotalPricePerProduct() < cest.productsStorage!!.storageProducts[j + 1]!!.calculateTotalPricePerProduct()) {
                    // Cambiamos
                    val aux = cest.productsStorage!!.storageProducts[j]
                    cest.productsStorage!!.storageProducts[j] = cest.productsStorage!!.storageProducts[j + 1]
                    cest.productsStorage!!.storageProducts[j + 1] = aux
                }
            }
        }
    }
}

@Throws(InterruptedException::class)
private fun updateProduct(cest: FinalCest?) {
    var exitPrincipalBucle = false
    while (!exitPrincipalBucle) {
        println("Esta es tu cesta de la compra actual:")
        cest!!.printCompleteCest()
        println()
        val userRespond = userRespond("Introduzca el nombre del producto que desees modificar (ejemplo -> Pan):")
        for (i in cest.productsStorage!!.storageProducts.indices) {
            if (cest.productsStorage!!.storageProducts[i] != null) {
                if (cest.productsStorage!!.storageProducts[i]!!.name == userRespond) {
                    decisionToUpdate(cest, i)
                    println("CESTA ACTUALIZADA")
                    Thread.sleep(1000)
                    falsoBorradoDeConsola()
                }
                if (i == cest.productsStorage!!.storageProducts.size - 1) {
                    println("No existe el producto que has escrito")
                    Thread.sleep(1000)
                    falsoBorradoDeConsola()
                }
            }
        }
        while (true) {
            val userReTry = userRespond("Quieres buscar nuevamente un producto? (Y/N)")
            if (userReTry == "Y" || userReTry == "y") {
                break
            } else if (userReTry == "N" || userReTry == "n") {
                exitPrincipalBucle = true
            } else {
                println("Debes introducir (Y/N)!")
                Thread.sleep(1200)
                falsoBorradoDeConsola()
            }
        }
    }
}

@Throws(InterruptedException::class)
private fun decisionToUpdate(cest: FinalCest?, positionOfProduct: Int) {
    while (true) {
        val userRespond = userRespond("Puede añadir,restar y eliminar por completo un producto (A/R/E):")
        if (userRespond == "A") {
            addQuantityProduct(cest, positionOfProduct)
        } else if (userRespond == "R") {
            restQuantityProduct(cest, positionOfProduct)
        } else if (userRespond == "E") {
            deleteProduct(cest, positionOfProduct)
            menuCest(cest)
        } else {
            println("Debes introducir (A/R/E)!")
            Thread.sleep(1200)
            falsoBorradoDeConsola()
        }
    }
}

/**
 * Elimina un producto que el usuario desee, asignaremos como nulo donde se encuentre el producto
 * eliminado y lo arrastraremos hasta el final del almacén, por tanto, debemos ahora tener un control
 * de nulos mayor.
 *
 * @param cest              para poder eliminar en la cesta el producto
 * @param positionOfProduct para poder detallar en que posición de la cesta
 * @throws InterruptedException
 */

fun deleteProduct(cest: FinalCest?, positionOfProduct: Int) {
    cest!!.productsStorage!!.storageProducts[positionOfProduct] = null
    for (i in cest.productsStorage!!.storageProducts.indices) {
        for (j in 0 until cest.productsStorage!!.storageProducts.size - 1) {
            if (cest.productsStorage!!.storageProducts[j] == null
                && cest.productsStorage!!.storageProducts[j + 1] != null
            ) {
                val aux = cest.productsStorage!!.storageProducts[j]
                cest.productsStorage!!.storageProducts[j] = cest.productsStorage!!.storageProducts[j + 1]
                cest.productsStorage!!.storageProducts[j + 1] = aux
            }
        }
    }
    println("Producto eliminado...")
    println("CARGANDO NUEVA CESTA...")
    Thread.sleep(2000)
}

/**
 * Resta la cantidad de un producto que el usuario desee
 *
 * @param cest              para poder restar en la cesta el producto
 * @param positionOfProduct para poder detallar en que posición de la cesta
 * @throws InterruptedException
 */
@Throws(InterruptedException::class)
fun restQuantityProduct(cest: FinalCest?, positionOfProduct: Int) {
    while (true) {
        val userRespond = userRespond("Elige la cantidad que quieras restar a tu producto:")
        if (checkInteger(userRespond)) {

            if (userRespond.toInt() > 0
                && userRespond.toInt() <= cest!!.productsStorage!!.storageProducts[positionOfProduct]!!.quantity
            ) {
                if (userRespond.toInt() == cest.productsStorage!!.storageProducts[positionOfProduct]!!.quantity) {
                    deleteProduct(cest, positionOfProduct)
                } else {
                    cest.productsStorage!!.storageProducts[positionOfProduct]!!.quantity =
                        cest.productsStorage!!.storageProducts[positionOfProduct]!!.quantity - userRespond.toInt()
                    println("Producto actualizado...")
                    println("CARGANDO NUEVA CESTA...")
                    Thread.sleep(2000)
                    menuCest(cest)
                }
            } else {
                println("Por favor, introduzca un número mayor de 1 y menor a su valor máximo " + cest!!.productsStorage!!.storageProducts[positionOfProduct]!!.quantity)
                Thread.sleep(2000)
                falsoBorradoDeConsola()
            }
        }
    }
}

/**
 * Añade la cantidad de un producto que el usuario desee
 *
 * @param cest              para poder aumentar en la cesta el producto
 * @param positionOfProduct para poder detallar en que posición de la cesta
 * @throws InterruptedException
 */
@Throws(InterruptedException::class)
fun addQuantityProduct(cest: FinalCest?, positionOfProduct: Int) {
    while (true) {
        val userRespond = userRespond("Elige la cantidad que quieras añadir a tu producto:")
        if (checkInteger(userRespond)) {
            if (userRespond.toInt() > 0) {
                cest!!.productsStorage!!.storageProducts[positionOfProduct]!!.quantity =
                    cest.productsStorage!!.storageProducts[positionOfProduct]!!.quantity + userRespond.toInt()
                println("Producto actualizado...")
                println("CARGANDO NUEVA CESTA...")
                Thread.sleep(2000)
                menuCest(cest)
            } else {
                println("Por favor, introduzca un número mayor de 0")
                Thread.sleep(2000)
                falsoBorradoDeConsola()
            }
        }
    }
}

/**
 * Se le presentará un mensaje al usuario y deberá introducir una respuesta que recogeremos
 *
 * @param message que se le muestra al usuario
 * @return la respuesta del usuario
 */
private fun userRespond(message: String): String {
    println(message)
    val r = Scanner(System.`in`)
    return r.nextLine()
}

/**
 * Creamos una nueva cesta de compra aleatoria
 *
 * @param cest la cesta que voy a reiniciar
 */

fun newCest(cest: FinalCest?) {
    var cest = cest
    cest = FinalCestFactory.create()
    println("CARGANDO SU NUEVA CESTA DE LA COMPRA...")
    Thread.sleep(2000)
    falsoBorradoDeConsola()
    cest.printCompleteCest()
}

/**
 * Filtra una cadena de caracteres para asegurar que sea números
 *
 * @param entradaUsuario La cadena de caracteres a filtrar.
 * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
 */
@Throws(InterruptedException::class)
fun checkInteger(entradaUsuario: String): Boolean {
    val regex = "[0-9]*"
    if (!entradaUsuario.matches(regex.toRegex())) {
        println("Debes introducir un número!")
        Thread.sleep(2000)
        println()
        return false
    }
    return true
}

/**
 * Permite al usuario volver al menú principal.
 *
 * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
 */
private fun returnToMenu(): Boolean {
    println()
    println("Introduzca (menu), para volver al menú principal:")
    val sc = Scanner(System.`in`)
    val entradaDireccionMenu = sc.nextLine().lowercase(Locale.getDefault())
    return entradaDireccionMenu == "menu"
}

/**
 * Crea una sensación de borrado de la consola.
 * Mediante una impresión de varias líneas en blanco.
 */
private fun falsoBorradoDeConsola() {
    // Para crear una sensación de borrado en consola
    for (i in 0..39) {
        println()
    }
}
