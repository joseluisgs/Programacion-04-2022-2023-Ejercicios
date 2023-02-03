package models


import enums.EstadoButaca

data class Sala(
    val nombreSala: String="La Paz del Pez"
){
    val distribucionSala = Array(6){Array<Butaca?>(9){null}}

    fun saludar(){
        println("Bienvenid@ a $nombreSala")
    }
    fun despedirse(){
        println("Esperamos que haya disfrutado y vuelva pronto.")
    }

    fun  mostrarSala(){

        val red = "\u001b[31m"
        val yellow = "\u001B[33m"
        val green = "\u001B[32m"
        val blue = "\u001B[34m"
        val reset = "\u001b[0m"
        var letraColumnas = 'A'


        println("$blue           [ P A N T A L L A ]\n")
        for (i in distribucionSala.indices){
            print("${i+1}  ")
            for (j in distribucionSala[0].indices){

                if (distribucionSala[i][j]?.estadoButaca== EstadoButaca.LIBRE){
                    print("$green[L] $reset")
                }
                if (distribucionSala[i][j]?.estadoButaca== EstadoButaca.OCUPADA){
                    print("$red[O] $reset")
                }else if(distribucionSala[i][j]?.estadoButaca== EstadoButaca.RESERVADA){
                    print("$yellow[R] $reset")
                }
            }
            println()
        }
        print("   ")
        for (i in distribucionSala[0].indices){

            print(" $letraColumnas  ")
            letraColumnas++
        }
    }

    private fun getBySitio(sitio:String):Butaca?{

        for (i in distribucionSala.indices){
            for (j in distribucionSala[0].indices){
                if (distribucionSala[i][j]!=null && distribucionSala[i][j]?.numeroSitio==sitio){
                    return distribucionSala[i][j]
                }
            }
        }
        return null
    }

    fun comprarEntrada(butacaElegida: String){

       val butacaSala = getBySitio(butacaElegida)
        if (butacaSala?.estadoButaca==EstadoButaca.OCUPADA|| butacaSala?.estadoButaca==EstadoButaca.RESERVADA) {
            System.err.println("Butaca no disponible. Revise la disponibilidad de butacas de la sala.")
        }else{
            butacaSala?.estadoButaca = EstadoButaca.OCUPADA
            println("Has comprado tu entrada correctamente.")
        }
    }

    fun reservarEntrada(butacaElegida: String){

        val butacaSala = getBySitio(butacaElegida)

        if (butacaSala?.estadoButaca==EstadoButaca.OCUPADA|| butacaSala?.estadoButaca==EstadoButaca.RESERVADA) {
            System.err.println("Butaca no disponible. Revise la disponibilidad de butacas de la sala.")
        }else{
            butacaSala?.estadoButaca = EstadoButaca.RESERVADA
            println("Se le ha reservado la butaca, por favor formalice la reserva para comprar la entrada.")
        }
    }

    fun formalizarReserva(butacaElegida: String){

        val butacaSala = getBySitio(butacaElegida)

        if (butacaSala?.estadoButaca==EstadoButaca.OCUPADA || butacaSala?.estadoButaca==EstadoButaca.LIBRE){
            System.err.println("La butaca no esta reservada.")
        }else{
            butacaSala?.estadoButaca = EstadoButaca.OCUPADA
            println("Se ha confirmado la reserva.")
        }

    }

    fun anularComRes(butacaElegida: String){

        val butacaSala = getBySitio(butacaElegida)

        if (butacaSala?.estadoButaca==EstadoButaca.LIBRE){
            System.err.println("La butaca no esta reservada.")
        }else{
            butacaSala?.estadoButaca = EstadoButaca.LIBRE
            println("Se ha anulado la reserva/compra de su butaca.")
        }
    }

    fun informeButacas():String{
        var butacasLibres = 0
        var butacasReservadas = 0
        var butacasOcupadas = 0
        val blue = "\u001B[34m"
        val reset = "\u001b[0m"

        for (i in distribucionSala.indices){
            for (j in distribucionSala[0].indices){
                when (distribucionSala[i][j]?.estadoButaca) {
                    EstadoButaca.LIBRE -> {
                        butacasLibres++
                    }
                    EstadoButaca.RESERVADA -> {
                        butacasReservadas++
                    }
                    else -> butacasOcupadas++
                }
            }
        }
        return "$blue$butacasLibres Butacas libres. \n $butacasReservadas Butacas reservadas. \n $butacasOcupadas Butacas ocupadas.$reset "
    }
}