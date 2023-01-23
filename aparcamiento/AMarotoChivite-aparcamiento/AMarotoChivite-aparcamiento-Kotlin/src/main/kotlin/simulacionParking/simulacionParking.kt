package simulacionParking

import simulacionParking.enums.TipoVehiculo
import simulacionParking.factories.ConductorFactory
import simulacionParking.factories.ParkingFactory.create
import simulacionParking.models.Conductor
import simulacionParking.models.Parking
import simulacionParking.models.Vehiculo
import simulacionParking.models.Vigilante
import java.util.*


fun main() {

    // Inicializamos un parking:
    val parking = create()

    // 10 conductores
    val almacenConductores = arrayOfNulls<Conductor>(10)
    for (i in almacenConductores.indices) {
        almacenConductores[i] = ConductorFactory.create()
    }
    var actualVehiculo = 0
    var actualConductor = 0
    var filas = 0
    while (filas < parking.matriz.size) {
        var columnas = 0
        while (columnas < parking.matriz[filas].size) {

            // Recorremos todos los coches del conductor
            if (parking.matriz[filas][columnas]!!.tipo == TipoVehiculo.VACIO) {
                // Aumentamos el contador de vehíulos aparcados
                almacenConductores[actualConductor]!!.quantityParking_AUTO++
                if (almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.tipo == TipoVehiculo.CAMION) {
                    for (i in 0..3) {
                        // Si entra un camión lo introducimos en la fila que nos encontremos
                        if (columnas + 4 < parking.matriz[filas].size) {
                            // Y cambiamos el estado del vehículo aparcado:
                            almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.setEstadoVehiculo(
                                Vehiculo.EstadoVehiculo.APARCADO
                            )
                            // Introducimos el vehículo en el parking
                            parking.matriz[filas][columnas + i] =
                                almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
                        } else {
                            introducirCamionEnSiguienteFila(
                                parking,
                                almacenConductores,
                                actualVehiculo,
                                actualConductor,
                                filas
                            )
                        }
                    }
                    // Interaccion Vigilante - Conductor
                    almacenConductores[actualConductor]!!.presentarse()
                    Vigilante.indicarDondeAparcar(
                        almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.tipo,
                        filas,
                        columnas
                    )
                } else if (almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.tipo == TipoVehiculo.COCHE) {
                    for (i in 0..1) {
                        // Si entra un coche lo introducimos en la fila que nos encontremos
                        if (columnas + 2 < parking.matriz[filas].size) {
                            // Y cambiamos el estado del vehículo aparcado:
                            almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.setEstadoVehiculo(
                                Vehiculo.EstadoVehiculo.APARCADO
                            )
                            // Introducimos el vehículo en el parking
                            parking.matriz[filas][columnas + i] =
                                almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
                        } else {
                            introducirCocheEnSiguienteFila(
                                parking,
                                almacenConductores,
                                actualVehiculo,
                                actualConductor,
                                filas
                            )
                        }
                    }
                    // Interaccion Vigilante - Conductor
                    almacenConductores[actualConductor]!!.presentarse()
                    Vigilante.indicarDondeAparcar(
                        almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.tipo,
                        filas,
                        columnas
                    )
                } else if (almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
                    !!.tipo == TipoVehiculo.MOTO || almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
                    !!.tipo == TipoVehiculo.BICI || almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
                    !!.tipo == TipoVehiculo.PATINETE
                ) {
                    // Introducimos bici,moto o patinete
                    parking.matriz[filas][columnas] =
                        almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]

                    // Y cambiamos el estado del vehículo aparcado:
                    almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.setEstadoVehiculo(Vehiculo.EstadoVehiculo.APARCADO)

                    // Interaccion Vigilante - Conductor
                    almacenConductores[actualConductor]!!.presentarse()
                    Vigilante.indicarDondeAparcar(
                        almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.tipo,
                        filas,
                        columnas
                    )
                }
                println(parking)
                // Reiniciamos el recorrido del parking, para optimizar el espacio y almacenar en todo el parking
                filas = 0
                columnas = 0
                // Y pasamos al siguiente coche del conductor
                actualVehiculo += 1
                // Y desplegamos el menú de elección
                menuParking(parking.matriz)
            }

            // Verificamos que hemos introducido todos los coches de un conductor
            if (almacenConductores[actualConductor]!!.ownerVehicle.size == actualVehiculo) {
                // Si ya hemos recorrido el almacen de coches que va a aparcar el conductor, reiniciamos los coches,
                actualVehiculo = 0
                // y pasamos al siguiente conductor
                actualConductor += 1
            }

            // Verificar que ya hemos almacenado a todos los conductores
            if (almacenConductores.size == actualConductor) {
                println(parking)
                Vigilante.trabajoTerminado()
                System.exit(0)
            }

            // Vigilante verifica que no esté lleno el parking, para cerrar el parking!
            if (Vigilante.parkingCompleto(parking)) {
                System.exit(0)
            }
            columnas++
        }
        filas++
    }
    println(parking)
    println("No todos los conductores han podido almacenar su vehículo!")
}

