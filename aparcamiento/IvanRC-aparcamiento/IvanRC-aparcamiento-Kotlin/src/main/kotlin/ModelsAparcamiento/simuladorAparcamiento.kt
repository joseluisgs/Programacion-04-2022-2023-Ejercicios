package ModelsAparcamiento

fun main(args: Array<String>) {
    val aparcamiento = Aparcamiento()
    var opcion = 0
    do {
        println("${Colores.CYAN.color}Seleccione la opción que deseé:")
        opcion = menu()
        when (opcion) {
            1 -> aparcamiento.aparcarUnNuevoVehiculo()
            2 -> aparcamiento.sacarVehiculoDeAparcamiento()
            3 -> aparcamiento.listadoDeVehiculos()
            4 -> aparcamiento.cuantosVehiculosTieneUnConductorAparcados()
            5 -> aparcamiento.recaudacion()
        }
    } while (opcion != 0)
    println("${Colores.CYAN.color}Adios..")
}

/**
 * función que presenta un menú con todas la opciones posibles, al usuario
 * @return la opción que haya introducido el usuario
 */
fun menu(): Int {
    println("${Colores.GREEN.color}************************************************************")
    println("*                          menú                            *")
    println("************************************************************")
    println("* ${Colores.YELLOW.color}[1] ${Colores.CYAN.color}Aparcar un nuevo vehículo${Colores.GREEN.color}                            *")
    println("* ${Colores.YELLOW.color}[2] ${Colores.CYAN.color}Sacar un vehículo del aparcamiento${Colores.GREEN.color}                   *")
    println("* ${Colores.YELLOW.color}[3] ${Colores.CYAN.color}Mostrar un listado de vehiculos${Colores.GREEN.color}                      *")
    println("* ${Colores.YELLOW.color}[4] ${Colores.CYAN.color}Cuantos vehículos aparcados tiene un conductor${Colores.GREEN.color}       *")
    println("* ${Colores.YELLOW.color}[5] ${Colores.CYAN.color}Calcular recaudación total${Colores.GREEN.color}                           *")
    println("* ${Colores.YELLOW.color}[0] ${Colores.CYAN.color}Salir${Colores.GREEN.color}                                                *")
    println("************************************************************")
    return introducirOpcion()
}

/**
 * función que sirve para introducir una opción, validarla y devolverla
 * @return la opción introducida y validada
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
 * función que sirve para comprobar si la opción introducida es válida
 * @param opcion es la opcion que queremos validar
 * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
 */
fun opcionValida(opcion: String?): Boolean {
    requireNotNull(opcion) { "${Colores.RED.color}La opción seleccionada no puede ser nula, vuelva a probar:" }
    require(!opcion.isEmpty()) { "${Colores.RED.color}La opción seleccionada no puede estar vacia, vuelva a probar:" }
    val opciones = opcion.toInt()
    require(!(opciones < 0 || opciones > 5)) { "${Colores.RED.color}La opción seleccionada es inválida, vuelva a probar:" }
    return true
}