import models.Butaca

import enums.EstadoButaca


fun menu(){


    println("\n¿Que desea hacer?")
    println("1. Mostrar Sala")
    println("2. Comprar entrada")
    println("3. Reservar entrada")
    println("4. Formalizar reserva")
    println("5. Anular reserva/compra")
    println("6. Informe butacas")
    println("0. Salir")

}

fun readInt(text: String, errorText:String,numMin:Int,numMax:Int): Int{


    print(text)
    var number = readln().toIntOrNull()?:-1

    while(number<numMin || number>numMax) {
        System.err.println(errorText)
        number = readln().toIntOrNull() ?: -1
    }
    return number
}

fun iniciarSala(distribucionSala: Array<Array<Butaca?>>){



    for (i in distribucionSala.indices){

        var letraColumnas = 'A'

        for (j in distribucionSala[0].indices){

            distribucionSala[i][j]= Butaca(numeroSitio = "${i+1}$letraColumnas", estadoButaca = EstadoButaca.LIBRE)
            letraColumnas++

        }

    }
}

fun elegirButaca():String {

    println("Elija la butaca de su conveniencia para realizar su operacion")
    print("Seleccione su opcion: ")

    val regex = Regex("[1-6][A-I]")
    var butacaElegida = readln().uppercase()
    while (!regex.matches(butacaElegida)){
        System.err.print("No se ha encontrado la butaca, inserte otra: ")
         butacaElegida = readln().uppercase()
    }

    return butacaElegida
}



