


import models.Butaca
import models.Sala

var exit = false

fun main() {

    //pedimos los valores del tamaño de la matriz de asientos y el nombre de la sala con diferentes funciones simples.
    val row = Sala(nombre = "").requestRowSize()
    val column = Sala(nombre = "").requestColumnSize()
    val roomName = Sala(nombre = "").requestRoomName()

    //coloco los asientos con los valores que se han pedido por consola antes.
    val seatsMatrix = Array(row) { Array<Butaca?>(column) { null } }
    Sala(nombre = "").placeSeats(seatsMatrix)

    do {
        when(Sala(nombre = "").selectOption()){
            //Función que reserva sitios
            1 -> Sala(nombre = "").processReservation(Sala(nombre = "").reverseSeat(seatsMatrix, column, row) ,seatsMatrix)
            //Función que formaliza la reserva
            2 -> Sala(nombre = "").processFormalization(Sala(nombre = "").formalizeReservation(seatsMatrix, column, row), seatsMatrix)
            //Función que cancela la reserva de un sitio que se elija.
            3 -> Sala(nombre = "").processCancellation(Sala(nombre = "").cancelReservation(seatsMatrix, column, row), seatsMatrix)
            //Función con la que se compran los asientos.
            4 -> Sala(nombre = "").processPucharse(Sala(nombre = "").buySeat(seatsMatrix, row, column), seatsMatrix)
            5 -> Sala(nombre = "").generateReport(roomName)
            6 -> exit = true
        }
    }while(!exit)

}



