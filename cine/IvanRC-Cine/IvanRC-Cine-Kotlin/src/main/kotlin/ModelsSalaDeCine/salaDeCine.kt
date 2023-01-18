package ModelsSalaDeCine

import Factories.ButacaFactory

data class salaDeCine(val nombre: String, val fila: Int, val columna: Int, val butacasVip: Int, val pelicula: pelicula) {

    var butacas: Array<Array<butaca?>> = Array(fila){Array<butaca?>(columna){null} }

    init {
        inicializarMatrizButacas()
        hacerButacasVip()
    }

    /**
     * función que sirve para averiguar el identificador de la butaca a la hora de inicializar la matriz
     * @param fila la posición de la fila sobre la que se colocará la butaca
     * @param columna la posición de la columna sobre la que se colocará la butaca
     * @return el indentificador creado a partir de los datos pasados por parametros
     */
    fun hallarIdentificadorButaca(fila: Int, columna: Int): String {
        val identificador = "${(65 + fila).toChar()}${columna+1}"
        return identificador
    }

    /**
     * función que sirve para comprar 1 o varias entradas
     */
    fun comprarEntrada(){
        println("${Colores.CYAN.color}La sala del cine es la siguiente:")
        representacionDeLaSala()
        var butaca = ""
        var contadorEntradas = 0
        do {
            println("""${Colores.CYAN.color}Introduzca el identificador de la butaca que quieras comprar ( "A1", por ejemplo ) o escribir "stop" para dejar de comprar butacas: """)
            butaca = introducirButaca()
            if(butacaLibre(butaca)) {
                if (butaca != "stop") {
                    val posicionButaca = buscarButacaPorIndentificador(butaca)
                    if (posicionButaca != Pair(-1, -1)) {
                        println("${Colores.GREEN.color}De acuerdo, has comprado la butaca ${comprar(posicionButaca)!!.identificador}")
                        contadorEntradas++
                        if(butacas[posicionButaca.first][posicionButaca.second]!!.tipoButaca == TipoButaca.VIP){
                            println("${Colores.GREEN.color}Ademas, cabe destacar que la butaca: ${butacas[posicionButaca.first][posicionButaca.second]!!.identificador}, es VIP")
                        }
                    } else {
                        println("${Colores.YELLOW.color}No existe ninguna butaca con esa identificación")
                    }
                }
            }else{
                println("${Colores.YELLOW.color}La bucata seleccionada ya está ocupada")
            }
        }while(butaca != "stop")
        println("${Colores.GREEN.color}Has comprado un total de $contadorEntradas butacas")
        println()
    }

    /**
     * función que sirve para poner el estado de una butaca en "comprado"
     * @return la butaca cuyo estado fue cambiado
     */
    fun comprar(posicionButaca: Pair<Int, Int>): butaca? {
        butacas[posicionButaca.first][posicionButaca.second]!!.estado = "comprado"
        return butacas[posicionButaca.first][posicionButaca.second]
    }

    /**
     * función que sirve para reservar 1 o varias entradas
     */
    fun reservarEntrada(){
        println("${Colores.CYAN.color}La sala del cine es la siguiente:")
        representacionDeLaSala()
        var butaca = ""
        var contadorEntradas = 0
        do {
            println("""${Colores.CYAN.color}Introduzca el identificador de la butaca que quieras reservar ( "A1", por ejemplo ) o escribir "stop" para dejar de reservar butacas: """)
            butaca = introducirButaca()
            if(butacaLibre(butaca)) {
                if (butaca != "stop") {
                    val posicionButaca = buscarButacaPorIndentificador(butaca)
                    if (posicionButaca != Pair(-1, -1)) {
                        println("${Colores.YELLOW.color}De acuerdo, has reservado la butaca ${reservar(posicionButaca)!!.identificador}")
                        contadorEntradas++
                        if(butacas[posicionButaca.first][posicionButaca.second]!!.tipoButaca == TipoButaca.VIP){
                            println("${Colores.YELLOW.color}Ademas, cabe destacar que la butaca: ${butacas[posicionButaca.first][posicionButaca.second]!!.identificador}, es VIP")
                        }
                    } else {
                        println("${Colores.YELLOW.color}No existe ninguna butaca con esa identificación")
                    }
                }
            }else{
                println("${Colores.YELLOW.color}La bucata seleccionada ya está ocupada")
            }
        }while(butaca != "stop")
        println("${Colores.YELLOW.color}Has reservado un total de $contadorEntradas butacas")
        println()
    }

