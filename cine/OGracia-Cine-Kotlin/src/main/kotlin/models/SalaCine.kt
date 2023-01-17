package models


data class SalaCine(val numeroSala:Int,val numeroFilas:Int,val numeroColumna:Int){
    val capacidadTotal:Int = numeroFilas * numeroColumna
    val asientosVip:Int = (capacidadTotal*20)/100 //maximo 45 %
    var peliculaProyectada:String = " "
    var salaCine = Array(numeroFilas){Array(numeroColumna){ButacaCine("A ",1,false)} }

    init {
        val letrasFilas =  arrayOf("A ","B ","C ","D ","E ","F ","G ","H ","I ","J ","K ","L ","M ","N ","O ")
        var contadorFila = -1
        var contadorColumna = 0
        var vipAsignadas = 0
        val inicioFilaVip = (numeroFilas/2)-2 //Esto es para calcular aprox la mejor zona para asignar vip
        val inicioColumnaVip = numeroColumna/3
        for(i in salaCine.indices){
            contadorFila +=1
            for(j in salaCine[i].indices){
                contadorColumna +=1
                if(contadorColumna==11)contadorColumna=1
                if(i>=inicioFilaVip && j>=inicioColumnaVip && j<=inicioColumnaVip*2 && vipAsignadas<asientosVip){
                    vipAsignadas+=1
                    val butacaNuevaVip =ButacaCine(letrasFilas[contadorFila],contadorColumna,true)
                    salaCine[i][j]= butacaNuevaVip
                }else{
                    val butacaNueva =ButacaCine(letrasFilas[contadorFila],contadorColumna,false)
                    salaCine[i][j]= butacaNueva}
            }
        }
    }

    /**
     * Función que imprime por consola el estado actual de la Sala.
     */
    fun mostrarSala() {
        println("V= Asiento Vip Libre L=Asiento Cutre Libre O=Ocupa R=Reservada ")
        println("                -|--------------------|-")
        println("                  1 2 3 4 5 6 7 8 9 10")
        for(i in salaCine.indices){
            print("| Esta Fila es ${salaCine[i][1].fila}|")
            for(j in salaCine[i].indices){
                when(salaCine[i][j].estadoButaca){
                    ButacaCine.EstadoButacas.LIBRE->if(salaCine[i][j].isVip){ print("V ")}else print("L ")
                    ButacaCine.EstadoButacas.OCUPADA-> print("O ")
                    ButacaCine.EstadoButacas.RESERVADA->print("R ")
                }
            }
            println("|")
        }
        println("")
        println("")
    }
    /**
     * Función que comprueba si alguna butaca esta libre. Devuelve Boolean True es lleno. False quedan libres
     */
    fun isLleno():Boolean{
        for(i in salaCine.indices){
            for(j in salaCine[i].indices){
                if(salaCine[i][j].estadoButaca==ButacaCine.EstadoButacas.LIBRE) return false
            }
        }
        return true
    }
    /**
     * Función que recorre la sala y devuelve un Pair de int con Ocupadas/Reservadas
     */
    fun getOcupadasReservadas():Pair<Int,Int> {
        var butacasLibres = 0
        var butacasOcupadas = 0
        var butacasReservadas= 0
        for(i in salaCine.indices){
            for(j in salaCine[i].indices){
                when(salaCine[i][j].estadoButaca){
                    ButacaCine.EstadoButacas.LIBRE-> butacasLibres+=1
                    ButacaCine.EstadoButacas.OCUPADA-> butacasOcupadas+=1
                    ButacaCine.EstadoButacas.RESERVADA-> butacasReservadas+=1
                }
            }
        }
        return Pair(butacasOcupadas,butacasReservadas)
    }
    fun getPorcentaje() {
        val butacasOcupadasReservadas = getOcupadasReservadas()
        val butacasLibres = capacidadTotal-butacasOcupadasReservadas.first-butacasOcupadasReservadas.second
        val porcentajeLibre:Double =(butacasLibres.toDouble()*100)/capacidadTotal.toDouble()
        val porcentajeOcupadas:Double =(butacasOcupadasReservadas.first.toDouble()*100)/capacidadTotal.toDouble()
        val porcentajeReservadas:Double =(butacasOcupadasReservadas.second.toDouble()*100)/capacidadTotal.toDouble()
        println("Las entras libres son $butacasLibres, el $porcentajeLibre%")
        println("Las entras Ocupadas son ${butacasOcupadasReservadas.first}, el $porcentajeOcupadas%")
        println("Las entras Reservadas son ${butacasOcupadasReservadas.second}, el $porcentajeReservadas%")
    }
}