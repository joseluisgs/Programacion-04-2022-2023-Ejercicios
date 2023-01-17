import models.ButacaCine
import models.Entrada
import models.SalaCine

/**
 * PROGRAMA QUE SIMULA EL FUNCIONAMIENTO DE UN CINE
 */
fun main(){
    val sala1 = SalaCine(1,8,10)
    sala1.peliculaProyectada = "The Thing 2. ODD attack"
    var caja = 0
    println("     CINE KOTLIN")
    do{
        val respuesta:String = getRespuesta()
        when(respuesta){
            "1"-> caja=comprar(sala1,caja)
            "2"-> reservar(sala1)
            "3"-> caja=pagarReserva(sala1,caja)
            "4"-> anularReserva(sala1)
            "5"-> caja=anularCompradas(sala1,caja)
            "6"->sala1.mostrarSala()
            "7"->getDineros(caja)
            "8"->sala1.getPorcentaje()
            "9"->caja=simulacion(sala1,caja)
        }
    }while(respuesta!="S")
}

/**
 * Función que pide por consola un número entre 1-8 o S. Lo pasa por Regex y devuelve String
 */
fun getRespuesta():String{
    var respuesta: String
    val regex= Regex("[1-9]|S")
    var respuestaValida = false

    println("-|---------------------|-")
    println("   SELECCIONA UNA OPCION")
    println("  1.- Comprar Entrada")
    println("  2.- Reservar Entrada")
    println("  3.- Pagar Reserva ")
    println("  4.- Anular Reserva")
    println("  5.- Anular Entrada Comprada")
    println("  6.- Mostrar Estado De la Sala")
    println("  7.- Mostrar Dinero Caja")
    println("  8.- Mostrar Porcentaje Ocupación")
    println("  9.- Simulación  ")
    println("  S.- Salir Programa")
    println("-|---------------------|-")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Fallo, Solo números entre 1-9 o S ") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    return respuesta
}


/**
 * Función para comprar entrada. Devuelve Caja como int.
 */
fun comprar(sala1: SalaCine, caja: Int):Int {
    var cajaLocal= 0
    if(!sala1.isLleno()){
        var numeroEntradas:Int = getNumeroEntradas()
        sala1.mostrarSala()
        do{
            val fila= getFila(sala1)
            val columna= getColumna()
            if(sala1.salaCine[fila][columna].estadoButaca ==ButacaCine.EstadoButacas.LIBRE) {
                sala1.salaCine[fila][columna].estadoButaca = ButacaCine.EstadoButacas.OCUPADA
                sala1.salaCine[fila][columna].entradaAsignada= Entrada(sala1.numeroSala,sala1.salaCine[fila][columna],
                    "13:00")
                sala1.salaCine[fila][columna].entradaAsignada!!.pagar()
                cajaLocal+= sala1.salaCine[fila][columna].entradaAsignada!!.precio
                println("Tu entrada para ${sala1.peliculaProyectada} es la" +
                        " referencia ${sala1.salaCine[fila][columna].entradaAsignada!!.id} y esta Pagada ")
                val precioLocal= sala1.salaCine[fila][columna].entradaAsignada!!.precio.toString()
                val precioMostrar = "${precioLocal[0]},${precioLocal[1]}${precioLocal[2]}€"
                println("Precio cobrado $precioMostrar")
                numeroEntradas -= 1
            }else println("Lo siento el asiento no esta disponible 😪")
        }while(numeroEntradas>0)
    }else println("Lo siento la sala esta llena")
    return  caja + cajaLocal
}

/**
 * Función que pregunta al usuario cuantas entradas quiere. Retorna un Int
 */
fun getNumeroEntradas(): Int {
    var respuesta: String
    val regex= Regex("[1-5]")
    var respuestaValida = false

    println("   ¿Cuantas Entradas Quieres? ")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Fallo, Solo números de 1-5") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    return respuesta.toInt()
}
/**
 * Función que pregunta a usuario por la fila de la butaca. Retorna Int
 */
