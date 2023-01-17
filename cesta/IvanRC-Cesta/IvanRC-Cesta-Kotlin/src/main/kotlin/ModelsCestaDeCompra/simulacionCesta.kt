package ModelsCestaDeCompra

import FactoriesCestaDeCompra.FactoryCesta

fun main(args: Array<String>) {
    val cesta = FactoryCesta.getInstance()!!.crearCestaRandom()

    var opcion = 0
    do {
        opcion = menu()
        when (opcion) {
            1 -> cesta.listaCesta.añadirProductosALaListaDeLaCesta()
            2 -> cesta.listaCesta.eliminarProductosALaListaDeLaCesta()
            3 -> cesta.listaCesta.actualizarProductosALaListaDeLaCesta()
            4 -> cesta.listaCesta.optenerElTotalDeLosProductosEnCaja()
            5 -> cesta.listaCesta.representarLaListaDeLaCesta()
        }
    }while(opcion != 0)
    println("${Colores.CYAN.color}Adios...")
}

/**
 * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
 * @return la opcion seleccionada por el usuario
 */
fun menu(): Int{
    println("${Colores.GREEN.color}****************************************************")
    println("*                      MENÚ                        *")
    println("****************************************************")
    println("* ${Colores.YELLOW.color}[1] ${Colores.CYAN.color}Añadir producto a la cesta${Colores.GREEN.color}                   *")
    println("* ${Colores.YELLOW.color}[2] ${Colores.CYAN.color}Eliminar producto de la cesta${Colores.GREEN.color}                *")
    println("* ${Colores.YELLOW.color}[3] ${Colores.CYAN.color}Actualizar cantidad de producto en la cesta${Colores.GREEN.color}  *")
    println("* ${Colores.YELLOW.color}[4] ${Colores.CYAN.color}Obtener el total de dinero de la cesta${Colores.GREEN.color}       *")
    println("* ${Colores.YELLOW.color}[5] ${Colores.CYAN.color}Mostrar la lista de la cesta${Colores.GREEN.color}                 *")
    println("* ${Colores.YELLOW.color}[0] ${Colores.CYAN.color}Salir${Colores.GREEN.color}                                        *")
    println("****************************************************")
    return introducirOpcion()
}

/**
 * función que sirve para introducir una opción válida
 * @return la opcion válida
 */
fun introducirOpcion(): Int {
    var opcion = ""
    do {
        try {
            opcion = readln().trim()
            opcionValida(opcion)
        } catch (e: Exception) {
            println(e.message)
            opcion = ""
        }
    } while (opcion == "")
    return opcion.toInt()
}

/**
 * función que sirve para validar la opción introducida por teclado
 * @param opcion lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun opcionValida(opcion: String?): Boolean {
    require(opcion != null){"${Colores.RED.color}La opción no puede ser nula, vuelve a probar:"}
    val regex = Regex("-?[0-9]+")
    require(opcion!!.matches(regex)){"${Colores.RED.color}La opción introducida no es válida, vuelve a probar:"}
    require(opcion.toInt() in 0..5){"${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:"}
    return true
}
