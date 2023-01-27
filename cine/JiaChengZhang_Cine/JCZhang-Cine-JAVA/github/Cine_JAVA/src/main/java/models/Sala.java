package models;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static models.Butaca.*;

public class Sala {

    static Double totalCash = 0.0;
    static int soldSeatsCount = 0;
    static int reservedSeatsCount = 0;
    static double normalSeatPrice = 5.25;
    static Scanner sc = new Scanner(System.in);
    /**
     * @author JiaCheng Zhang
     * @param roomName Es el nombre de la sala de cine, se pide por consola al usuario al iniciar el programa
     * Es una función que imprime por pantalla un informe de la situación actual de cine
     */
    public static void generateReport(String roomName) {
        System.out.println("ESTE ES EL INFORME DEL CINE");
        System.out.println(" - La película reproducida es" + new Pelicula());
        System.out.println(" - Está siendo reproducida en la sala " + roomName);
        System.out.println(" - El dinero total recolectado es de " + totalCash + " €");
        System.out.println(" - En este momento hay un total de " + reservedSeatsCount + " asientos reservados y un total de " + soldSeatsCount + " asientos vendidos");
    }
    /**
     * @author JiaCheng Zhang
     * @return El return por defecto de esta función es que devuelva 0, pero nunca se llega hasta ese punto, ya que hay early returns dentro de un bucle y no se puede salir de ese bucle.
     * Es una Función que filtra las entradas por teclado e imprime un menú.
     */
    public static int selectOption() {

        System.out.println("***¡¡BIENVENIDO AL CINE!!***");
        System.out.println("Seleccione la opción que necesite");
        System.out.println();
        System.out.println("1 -> RESERVAR ASIENTO (PALOMITAS DE REGALO)");
        System.out.println("2 -> FORMALIZAR RESERVA (RESERVA REQUERIDA)");
        System.out.println("3 -> CANCELAR RESERVA (RESERVA REQUERIDA)");
        System.out.println("4 -> COMPRAR ASIENTO");
        System.out.println("5 -> GENERAR INFORME DEL CINE");
        System.out.println("6 -> SALIR");
        String option;
        do {
            System.out.println("Opción seleccionada: ");
            option = sc.nextLine();
            if (parseInt(option) > 6 || parseInt(option) < 1) {
                System.out.println("Opción no valida");
            } else {
                return parseInt(option);
            }
        } while (parseInt(option) > 6 || parseInt(option) < 1);
        return 0;
    }

