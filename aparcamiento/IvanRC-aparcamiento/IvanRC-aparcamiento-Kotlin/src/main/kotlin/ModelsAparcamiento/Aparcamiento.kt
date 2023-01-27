package ModelsAparcamiento

import FactoriesAparcamiento.FactoryConductor
import FactoriesAparcamiento.FactoryVehiculo

class Aparcamiento {
    var aparcamientos: Array<Array<Vehiculo?>> = Array(4) { Array<Vehiculo?>(4){null} }
    var contadorVehiculosAparcados = 0

    /**
     * función que sirve para introducir un vehículo en la matriz parking
     */
    fun aparcarUnNuevoVehiculo() {
        val posicionLibre = buscarPrimeraPosicionLibre()
        if (posicionLibre != "") {
            var nuevoVehiculo: Vehiculo? = null
            do {
                println("${Colores.CYAN.color}Seleccione la opción que deseé:")
                when (menu()) {
                    1 -> nuevoVehiculo = introducirDatosVehiculo()
                    2 -> nuevoVehiculo = FactoryVehiculo.getInstance()!!.createVehiculoRandom()
                }
            } while (nuevoVehiculo == null)
            println("${Colores.CYAN.color}De acuerdo, se ha aparcado el vehículo: " + aparcar(nuevoVehiculo, posicionLibre))
            contadorVehiculosAparcados++
        } else {
            println("${Colores.YELLOW.color}No hay más aparcamientos libres donde poder meter nuevos coches, libera espacio y vuelve a probar")
        }
    }

    /**
     * función que sirve para aparcar un vehículo en la matriz parking
     * @param nuevoVehiculo es el vehículo a introducir en el parking
     * @param posicionLibre es la posición donde meteremos al vehículo
     * @return el vehículo introducido en la matriz
     */
    fun aparcar(nuevoVehiculo: Vehiculo?, posicionLibre: String): Vehiculo? {
        val fila = posicionLibre.split("-")[0].toInt()
        val columna = posicionLibre.split("-")[1].toInt()
        aparcamientos[fila][columna] = nuevoVehiculo
        return aparcamientos[fila][columna]
    }

    /**
     * función que sirve para que el usuario introduzca los datos del vehiculo por teclado
     * @return el vehiculo creado con los datos introducidos por el usuario
     */
    private fun introducirDatosVehiculo(): Vehiculo {
        println("${Colores.CYAN.color}Introduce la información del nuevo vehículo a introducir en el parking:")
        println("${Colores.CYAN.color}Introduce la matrícula del vehículo:")
        val matricula = introducirMatricula()
        println("${Colores.CYAN.color}Introduce el año de fabricación del vehículo:")
        val añoFabricacion = introducirAñoFabricacion()
        println("${Colores.CYAN.color}Introduce el tipo de vehículo que tienes:")
        val tipo = introducirTipoVehiculo()
        println("${Colores.CYAN.color}Ahora te toca introducir la información del conductor del nuevo vehículo:")
        println("${Colores.CYAN.color}Introduce el nombre del conductor:")
        val nombre = introducirNombre()
        println("${Colores.CYAN.color}Introduce el dni del conductor:")
        val dni = introducirDni()
        return FactoryVehiculo.getInstance()!!.create(matricula, añoFabricacion, tipo, FactoryConductor.getInstance()!!.create(nombre, dni))
    }

    /**
     * función que sirve para sacar un vehículo de la matriz parking
     */
    fun sacarVehiculoDeAparcamiento() {
        if (matrizNoEstaVacia()) {
            println("${Colores.CYAN.color}La lista de vehículos actual es:${Colores.ROSE.color}")
            representarAparcamiento()
            println("${Colores.CYAN.color}Introduzca la matrícula del vehículo que deseas sacar del apartamento:")
            val posicionVehiculo = buscarVehiculoSegunMatricula(introducirMatricula())
            if (posicionVehiculo != "") {
                println("${Colores.CYAN.color}El coche: ${eliminarCocheDeAparcamiento(posicionVehiculo)}, que se encontraba en la posición $posicionVehiculo ha salido del parking")
            } else {
                println("${Colores.YELLOW.color}No hay ningún coche con esa matrícula")
            }
        } else {
            println("${Colores.YELLOW.color}No hay ningún vehículo aparcado")
        }
    }