fun getFila(sala1: SalaCine): Int {
    val ultimaFila = sala1.numeroFilas
    val letrasFilas =  arrayOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T")
    var respuestaSalida = 0
    var respuesta: String
    val regex= Regex("[A-${letrasFilas[ultimaFila-1]}]")
    var respuestaValida = false
    println("   ¿En que Fila?                       Introduce la letra ")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Ups, Algo fallo. Introduce solo una letra valida") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)

    for(i in letrasFilas.indices){
        if(respuesta==letrasFilas[i]){
            respuestaSalida= i
        }
    }
    return  respuestaSalida
}
/**
 * Función que pide al usuario la columna de la butaca. Devuelve Int
 */
fun getColumna(): Int {
    var respuesta: String
    val regex= Regex("[1-9]|10")
    var respuestaValida = false

    println("   ¿En que numero de la Columna?    Introduce el numero de la butaca ")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Fallo, Solo números de 1-10") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    return respuesta.toInt()-1
}


/**
 * Función que reserva una butaca y genera entrada.
 */
fun reservar(sala1: SalaCine) {
    if(!sala1.isLleno()){
        var numeroEntradas:Int = getNumeroEntradas()
        sala1.mostrarSala()
        do{
            val fila= getFila(sala1)
            val columna= getColumna()
            if(sala1.salaCine[fila][columna].estadoButaca ==ButacaCine.EstadoButacas.LIBRE) {
                sala1.salaCine[fila][columna].estadoButaca = ButacaCine.EstadoButacas.RESERVADA
                sala1.salaCine[fila][columna].entradaAsignada= Entrada(sala1.numeroSala,sala1.salaCine[fila][columna],
                    "13:00")
                println("Tu entrada para ${sala1.peliculaProyectada} es la" +
                        " referencia ${sala1.salaCine[fila][columna].entradaAsignada!!.id }")
                numeroEntradas -= 1
            }else println("Lo siento el asiento no esta disponible 😪")
        }while(numeroEntradas>0)
    }else println("Lo siento la sala esta llena")
}


/**
 * Función para Pagar la reserva. Devuelve Int (caja)
 */
fun pagarReserva(sala1: SalaCine, caja: Int): Int {
    val butacaReservadaPosicion:Pair<Int,Int> = getButaca(sala1)
    if(sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].estadoButaca ==
        ButacaCine.EstadoButacas.RESERVADA){
        sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].estadoButaca =
            ButacaCine.EstadoButacas.OCUPADA
        sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].entradaAsignada!!.pagar()
        println("Tu entrada a sido Pagada. Gracias, disfrute la película")
        return  caja + sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].entradaAsignada!!.precio}
    else println("Error, La butaca Ya esta ocupada")
    return  caja
}
/**
 * Función que pide a usuario modo de confirmar posición butaca 1.- por su ubicación con Funciones fila, columna
 * o por Id. Devuelve posición como Pair de Ints
 */
fun getButaca(sala1: SalaCine): Pair<Int, Int> {
    val respuesta = getModoCheck()
    var respuestaChachi= false
    var salida = Pair(0,0)
    when(respuesta){
        1-> {
            do {
                val fila = getFila(sala1)
                val columna = getColumna()
                salida= Pair(fila,columna)
                if(sala1.salaCine[salida.first][salida.second].estadoButaca==ButacaCine.EstadoButacas.RESERVADA||
                    sala1.salaCine[salida.first][salida.second].estadoButaca==ButacaCine.EstadoButacas.OCUPADA )
                    respuestaChachi= true
                else println("La Butaca seleccionada esta libre.")
            }while(!respuestaChachi)

        }
        2-> salida= getButacaXId(sala1)
    }
    return  salida
}
/**
 * Función que pregunta a usuario por consola modo de identificar butaca. Devuelve Int
 */
fun getModoCheck(): Int {
    var respuesta: String
    val regex= Regex("[1-2]")
    var respuestaValida = false

    println("   ¿Como quieres confirmar? ")
    println("   ")
    println("   1.- Por Fila/Columna")
    println("   2.- Por Id Entrada")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Fallo, Solo 1 o 2") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    return respuesta.toInt()
}
/**
 * Función que pide a usuario ID de butaca. Devuelve la Id como Int
 */
