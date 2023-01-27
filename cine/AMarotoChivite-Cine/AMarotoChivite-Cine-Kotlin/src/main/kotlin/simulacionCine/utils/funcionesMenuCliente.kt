package simulacionCine.utils

import simulacionCine.PRECIO_ESTANDAR
import simulacionCine.PRECIO_VIP
import simulacionCine.enums.Color
import simulacionCine.enums.EstadoButaca
import simulacionCine.enums.EstadoTicket
import simulacionCine.models.Butaca
import simulacionCine.models.Cliente
import simulacionCine.models.Sala
import simulacionCine.models.Ticket
import simulacionCine.repetir
import simulacionCine.volverAlMenu

/**
 * Menú de opciones para el cliente.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun menuCliente(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    while (true) {
        portadaCinesAngel()
        println("(${Color.YELLOW_BRIGHT.color}USUARIO${Color.RESET.color}) -> Selecciona la opción deseada: ")
        println("")
        println("1: Mostrar cine completo (salas/películas/butacas)")
        println("2: Comprar entrada (Compra directa)")
        println("3: Reservar entrada (CUIDADO: posteriormente se debe formalizar la reserva!)")
        println("4: Formalizar reserva (Finaliza tu reserva pendiente para comprar la entrada)")
        println("5: Anular reserva")
        println("6: Anular compra (Devolución/reembolso)")
        println("7: Buscar información sobre compra/reserva realizada")
        println("0: Salir")

        when (readln()) {
            // Usuario
            "1" -> {
                falsoBorradoDeConsola()
                mostrarCine(cine)
                while (!volverAlMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "2" -> {
                falsoBorradoDeConsola()
                comprarEntrada(cine, almacenClientes)
                while (!volverAlMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "3" -> {
                falsoBorradoDeConsola()
                reservarEntrada(cine, almacenClientes)
                while (!volverAlMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "4" -> {
                falsoBorradoDeConsola()
                formalizarReserva(cine, almacenClientes)
                falsoBorradoDeConsola()
            }

            "5" -> {
                falsoBorradoDeConsola()
                anularReserva(cine, almacenClientes)
                falsoBorradoDeConsola()
            }

            "6" -> {
                falsoBorradoDeConsola()
                anularCompra(cine, almacenClientes)
                falsoBorradoDeConsola()
            }

            "7" -> {
                falsoBorradoDeConsola()
                buscarInformacionClientes(almacenClientes)
                falsoBorradoDeConsola()
            }
            // Salir
            "0" -> {
                falsoBorradoDeConsola()
                break
            }
        }
    }
}

/**
 * Muestra la información de todos los clientes del cine.
 *
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun buscarInformacionClientes(almacenClientes: Array<Cliente>) {
    do {
        demostrarInformacionGeneral(almacenClientes)
    } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"))
}

/**
 * Anula la compra de una entrada y devuelve el dinero al cliente.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun anularCompra(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    do {
        existenciaCompraParaAnular(cine, almacenClientes)
    } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"))
}

/**
 * Comprueba si existe alguna compra realizada con el DNI, email o ID_Ticket proporcionado por el usuario.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun existenciaCompraParaAnular(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    println("Puedes realizar la búsqueda de tu compra mediante -> DNI, email o ID_Ticket: ")
    val entradaUsuario = readln()

    for (i in almacenClientes.indices) {
        if (almacenClientes[i].informacionTicket.estado == EstadoTicket.COMPRA) {
            if (almacenClientes[i].email == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaCompra(cine, almacenClientes, i)
                break
            }
            if (almacenClientes[i].dni == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaCompra(cine, almacenClientes, i)
                break
            }
            if (almacenClientes[i].informacionTicket.ticketIDstring() == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaCompra(cine, almacenClientes, i)
                break
            }
        }
    }
    println("No hay ninguna compra realizada con los datos que nos proporcionas!")
    println("")
}

/**
 * Anula la compra de una entrada y devuelve el dinero al cliente.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 * @param posicionCliente Índice del cliente en el array almacenClientes
 */
