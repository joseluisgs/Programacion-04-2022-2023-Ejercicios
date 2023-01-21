package ModelsSalaDeCine

import Factories.PeliculaFactory
import Factories.SalaDeCineFactory

fun main(args: Array<String>){

    var salaCine: salaDeCine? = null

    if(args.size != 6) {
        println("${Colores.CYAN.color}No se encontrarón los argumentos necesarios, por lo que debe elegir:")
        when (elegirComoIntroducirDatosDeLaSalaDeCine()) {
            1 -> salaCine = introducirDatosAMano()
            2 -> salaCine = SalaDeCineFactory.getInstance()!!.crearSalaDeCineCompletamenteAleatoria()
        }
        println()
    }else{

        if(comprobarSiLosArgumentosSonValidos(args) == false){
            println("${Colores.CYAN.color}No se encontrarón los argumentos necesarios, por lo que debe elegir:")
            when (elegirComoIntroducirDatosDeLaSalaDeCine()) {
                1 -> salaCine = introducirDatosAMano()
                2 -> salaCine = SalaDeCineFactory.getInstance()!!.crearSalaDeCineCompletamenteAleatoria()
            }
            println()
        }else{
            println("${Colores.CYAN.color}De acuerdo, como ya ha introducido el número de filas, columnas y butacas vip del cine, le queda introducir lo siguiente:")
            salaCine = introducirElRestoDeDatosAMano(args[1].toInt(), args[3].toInt(), args[5].toInt())
            println()
        }
    }

    println("${Colores.CYAN.color}La sala del cine es la siguiente:")
    salaCine!!.representacionDeLaSala()

    var opcion = 0
    do{
        println("${Colores.CYAN.color}Seleccione la opción que desea:")
        opcion = menu()
        println()
        when(opcion){
            1 -> salaCine!!.comprarEntrada()
            2 -> salaCine!!.reservarEntrada()
            3 -> salaCine!!.formalizarReserva()
            4 -> salaCine!!.anularReservaCompra()
            5 -> salaCine!!.informeDeLaSalaDeCine()
            6 -> salaCine!!.dineroTotalEnCaja()
        }
    }while(opcion != 0)
    println("${Colores.CYAN.color}Adios...")

}

/**
 * función que srive para comprobar si los valores introducidos por los argumentos, son válidos o no
 * @param args son los argumentos a comprobar
 * @return true si son válidos, false si no lo son
 */
fun comprobarSiLosArgumentosSonValidos(args: Array<String>): Boolean {
    var sonValidos = true
    try {
        filaColumnaValida(args[1])
        filaColumnaValida(args[3])
        numeroButacasVipValido(args[5], args[1].toInt(), args[3].toInt())
    } catch (e: Exception) {
        sonValidos = false
    }
    return sonValidos
}

/**
 * función que permite al usuario crear una sala de cine a partir de los datos que el mete
 * @return la sala de cine creada a partir de los datos introducidos
 */
fun introducirDatosAMano(): salaDeCine {
    println("${Colores.CYAN.color}Primero introduce los datos del cine:")
    println("${Colores.CYAN.color}Introduce el nombre que tiene su cine:")
    val nombre = introducirNombre()
    println("${Colores.CYAN.color}Introduce el número de filas que tiene su cine:")
    val filas = introducirFilaColumna()
    println("${Colores.CYAN.color}Introduce el número de columnas que tiene su cine:")
    val columnas = introducirFilaColumna()
    println("${Colores.CYAN.color}Introduce el número de butacas vip que tiene su cine::")
    val butacasVip = introducirNumeroButacasVip(filas, columnas)

    println("${Colores.CYAN.color}Ahora introduce los datos de la pelicula que se va a mostrar:")
    println("${Colores.CYAN.color}Introduce el titulo de la pelicula:")
    val titulo = introducirTitulo()
    println("${Colores.CYAN.color}Introduce el año de publicación de la pelicula:")
    val añoPublicacion = introducirAñoPublicación()
    println("${Colores.CYAN.color}Introduce el nombre del director de la pelicula:")
    val director = introducirDirector()
    println("${Colores.CYAN.color}Introduce el genero de la pelicula:")
    val genero = introducirGenero()
    println()
    return SalaDeCineFactory.getInstance()!!.crearSalaDeCine(nombre, filas, columnas, butacasVip, PeliculaFactory.getInstance()!!.crearPelicula(titulo, añoPublicacion, director, genero))
}

