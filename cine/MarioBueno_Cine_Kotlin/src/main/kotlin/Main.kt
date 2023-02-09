import `class`.Pelicula
import `class`.SalaCine
import kotlin.math.round

val arrayLetras = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T")
val mapa = mapOf("A" to 1, "B" to 2, "C" to 3, "D" to 4, "E" to 5, "F" to 6, "G" to 7, "H" to 8, "I" to 9, "J" to 10, "K" to 11, "L" to 12, "M" to 13, "N" to 14, "O" to 15, "P" to 16, "Q" to 17, "R" to 18, "S" to 19, "T" to 20)

//Películas disponibles
val peliculas =arrayOf<Pelicula?>(
    Pelicula("La La Land", "2016", "Damien Chazelle", "Musical"),
    Pelicula("Titanic", "1997", "James Cameron", "Romance/Drama"),
    Pelicula("ElPadrino", "1972", "Francis Ford Coppola", "Drama"),
    Pelicula("Pulp Fiction", "1994", "Quentin Tarantino", "Comedia"),
    Pelicula("El Señor De Los Anillos: El retorno del rey", "2003", "Peter Jackson", "Acción/Aventura"),
    Pelicula("Forrest Gump", "1994", "Robert Zemeckis", "Comedia Romántica"),
    Pelicula("El Club De La Lucha", "1999", "David Fincher", "Acción/Drama"),
    Pelicula("Star Wars: El Imperio Contraataca", "1980", "Irvin Kershner", "Acción/Fantasía")
)

//Salas disponibles
val salasDeCine = arrayOf<SalaCine?>(
    SalaCine("Sala 1", 10, 10, peliculas[0]),
    SalaCine("Sala 2", 15, 15, peliculas[1]),
    SalaCine("Sala 3", 10, 10, peliculas[2]),
    SalaCine("Sala 4", 7, 5, peliculas[3]),
    SalaCine("Sala 5", 10, 15, peliculas[4]),
    SalaCine("Sala 6", 5, 10, peliculas[5]),
    SalaCine("Sala 7", 12, 7, peliculas[6]),
    SalaCine("Sala 8", 20, 20, peliculas[7])
)

var opcionSeleccionada: Int = 0
var salaSeleccionada: SalaCine? = null
var columnaSeleccionada: Int = 0
var filaSeleccionada: Int = 0
var columnaFinalSeleccionada: Int = 0

fun main() {
    seleccionadorDeOpcion("""
        |
        |Bienvenido a la web de Cines Bueno. ¿Qué desea hacer?:
        |1 - Ver la cartelera actual
        |2 - Ver la disponibilidad de asientos de una sala
        |3 - Reservar butaca/s
        |4 - Confirmar reserva/s
        |5 - Cancelar una reserva
        |6 - Ver los ingresos de una sala
        |7 - Ver los ingresos totales
        |8 - Salir
    """.trimMargin(), 1..8)
    when (opcionSeleccionada)
    {
        1-> cartelera()
        2-> disponibilidad()
        3-> reserva()
        4-> confirmarReserva()
        5-> cancelarReserva()
        6-> ingresosDeSala()
        7-> ingresosTotales()
        8-> println("Gracias por usar la web de Cines Bueno, hasta la próxima.")
    }
}

//Muestra la cartelera actual
fun cartelera() {
    println("Las películas del día de hoy son las siguientes:")
    for (i in salasDeCine.indices) {
        print("${salasDeCine[i]?.nombre}: ")
        println("Película: ${peliculas[i]?.titulo}, Año: ${peliculas[i]?.year}, Director: ${peliculas[i]?.director}, Género: ${peliculas[i]?.genero}")
    }
    main()
}