fun anularUnaCompra(cine: Array<Sala>, almacenClientes: Array<Cliente>, posicionCliente: Int) {
    val mensaje: String = "¿Está seguro que desea anular su compra (S/N)?"
    if (deseaAnular(mensaje)) {
        println("¡Compra anulada!")
        println(
            "Con una devolución de: ${
                almacenClientes[posicionCliente].informacionTicket.getCantidadEntradas().toDouble() * 5.25
            }€"
        )
        // Cambiamos el estado de la/s butaca/s a libre/s
        val salaParaActualizar: String = almacenClientes[posicionCliente].informacionTicket.salaID
        val posicionButacasParaActualizar: Array<Butaca> = almacenClientes[posicionCliente].informacionTicket.butacas
        for (i in cine.indices) {
            if (cine[i].id == salaParaActualizar) {
                for (k in posicionButacasParaActualizar.indices) {
                    cine[i].liberarButaca(posicionButacasParaActualizar[k].getPosicionCompletaButaca())
                }
            }
        }
        // Establecemos un cliente plantilla por defecto inicial
        val usuarioClientePorDefecto: Cliente =
            Cliente(" ", " ", " ", " ", " ", " ",
                Ticket(
                    EstadoTicket.INACTIVO, " ", " ", " ",
                    Array(cine[0].getTamannoMaxFilas() * cine[0].getTamannoMaxColumnas()) {
                        Butaca(
                            EstadoButaca.LIBRE,
                            "A",
                            "0",
                            false
                        )
                    }
                )
            )
        almacenClientes[posicionCliente] = usuarioClientePorDefecto
        Thread.sleep(3000)
    }
}

/**
 * Anula la reserva de una entrada.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun anularReserva(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    do {
        existenciaReservaParaAnular(cine, almacenClientes)
    } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"))
}

/**
 * Comprueba si existe alguna reserva realizada con el DNI, email o ID_Ticket proporcionado por el usuario.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 */
fun existenciaReservaParaAnular(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    println("Puedes realizar la búsqueda de tu reserva mediante -> DNI, email o ID_Ticket: ")
    val entradaUsuario = readln()
    var encontrado: Boolean = false
    for (i in almacenClientes.indices) {
        if (almacenClientes[i].informacionTicket.estado == EstadoTicket.RESERVA) {
            if (almacenClientes[i].email == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaReserva(cine, almacenClientes, i)
                encontrado = true
                break
            }
            if (almacenClientes[i].dni == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaReserva(cine, almacenClientes, i)
                encontrado = true
                break
            }
            if (almacenClientes[i].informacionTicket.ticketIDstring() == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                anularUnaReserva(cine, almacenClientes, i)
                encontrado = true
                break
            }
        }
    }
    if (!encontrado) {
        println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!")
        println("")
    }
}

/**
 * Anula la reserva de una entrada y libera las butacas.
 *
 * @param cine Array de objetos Sala con las salas del cine
 * @param almacenClientes Array de objetos Cliente con la información de todos los clientes del cine
 * @param posicionCliente Índice del cliente en el array almacenClientes
 */
fun anularUnaReserva(cine: Array<Sala>, almacenClientes: Array<Cliente>, posicionCliente: Int) {
    val mensaje: String = "¿Está seguro que desea anular su reserva (S/N)?"
    if (deseaAnular(mensaje)) {
        // Cambiamos el estado de la/s butaca/s a libre/s
        val salaParaActualizar: String = almacenClientes[posicionCliente].informacionTicket.salaID
        val posicionButacasParaActualizar: Array<Butaca> = almacenClientes[posicionCliente].informacionTicket.butacas
        for (i in cine.indices) {
            if (cine[i].id == salaParaActualizar) {
                for (k in posicionButacasParaActualizar.indices) {
                    cine[i].liberarButaca(posicionButacasParaActualizar[k].getPosicionCompletaButaca())
                }
            }
        }

        // Y establecemos un cliente plantilla por defecto inicial
        val usuarioClientePorDefecto: Cliente =
            Cliente(" ", " ", " ", " ", " ", " ",
                Ticket(
                    EstadoTicket.INACTIVO, " ", " ", " ",
                    Array(cine[0].getTamannoMaxFilas() * cine[0].getTamannoMaxColumnas()) {
                        Butaca(
                            EstadoButaca.LIBRE,
                            "A",
                            "0",
                            false
                        )
                    }
                )
            )
        almacenClientes[posicionCliente] = usuarioClientePorDefecto

        println("¡Reserva anulada!")
        Thread.sleep(2250)
    }
}