    /**
     * función que sirve para poner el estado de una butaca en "reservado"
     * @return la butaca cuyo estado fue cambiado
     */
    fun reservar(posicionButaca: Pair<Int, Int>): butaca? {
        butacas[posicionButaca.first][posicionButaca.second]!!.estado = "reservado"
        return butacas[posicionButaca.first][posicionButaca.second]
    }

    /**
     * función que sirve para formalizar de reservado a comprado 1 o varias butacas
     */
    fun formalizarReserva(){
        println("${Colores.CYAN.color}La sala del cine es la siguiente:")
        representacionDeLaSala()
        var butaca = ""
        var contadorEntradas = 0
        do {
            println("""${Colores.CYAN.color}Introduzca el identificador de la butaca que quieras formalizar de reservas a compras ( "A1", por ejemplo ) o escribir "stop" para dejarlo: """)
            butaca = introducirButaca()
            if(butaca != "stop"){
                val posicionButaca = buscarButacaPorIndentificador(butaca)
                if(posicionButaca != Pair(-1, -1) && butacas[posicionButaca.first][posicionButaca.second]!!.estado == "reservado") {
                    println("${Colores.GREEN.color}De acuerdo, has formalizado la butaca ${comprar(posicionButaca)!!.identificador}")
                    contadorEntradas++
                    if(butacas[posicionButaca.first][posicionButaca.second]!!.tipoButaca == TipoButaca.VIP){
                        println("${Colores.GREEN.color}Ademas, cabe destacar que la butaca: ${butacas[posicionButaca.first][posicionButaca.second]!!.identificador}, es VIP")
                    }
                }else{
                    if(butacas[posicionButaca.first][posicionButaca.second]!!.estado == "reservado") {
                        println("${Colores.YELLOW.color}No existe ninguna butaca con esa identificación")
                    }else{
                        println("${Colores.YELLOW.color}Esa butaca no estaba reservada, por lo que no puedes formalizarla")
                    }
                }
            }
        }while(butaca != "stop")
        println("${Colores.GREEN.color}Has formalizado un total de $contadorEntradas butacas")
        println()
    }

    /**
     * función que sirve para formalizar de reservado a comprado 1 o varias butacas
     */
    fun anularReservaCompra(){
        println("${Colores.CYAN.color}La sala del cine es la siguiente:")
        representacionDeLaSala()
        var butaca = ""
        var contadorEntradas = 0
        do {
            println("""${Colores.CYAN.color}Introduzca las butacas cuya reserva/compra quieras anular, puedes introducir el indentificador de una butaca ( "A1", por ejemplo ) o escribir "stop" para dejar de anular reservas/compras: """)
            butaca = introducirButaca()
            if(butaca != "stop"){
                val posicionButaca = buscarButacaPorIndentificador(butaca)
                if(posicionButaca != Pair(-1, -1)) {
                    if(butacas[posicionButaca.first][posicionButaca.second]!!.estado == "reservado" || butacas[posicionButaca.first][posicionButaca.second]!!.estado == "comprado"){
                        println("${Colores.RED.color}De acuerdo, has cancelado la reserva/compra de la butaca ${anular(posicionButaca)!!.identificador}")
                        contadorEntradas++
                        if(butacas[posicionButaca.first][posicionButaca.second]!!.tipoButaca == TipoButaca.VIP){
                            println("${Colores.RED.color}Ademas, cabe destacar que la butaca: ${butacas[posicionButaca.first][posicionButaca.second]!!.identificador}, es VIP")
                        }
                    }
                }else{
                    if(butacas[posicionButaca.first][posicionButaca.second]!!.estado == "reservado" || butacas[posicionButaca.first][posicionButaca.second]!!.estado == "comprado") {
                        println("${Colores.YELLOW.color}No existe ninguna butaca con esa identificación")
                    }else{
                        println("${Colores.YELLOW.color}Esa butaca está libre, por lo que no puedes cancelar ninguna reserva/compra")
                    }
                }
            }
        }while(butaca != "stop")
        println("${Colores.RED.color}Has cancelado la reserva/compra de un total de $contadorEntradas butacas")
        println()
    }