/**
 * Introducimos un camión en la siguiente fila del parking, en caso de que no se puede introducir
 * en la que previamente nos encontrábamos
 *
 * @param parking                donde estamos aparcando vehículos
 * @param almacenConductores     para saber que conductor y que vehículo aparcar
 * @param actualConductor        para saber en qué posición del almacenConductores nos encontramos
 * @param actualVehiculo         para saber en qué posición del almacenConductores y su vehículo nos encontramos
 * @param filaDondeNoEntraCamion para saber en qué fila, es donde no entra el camión
 */
fun introducirCamionEnSiguienteFila(
    parking: Parking,
    almacenConductores: Array<Conductor?>,
    actualVehiculo: Int,
    actualConductor: Int,
    filaDondeNoEntraCamion: Int
) {
    if (filaDondeNoEntraCamion + 1 <= parking.matriz.size) {
        // En caso contrario, si al pasar a la siguiente fila, esta fila existe, sin salirnos de la matriz!
        // Pasamos la siguiente fila, y empezamos a introducir ahí, si está vacío
        for (columnaSiguiente in 0..3) {
            if (parking.matriz[filaDondeNoEntraCamion + 1][columnaSiguiente]!!.tipo
                    .equals(TipoVehiculo.VACIO)
            ) {
                // Y cambiamos el estado del vehículo aparcado:
                almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.setEstadoVehiculo(Vehiculo.EstadoVehiculo.APARCADO)
                // Introducimos el vehículo en el parking
                parking.matriz[filaDondeNoEntraCamion + 1][columnaSiguiente] =
                    almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
            }
        }
    }
}

/**
 * Introducimos un coche en la siguiente fila del parking, en caso de que no se puede introducir
 * en la que previamente nos encontrábamos
 *
 * @param parking               donde estamos aparcando vehículos
 * @param almacenConductores    para saber que conductor y que vehículo aparcar
 * @param actualConductor       para saber en qué posición del almacenConductores nos encontramos
 * @param actualVehiculo        para saber en qué posición del almacenConductores y su vehículo nos encontramos
 * @param filaDondeNoEntraCoche para saber en qué fila, es donde no entra el coche
 */
fun introducirCocheEnSiguienteFila(
    parking: Parking,
    almacenConductores: Array<Conductor?>,
    actualVehiculo: Int,
    actualConductor: Int,
    filaDondeNoEntraCoche: Int
) {
    if (filaDondeNoEntraCoche + 1 <= parking.matriz.size) {
        // En caso contrario, si al pasar a la siguiente fila, esta fila existe, sin salirnos de la matriz!
        // Pasamos la siguiente fila, y empezamos a introducir ahí, si está vacío
        for (columnaSiguiente in 0..1) {
            if (parking.matriz[filaDondeNoEntraCoche + 1][columnaSiguiente]!!.tipo
                    .equals(TipoVehiculo.VACIO)
            ) {
                // Y cambiamos el estado del vehículo aparcado:
                almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]!!.setEstadoVehiculo(Vehiculo.EstadoVehiculo.APARCADO)
                // Introducimos el vehículo en el parking
                parking.matriz[filaDondeNoEntraCoche + 1][columnaSiguiente] =
                    almacenConductores[actualConductor]!!.ownerVehicle[actualVehiculo]
            }
        }
    }
}