/**
 * Pide al usuario que indique si desea anular algo o no.
 *
 * @param mensaje Mensaje que se mostrará al usuario para pedirle que indique si desea anular algo o no
 * @return "true" si el usuario desea anular, "false" si no lo desea
 */
fun deseaAnular(mensaje: String): Boolean {
    while (true) {
        println(mensaje)
        val entradaUsuario: String = readln().lowercase()
        if (entradaUsuario == "s") {
            falsoBorradoDeConsola()
            return true
        }
        if (entradaUsuario == "n") {
            falsoBorradoDeConsola()
            return false
        }
        falsoBorradoDeConsola()
        println("Debe introducir (S/N)!")
        Thread.sleep(1500)
        falsoBorradoDeConsola()
    }
}

/**
 * Formaliza una reserva previamente realizada por un usuario.
 *
 * @param cine Array de salas del cine.
 * @param almacenClientes Array de clientes del cine.
 */
fun formalizarReserva(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    do {
        existenciaReservaParaFormalizar(cine, almacenClientes)
    } while (repetir("¿Quieres volver a realizar una búsqueda (S/N)?"))
}

/**
 * Función que permite a un usuario formalizar su reserva.
 *
 * @param cine Array de objetos Sala que almacena todas las salas del cine
 * @param almacenClientes Array de objetos Cliente que almacena todos los clientes del cine
 *
 * El usuario puede realizar la búsqueda de su reserva mediante su DNI, email o ID del ticket.
 * Si se encuentra la reserva, se procede al pago y se cambia el estado del ticket a "COMPRA".
 * Además, se cambian las butacas de la sala correspondiente a "OCUPADAS".
 */