    /**
     * @param soldSeat Es el asiento que ha elegido el usuario para comprarlo y que ya ha sido filtrada anteriormente para que no contengan errores
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la compra
     */
    public static void processPucharse(String soldSeat, Butaca[][] seatsMatrix) {
        String[] pucharsedSeat = soldSeat.split(":");
        String rowLetter = pucharsedSeat[0];
        int processedRow = rowLetterToNumber(rowLetter);
        String selectedColumn = pucharsedSeat[1];
        changeSeatStatusToOccupied(seatsMatrix, selectedColumn, processedRow);
        printSeats(seatsMatrix);
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca por consola el asiento que quiere comprar.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return devuelve el asiento deseado.
     */
    public static String buySeat(Butaca[][] seatsMatrix, int row, int column) {
        System.out.println();
        var soldSeat = "";
        Pattern regex = Pattern.compile("[A-Z]:[0-9]+", Pattern.CASE_INSENSITIVE);

        System.out.println("Hola! Bienvenido al cine! Estos son los asientos disponibles (Los que aparecen con una 💺) ");
        printSeats(seatsMatrix);
        do {
            System.out.println("Introduce el asiento que quieres comprar: ");

            do {
                soldSeat = sc.nextLine();
                if (!Pattern.matches(String.valueOf(regex), soldSeat.toUpperCase())) {
                    System.out.println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ");
                }
                if (Pattern.matches(String.valueOf(regex), soldSeat.toUpperCase())) {
                    if (!doesColumnExist(soldSeat, column)) {
                        System.out.println("La columna que has elegido no existe, elige otro asiento.");
                    }
                }
                if (Pattern.matches(String.valueOf(regex), soldSeat.toUpperCase())) {
                    if (!doesRowExist(soldSeat, row)) {
                        System.out.println("La fila que has elegido no existe, elige otro asiento.");
                    }
                }

            } while (!Pattern.matches(String.valueOf(regex), soldSeat.toUpperCase()) || !doesColumnExist(soldSeat, column));


            if (isSeatReserved(soldSeat, seatsMatrix)) {
                System.out.println("El asiento que has elegido, ha sido reservado anteriormente, elige otro: ");
            }

        } while (isSeatReserved(soldSeat, seatsMatrix));
        System.out.println("El asiento ha sido comprado correctamente");
        System.out.println("Se te ha hecho el cobre de 5.25€ automáticamente.");
        totalCash += normalSeatPrice;
        soldSeatsCount++;
        return soldSeat;
    }

    /**
     * @param formalizedReservation Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la formalización de la reserva del asiento
     */
    public static void processFormalization(@NotNull String formalizedReservation, Butaca[][] seatsMatrix) {
        String[] processedFormalization = formalizedReservation.split(":");
        String selectedRow = processedFormalization[0];
        String selectedColumn = processedFormalization[1];
        int processedRow = rowLetterToNumber(selectedRow);
        changeSeatStatusToOccupied(seatsMatrix, selectedColumn, processedRow);
        printSeats(seatsMatrix);
    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "OCUPADO"
     */
    public static Butaca changeSeatStatusToOccupied(@NotNull Butaca[][] seatsMatrix, @NotNull String selectedColumn, int processedRow) {
        seatsMatrix[processedRow][parseInt(selectedColumn) - 1] = Butaca.SOLD_SEAT;
        return SOLD_SEAT;
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca el asiento qye ha reservado anteriormente para poder formalizar la reserva.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos
     * @return Devuelve el asiento deseado
     */
    public static String formalizeReservation(Butaca[][] seatsMatrix, int column, int row) {
        System.out.println();
        var toBeFormalizedReservation = "";
        printSeats(seatsMatrix);
        Pattern regex = Pattern.compile("[A-Z]:[0-9]+");

        System.out.println("Introduce el asiento que has reservado, para que podamos formalizar la reserva por usted y finalizar la compra de esta: ");
        do {

            do {
                toBeFormalizedReservation = sc.nextLine();
                if (!Pattern.matches(String.valueOf(regex), toBeFormalizedReservation.toUpperCase())) {
                    System.out.println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ");
                }
                if (Pattern.matches(String.valueOf(regex), toBeFormalizedReservation.toUpperCase())) {
                    if (!doesColumnExist(toBeFormalizedReservation, column)) {
                        System.out.println("La columna que has elegido no existe, elige otro asiento.");
                    }
                }
                if (Pattern.matches(String.valueOf(regex), toBeFormalizedReservation.toUpperCase())) {
                    if (!doesRowExist(toBeFormalizedReservation, row)) {
                        System.out.println("La fila que has elegido no existe, elige otro asiento.");
                    }
                }

            } while (!Pattern.matches(String.valueOf(regex), toBeFormalizedReservation.toUpperCase()) || !doesColumnExist(toBeFormalizedReservation, column));

            // Desde aquí hacia arriba, nos aseguramos de que el asiento que el usuario ha elegido está escrito de la manera que queremos y que está dentro de los límites de la matriz de asientos.
            if (!isSeatReserved(toBeFormalizedReservation, seatsMatrix)) {
                System.out.println("El asiento que has elegido, no ha sido reservado anteriormente, elige otro: ");
            }

        } while (!isSeatReserved(toBeFormalizedReservation, seatsMatrix));
        System.out.println("Has formalizado la reserva correctamente! Ya se te ha hecho el cobro de los 4€ restantes. Muchas gracias! ");
        totalCash += 4;
        reservedSeatsCount--;
        soldSeatsCount++;
        return toBeFormalizedReservation;

    }

    /**
     * @param toBeCancelledSeat Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la formalización de la reserva del asiento
     */
    public static void processCancellation(String toBeCancelledSeat, Butaca[][] seatsMatrix) {
        String[] processedCancellation = toBeCancelledSeat.split(":");
        String selectedRow = processedCancellation[0];
        String selectedColumn = processedCancellation[1];
        int processedRow = rowLetterToNumber(selectedRow);


        changeSeatStatusToFree(seatsMatrix, selectedColumn, processedRow);
        printSeats(seatsMatrix);
    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "LIBRE"
     */
    public static Butaca changeSeatStatusToFree(Butaca[][] seatsMatrix, String selectedColumn, int processedRow) {
        seatsMatrix[processedRow][parseInt(selectedColumn) - 1] = FREE_SEAT;
        return FREE_SEAT;
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca el asiento qye ha reservado anteriormente para poder cancelar la reserva.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return Devuelve el asiento elegido
     */
    public static String cancelReservation(Butaca[][] seatsMatrix, int column, int row) {
        System.out.println();
        var toBeCancelledSeat = "";
        Pattern regex = Pattern.compile("[A-Z]:[0-9]+", Pattern.CASE_INSENSITIVE);

        System.out.println("Introduce el asiento que has reservado, para que podamos cancelar la reserva por usted: ");
        do {

            do {
                toBeCancelledSeat = sc.nextLine();
                if (!Pattern.matches(String.valueOf(regex), toBeCancelledSeat.toUpperCase())) {
                    System.out.println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ");
                }
                if (Pattern.matches(String.valueOf(regex), toBeCancelledSeat.toUpperCase())) {
                    if (!doesColumnExist(toBeCancelledSeat, column)) {
                        System.out.println("La columna que has elegido no existe, elige otro asiento.");
                    }
                }
                if (Pattern.matches(String.valueOf(regex), toBeCancelledSeat.toUpperCase())) {
                    if (!doesRowExist(toBeCancelledSeat, row)) {
                        System.out.println("La fila que has elegido no existe, elige otro asiento.");
                    }
                }

            } while (!Pattern.matches(String.valueOf(regex), toBeCancelledSeat.toUpperCase()) || !doesColumnExist(toBeCancelledSeat, column));

            // Desde aquí hacia arriba, nos aseguramos de que el asiento que el usuario ha elegido está escrito de la manera que queremos y que está dentro de los límites de la matriz de asientos.
            if (!isSeatReserved(toBeCancelledSeat, seatsMatrix)) {
                System.out.println("El asiento que has elegido, no ha sido reservado anteriormente, elige otro: ");
            }

        } while (!isSeatReserved(toBeCancelledSeat, seatsMatrix));
        System.out.println("Has cancelado la reserva correctamente");
        totalCash -= 1.25;
        System.out.println("Se te ha devuelto 1.25€");
        reservedSeatsCount--;
        return toBeCancelledSeat;
    }

    /**
     * @author JiaCheng Zhang
     * @param toBeCancelledSeat Es el asiento que ha introducido el usuario por teclado
     * @param seatsMatrix Es la matriz de asientos.
     * La función comprueba el asiento ha sido reservado realmente
     * @return Devuelve true si el asiento está reservado y false si no lo está
     */
    public static boolean isSeatReserved(String toBeCancelledSeat, Butaca[][] seatsMatrix) {
        String[] aux = toBeCancelledSeat.split(":");
        String auxRow = aux[0];
        int processedRow = rowLetterToNumber(auxRow);
        String auxColumn = aux[1];
        return seatsMatrix[processedRow][parseInt(auxColumn) - 1] == Butaca.RESERVED_SEAT;

    }

    /**
     * @param reservation Es el asiento que El usuario ya ha reservado con anterioridad
     * @param seatsMatrix Es la matriz de asientos
     * @author JiaCheng Zhang
     * Es una función intermediaria que llama a otras funciones para procesar la reserva del asiento
     */
    public static void processReservation(String reservation, Butaca[][] seatsMatrix) {
        String[] processedReservation = reservation.split(":");
        String selectedRow = processedReservation[0];
        String selectedColumn = processedReservation[1];
        int processedRow = rowLetterToNumber(selectedRow);
        changeSeatStatusToReserved(seatsMatrix, selectedColumn, processedRow);
        printSeats(seatsMatrix);

    }

    /**
     * @author JiaCheng Zhang
     * @param  seatsMatrix Es la matriz de asientos
     * @param selectedColumn Es la columna que seleccionado el usuario
     * @param processedRow Es la fila que seleccionado el usuario
     * La función cambia el estado del asiento que se encuentra en la fila y la columna que se realiza el usuario por "RESERVADO"
     * @return Devuelve un asiento reservado
     */
    public static Butaca changeSeatStatusToReserved(Butaca[][] seatsMatrix, String selectedColumn, int processedRow) {

        seatsMatrix[processedRow][parseInt(selectedColumn) - 1] = Butaca.RESERVED_SEAT;
        return RESERVED_SEAT;
    }

    /**
     * @author JiaCheng Zhang
     * @param selectedRow Es la fila que ha elegido el usuario (se ha exigido que sea una letra)
     * La función cambia las letras de las filas por los números correspondientes a la matriz
     * @return Devuelve los números correspondientes a sus letras
     */
    public static int rowLetterToNumber(String selectedRow) {
        return switch (selectedRow.toUpperCase()) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            case "I" -> 8;
            case "J" -> 9;
            case "K" -> 10;
            case "L" -> 11;
            case "M" -> 12;
            case "N" -> 13;
            case "O" -> 14;
            case "P" -> 15;
            case "Q" -> 16;
            case "R" -> 17;
            case "S" -> 18;
            case "T" -> 19;
            case "U" -> 20;
            case "V" -> 21;
            case "W" -> 22;
            case "X" -> 23;
            case "Y" -> 24;
            case "Z" -> 25;
            default -> -1;
        };
    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * @param row Es el número de filas que tiene la matriz de asientos.
     * @param column Es el número de columnas que tiene la matriz de asientos.
     * Esta función pide al usuario que introduzca un asiento para que pueda ser reservado.
     * Hay un bucle del que no se puede salir hasta que el acento que introduzca el usuario por teclado cumpla los requisitos establecidos.
     * @return Devuelve el asiento deseado
     */
    public static String reverseSeat(Butaca[][] seatsMatrix, int column, int row) {
        System.out.println();
        String reservedSeat;
        Pattern regex = Pattern.compile("[A-Z]:[0-9]+", Pattern.CASE_INSENSITIVE);

        printSeats(seatsMatrix);
        System.out.println("Hola! ¿Que asiento quieres reservar? Estas son las butacas disponibles.");
        System.out.println("Las filas se ordenan con las letras del abecedario y las columnas con números, un ejemplo de asiento seria B:4");
        System.out.println("que representaría el asiento de la segunda fila y la cuarta columna");
        System.out.println("Introduce el asiento: ");

        do {
            reservedSeat = sc.nextLine();
            if (!Pattern.matches(String.valueOf(regex), reservedSeat.toUpperCase())) {
                System.out.println("Debes el introducir la LETRA de la fila y el NÚMERO de la columna. Ejemplo: A:1 ");
            }
            if (Pattern.matches(String.valueOf(regex), reservedSeat.toUpperCase())) {
                if (!doesColumnExist(reservedSeat, column)) {
                    System.out.println("La columna que has elegido no existe, elige otro asiento.");
                }
            }
            if (Pattern.matches(String.valueOf(regex), reservedSeat.toUpperCase())) {
                if (!doesRowExist(reservedSeat, row)) {
                    System.out.println("La fila que has elegido no existe, elige otro asiento.");
                }
            }

        } while (!Pattern.matches(String.valueOf(regex), reservedSeat.toUpperCase()) || !doesColumnExist(reservedSeat, column));
        totalCash += 1.25;
        reservedSeatsCount++;
        System.out.println("El precio de la reserva es de 1.25€, cuando formalice la reserva se le cobrarán 4 euros para completar el precio de la entrada que es de 5.25");
        System.out.println("Se te ha cobrado $totalCash");
        return reservedSeat;
    }


    /**
     * @param reservedSeat Esa la siento que he introducido el usuario por teclado en la función anterior
     * @param row Es la fila que entre reducido el usuario por teclado
     * La función comprueba que la fila que ha introducido el usuario por teclado está dentro de los límites de la matriz, cuyas dimensiones han sido establecidas al principio del programa
     * @return Devuelve true si la fila está dentro de la matriz y false si la fila está afuera
     */
    public static boolean doesRowExist(String reservedSeat, int row) {
        String[] filteredRow = reservedSeat.split(":");
        int rowNumber = rowLetterToNumber(filteredRow[0]);
        return rowNumber <= row;
    }

    /**
     * @param reservedSeat Esa la siento que he introducido el usuario por teclado en la función anterior
     * @param column Es la columna que entre reducido el usuario por teclado
     * La función comprueba que la columna que ha introducido el usuario por teclado está dentro de los límites de la matriz, cuyas dimensiones han sido establecidas al principio del programa
     * @return Devuelve true si la columna existe, false si no
     */
    public static boolean doesColumnExist(String reservedSeat, int column) {
        String[] filteredColumn = reservedSeat.split(":");
        return parseInt(filteredColumn[1]) <= column;

    }

    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * La función llena la matriz de butacas libres
     */
    public static void placeSeats(Butaca[][] seatsMatrix) {
        for (int i = 0; seatsMatrix.length - 1 >= i; i++) {
            for (int j = 0; seatsMatrix[i].length - 1 >= j; j++) {
                seatsMatrix[i][j] = FREE_SEAT;
            }
        }
    }


    /**
     * @author JiaCheng Zhang
     * @param seatsMatrix Es la matriz de asientos
     * La función imprime por pantalla la matriz de asientos
     */
    public static void printSeats(Butaca[][] seatsMatrix) {
        for (int i = 0; seatsMatrix.length - 1 >= i; i++) {
            System.out.println(Arrays.toString(seatsMatrix[i]));
        }

    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca por teclado el nombre de la sala
     * @return devuelve el nombre
     */
    public static String requestRoomName() {
        System.out.println("Introduce el nombre de la sala de cine:");
        var roomName = "";
        roomName = sc.nextLine();
        return roomName;
    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca la columna deseada
     * @return devuelve la columna, siempre que cumpla los requisitos
     */
    public static int requestColumnSize() {
        Pattern regexColumn = Pattern.compile("[0-9]+");
        int minColumnSize = 1;
        String column;

        do {
            System.out.println("¿Cuántas columnas de butacas quieres?");
            column = sc.nextLine();
            if (!Pattern.matches(String.valueOf(regexColumn), column) || parseInt(column) < minColumnSize) {
                System.out.println("¡EL VALOR INTRODUCIDO DEBE SER UN NUMERO ENTERO");
            }
        } while (!Pattern.matches(String.valueOf(regexColumn), column) || parseInt(column) < minColumnSize);
        return parseInt(column);
    }

    /**
     * @author JiaCheng Zhang
     * Pide al usuario que introduzca la fila deseada
     * @return devuelve la fila, siempre que cumpla los requisitos
     */
    public static int requestRowSize() {
        Pattern regexRow = Pattern.compile("[0-9]+");
        /*
        Vamos a nombrar las butacas con letras en la fila, por lo que el máximo valor permitido en la fila es de 26
        por ejemplo, el asiento A:1 sería la posición 1:1 en la matriz de las butacas.
         */
        int maxRowSize = 26;
        int minRowSize = 1;
        String fila;
        do {
            System.out.println("¿Cuántas filas de butacas quieres?");
            fila = sc.nextLine();
            if (!Pattern.matches(String.valueOf(regexRow), fila) || parseInt(fila) > maxRowSize || parseInt(fila) < minRowSize) {
                System.out.println("¡EL VALOR INTRODUCIDO DEBER SER UN NUMERO ENTERO ENTRE 1 Y 26!");
            }
        } while (!Pattern.matches(String.valueOf(regexRow), fila) || parseInt(fila) > maxRowSize || parseInt(fila) < minRowSize);
        return parseInt(fila);

    }

}