/**
 * Recuento del parking, en función de loa vehículo que haya multiplicamos por el precio por aparcar (3.75€)
 *
 * @param matriz es el parking donde hacemos la lectura de vehículos
 * @return recaudacionTotal
 */
fun recuentoFinal(matriz: Array<Array<Vehiculo?>>): Double {
    val precioParking = 3.75
    val contadorVehiculos = contadorVehiculosEnParking(matriz)
    val recaudacionTotal = contadorVehiculos * precioParking
    println("La recaudación total actual es de: " + recaudacionTotal + "€")
    return recaudacionTotal
}

/**
 * Contamos los vehículos que hay en el Parking
 *
 * @param matriz parking donde están aparcados los vehículos
 * @return contadorCoches + contadorCamiones + contadorIndividual, es la suma de los vehículos
 */
fun contadorVehiculosEnParking(matriz: Array<Array<Vehiculo?>>): Int {
    var contadorCamiones = 0
    var contadorCoches = 0
    var contadorIndividual = 0
    for (filas in matriz.indices) {
        for (columnas in matriz[filas].indices) {
            if (matriz[filas][columnas]!!.tipo == TipoVehiculo.CAMION) {
                contadorCamiones++
            }
        }
    }
    for (filas in matriz.indices) {
        for (columnas in matriz[filas].indices) {
            if (matriz[filas][columnas]!!.tipo == TipoVehiculo.COCHE) {
                contadorCoches++
            }
        }
    }
    for (filas in matriz.indices) {
        for (columnas in matriz[filas].indices) {
            if (matriz[filas][columnas]!!
                    .tipo == TipoVehiculo.MOTO || matriz[filas][columnas]!!
                    .tipo == TipoVehiculo.BICI || matriz[filas][columnas]!!.tipo == TipoVehiculo.PATINETE
            ) {
                contadorIndividual++
            }
        }
    }
    contadorCoches = contadorCoches / 2
    contadorCamiones = contadorCamiones / 4
    return contadorCoches + contadorCamiones + contadorIndividual
}

/**
 * Crea una sensación de borrado de la consola.
 * Mediante una impresión de varias líneas en blanco.
 */
fun falsoBorradoDeConsola() {
    // Para crear una senación de borrado en consola
    for (i in 0..39) {
        println()
    }
}

/**
 * Para preguntar al usuario si quiere continuar, en caso de errar la entrada se encuentra en un
 * bucle hasta dar con una respuesta válida (S/N)
 *
 * @param mensaje para poder informar al usuario
 * @return true = si quiere continuar, false = si no quiere continuar
 * @throws InterruptedException
 */
@Throws(InterruptedException::class)
fun continuar(mensaje: String?): Boolean {
    while (true) {
        val entradaUsuario = pedirEntradaSinFiltro(mensaje)
        if (entradaUsuario == "S") {
            falsoBorradoDeConsola()
            return true
        }
        if (entradaUsuario == "N") {
            falsoBorradoDeConsola()
            return false
        }
        falsoBorradoDeConsola()
        println("Debe introducir (S)!")
        Thread.sleep(1500)
        falsoBorradoDeConsola()
    }
}

/**
 * Menú para tener información extra del parking
 *
 * @param parking para poder calcular distintas funciones dentro del menú
 * @throws InterruptedException
 */
@Throws(InterruptedException::class)
fun menuParking(parking: Array<Array<Vehiculo?>>) {
    var deplegarMenu = continuar("¿Quieres desplegar un menú interactivo? (S/N)")
    while (deplegarMenu) {
        println("(USUARIO) -> Selecciona la opción deseada: ")
        println()
        println("1: Continuar simulación")
        println("2: Listado Parking (ordenados: antigüedad ascendete)")
        println("3: Recaudación total (caja actual del Parking)")
        println("4: Encontrar tu vehículo (matricula)")
        println("0: Finalizar simulación")
        val sc = Scanner(System.`in`)
        when (sc.nextLine()) {
            "1" -> {
                falsoBorradoDeConsola()
                deplegarMenu = false
                falsoBorradoDeConsola()
            }

            "2" -> {
                falsoBorradoDeConsola()
                listadoParking(parking)
                println()
                continuar("Volver al menú (S)")
                falsoBorradoDeConsola()
            }

            "3" -> {
                falsoBorradoDeConsola()
                recuentoFinal(parking)
                println()
                continuar("Volver al menú (S)")
                falsoBorradoDeConsola()
            }

            "4" -> {
                falsoBorradoDeConsola()
                var salirBucle = false
                while (!salirBucle) {
                    val entrada =
                        pedirEntradaSinFiltro("Puedes realizar la búsqueda de tu vehículo mediante -> matrícula: ")
                    encontrarVehiculo(parking, entrada)
                    salirBucle = !continuar("¿Quieres realizar de nuevo la búsqueda? (S/N)")
                }
                falsoBorradoDeConsola()
            }

            "0" -> {
                falsoBorradoDeConsola()
                System.exit(0)
            }
        }
    }
}

