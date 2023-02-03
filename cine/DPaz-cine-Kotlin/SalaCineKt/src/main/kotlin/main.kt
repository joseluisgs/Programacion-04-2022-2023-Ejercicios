import models.Sala

fun main(){

    val sala =Sala()



    iniciarSala(sala.distribucionSala)
    sala.saludar()
    Thread.sleep(1500)

    do{

        menu()
        val reply = readInt("\nSeleccione opcion: ","Opcion no valida,inserte otra: ",0,6)

        when(reply){
            1 -> sala.mostrarSala()
            2 -> sala.comprarEntrada(elegirButaca())
            3 -> sala.reservarEntrada(elegirButaca())
            4 -> sala.formalizarReserva(elegirButaca())
            5 -> sala.anularComRes(elegirButaca())
            6 -> println(sala.informeButacas())
            0 -> sala.despedirse()
        }
    }while(reply!=0)

}