fun existenciaReservaParaFormalizar(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    println("Puedes realizar la búsqueda de tu reserva mediante -> DNI, email o ID_Ticket: ")
    val entradaUsuario = readln()
    var encontrado: Boolean = false
    for (i in almacenClientes.indices) {
        if (almacenClientes[i].informacionTicket.estado == EstadoTicket.RESERVA) {
            if (almacenClientes[i].email == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                procederPagoDeUnaReserva(almacenClientes, i)
                encontrado = true
                // Cambiamos reserva a comprada, en el ticket
                almacenClientes[i].setEstadoTicketAsociado(EstadoTicket.COMPRA)
                // Cambiamos butacas de la sala a OCUPADAS
                val salaIDParaCambiar: String = almacenClientes[i].getIDsalaAsociadaCliente()
                for (j in cine.indices) {
                    // Filtro para únicamente cambiar las butacas de la sala que el cliente tiene las butacas reservadas
                    if (cine[j].id == salaIDParaCambiar) {
                        // Recorremos el vector de butacas seleccionadas previamente por el cliente y las asignamos a ocupadas
                        val butacasSeleccionas: Array<Butaca> =
                            almacenClientes[i].informacionTicket.butacas
                        for (k in butacasSeleccionas.indices) {
                            cine[j].ocuparButaca(butacasSeleccionas[k].getPosicionCompletaButaca())
                        }
                    }
                }
                break
            }
            if (almacenClientes[i].dni == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                procederPagoDeUnaReserva(almacenClientes, i)
                encontrado = true
                // Cambiamos reserva a comprada, en el ticket
                almacenClientes[i].setEstadoTicketAsociado(EstadoTicket.COMPRA)
                // Cambiamos butacas de la sala a OCUPADAS
                val salaIDParaCambiar: String = almacenClientes[i].getIDsalaAsociadaCliente()
                for (j in cine.indices) {
                    // Filtro para únicamente cambiar las butacas de la sala que el cliente tiene las butacas reservadas
                    if (cine[j].id == salaIDParaCambiar) {
                        // Recorremos el vector de butacas seleccionadas previamente por el cliente y las asignamos a ocupadas
                        val butacasSeleccionas: Array<Butaca> =
                            almacenClientes[i].informacionTicket.butacas
                        for (k in butacasSeleccionas.indices) {
                            cine[j].ocuparButaca(butacasSeleccionas[k].getPosicionCompletaButaca())
                        }
                    }
                }
                break
            }
            if (almacenClientes[i].informacionTicket.ticketIDstring() == entradaUsuario) {
                println(almacenClientes[i])
                println(almacenClientes[i].informacionTicket)
                procederPagoDeUnaReserva(almacenClientes, i)
                encontrado = true
                // Cambiamos reserva a comprada en el ticket
                almacenClientes[i].setEstadoTicketAsociado(EstadoTicket.COMPRA)
                // Cambiamos butacas de la sala a OCUPADAS
                val salaIDParaCambiar: String = almacenClientes[i].getIDsalaAsociadaCliente()
                for (j in cine.indices) {
                    // Filtro para únicamente cambiar las butacas de la sala que el cliente tiene las butacas reservadas
                    if (cine[j].id == salaIDParaCambiar) {
                        // Recorremos el vector de butacas seleccionadas previamente por el cliente y las asignamos a ocupadas
                        val butacasSeleccionas: Array<Butaca> =
                            almacenClientes[i].informacionTicket.butacas
                        for (k in butacasSeleccionas.indices) {
                            cine[j].ocuparButaca(butacasSeleccionas[k].getPosicionCompletaButaca())
                        }
                    }
                }
                break
            }
        }
    }
    if (!encontrado) {
        println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!")
        println("")
    }
}

/**
 * Realiza el pago de una reserva a través de tarjeta de crédito.
 *
 * @param almacenClientes Arreglo de objetos de tipo Cliente.
 * @param posicionCliente Índice del cliente en el Array almacenClientes.
 */
fun procederPagoDeUnaReserva(almacenClientes: Array<Cliente>, posicionCliente: Int) {
    if (deseaPagar()) {
        val clienteActualizar: Cliente = almacenClientes[posicionCliente]
        while (true) {
            println("Tarjeta de Crédito (*Obligatorio):")
            val tarjetaCliente: String = readln()
            if (filtroTarjetaCredito(tarjetaCliente)) {
                // Si superamos el filtro actualizamos la tarjeta
                clienteActualizar.setTarjetaCredito(tarjetaCliente)
                falsoBorradoDeConsola()
                println("Acaba de formalizar la compra de ${clienteActualizar.informacionTicket.getCantidadEntradas()} entradas.")
                println(
                    "Precio total cobrado: ${
                        clienteActualizar.informacionTicket.getCantidadEntradas().toDouble() * 5.25
                    }€"
                )
                println("")
                break
            }
        }
    }
}

/**
 * Muestra la información general de un cliente y su reserva.
 *
 * @param almacenClientes Array de objetos de tipo Cliente.
 */
fun demostrarInformacionGeneral(almacenClientes: Array<Cliente>) {
    println("Puedes realizar la búsqueda de tu compra/reserva mediante -> DNI, email o ID_Ticket: ")
    val entradaUsuario = readln()
    var encontrado: Boolean = false

    for (i in almacenClientes.indices) {
        if (almacenClientes[i].email == entradaUsuario) {
            println(almacenClientes[i])
            println(almacenClientes[i].informacionTicket)
            println(" ")
            encontrado = true
        }
        if (almacenClientes[i].dni == entradaUsuario) {
            println(almacenClientes[i])
            println(almacenClientes[i].informacionTicket)
            println(" ")
            encontrado = true
        }
        if (almacenClientes[i].informacionTicket.ticketIDstring() == entradaUsuario) {
            println(almacenClientes[i])
            println(almacenClientes[i].informacionTicket)
            println(" ")
            encontrado = true
        }
    }
    if (!encontrado) {
        println("No hay ninguna compra o reserva realizada con los datos que nos proporcionas!")
        println("")
    }
}