fun getIdButaca(): Int {
    var respuesta:String
    val regex= Regex("[0-9]*")
    var respuestaValida = false

    println("   ¿Cual es la ID de la entrada? ")
    do {
        print("  : ")
        respuesta = readln().trim().uppercase()
        if (!regex.matches(respuesta)){ println("Fallo, Solo números") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    return respuesta.toInt()
}
/**
 * Función que busca una, Id en el cine y devuelve Pair de Int con su ubicación en la sala
 */
fun getButacaXId(sala1: SalaCine): Pair<Int, Int> {
    var respuestacorrecta = false
    do {
        val respuesta = getIdButaca()
        for (i in sala1.salaCine.indices) {
            for (j in sala1.salaCine[i].indices) {
                if (sala1.salaCine[i][j].entradaAsignada != null && sala1.salaCine[i][j].entradaAsignada!!.id == respuesta)
                    return Pair(i, j)
            }
        }
        print("Error!!, Id no encontrada.")
    }while(!respuestacorrecta)
    return Pair(0,0)
}


/**
 * Función que cambia estado de una Butaca a Libre
 */
fun anularReserva(sala1: SalaCine) {
    val butacaReservadaPosicion:Pair<Int,Int> = getButaca(sala1)
    if(sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].estadoButaca ==
            ButacaCine.EstadoButacas.RESERVADA){
            sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].estadoButaca =
            ButacaCine.EstadoButacas.LIBRE
        sala1.salaCine[butacaReservadaPosicion.first][butacaReservadaPosicion.second].entradaAsignada = null
    println("Tu entrada a sido Liberada")}
    else println("Error esa entrada no esta reservada, esta ocupada")
}

/**
 * Función que anula la compra de una entrada. Devuelve Int (caja)
 */
fun anularCompradas(sala1: SalaCine, caja: Int): Int {
    val butacaCompradaPosicion:Pair<Int,Int> = getButaca(sala1)
    val precioDevolucion =
        sala1.salaCine[butacaCompradaPosicion.first][butacaCompradaPosicion.second].entradaAsignada!!.precio
    if(sala1.salaCine[butacaCompradaPosicion.first][butacaCompradaPosicion.second].estadoButaca ==
        ButacaCine.EstadoButacas.OCUPADA){
        sala1.salaCine[butacaCompradaPosicion.first][butacaCompradaPosicion.second].estadoButaca =
            ButacaCine.EstadoButacas.LIBRE
        sala1.salaCine[butacaCompradaPosicion.first][butacaCompradaPosicion.second].entradaAsignada= null
        println("Tu entrada a sido Liberada, Dinero devuelto")
        return caja -precioDevolucion}
    else println("Error, esa butaca esta reservada, no ocupada")
    return  caja
}


/**
 * Función que imprime el importe en caja
 */
fun getDineros(caja: Int) {
    val cajaLocal = caja.toString()
    val cajaComoArray = cajaLocal.toCharArray()
    if(cajaComoArray.size>2){
        val longArrayEntero:Int = cajaComoArray.size-2
        println("La recaudación es de " +
                "${cajaLocal.substring(0,longArrayEntero)},${cajaLocal.substring(longArrayEntero,longArrayEntero+2)}€")
    }else{
        println("La recaudación es de $cajaLocal €")
    }
}


/**
 * Función que imprime por pantalla el porcentaje del estado de la sala.
 */



/**
 * Función que pide a usuario porcentaje butacas Ocupadas y Reservadas y lo aplica a la sala de forma random
 * Devuelve Int (caja)
 */
