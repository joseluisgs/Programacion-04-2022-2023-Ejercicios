import models.Coche
import models.Propietario
import models.Aparcamiento

//Aparcamientos creados
val aparcamientos = arrayOf<Aparcamiento?>(
    Aparcamiento("Parking 1", 4, 4),
    Aparcamiento("Parking 2",5, 5),
    Aparcamiento("Parking 3",6, 6)
)

var aparcamientoSeleccionado: Aparcamiento? = null

//Propietarios existentes
val propietarios: Array<Propietario> = arrayOf(
    Propietario("Iván", 1),
    Propietario("Raúl", 1),
    Propietario("Carlos", 1),
    Propietario("Pablo", 1),
    Propietario("Mario", 1),
    Propietario("Izan", 1),
)

//Coches disponibles
val coches: Array<Coche> = arrayOf(
    Coche("Toyota", "Supra", propietarios[0], 12),
    Coche("Nissan", "GTR R-34", propietarios[0], 15),
    Coche("Nissan", "GTR R-32", propietarios[1], 2),
    Coche("Ferrari", "Testarrosa", propietarios[2], 33),
    Coche("Lamborghini", "Murciélago", propietarios[2], 25),
    Coche("Lamborghini", "Aventador", propietarios[3], 14),
    Coche("Ford", "Mustang", propietarios[4], 10),
    Coche("Toyota", "Yaris", propietarios[4], 9),
    Coche("Citroen", "C4", propietarios[5], 7),
    Coche("Ford", "Fiesta", propietarios[5], 66),
)

fun main () {
    when(inputNum("""
        |
        |Bienvenido al Parking del hotel Bueno, ¿qué desea hacer?:
        |1 - Ver el aparcamiento
        |2 - Aparcar coche
        |3 - Contar coches de un parking
        |4 - Ver lista de coches aparcados
        |5 - Buscar Coche
        |6 - Vaciar una plaza ocupada
        |7 - Salir
    """.trimMargin(), 1..7)){
        1 -> verAparcamiento()
        2 -> aparcarCoche()
        3 -> contarCoches()
        4 -> verListaDeCoches()
        5 -> buscarCoche()
        6 -> quitarCoche()
        7 -> println("Gracias por venir al hotel Bueno, esperamos verle pronto.")
    }
}

//Llama al método verPlazas
fun verAparcamiento() {
    seleccionadorDeParking()?.verPlazas()
    main()
}

//Llama al método aparcarCoche
fun aparcarCoche() {
    seleccionadorDeParking()?.aparcarCoche(seleccionadorDeCoche(), seleccionadorDeColumna(), seleccionadorDeFila())
    main()
}

//Llama al método quitarCoche
fun quitarCoche() {
    seleccionadorDeParking()?.quitarCoche(seleccionadorDeColumna(), seleccionadorDeFila())
    main()
}

//Llama al método contarPlazasOcupadas
fun contarCoches() {
    val parkingSeleccionado: Aparcamiento? = seleccionadorDeParking()
    if (parkingSeleccionado?.contarPlazasOcupadas() == 0)
        println("No hay ningún coche aparcado en este parking.")
    else
        println("Hay ${parkingSeleccionado?.contarPlazasOcupadas()} coche/s.")
    main()
}

//Llama al método cochesOrdenados
fun verListaDeCoches () {
    val parkingSeleccionado: Aparcamiento? = seleccionadorDeParking()
    if (parkingSeleccionado?.contarPlazasOcupadas() == 0)
        println("No hay ningún coche aparcado en este parking.")
    else {
        println("Esta es la lista de coches en orden de antigüedad: ")
        parkingSeleccionado?.cochesOrdenados()
    }
    main()
}

//Llama al método buscarCoche
fun buscarCoche() {
    val cocheParaBuscar: Coche? = seleccionadorDeCoche()
    for (aparcamiento in aparcamientos){
        aparcamiento?.buscarCoche(cocheParaBuscar)
    }
    main()
}


//Funciones para cumplir con el principio de responsabilidad única:

//Selecciona un parking
fun seleccionadorDeParking(): Aparcamiento? {
    when(inputNum("Elige el aparcamiento [1/3]:".trimMargin(), 1..3)){
        1 -> aparcamientoSeleccionado = aparcamientos[0]
        2 -> aparcamientoSeleccionado = aparcamientos[1]
        3 -> aparcamientoSeleccionado = aparcamientos[2]
    }
    return aparcamientoSeleccionado
}

//Selecciona un coche
fun seleccionadorDeCoche(): Coche? {
    var coche: Coche? = null
    when(inputNum("""
        |Elige el coche [1/10]:
        |1 - Marca: ${coches[0].marca}, Modelo: ${coches[0].modelo}, Propietario: ${propietarios[0].nombre}, Antigüedad: ${coches[0].antiguedad} años.
        |2 - Marca: ${coches[1].marca}, Modelo: ${coches[1].modelo}, Propietario: ${propietarios[0].nombre}, Antigüedad: ${coches[1].antiguedad} años.
        |3 - Marca: ${coches[2].marca}, Modelo: ${coches[2].modelo}, Propietario: ${propietarios[1].nombre}, Antigüedad: ${coches[2].antiguedad} años.
        |4 - Marca: ${coches[3].marca}, Modelo: ${coches[3].modelo}, Propietario: ${propietarios[2].nombre}, Antigüedad: ${coches[3].antiguedad} años.
        |5 - Marca: ${coches[4].marca}, Modelo: ${coches[4].modelo}, Propietario: ${propietarios[2].nombre}, Antigüedad: ${coches[4].antiguedad} años.
        |6 - Marca: ${coches[5].marca}, Modelo: ${coches[5].modelo}, Propietario: ${propietarios[3].nombre}, Antigüedad: ${coches[5].antiguedad} años.
        |7 - Marca: ${coches[6].marca}, Modelo: ${coches[6].modelo}, Propietario: ${propietarios[4].nombre}, Antigüedad: ${coches[6].antiguedad} años.
        |8 - Marca: ${coches[7].marca}, Modelo: ${coches[7].modelo}, Propietario: ${propietarios[4].nombre}, Antigüedad: ${coches[7].antiguedad} años.
        |9 - Marca: ${coches[8].marca}, Modelo: ${coches[8].modelo}, Propietario: ${propietarios[5].nombre}, Antigüedad: ${coches[8].antiguedad} años.
        |10 - Marca: ${coches[9].marca}, Modelo: ${coches[9].modelo}, Propietario: ${propietarios[5].nombre}, Antigüedad: ${coches[9].antiguedad} años.
    """.trimMargin(), 1..10)){
        1 -> coche = coches[0]
        2 -> coche = coches[1]
        3 -> coche = coches[2]
        4 -> coche = coches[3]
        5 -> coche = coches[4]
        6 -> coche = coches[5]
        7 -> coche = coches[6]
        8 -> coche = coches[7]
        9 -> coche = coches[8]
        10 ->coche = coches[9]
    }
    return coche
}

//Selecciona una fila
fun seleccionadorDeFila (): Int {
    var fila = 0
    when (inputNum("Selecciona una fila [1,${aparcamientoSeleccionado?.filas}]: ",1..aparcamientoSeleccionado?.filas!!)){
        1 -> fila = 0
        2 -> fila = 1
        3 -> fila = 2
        4 -> fila = 3
        5 -> fila = 4
        6 -> fila = 5
    }
    return fila
}

//Selecciona una columna
fun seleccionadorDeColumna (): Int {
    var columnaSeleccionada = 0
    when (inputNum("Selecciona una columna [1,${aparcamientoSeleccionado?.columnas}]: ",1..aparcamientoSeleccionado?.columnas!!)){
        1 -> columnaSeleccionada = 0
        2 -> columnaSeleccionada = 1
        3 -> columnaSeleccionada = 2
        4 -> columnaSeleccionada = 3
        5 -> columnaSeleccionada = 4
        6 -> columnaSeleccionada = 5
    }
    return columnaSeleccionada
}

//Evita inputs inválidos
fun inputNum(message: String, range: IntRange = -999..999): Int{
    println(message)
    var response: Int?
    do {
        response = readln().toIntOrNull()
        if (response !in range) println("Error: Introduce un número entre ${range.first}-${range.last}.")
    }while (response !in range)
    return response ?: -1
}