/**
 * Permite seleccionar las butacas que se quieren reservar.
 *
 * @param cine Arreglo de objetos de tipo Sala.
 * @param idSala Identificador de la sala a la que pertenecen las butacas.
 * @param cantidadEntradas Número de butacas a reservar.
 * @return Un arreglo de objetos de tipo Butaca con las butacas seleccionadas y reservadas.
 */
fun seleccionButacasReservadas(cine: Array<Sala>, idSala: String, cantidadEntradas: String): Array<Butaca> {
    val almacenSeleccionButacas: Array<Butaca> =
        Array(cantidadEntradas.toInt()) { Butaca(EstadoButaca.LIBRE, "A", "0", false) }
    var contadorButaca: Int = 1
    repeat(cantidadEntradas.toInt()) {

        var salirBucle: Boolean = false
        while (!salirBucle) {
            mostrarSala(cine, idSala)
            println("Seleccione BUTACA número $contadorButaca para reservar (ejemplo -> A1):")
            val entradaButacaReservada: String = readln().uppercase()
            if (filtradoButacas(cine, idSala, entradaButacaReservada)) {
                contadorButaca += 1
                for (i in cine.indices) {
                    if (cine[i].id == idSala) {
                        // Introducimos la butaca filtrada en nuestro almacén, donde haya una LIBRE
                        for (j in almacenSeleccionButacas.indices) {
                            if (almacenSeleccionButacas[j].getEstadoButaca() == EstadoButaca.LIBRE) {
                                almacenSeleccionButacas[j] = Butaca(
                                    EstadoButaca.RESERVADO,
                                    entradaButacaReservada[0].toString(),
                                    entradaButacaReservada[1].toString(),
                                    // Asignamos si era VIP con anterioridad o no
                                    cine[i].getBooleanButacaVipDesdeSala(entradaButacaReservada)
                                )
                                break
                            }
                        }
                        // Asignamos reservada la butaca en la sala específica seleccionada
                        cine[i].reservarButaca(entradaButacaReservada)
                        salirBucle = true
                        break
                    }
                }
            }
        }
        mostrarSala(cine, idSala)
    }
    return almacenSeleccionButacas
}

/**
 * Selecciona una cantidad determinada de butacas ocupadas en una sala de cine específica.
 *
 * @param cine Array de objetos de la clase Sala que representa el cine completo.
 * @param idSala Identificador de la sala de cine en la que se desean seleccionar las butacas.
 * @param cantidadEntradas Cantidad de butacas a seleccionar.
 * @return Array de objetos de la clase Butaca que representa las butacas seleccionadas.
 */
fun seleccionButacasOcupadas(cine: Array<Sala>, idSala: String, cantidadEntradas: String): Array<Butaca> {
    val almacenSeleccionButacas: Array<Butaca> =
        Array(cantidadEntradas.toInt()) { Butaca(EstadoButaca.LIBRE, "A", "0", false) }
    var contadorButaca: Int = 1
    repeat(cantidadEntradas.toInt()) {

        var salirBucle: Boolean = false
        while (!salirBucle) {
            mostrarSala(cine, idSala)
            println("Seleccione BUTACA número $contadorButaca para comprar (ejemplo -> A1):")
            val entradaButacaOcupada: String = readln().uppercase()
            // Aplicamos filtro para no seleccionar una butaca no existente, ya reservada u ocupada
            if (filtradoButacas(cine, idSala, entradaButacaOcupada)) {
                contadorButaca += 1
                for (i in cine.indices) {
                    if (cine[i].id == idSala) {
                        // Introducimos la butaca filtrada en nuestro almacén, donde haya una LIBRE
                        for (j in almacenSeleccionButacas.indices) {
                            if (almacenSeleccionButacas[j].getEstadoButaca() == EstadoButaca.LIBRE) {
                                almacenSeleccionButacas[j] = Butaca(
                                    EstadoButaca.OCUPADO,
                                    entradaButacaOcupada[0].toString(),
                                    entradaButacaOcupada[1].toString(),
                                    // Asignamos si era VIP con anterioridad o no
                                    cine[i].getBooleanButacaVipDesdeSala(entradaButacaOcupada)
                                )
                                break
                            }
                        }
                        // Asignamos ocupada la butaca en la sala específica seleccionada
                        cine[i].ocuparButaca(entradaButacaOcupada)
                        salirBucle = true
                        break
                    }
                }
            }
        }
        mostrarSala(cine, idSala)
    }
    return almacenSeleccionButacas
}