//Muestra la disponibilidad de asientos de una sala en específico y te los muestra en pantalla con el metodo mostrarButacas y el metodo mostrarEstado
fun disponibilidad () {
    seleccionadorDeSala("¿Cuál de las 8 salas quieres ver? [1/8] : ", 1..8)
    println("${salaSeleccionada?.nombre} :")
    salaSeleccionada?.mostrarButacas()
    salaSeleccionada?.mostrarEstado()
    println("----------------------------------------------------------------------------")
    main()
}

//Llama al método reserva unitaria o contigua depende de la opción que elijas
fun reserva() {
    seleccionadorDeOpcion(
        """Quieres reservar una única butaca o varias a la vez?:
        |1 - Reservar una única butaca
        |2 - Reservar butacas contigüas
        """.trimMargin(), 1..2)
    when (opcionSeleccionada) {
        1 -> reservarButacaUnitaria()
        2 -> reservarButacasContiguas()
    }
}

fun reservarButacaUnitaria () {
    seleccionadorDeSala("¿En qué sala quieres reservar? [1/8] : ", 1..8)
    seleccionadorDeColumna("¿En que columna quieres estar? [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    seleccionadorDeFila("¿En que fila quieres estar? [A/${arrayLetras[salaSeleccionada?.filas!!-1]}] : ", salaSeleccionada?.filas!!)
    salaSeleccionada?.reservarButacaUnitaria(columnaSeleccionada, filaSeleccionada)
    main()
}

fun reservarButacasContiguas () {
    seleccionadorDeSala("¿En qué sala queréis reservar? [1/8] : ", 1..8)
    seleccionadorDeFila ("¿En que fila queréis estar? [A/${arrayLetras[salaSeleccionada?.filas!!-1]}]: ", salaSeleccionada?.filas!!)
    seleccionadorDeColumna("Selecciona la columna inicial: [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    seleccionadorDeColumnaFinal("Selecciona la columna final: [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    val temp: Int
    if (columnaSeleccionada == columnaFinalSeleccionada) {
        salaSeleccionada?.reservarButacaUnitaria(columnaSeleccionada, filaSeleccionada)
    }
    if (columnaSeleccionada > columnaFinalSeleccionada){
        temp = columnaSeleccionada
        columnaSeleccionada = columnaFinalSeleccionada
        columnaFinalSeleccionada = temp
        salaSeleccionada!!.reservarButacasContiguas(filaSeleccionada, columnaSeleccionada, columnaFinalSeleccionada)
    }else salaSeleccionada!!.reservarButacasContiguas(filaSeleccionada, columnaSeleccionada, columnaFinalSeleccionada)
    main()
}

//Llama al método confirmar reserva unitaria o contigua dependiendo de la opcion elejida
fun confirmarReserva() {
    seleccionadorDeOpcion("""¿Quieres confirmar una única reserva o quieres confirmar varias a la vez?: 
        |1- Confirmar una única reserva
        |2 - Confirmar varias reservas a la vez
    """.trimMargin(), 1..2)
    when (opcionSeleccionada){
        1 -> {confirmarButacaUnitaria()}
        2 -> {confirmarButacasContiguas()}
    }
}

fun confirmarButacaUnitaria () {
    seleccionadorDeSala("¿En qué sala tienes la reserva? [1/8] : ", 1..8)
    seleccionadorDeColumna("¿Cuál es la columna de tu reserva? [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    seleccionadorDeFila("¿Cuál es la fila de tu reserva? [A/${arrayLetras[salaSeleccionada?.filas!!-1]}] : ", salaSeleccionada?.filas!!)
    salaSeleccionada?.confirmarReservaUnitaria(salaSeleccionada!!, columnaSeleccionada, filaSeleccionada)
    main()
}

fun confirmarButacasContiguas() {
    seleccionadorDeSala("¿En qué sala tenéis las reservas por confirmar? [1/8] : ", 1..8)
    seleccionadorDeFila("¿En que fila tenéis las reservas? [A/${arrayLetras[salaSeleccionada?.filas!!-1]}] : ", salaSeleccionada?.filas!!)
    seleccionadorDeColumna("Selecciona la columna inicial: [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    seleccionadorDeColumnaFinal("Selecciona la columna final: [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    val temp: Int
    if (columnaSeleccionada == columnaFinalSeleccionada) {
        salaSeleccionada?.confirmarReservaUnitaria(salaSeleccionada!!, columnaSeleccionada, filaSeleccionada)
    }
    if (columnaSeleccionada > columnaFinalSeleccionada){
        temp = columnaSeleccionada
        columnaSeleccionada = columnaFinalSeleccionada
        columnaFinalSeleccionada = temp
        salaSeleccionada!!.confirmarReservasContiguas(filaSeleccionada, columnaSeleccionada, columnaFinalSeleccionada)
    }else salaSeleccionada!!.confirmarReservasContiguas(filaSeleccionada, columnaSeleccionada, columnaFinalSeleccionada)
    main()
}

//Llama al método cancelar reserva
fun cancelarReserva () {
    seleccionadorDeSala("¿En qué sala tienes la reserva confirmada? [1/8] : ", 1..8)
    seleccionadorDeColumna("¿En que columna está la butaca reservada? [1/${salaSeleccionada?.columnas}] : ", 1..(salaSeleccionada?.columnas!!))
    seleccionadorDeFila("¿En que fila está la butaca reservada? [A/${arrayLetras[salaSeleccionada?.filas!!-1]}] : ", salaSeleccionada?.filas!!)
    salaSeleccionada?.cancelarReserva(salaSeleccionada!!, columnaSeleccionada, filaSeleccionada)
    main()
}

//Calcula los ingresos de una sala en específico
fun ingresosDeSala () {
    seleccionadorDeSala("Los ingresos de cual de las 8 salas quieres revisar? [1/8] : ", 1..8)
    println("Los ingresos de la ${salaSeleccionada?.nombre} son ${salaSeleccionada?.balance?.let { round(it) }} €")
    main()
}

//Calcula los ingresos totales del cine
fun ingresosTotales() {
    var balanceTotal = 0.0
    for (i in salasDeCine){
        balanceTotal += i?.balance!!
    }
    println("Los ingresos totales del cine el día de hoy son: ${round(balanceTotal)} €")
    main()
}


//Funciones separadas para cumplir con la regla de responsabilidad única:

//Selecciona una de las 8 salas
fun seleccionadorDeSala (message: String, rangoSalas: IntRange) {
    println(message)
    salaSeleccionada = salasDeCine[inputNum(rangoSalas)-1]
}

//Selecciona una fila que exista dentro de la sala seleccionada
fun seleccionadorDeFila (message: String, filas: Int) {
    println(message)
    var eleccion: String
    do {
        eleccion = readln().uppercase()
        if (eleccion !in arrayLetras)
            println("Error: Introduce una letra entre la A y la ${arrayLetras[filas - 1]}.")
    }while (eleccion !in arrayLetras)
    filaSeleccionada = mapa.getValue(eleccion)
    //filaSeleccionada = arrayLetras.indexOf(eleccion)
}

//Selecciona una columna que exista dentro de la sala seleccionada
fun seleccionadorDeColumna (message: String, rangoColumnas: IntRange) {
    println(message)
    columnaSeleccionada = inputNum(rangoColumnas)
}

//Selecciona una columna que exista dentro de la sala seleccionada
fun seleccionadorDeColumnaFinal (message: String, rangoColumnas: IntRange) {
    println(message)
    columnaFinalSeleccionada = inputNum(rangoColumnas)
}

//Da a elegir una opción válida
fun seleccionadorDeOpcion (message: String, rango: IntRange) {
    println(message)
    opcionSeleccionada = inputNum(rango)
}

//Evita inputs inválidos
fun inputNum (range: IntRange): Int{
    var eleccion : Int
    do {
        eleccion = readln().toIntOrNull() ?: (range.last - 1)
        if (eleccion !in range)
            println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (eleccion !in range)
    return eleccion
}