/**
 * función que permite al usuario crear una sala de cine a partir de los datos que el mete
 * @param filas es el numero de filas que tiene el cine
 * @param columnas es el numero de columnas que tiene el cine
 * @param butacasVip es el numero de butacasVip que tiene el cine
 * @return la sala de cine creada a partir de los datos introducidos
 */
fun introducirElRestoDeDatosAMano(filas: Int, columnas: Int, butacasVip: Int): salaDeCine? {
    println("${Colores.CYAN.color}Primero introduce los datos del cine:")
    println("${Colores.CYAN.color}Introduce el nombre que tiene su cine:")
    val nombre = introducirNombre()

    println("${Colores.CYAN.color}Ahora introduce los datos de la pelicula que se va a mostrar:")
    println("${Colores.CYAN.color}Introduce el titulo de la pelicula:")
    val titulo = introducirTitulo()
    println("${Colores.CYAN.color}Introduce el año de publicación de la pelicula:")
    val añoPublicacion = introducirAñoPublicación()
    println("${Colores.CYAN.color}Introduce el nombre del director de la pelicula:")
    val director = introducirDirector()
    println("${Colores.CYAN.color}Introduce el genero de la pelicula:")
    val genero = introducirGenero()
    println()
    return SalaDeCineFactory.getInstance()!!.crearSalaDeCine(nombre, filas, columnas, butacasVip, PeliculaFactory.getInstance()!!.crearPelicula(titulo, añoPublicacion, director, genero))
}

/**
 * función que sirve para introducir un número de butacas vip válido
 * @param fila el número de filas con el el se calcula el total de butacas
 * @param columna el número de columnas con el el se calcula el total de butacas
 * @return el número de butacas vip introducido por teclado
 */
fun introducirNumeroButacasVip(fila: Int, columna: Int): Int{
    var butacasVip = ""
    do{
        try{
            butacasVip = readln().trim()
            numeroButacasVipValido(butacasVip, fila, columna)
        }catch(e: Exception){
            println(e.message)
            butacasVip = ""
        }
    }while(butacasVip == "")
    return butacasVip.toInt()
}

/**
 * función que sirve para validar el número de butacas vip introducido por teclado
 * @param butacasVip lo que queremos validar
 * @param fila el número de filas con el el se calcula el total de butacas
 * @param columna el número de columnas con el el se calcula el total de butacas
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun numeroButacasVipValido(butacasVip: String?, fila: Int, columna: Int): Boolean {
    require(butacasVip != null){("${Colores.RED.color}El número de butacas vip no puede ser nulo, vuelve a probar:")}
    val regex = Regex("[0-9]+")
    require(butacasVip!!.matches(regex)){"${Colores.RED.color}El número de butacas vip introducido no es válida, vuelve a probar:"}
    val filaOColumna = butacasVip.toInt()
    require(filaOColumna <= (fila*columna)){"${Colores.RED.color}El número de butacas vip no puede ser mayor que el número de butacas totales, que es: ${fila*columna}, vuelve a probar:"}
    return true
}

/**
 * función que sirve para introducir una fila o columna válida
 * @return la fila o columna introducida por teclado
 */
fun introducirFilaColumna(): Int{
    var filaColumna = ""
    do{
        try{
            filaColumna = readln().trim()
            filaColumnaValida(filaColumna)
        }catch(e: Exception){
            println(e.message)
            filaColumna = ""
        }
    }while(filaColumna == "")
    return filaColumna.toInt()
}

/**
 * función que sirve para validar el año de publicación introducido por teclado
 * @param filaColumna lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun filaColumnaValida(filaColumna: String?): Boolean {
    require(filaColumna != null){("${Colores.RED.color}La fila/columna no puede ser nulo, vuelve a probar:")}
    val regex = Regex("-?[0-9]+")
    require(filaColumna!!.matches(regex)){"${Colores.RED.color}La fila/columna introducida no es válida, vuelve a probar:"}
    val filaOColumna = filaColumna.toInt()
    require(filaOColumna > 0){"${Colores.RED.color}La fila/columna no puede ser menor que 1, vuelve a probar:"}
    require(filaOColumna < 26){"${Colores.RED.color}La fila/columna no puede sobrepasar el tamaño 26, vuelve a probar:"}
    return true
}

/**
 * función que sirve para introducir un nombre válido
 * @return el nombre introducido por teclado
 */