fun simulacion(sala1: SalaCine, caja: Int):Int {
    println("   ¿Que porcentaje de ocupación quieres?  Valores entre 0,01 y 100 (da igual separación por , o .) ")
    var cajaLocal = caja
    val respuestaPorcentajeOcupadas:Int = getRespuestaPorcentaje() // 0,01% = 1  1%= 100  100% = 10000
    val butacasOcupadasReservadas = sala1.getOcupadasReservadas()
    var butacasPorOcupar = ((sala1.capacidadTotal * respuestaPorcentajeOcupadas)/10000)-butacasOcupadasReservadas.first
    var butacasLibres = sala1.capacidadTotal-butacasOcupadasReservadas.first-butacasOcupadasReservadas.second
    if(butacasPorOcupar<0) println("El porcentaje actual ya es mayor")
    else{
        do{
            if(butacasLibres<butacasPorOcupar){println("No queda tanto espacio libre. Se ocupara el máximo posible")
            butacasPorOcupar=butacasLibres}
            val filaRandom = (0 until sala1.numeroFilas).random()
            val columnaRandom = (0 until sala1.numeroColumna).random()
            if(sala1.salaCine[filaRandom][columnaRandom].estadoButaca==ButacaCine.EstadoButacas.LIBRE){
                sala1.salaCine[filaRandom][columnaRandom].estadoButaca = ButacaCine.EstadoButacas.OCUPADA
                sala1.salaCine[filaRandom][columnaRandom].entradaAsignada=
                    Entrada(sala1.numeroSala,sala1.salaCine[filaRandom][columnaRandom], "13:00")
                    sala1.salaCine[filaRandom][columnaRandom].entradaAsignada!!.pagar()
                    cajaLocal+= sala1.salaCine[filaRandom][columnaRandom].entradaAsignada!!.precio
                    butacasPorOcupar-=1}
            }while(butacasPorOcupar!=0)
        }
    println("   ¿Que porcentaje de Reservas quieres?  Valores entre 0,01 y 100 (da igual separación por , o .) ")
    val respuestaReservadas = getRespuestaPorcentaje()
    var butacasPorReservar = ((sala1.capacidadTotal * respuestaReservadas) / 10000)-butacasOcupadasReservadas.second
    if(butacasPorReservar<0) println("El porcentaje actual ya es mayor")
    else{
        do{
            if(butacasLibres<butacasPorReservar){println("No queda tanto espacio libre. Se Reservara el máximo posible")
                butacasPorReservar=butacasLibres}
            val filaRandom = (0 until sala1.numeroFilas).random()
            val columnaRandom = (0 until sala1.numeroColumna).random()
            if(sala1.salaCine[filaRandom][columnaRandom].estadoButaca==ButacaCine.EstadoButacas.LIBRE){
                sala1.salaCine[filaRandom][columnaRandom].estadoButaca = ButacaCine.EstadoButacas.RESERVADA
                sala1.salaCine[filaRandom][columnaRandom].entradaAsignada=
                    Entrada(sala1.numeroSala,sala1.salaCine[filaRandom][columnaRandom],
                        "13:00")
                butacasPorReservar-=1
            }
        }while(butacasPorReservar!=0)
    }
    sala1.mostrarSala()
    sala1.getPorcentaje()
    getDineros(cajaLocal)
    return  cajaLocal
}

/**
 * Función que pregunta a usuario que porcentaje desea. (0,01-100) Devuelve porcentaje como Int (0,01=1 , 1=100 )
 */
fun getRespuestaPorcentaje(): Int {
    var respuesta:String
    val regex= Regex("\\b100|[0-9]?[0-9][,][0-9][0-9]?|[1-9]?[0-9]\\b")
    var respuestaValida = false
    var respuestaComoInt = 0

    do {
        print("  : ")
        respuesta = readln().trim().replace(".",",").replace(" ",",")
        if (!regex.matches(respuesta)){ println("Fallo, Solo Valores entre 0,01 y 100") }
        else{
            respuestaValida = true
        }
    }while(!respuestaValida)
    if(!respuesta.contains(",")) return respuesta.toInt()*100
    else {
        val respuestaComoArray = respuesta.toCharArray()
        var numeroDecimales = 0
        for(i in respuestaComoArray.indices)
            if(respuestaComoArray[i]==',') numeroDecimales = respuestaComoArray.size-i-1
        val respuestaSinEspacio=respuesta.replace(",","")
        when(numeroDecimales){
            1-> respuestaComoInt = respuestaSinEspacio.toInt()*10
            2-> respuestaComoInt = respuestaSinEspacio.toInt()
        }

    }
     return respuestaComoInt
}