/**
 * Encuentra un vehícula en función de su matrícula, si lo encuentra indica la fila y columna donde se encuentre
 *
 * @param parking para poder encontrar el vehículo
 * @param entrada matrícula que introduce el usuario para buscar
 * @return true = si matrícula existe en el parking, false = si no encuentra
 * @throws InterruptedException
 */
@Throws(InterruptedException::class)
fun encontrarVehiculo(parking: Array<Array<Vehiculo?>>, entrada: String): Boolean {
    var encontrado = false
    for (filas in parking.indices) {
        for (columnas in parking[filas].indices) {
            if (parking[filas][columnas]!!.matricula == entrada) {
                println("Tu vehículo se encuentra en la fila " + (filas + 1) + " columna " + (columnas + 1))
                println(" ")
                encontrado = true
                return true
            }
        }
    }
    if (!encontrado) {
        println("No hay ningún vehículo con la matrícula que nos proporcionas!")
        println()
        return false
    }
    return false
}

/**
 * Para pedir al usuario una entrada, no presentan filtro, ya que las introduzco en bucles, hasta que
 * favorezca a las condiciones
 *
 * @param mensaje para informar al usuario sobre que debe introducir
 * @return scanner la entrada que ha proporcionado el usuario
 */
fun pedirEntradaSinFiltro(mensaje: String?): String {
    println(mensaje)
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}

/**
 * Imprime en pantalla un listado ordenados de más viejos a más nuevos los vehículos, y el parking actual
 *
 * @param parking para poder listar e imprimir
 */
fun listadoParking(parking: Array<Array<Vehiculo?>>) {
    val contadorVehiculos = contadorVehiculosEnParking(parking)
    val almacenVehiculosAparcados = arrayOfNulls<Vehiculo>(80)
    println("Disponemos de un total actual de: $contadorVehiculos vehículos")
    for (filas in parking.indices) {
        for (columnas in parking[filas].indices) {
            if (parking[filas][columnas]!!.id != "0") {
                // Recorremos el almacén e introducimos un coche
                for (i in almacenVehiculosAparcados.indices) {
                    // Introducimos donde no haya coche
                    if (almacenVehiculosAparcados[i] == null) {
                        almacenVehiculosAparcados[i] = parking[filas][columnas]
                        break
                    }
                }
            }
        }
    }
    // Ordenamos los coches
    bubbleSort(almacenVehiculosAparcados)
    // Imprimimos
    for (i in almacenVehiculosAparcados.indices) {
        if (almacenVehiculosAparcados[i] != null) {
            println(almacenVehiculosAparcados[i].toString())
        }
    }
    print(parking)
}

/**
 * Ordenación de Vehículos en función de la vejez del año de fabricación del vehículo
 *
 * @param vector almacén de los vehículos que queremos ordenar
 */
fun bubbleSort(vector: Array<Vehiculo?>) {
    var annoActual = 0
    var annoSiguiente = 0
    for (i in vector.indices) {
        for (j in 0 until vector.size - 1) {
            if (vector[j] != null && vector[j + 1] != null) {
                annoActual = vector[j]!!.anno!!.toInt()
                annoSiguiente = vector[j + 1]!!.anno!!.toInt()
                if (annoActual > annoSiguiente) {
                    val aux = vector[j]
                    vector[j] = vector[j + 1]
                    vector[j + 1] = aux
                }
            }
        }
    }
}