fun introducirNombre(): String{
    var nombre = ""
    do{
        try{
            nombre = readln().trim()
            nombreValido(nombre)
        }catch(e: Exception){
            println(e.message)
            nombre = ""
        }
    }while(nombre == "")
    return nombre
}

/**
 * función que sirve para validar el nombre introducido por teclado
 * @param nombre lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun nombreValido(nombre: String?): Boolean {
    require(nombre != null){("${Colores.RED.color}El nombre no puede ser nulo, vuelve a probar:")}
    require(nombre.isNotEmpty()){"${Colores.RED.color}El nombre no puede estar vacio, vuelve a probar:"}
    return true
}

/**
 * función que sirve para introducir un titulo válido
 * @return el título introducido por teclado
 */
fun introducirTitulo(): String {
    var titulo = ""
    do {
        try {
            titulo = readln().trim()
            tituloValido(titulo)
        } catch (e: Exception) {
            println(e.message)
            titulo = ""
        }
    } while (titulo == "")
    return titulo
}

/**
 * función que sirve para validar el título introducido por teclado
 * @param titulo lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun tituloValido(titulo: String?): Boolean {
    require(titulo != null) { "${Colores.RED.color}El título no puede ser nulo, vuelve a probar:" }
    require(titulo.isNotEmpty()) { "${Colores.RED.color}El título de la peli no puede estar vacio, vuelve a probar:" }
    return true
}

/**
 * función que sirve para introducir un año de publicacion válido
 * @return el año de publicacion introducido por teclado
 */
fun introducirAñoPublicación(): Int {
    var añoPublicacion = ""
    do {
        try {
            añoPublicacion = readln().trim()
            añoPublicacionValido(añoPublicacion)
        } catch (e: Exception) {
            println(e.message)
            añoPublicacion = ""
        }
    } while (añoPublicacion == "")
    return añoPublicacion.toInt()
}

/**
 * función que sirve para validar el año de publicación introducido por teclado
 * @param añoPublicacion lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun añoPublicacionValido(añoPublicacion: String?): Boolean {
    require(añoPublicacion != null) { "${Colores.RED.color}El año de publicación no puede ser nulo, vuelve a probar:" }
    val regex = Regex("-?[0-9]+")
    require(añoPublicacion!!.matches(regex)){"${Colores.RED.color}El año de publicación introducido no es válido, vuelve a probar:"}
    val añoDePublicacion = añoPublicacion.toInt()
    require(añoDePublicacion > 0) { "${Colores.RED.color}El año de publicación no puede ser negativo, vuelve a probar:" }
    require(añoDePublicacion in 1950..2023) { "${Colores.RED.color}El año de publicación de la peli debe ser entre 1950 y 2023, vuelve a probar:" }
    return true
}

/**
 * función que sirve para introducir un director válido
 * @return el director introducido por teclado
 */
fun introducirDirector(): String {
    var director = ""
    do {
        try {
            director = readln().trim()
            directorValido(director)
        } catch (e: Exception) {
            println(e.message)
            director = ""
        }
    } while (director == "")
    return director
}

/**
 * función que sirve para validar el director introducido por teclado
 * @param director lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun directorValido(director: String?): Boolean {
    require(director != null) { "${Colores.RED.color}El director no puede ser nulo, vuelve a probar:" }
    require(director.isNotEmpty()) { "${Colores.RED.color}El director de la peli no puede estar vacio, vuelve a probar:" }
    return true
}

/**
 * función que sirve para introducir un género válido
 * @return el género introducido por teclado
 */
fun introducirGenero(): String {
    var genero = ""
    do {
        try {
            genero = readln().trim()
            generoValido(genero)
        } catch (e: Exception) {
            println(e.message)
            genero = ""
        }
    } while (genero == "")
    return genero
}

