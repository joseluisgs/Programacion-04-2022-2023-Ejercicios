package simulacionCine.utils

import simulacionCine.enums.EstadoButaca
import simulacionCine.models.Sala

/**
 * Filtra una cadena de caracteres según una expresión regular para asegurar que tiene entre 3 y 20 letras.
 *
 * @param letrasCliente La cadena de caracteres a filtrar.
 * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
 */
fun filtroMaxLetras(letrasCliente: String): Boolean {
    val regex = Regex("[a-zA-Z]{3,20}")
    if (!regex.matches(letrasCliente)) {
        println("Como mínimo 3 letras y como máximo 20")
        println("")
        return false
    }
    return true
}

/**
 * Filtra una cadena de caracteres para asegurar que tiene 16 números.
 *
 * @param tarjetaCliente La cadena de caracteres a filtrar.
 * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
 */
fun filtroTarjetaCredito(tarjetaCliente: String): Boolean {
    val regex = Regex("[0-9]{16}")
    if (!regex.matches(tarjetaCliente)) {
        println("La tarjeta debe estar compuesto de 16 números!")
        println("")
        return false
    }
    return true
}

/**
 * Filtra una cadena de caracteres para asegurar que tiene el formato de un correo electrónico válido.
 *
 * @param emailCliente La cadena de caracteres a filtrar.
 * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
 */
fun filtroEmail(emailCliente: String): Boolean {
    val regex = Regex("[A-Za-z0-9]+@[A-Za-z0-9.-]+.[A-Za-z]{2,}")
    if (!regex.matches(emailCliente)) {
        println("El email debe estar compuesto de: xxx@xxx.xx")
        println("")
        return false
    }
    return true
}

/**
 * Filtra una cadena de caracteres para asegurar que tiene 9 números.
 *
 * @param telefonoCliente La cadena de caracteres a filtrar.
 * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
 */
fun filtroTelefono(telefonoCliente: String): Boolean {
    val regex = Regex("[0-9]{9}|")
    if (!regex.matches(telefonoCliente)) {
        println("El teléfono debe tener 9 números: (612345678)!")
        println("")
        return false
    }
    return true
}

/**
 * Verifica si el DNI de un cliente es válido.
 * Un DNI válido debe tener 8 números y una letra.
 *
 * @param dniCliente El DNI del cliente a verificar.
 * @return {@code true} si el DNI es válido, {@code false} si no lo es.
 */
fun filtroDNI(dniCliente: String): Boolean {
    val regex = Regex("[0-9]{8}[A-Za-z]")
    if (!regex.matches(dniCliente)) {
        println("El DNI debe tener 8 número y una letra: (12345678A)!")
        println("")
        return false
    }
    return true
}

/**
 * Verifica si la cantidad de entradas es válida.
 * Una cantidad de entradas válida debe ser un número entero mayor a 0 y menor o igual al número máximo de butacas.
 *
 * @param cantidadEntradas La cantidad de entradas a verificar.
 * @param maxButacas El número máximo de butacas disponibles.
 * @return "true" si la cantidad de entradas es válida, "false" si no lo es.
 */
fun filtroCantidadEntradas(cantidadEntradas: String, maxButacas: Int): Boolean {
    // Filtro valores alfabéticos
    val regexValorUnico = Regex("\\d+")
    if (!regexValorUnico.matches(cantidadEntradas)) {
        println("ERROR: Debe ser un número!")
        println("")
        return false
    }

    if (cantidadEntradas.toInt() > maxButacas) {
        println("ERROR: Como mínimo es 1, y como máximo $maxButacas!")
        println("")
        return false
    } else if (cantidadEntradas.toInt() <= 0) {
        println("ERROR: Como mínimo es 1, y como máximo $maxButacas!")
        println("")
        return false
    }
    return true
}

/**
 * Verifica si una butaca es válida para ser reservada u ocupada.
 * Una butaca es válida si cumple con los siguientes criterios:
 * - Debe tener un formato válido: una letra seguida de un número.
 * - No debe estar ocupada o reservada previamente.
 * - Debe estar dentro de los límites de la sala en cuestión.
 *
 * @param cine El cine al que pertenece la sala.
 * @param idSala El ID de la sala a verificar.
 * @param entradaButaca La butaca a verificar.
 * @return "true" si la butaca es válida, "false" si no lo es.
 */
fun filtradoButacas(cine: Array<Sala>, idSala: String, entradaButaca: String): Boolean {
    // Filtro si me devuelven un valor distinto de dos índices
    var contadorLimite: Int = 0
    for (i in 0 until entradaButaca.length) {
        contadorLimite += 1
    }
    if (contadorLimite != 2) {
        println("ERROR: Debes introducir una letra y un número: (ejemplo -> A1)")
        println("")
        return false
    }

    // COLUMNAS
    // Filtro para ser las columnas siempre números
    val regexColumna = Regex("\\d+")
    if (!regexColumna.matches(entradaButaca[1].toString())) {
        println("ERROR: Debes introducir en las columnas un número: (ejemplo -> A1)")
        println("")
        return false
    }
    // Filtrado para limitar respecto al tamaño de sala
    if (entradaButaca.substring(1, 2).toInt() > cine[0].getTamannoMaxColumnas()) {
        println("ERROR: No existe la butaca seleccionada")
        println("Has asignado una butaca en una posición de columna más grande que la SALA!")
        println("")
        return false
    }
    if (entradaButaca.substring(1, 2).toInt() <= 0) {
        println("ERROR: No existe la butaca seleccinada")
        println("Has asignado una butaca en una posición de columna más pequeña de la SALA!")
        println("")
        return false
    }

    // FILAS
    // Filtro para ser las filas siempre letras
    val regexFila = Regex("[a-z]|[A-Z]")
    if (!regexFila.matches(entradaButaca[0].toString())) {
        println("ERROR: Debes introducir en las filas una letra: (ejemplo -> A1)")
        println("")
        return false
    }
    // Filtrado para limitar respecto al tamaño de sala
    val filaButaca: Char = entradaButaca[0]
    val abecedario: String = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
    var contadorFilaSeleccionada: Int = 0
    for (element in abecedario) {
        contadorFilaSeleccionada += 1
        if (contadorFilaSeleccionada > cine[0].getTamannoMaxFilas()) {
            println("ERROR: No existe la butaca seleccionada")
            println("Has asignado una butaca en una posición de fila más grande de la SALA!")
            println("")
            return false
        } else if (element == filaButaca && contadorFilaSeleccionada <= cine[0].getTamannoMaxFilas()) {
            break
        }
    }

    // Filtro butaca ya reservada u ocupada
    // Nos dirigimos a la sala que necesitemos
    for (i in cine.indices) {
        if (cine[i].id == idSala) {
            val estadoButacaParaFiltrar: EstadoButaca = cine[i].getEstadoButacaEspecifica(entradaButaca)
            if (estadoButacaParaFiltrar == EstadoButaca.OCUPADO) {
                println("ERROR: La butaca $entradaButaca está ocupada!")
                return false
            }
            if (estadoButacaParaFiltrar == EstadoButaca.RESERVADO) {
                println("ERROR: La butaca $entradaButaca está reservada!")
                return false
            }
        }
    }
    return true
}