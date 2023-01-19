
import models.Butaca;
import models.Sala;

public class Cine_Main {
    static boolean exit = false;
    public static void main(String[] args) {

        //pedimos los valores del tamaño de la matriz de asientos y el nombre de la sala con diferentes funciones simples.
        int row = Sala.requestRowSize();
        int column = Sala.requestColumnSize();
        String roomName = Sala.requestRoomName();

        //coloco los asientos con los valores que se han pedido por consola antes.
        Butaca[][] seatsMatrix = new Butaca[row][column];

        Sala.placeSeats(seatsMatrix);

        do {
            switch(Sala.selectOption()){
                //Función que reserva sitios
                case 1 -> Sala.processReservation(Sala.reverseSeat(seatsMatrix, column, row) ,seatsMatrix);
                //Función que formaliza la reserva
                case 2 -> Sala.processFormalization(Sala.formalizeReservation(seatsMatrix, column, row), seatsMatrix);
                //Función que cancela la reserva de un sitio que se elija.
                case 3 -> Sala.processCancellation(Sala.cancelReservation(seatsMatrix, column, row), seatsMatrix);
                //Función con la que se compran los asientos.
                case 4 -> Sala.processPucharse(Sala.buySeat(seatsMatrix, row, column), seatsMatrix);
                case 5 -> Sala.generateReport(roomName);
                case 6 -> exit = true;
            }
        }while(!exit);

    }

}