    /**
     * función que sirve para obtener una lista de coches en el aparcamiento
     */
    private fun representarAparcamiento() {
        for (i in aparcamientos.indices) {
            for(j in aparcamientos[i].indices)
                if (aparcamientos[i][j] != null) {
                    println(aparcamientos[i][j])
                }
        }
    }

    /**
     * función que sirve para saber si la matriz de vehículos tiene vehículos o no
     * @return true en caso de que no este vacia, y false en caso contrario
     */
    fun matrizNoEstaVacia(): Boolean {
        var noEstaVacia = false
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] != null) {
                    noEstaVacia = true
                    break
                }
            }
            if (noEstaVacia) break
        }
        return noEstaVacia
    }

    /**
     * función que srive para eliminar un vehículo de el array parking
     * @param posicionVehiculo la fila y columna de donde eliminaremos al vehiculo
     */
    fun eliminarCocheDeAparcamiento(posicionVehiculo: String): Vehiculo? {
        val fila = posicionVehiculo.split("-")[0].toInt()
        val columna = posicionVehiculo.split("-")[1].toInt()
        val vehiculoAuxiliar = aparcamientos[fila][columna]
        aparcamientos[fila][columna] = null
        return vehiculoAuxiliar
    }

    /**
     * función que sirve para hallar el número total de vehiculos en el parking
     * @return el número de vehículos que hay
     */
    fun cuantosVehiculosHayAparcados(): Int {
        var contadorVehiculosAparcados = 0
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] != null) {
                    contadorVehiculosAparcados++
                }
            }
        }
        return contadorVehiculosAparcados
    }

    /**
     * función que sirve para representar el array de vehículos
     */
    fun listadoDeVehiculos() {
        if (matrizNoEstaVacia()) {
            val vectorVehiculos = pasarMatrizAVector(cuantosVehiculosHayAparcados())
            if (vectorVehiculos.size >= 2) {
                ordenarMetodoBurbujaDescendente(vectorVehiculos)
            }
            println("${Colores.CYAN.color}Hay un total de ${Colores.ROSE.color}${vectorVehiculos.size}${Colores.CYAN.color} vehículos aparcados, y son:${Colores.ROSE.color}")
            for (i in vectorVehiculos.indices) {
                if (vectorVehiculos[i] != null) {
                    println(vectorVehiculos[i])
                }
            }
        } else {
            println("${Colores.YELLOW.color}No hay ningún vehículo aparcado")
        }
    }

    /**
     * función que sirve para representar el número de coches en total que tiene un mismo usuario
     */
    fun cuantosVehiculosTieneUnConductorAparcados() {
        if (matrizNoEstaVacia()) {
            println("${Colores.CYAN.color}Introduzca el dni del conductor cuya cantidad de vehículos aparcados quiere comprobar:")
            val dni = introducirDni()
            println(
                "El conductor del dni: ${Colores.ROSE.color}$dni${Colores.CYAN.color} tiene aparcados un total de: " +
                        "${Colores.ROSE.color}${contarVehiculosAparcadosDeConductor(dni)}${Colores.CYAN.color} coches")
        } else {
            println("${Colores.YELLOW.color}No hay ningún vehículo aparcado")
        }
    }

    /**
     * función que sirve para representar la recaudación total
     */
    fun recaudacion() {
        println("${Colores.CYAN.color}Por ahora, a habido un total de ${Colores.ROSE.color}$contadorVehiculosAparcados${Colores.CYAN.color} vehículos, " +
                    "por lo que la recaudación actual ( a 3.75 euros el aparcamiento ) es de: ${Colores.ROSE.color}" +
                    "${String.format("%.2f", calcularRecaudacion())} euros")
    }

    /**
     * función que sirve para calcular la recaudación total
     */
    fun calcularRecaudacion(): Double {
        return contadorVehiculosAparcados * 3.75
    }

    /**
     * función que sirve para hallar el número de coches en total que tiene un mismo usuario
     * @param dni el dni del conductor cuyos coches queremos contar
     * @return el número de coches que tiene un usuario
     */
    fun contarVehiculosAparcadosDeConductor(dni: String): Int {
        var contador = 0
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] != null) {
                    if (aparcamientos[i][j]!!.conductor.dni == dni) {
                        contador++
                    }
                }
            }
        }
        return contador
    }

    /**
     * función que sirve para pasar la matriz de vehículos a un array de vehículos
     * @param cantidadVehiculos es la cantidad de vehículos que hay en el parking
     * @return el array de vehículos conseguido a traves de la matriz de vehículos
     */
    fun pasarMatrizAVector(cantidadVehiculos: Int): Array<Vehiculo?> {
        val vectorVehiculos: Array<Vehiculo?> = Array<Vehiculo?>(cantidadVehiculos){null}
        var contador = 0
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] != null) {
                    vectorVehiculos[contador] = aparcamientos[i][j]
                    contador++
                }
            }
        }
        return vectorVehiculos
    }

    /**
     * función que sirve para buscar un vehículo según su matrícula
     * @return la fila y columna vacia como un Pair<Int></Int>, Int>
     */
    fun buscarVehiculoSegunMatricula(matricula: String): String {
        var posicion = ""
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] != null) {
                    if (aparcamientos[i][j]!!.matricula == matricula) {
                        posicion = "$i-$j"
                        break
                    }
                }
            }
            if (posicion != "") break
        }
        return posicion
    }

    /**
     * función que sirve para buscar el primer hueco libre en el matriz parking
     * @return la fila y columna vacia como un Pair<Int></Int>, Int>
     */
    fun buscarPrimeraPosicionLibre(): String {
        var posicion = ""
        for (i in aparcamientos.indices) {
            for (j in aparcamientos[i].indices) {
                if (aparcamientos[i][j] == null) {
                    posicion = "$i-$j"
                    break
                }
            }
            if (posicion != "") {
                break
            }
        }
        return posicion
    }

    /**
     * función que sirve para introducir una matricula, validarla y devolverla
     * @return la matricula introducida y validada
     */
    fun introducirMatricula(): String {
        var matricula = ""
        do {
            try {
                matricula = readln().trim()
                matriculaValida(matricula)
            } catch (e: Exception) {
                println(e.message)
                matricula = ""
            }
        } while (matricula == "")
        return matricula
    }

    /**
     * función que sirve para comprobar si la matricula introducida es válida
     * @param matricula es la matricula que queremos validar
     * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
     */
    fun matriculaValida(matricula: String?): Boolean {
        requireNotNull(matricula) { "${Colores.RED.color}La matricula introducida no puede ser nula, vuelva a probar:" }
        require(!matricula.isEmpty()) { "${Colores.RED.color}La matricula introducida no puede estar vacia, vuelva a probar:" }
        val matriculaRegex = Regex("[0-9]{4}-[A-Z]{3}")
        require(matricula.matches(matriculaRegex)) { "${Colores.RED.color}La matrícula introducida no es válida, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para introducir un año de fabricación, validarlo y devolverlo
     * @return el año de fabricación introducido y validado
     */
    fun introducirAñoFabricacion(): Int {
        var añoFabricacion = ""
        do {
            try {
                añoFabricacion = readln().trim()
                añoFabricacionValido(añoFabricacion)
            } catch (e: Exception) {
                println(e.message)
                añoFabricacion = ""
            }
        } while (añoFabricacion === "")
        return añoFabricacion.toInt()
    }

    /**
     * función que sirve para comprobar si el año de fabricación introducido es válido
     * @param añoDeFabricacion es el año de fabricacion que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    fun añoFabricacionValido(añoDeFabricacion: String?): Boolean {
        requireNotNull(añoDeFabricacion) { "${Colores.RED.color}El año de fabricacion introducido no puede ser nulo, vuelva a probar:" }
        require(!añoDeFabricacion.isEmpty()) { "${Colores.RED.color}El año de fabricacion introducido no puede estar vacio, vuelva a probar:" }
        val añoFabricacion = añoDeFabricacion.toInt()
        require(!(añoFabricacion < 1950 || añoFabricacion > 2022)) { "${Colores.RED.color}El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para introducir un tipo, validarlo y devolverlo
     * @return el tipo introducido y validado
     */
    fun introducirTipoVehiculo(): tipoVehiculo? {
        var tipo = ""
        do {
            try {
                tipo = readln().trim()
                tipoValido(tipo)
            } catch (e: Exception) {
                println(e.message)
                tipo = ""
            }
        } while (tipo === "")
        var tipoV: tipoVehiculo? = null
        when (tipo) {
            "coche" -> tipoV = tipoVehiculo.coche
            "moto" -> tipoV = tipoVehiculo.moto
            "patinete" -> tipoV = tipoVehiculo.patinete
        }
        return tipoV
    }

    /**
     * función que sirve para comprobar si el tipo introducido es válido
     * @param tipo es el tipo que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    fun tipoValido(tipo: String?): Boolean {
        requireNotNull(tipo) { "${Colores.RED.color}El tipo introducido no puede ser nulo, vuelva a probar:" }
        require(!tipo.isEmpty()) { "${Colores.RED.color}El tipo introducido no puede estar vacio, vuelva a probar:" }
        require(!(tipo != "coche" && tipo != "moto" && tipo != "patinete")) { "${Colores.RED.color}El tipo introducido no es ni un coche, ni una moto, ni un patinete, por lo que no está permitido en el aparcamiento, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para introducir un nombre, validarlo y devolverlo
     * @return el nombre introducido y validado
     */
    fun introducirNombre(): String {
        var nombre = ""
        do {
            try {
                nombre = readln().trim()
                nombreValido(nombre)
            } catch (e: Exception) {
                println(e.message)
                nombre = ""
            }
        } while (nombre === "")
        return nombre
    }

    /**
     * función que sirve para comprobar si el nombre introducida es válido
     * @param nombre es el nombre que queremos validar
     * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
     */
    fun nombreValido(nombre: String?): Boolean {
        requireNotNull(nombre) { "${Colores.RED.color}El nombre introducido no puede ser nulo, vuelva a probar:" }
        require(!nombre.isEmpty()) { "${Colores.RED.color}El nombre introducido no puede estar vacio, vuelva a probar:" }
        val nombreRegex = Regex("[a-zA-ZáéúíóÁÉÚÍÓ]+")
        require(nombre.matches(nombreRegex)) { "${Colores.RED.color}El nombre introducido no es válido, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para introducir un dni, validarlo y devolverlo
     * @return el dni introducido y validado
     */
    fun introducirDni(): String {
        var dni = ""
        do {
            try {
                dni = readln().trim()
                dniValido(dni)
            } catch (e: Exception) {
                println(e.message)
                dni = ""
            }
        } while (dni === "")
        return dni
    }

    /**
     * función que sirve para comprobar si el dni introducido es válido
     * @param dni es el dni que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    fun dniValido(dni: String?): Boolean {
        requireNotNull(dni) {"${Colores.RED.color}El dni introducido no puede ser nulo, vuelva a probar:" }
        require(!dni.isEmpty()) { "${Colores.RED.color}El dni introducido no puede estar vacio, vuelva a probar:" }
        val dniRegex = Regex("[0-9]{8}[A-Z]")
        require(dni.matches(dniRegex)) { "${Colores.RED.color}El dni introducido no es válido, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para ordenar la de manera descendente el array de vehículos
     */
    fun ordenarMetodoBurbujaDescendente(vectorVehiculos: Array<Vehiculo?>) {
        for (i in vectorVehiculos.indices) {
            for (j in 0 until vectorVehiculos.size - i) {
                if (j >= 0 && j < vectorVehiculos.size && j + 1 >= 0 && j + 1 < vectorVehiculos.size) {
                    if (vectorVehiculos[j]!!.añoFabricacion < vectorVehiculos[j + 1]!!.añoFabricacion) {
                        val vehiculoAuxiliar = vectorVehiculos[j + 1]
                        vectorVehiculos[j + 1] = vectorVehiculos[j]
                        vectorVehiculos[j] = vehiculoAuxiliar
                    }
                }
            }
        }
    }

    /**
     * función que presenta un menú con todas la opciones posibles, al usuario
     * @return la opción que haya introducido el usuario
     */
    fun menu(): Int {
        println("${Colores.GREEN.color}************************************************")
        println("*                     menú                     *")
        println("************************************************")
        println("* " + "${Colores.YELLOW.color}[1] " + "${Colores.CYAN.color}Introducir datos de vehículo a mano${Colores.GREEN.color}      *")
        println("* " + "${Colores.YELLOW.color}[2] " + "${Colores.CYAN.color}Generar vehículo aleatorio${Colores.GREEN.color}               *")
        println("************************************************")
        return introducirOpcion()
    }

    /**
     * función que sirve para introducir una opción, validarla y devolverla
     * @return la opción introducida y validada
     */
    private fun introducirOpcion(): Int {
        var opcion = ""
        do {
            try {
                opcion = readln().trim()
                opcionValida(opcion)
            } catch (e: Exception) {
                println(e.message)
                opcion = ""
            }
        } while (opcion === "")
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
        require(!(opciones < 1 || opciones > 2)) { "${Colores.RED.color}La opción seleccionada es inválida, vuelva a probar:" }
        return true
    }
}