/**
 * función que sirve para validar el género introducido por teclado
 * @param genero lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun generoValido(genero: String?): Boolean {
    require(genero != null) { "${Colores.RED.color}El género no puede ser nulo, vuelve a probar:" }
    require(genero.isNotEmpty()) { "${Colores.RED.color}El género de la peli no puede estar vacio, vuelve a probar:" }
    return true
}

/**
 * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
 * @return la opcion seleccionada por el usuario
 */
fun menu(): Int{
    println("${Colores.GREEN.color}*************************************************")
    println("*                    MENÚ                       *")
    println("*************************************************")
    println("* ${Colores.YELLOW.color}[1] ${Colores.CYAN.color}Comprar entrada${Colores.GREEN.color}                           *")
    println("* ${Colores.YELLOW.color}[2] ${Colores.CYAN.color}Reservar entrada${Colores.GREEN.color}                          *")
    println("* ${Colores.YELLOW.color}[3] ${Colores.CYAN.color}Formalizar reserva de entrada${Colores.GREEN.color}             *")
    println("* ${Colores.YELLOW.color}[4] ${Colores.CYAN.color}Anular reserva o compra de entrada${Colores.GREEN.color}        *")
    println("* ${Colores.YELLOW.color}[5] ${Colores.CYAN.color}Conseguir informe de la sala${Colores.GREEN.color}              *")
    println("* ${Colores.YELLOW.color}[6] ${Colores.CYAN.color}Conseguir recaudación total de la caja${Colores.GREEN.color}    *")
    println("* ${Colores.YELLOW.color}[0] ${Colores.CYAN.color}Salir${Colores.GREEN.color}                                     *")
    println("*************************************************")
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
    require(opcion.toInt() in 0..6){"${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:"}
    return true
}
/**
 * función que sirve para introducir un identificador de butaca válido o "stop"
 * @return la butaca o el "stop" introducido por teclado
 */
fun introducirButaca(): String{
    var butaca = ""
    do{
        try{
            butaca = readln().trim()
            butacaValida(butaca)
        }catch(e: Exception){
            println(e.message)
            butaca = ""
        }
    }while(butaca == "")
    return butaca
}

/**
 * función que sirve para validar la butaca o el "stop" introducido por teclado
 * @param butaca lo que queremos validar
 * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
 * @return true en caso de que sea válido
 */
fun butacaValida(butaca: String?): Boolean {
    require(butaca != null){("${Colores.RED.color}El mensaje no puede ser nulo, vuelve a probar:")}
    require(butaca.isNotEmpty()){"${Colores.RED.color}El mensaje no puede estar vacio, vuelve a probar:"}
    val regex = Regex("[A-Z][0-9]+")
    require(butaca == "stop" || butaca.matches(regex)){"${Colores.RED.color}EL mensaje introducido no es válido, vuelve a probar:"}
    return true
}

/**
 * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
 * @return la opcion seleccionada por el usuario
 */
fun elegirComoIntroducirDatosDeLaSalaDeCine(): Int {
    println("${Colores.GREEN.color}***************************************")
    println("*                MENÚ                 *")
    println("***************************************")
    println("* ${Colores.YELLOW.color}[1] ${Colores.CYAN.color}Introducir datos a mano${Colores.GREEN.color}         *")
    println("* ${Colores.YELLOW.color}[2] ${Colores.CYAN.color}Generar datos aleatoriamente${Colores.GREEN.color}    *")
    println("***************************************")
    return introducirOpcionDeIntroducirDatos()
}

/**
 * función que sirve para introducir una opción válida
 * @return la opcion válida
 */
fun introducirOpcionDeIntroducirDatos(): Int {
    var opcion = ""
    do {
        try {
            opcion = readln().trim()
            opcionDeIntroducirDatosValida(opcion)
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
fun opcionDeIntroducirDatosValida(opcion: String?): Boolean {
    require(opcion != null){"${Colores.RED.color}La opción no puede ser nula, vuelve a probar:"}
    val regex = Regex("-?[0-9]+")
    require(opcion!!.matches(regex)){"${Colores.RED.color}La opción introducida no es válida, vuelve a probar:"}
    require(opcion.toInt() in 1..2){"${Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:"}
    return true
}