    /**
     * función que sirve para poner el estado de una butaca en "reservado"
     * @return la butaca cuyo estado fue cambiado
     */
    fun anular(posicionButaca: Pair<Int, Int>): butaca? {
        butacas[posicionButaca.first][posicionButaca.second]!!.estado = "libre"
        return butacas[posicionButaca.first][posicionButaca.second]
    }

    /**
     * función que proporciona un informe de la sala del cine
     */
    fun informeDeLaSalaDeCine(){
        println("${Colores.ROSE.color}Estás en el cine $nombre, en donde se va ha representar la película: $pelicula")
        representarButacas()
        val tiposDeButacas = contarNumeroDeButacasPorTipo()
        println("${Colores.ROSE.color}Hay un total de ${Colores.CYAN.color}${tiposDeButacas.first} ${Colores.ROSE.color}butacas libres")
        println("${Colores.ROSE.color}Hay un total de ${Colores.CYAN.color}${tiposDeButacas.second} ${Colores.ROSE.color}butacas reservadas")
        println("${Colores.ROSE.color}Hay un total de ${Colores.CYAN.color}${tiposDeButacas.third} ${Colores.ROSE.color}butacas compradas")
        println()
    }

    /**
     * función que sirve para calcular el dinero total que hay en caja para la pelicula
     */
    fun dineroTotalEnCaja(){
        println("${Colores.ROSE.color}El dinero total en caja en la actualidad es de: ${Colores.CYAN.color}${calcularDineroEnCaja()}€")
        println()
    }