/**
 * Pregunta al usuario si desea realizar el pago.
 * @return true si el usuario quiere realizar el pago, false en caso contrario.
 */
fun deseaPagar(): Boolean {
    while (true) {
        println("¿Quiere realizar el pago (S/N)?")
        val entradaUsuario: String = readln().lowercase()
        if (entradaUsuario == "s") {
            falsoBorradoDeConsola()
            return true
        }
        if (entradaUsuario == "n") {
            falsoBorradoDeConsola()
            return false
        }
        falsoBorradoDeConsola()
        println("Debe introducir (S/N)!")
        Thread.sleep(1500)
        falsoBorradoDeConsola()
    }
}

/**
 * Permite a un cliente reservar entradas para una película.
 *
 * @param cine Array de objetos de tipo Sala.
 * @param almacenClientes Array de objetos de tipo Cliente.
 */
fun reservarEntrada(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    // Almacén donde guardaré las elecciones de mi usuario
    val almacenElecciones: Array<String> = Array(3) { "" }

    var salirBucle: Boolean = false
    while (!salirBucle) {
        mostrarCatalogo(cine)
        println("Introduzca el ID de la sala de la película que quieras ver:")
        val entradaIDsala: String = readln()
        falsoBorradoDeConsola()

        // Filtro para elegir un ID existente
        for (i in cine.indices) {
            if (entradaIDsala == cine[i].id) {
                almacenElecciones[0] = entradaIDsala
                salirBucle = true
                break
            }
            if (i == cine.size - 1) {
                if (entradaIDsala != cine[i].id) {
                    println("ID inválido! Debe existir la sala en el CINE!")
                    Thread.sleep(2250)
                    falsoBorradoDeConsola()
                    break
                }
            }

        }

    }

    while (true) {
        val maxButacas: Int = cine[0].cantidadButacasTotal()

        println("Introduzca la cantidad de entradas que quiere reservar:")
        val cantidadEntradas: String = readln()

        if (filtroCantidadEntradas(cantidadEntradas, maxButacas)) {
            almacenElecciones[1] = cantidadEntradas
            break
        }
    }

    // Seleccionar butacas donde quiera reservar
    val entradaIDsala: String = almacenElecciones[0]
    val cantidadEntradas: String = almacenElecciones[1]
    // Tienen filtros de entrada por consola las butacas en la selección
    val seleccionButacas: Array<Butaca> = seleccionButacasReservadas(cine, entradaIDsala, cantidadEntradas)

    val datosCliente: Array<String> = Array<String>(6) { " " }
    print("Introduzca sus datos para realizar la reserva:")
    println("")

    while (true) {
        println("Nombre (*Obligatorio):")
        val nombreCliente: String = readln()
        if (filtroMaxLetras(nombreCliente)) {
            datosCliente[0] = nombreCliente
            break
        }
    }

    while (true) {
        println("Apellido (*Obligatorio):")
        val apellidoCliente: String = readln()
        if (filtroMaxLetras(apellidoCliente)) {
            datosCliente[1] = apellidoCliente
            break
        }
    }

    while (true) {
        println("DNI (*Obligatorio):")
        val dniCliente: String = readln()
        if (filtroDNI(dniCliente)) {
            datosCliente[2] = dniCliente
            break
        }
    }

    while (true) {
        println("Teléfono:")
        val telefonoCliente: String = readln()
        if (filtroTelefono(telefonoCliente)) {
            datosCliente[3] = telefonoCliente
            break
        }
    }

    while (true) {
        println("Email (*Obligatorio):")
        val emailCliente: String = readln()
        if (filtroEmail(emailCliente)) {
            datosCliente[4] = emailCliente
            break
        }
    }
    // No asignamos tarjeta de crédito en la reserva! datosCliente[5] = NADA

    // Una vez superado los filtrados y es correcto:
    for (i in cine.indices) {
        if (cine[i].id == almacenElecciones[0]) {
            almacenElecciones[2] = cine[i].pelicula.nombrePeliculaString()
        }
    }
    // Generamos ticket de reserva
    val ticketNuevo: Ticket =
        Ticket(
            EstadoTicket.RESERVA,
            almacenElecciones[0],
            almacenElecciones[1],
            almacenElecciones[2],
            seleccionButacas
        )

    // Creamos nuevo cliente con todos los datos anteriores
    val clienteNuevo: Cliente = Cliente(
        datosCliente[0],
        datosCliente[1],
        datosCliente[2],
        datosCliente[3],
        datosCliente[4],
        "EN ESPERA DE FORMALIZAR RESERVA",
        ticketNuevo
    )
    println("Sus datos son:")
    println(clienteNuevo)

    // Almacenamos nuestro cliente en nuestra base de datos volátil únicamente viva hasta parar el programa
    for (i in almacenClientes.indices) {
        if (almacenClientes[i].dni == " ") {
            almacenClientes[i] = clienteNuevo
            break
        }
    }

    // Vemos si son VIP o no nuestras butacas para calcular su precio:
    var contadorButacasVIP: Int = 0
    var contadorButacasEstandar: Int = 0
    for (i in seleccionButacas.indices) {
        if (seleccionButacas[i].getBooleanButacaVip()) {
            contadorButacasVIP += 1
        } else {
            contadorButacasEstandar += 1
        }
    }
    val precioTotalCobrar: Double = (contadorButacasEstandar * PRECIO_ESTANDAR) + (contadorButacasVIP * PRECIO_VIP)

    println("")
    println("Acaba de formalizar una reserva de ${almacenElecciones[1]} entradas.")
    println("$contadorButacasEstandar entradas ESTÁNDAR")
    println("$contadorButacasVIP entradas VIP")
    println("Precio total para cobrar: $precioTotalCobrar€")
    println("IMPORTANTE: debe formalizar la reserva antes de 30 minutos! Si no se le anulará la reserva!")
    println("")
}