    /**
     * función que sirve para calcular el dinero en caja actual de la sala de cine
     * @return el dinero en caja actual en la sala de cine
     */
    fun calcularDineroEnCaja(): Double {
        var resultado = 0.0
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null){
                    if(butacas[i][j]!!.estado == "comprado"){
                        resultado += butacas[i][j]!!.tipoButaca.valor
                    }
                }
            }
        }
        return resultado
    }

    /**
     * función que sirve para calcula el número de butacas libres, reservadas y compradas que hay
     * @return un triple con el número de butacas libres, reservadas y compradas
     */
    fun contarNumeroDeButacasPorTipo(): Triple<Int, Int, Int> {
        var libres = 0
        var reservadas = 0
        var compradas = 0
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null){
                    when(butacas[i][j]!!.estado){
                        "libre" -> libres++
                        "reservado" -> reservadas++
                        "comprado" -> compradas++
                    }
                }
            }
        }
        return Triple(libres, reservadas, compradas)
    }

    /**
     * función que sirve para representar las butacas de la sala de cine como libre, reservadas o compradas
     */
    fun representarButacas() {
        var mensaje = ""
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null){
                    when(butacas[i][j]!!.estado){
                        "libre" -> mensaje = "$mensaje ${Colores.GREEN.color}l"
                        "reservado" -> mensaje = "$mensaje ${Colores.YELLOW.color}r"
                        "comprado" -> mensaje = "$mensaje ${Colores.RED.color}c"
                    }
                }
            }
            println(mensaje)
            mensaje = ""
        }
    }

    /**
     * función que sirve para hallar la posición de una butaca según su identificador
     * @param identificador el dato de la butaca usado para buscar la posición de la butaca
     * @return un par con la fila y columna de la butaca
     */
    fun buscarButacaPorIndentificador(identificador: String): Pair<Int, Int> {
        var posicion = Pair(-1, -1)
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null) {
                    if (butacas[i][j]!!.identificador == identificador){
                        posicion = Pair(i, j)
                        break
                    }
                }
            }
            if(posicion != Pair(-1, -1)){
                break
            }
        }
        return posicion
    }

    /**
     * función que sirve para comprobar si la butaca seleccionada está libre o no
     * @param butaca lo que queremos validar
     * @return true si está libre, false si está ocupada
     */
    fun butacaLibre(butaca: String): Boolean {
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null){
                    if(butacas[i][j]!!.identificador == butaca){
                        if(butacas[i][j]!!.estado != "libre"){
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    /**
     * función que sirve para representar las butacas de la sala de cine con su identificador
     */
    fun representacionDeLaSala() {
        var mensaje = ""
        for(i in 0..butacas.size-1){
            for(j in 0..butacas[i].size-1){
                if(butacas[i][j] != null){
                    if(butacas[i][j]!!.tipoButaca == TipoButaca.NORMAL) {
                        when (butacas[i][j]!!.estado) {
                            "libre" -> mensaje = "$mensaje ${Colores.GREEN.color}${butacas[i][j]!!.identificador}"
                            "reservado" -> mensaje = "$mensaje ${Colores.YELLOW.color}${butacas[i][j]!!.identificador}"
                            "comprado" -> mensaje = "$mensaje ${Colores.RED.color}${butacas[i][j]!!.identificador}"
                        }
                    }else{
                        if(butacas[i][j]!!.identificador.length == 2) {
                            when (butacas[i][j]!!.estado) {
                                "libre" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.GREEN.color}${butacas[i][j]!!.identificador[1]}"

                                "reservado" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.YELLOW.color}${butacas[i][j]!!.identificador[1]}"

                                "comprado" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.RED.color}${butacas[i][j]!!.identificador[1]}"
                            }
                        }else{
                            when (butacas[i][j]!!.estado) {
                                "libre" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.GREEN.color}${butacas[i][j]!!.identificador.substring(1,3)}"

                                "reservado" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.YELLOW.color}${butacas[i][j]!!.identificador.substring(1,3)}"

                                "comprado" -> mensaje =
                                    "$mensaje ${Colores.ROSE.color}${butacas[i][j]!!.identificador[0]}${Colores.RED.color}${butacas[i][j]!!.identificador.substring(1,3)}"
                            }
                        }
                    }
                }
            }
            println(mensaje)
            mensaje = ""
        }
    }

    /**
     * función que sirve para introducir butacas con una identificación adecuada a su localización,
     * con el estado base "libre" y siendo "NORMAL" hasta que se dicte lo contrario
     */
    private fun inicializarMatrizButacas() {
        for (i in 0..fila - 1) {
            for (j in 0..columna - 1) {
                butacas[i][j] = ButacaFactory.getInstance()!!.crearButaca(hallarIdentificadorButaca(i, j), "libre", TipoButaca.NORMAL)
            }
        }
    }

    /**
     * función que sirve para generar el número introducido de butacas vip aleatoriamente por la sala
     */
    private fun hacerButacasVip() {
        var fila = 0
        var columna = 0
        for(i in 1..butacasVip){
            do{
                fila = (0..this.fila-1).random()
                columna = (0..this.columna-1).random()
            }while(butacas[fila][columna]!!.tipoButaca == TipoButaca.VIP)
            butacas[fila][columna]!!.tipoButaca = TipoButaca.VIP
        }
    }
}