/**
 * Permite a un cliente comprar entradas para una película.
 *
 * @param cine Array de objetos de tipo Sala.
 * @param almacenClientes Array de objetos de tipo Cliente.
 */
fun comprarEntrada(cine: Array<Sala>, almacenClientes: Array<Cliente>) {
    // Almacén donde guardaré las elecciones de mi usuario
    val almacenElecciones: Array<String> = Array(3) { "" }

    var salirBucle: Boolean = false
    while (!salirBucle) {
        mostrarCatalogo(cine)
        println("Introduzca el ID de la sala de la película que quieras ver:")
        val entradaIDsala: String = readln()
        falsoBorradoDeConsola()

        // Filtro para elegir un ID existente
        for (i in cine.indices) {
            if (entradaIDsala == cine[i].id) {
                almacenElecciones[0] = entradaIDsala
                salirBucle = true
                break
            }
            if (i == cine.size - 1) {
                if (entradaIDsala != cine[i].id) {
                    println("ID inválido! Debe existir la sala en el CINE!")
                    Thread.sleep(2250)
                    falsoBorradoDeConsola()
                    break
                }
            }

        }

    }

    while (true) {
        val maxButacas: Int = cine[0].cantidadButacasTotal()

        println("Introduzca la cantidad de entradas que quiere comprar:")
        val cantidadEntradas: String = readln()

        if (filtroCantidadEntradas(cantidadEntradas, maxButacas)) {
            almacenElecciones[1] = cantidadEntradas
            break
        }
    }

    // Seleccionar butacas donde quiera comprar
    val entradaIDsala: String = almacenElecciones[0]
    val cantidadEntradas: String = almacenElecciones[1]
    // Ya están filtradas dentro
    val seleccionButacas: Array<Butaca> = seleccionButacasOcupadas(cine, entradaIDsala, cantidadEntradas)

    val datosCliente: Array<String> = Array<String>(6) { " " }
    print("Introduzca sus datos para realizar la compra:")
    println("")

    while (true) {
        println("Nombre (*Obligatorio):")
        val nombreCliente: String = readln()
        if (filtroMaxLetras(nombreCliente)) {
            datosCliente[0] = nombreCliente
            break
        }
    }

    while (true) {
        println("Apellido (*Obligatorio):")
        val apellidoCliente: String = readln()
        if (filtroMaxLetras(apellidoCliente)) {
            datosCliente[1] = apellidoCliente
            break
        }
    }

    while (true) {
        println("DNI (*Obligatorio):")
        val dniCliente: String = readln()
        if (filtroDNI(dniCliente)) {
            datosCliente[2] = dniCliente
            break
        }
    }

    while (true) {
        println("Teléfono:")
        val telefonoCliente: String = readln()
        if (filtroTelefono(telefonoCliente)) {
            datosCliente[3] = telefonoCliente
            break
        }
    }

    while (true) {
        println("Email (*Obligatorio):")
        val emailCliente: String = readln()
        if (filtroEmail(emailCliente)) {
            datosCliente[4] = emailCliente
            break
        }
    }

    while (true) {
        println("Tarjeta de Crédito (*Obligatorio):")
        val tarjetaCliente: String = readln()
        if (filtroTarjetaCredito(tarjetaCliente)) {
            datosCliente[5] = tarjetaCliente
            break
        }
    }

    // Una vez superado los filtrados y es correcto
    // Generamos ticket
    for (i in cine.indices) {
        if (cine[i].id == almacenElecciones[0]) {
            almacenElecciones[2] = cine[i].pelicula.nombrePeliculaString()
        }
    }
    val ticketNuevo: Ticket =
        Ticket(
            EstadoTicket.COMPRA,
            almacenElecciones[0],
            almacenElecciones[1],
            almacenElecciones[2],
            seleccionButacas
        )

    // Creamos nuevo cliente con todos los datos anteriores
    val clienteNuevo: Cliente = Cliente(
        datosCliente[0],
        datosCliente[1],
        datosCliente[2],
        datosCliente[3],
        datosCliente[4],
        datosCliente[5],
        ticketNuevo
    )
    println("Sus datos son:")
    println(clienteNuevo)

    // Almacenamos nuestro cliente en nuestra base de datos volátil únicamente viva hasta parar el programa
    for (i in almacenClientes.indices) {
        if (almacenClientes[i].dni == " ") {
            almacenClientes[i] = clienteNuevo
            break
        }
    }

    // Vemos si son VIP o no nuestras butacas para calcular su precio:
    var contadorButacasVIP: Int = 0
    var contadorButacasEstandar: Int = 0
    for (i in seleccionButacas.indices) {
        if (seleccionButacas[i].getBooleanButacaVip()) {
            contadorButacasVIP += 1
        } else {
            contadorButacasEstandar += 1
        }
    }
    val precioTotalCobrar: Double = (contadorButacasEstandar * PRECIO_ESTANDAR) + (contadorButacasVIP * PRECIO_VIP)
    println("")
    println("Acaba de formalizar la compra de ${almacenElecciones[1]} entradas.")
    println("$contadorButacasEstandar entradas ESTÁNDAR")
    println("$contadorButacasVIP entradas VIP")
    println("Precio total cobrado: $precioTotalCobrar€")
    println("")
}