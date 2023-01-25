import javafx.util.Pair;
import models.*;
import enums.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.Thread.sleep;

public class SalaCineEditor {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bienvenido al editor de salas de cine:");
        Sala sala = setInitialValuesSala();
        Pair<Integer, Integer> sizeSala = sala.getSize();
        mainLoop: do {
            clear();
            switch(menu()){
                case 1 -> sala.mostrarSala();
                case 2 -> mostrarResultado(sala.reservaButaca(inputPos("Introduce la posición donde quieres hacer la reserva", sizeSala)),
                        "La butaca se a reservado correctamente.", "Error: No se ha podido reservar la butaca.");
                case 3 -> mostrarResultado(sala.formalizarReserva(inputPos("Introduce la posición donde quieres formalizar la reserva", sizeSala)),
                        "Se ha formalizado la reserva correctamente.", "Error: No se ha podido formalizar la reserva.");
                case 4 -> mostrarResultado(sala.anularReserva(inputPos("Introduce la posición donde quieres anular la reserva", sizeSala)),
                        "La reserva se ha anulado correctamente.", "Error: No se ha podido anular la reserva.");
                case 5 -> System.out.println("El resumen del estado de la sala es el siguiente:\n" + sala.countEstadosText());
                case 6 -> System.out.println("El balance de la sala es de " + sala.getBalance() + "€.");
                default -> {
                    break mainLoop;
                }
            }
            sleep(2500);
        }while (true);
        sala.mostrarSala();
    }

    private static void mostrarResultado(boolean reservaButaca, String good, String bad) {
        if (reservaButaca) System.out.println(good);
        else System.out.println(bad);
    }

    private static int menu(){
        String message = """
                ¿Qué quieres hacer con la sala ahora?
                1 -> Mostrar estado de la sala
                2 -> Reservar butaca/s
                3 -> Formalizar reserva
                4 -> Anular reserva
                5 -> Número de butacas libres, reservadas y ocupadas
                6 -> Balance de la sala
                7 -> Salir""";
        return inputNumber(message, 1, 7);
    }

    private static Sala setInitialValuesSala() {
        String nameSala = inputString("Introduce el nombre de la sala:");

        String nameFilm = inputString("Introduce el nombre de la película que se va ha ver en la sala:");
        int yearFilm = inputYear("Introduce el año en el que se estreno la película:");
        String directorFilm = inputString("Introduce el nombre del director que dirigió la película:");
        FilmGenero generoFilm = inputFilmGenero("Introduce el genero de la película:");
        Film film = new Film(nameFilm, yearFilm, directorFilm, generoFilm);

        Pair<Integer, Integer> sizeSala = new Pair<>(
                inputNumber("Introduce cuantas columnas quieres que tenga la sala:", 3, 50),
                inputNumber("Introduce cuantas columnas quieres que tenga la sala:", 5, 50));

        return new Sala(nameSala, film, sizeSala, 40); // 40% -> 2 de cada 5
    }

    //region Inputs
    private static String inputString(String message) {
        System.out.println(message);
        String response;
        do {
            response = sc.nextLine();
            if (response.isEmpty())
                System.out.println("Error: Introduce algún texto.");
        }while (response.isEmpty());
        return response;
    }

    private static int inputNumber(String message, int min, int max){
        return inputNumber(message, "Error: Introduce un número entre " + min + "-" + max +".", min, max);
    }

    private static int inputNumber(String message, String errorMessage, int min, int max){
        System.out.println(message);
        int response;
        do {
            String responseString = sc.nextLine();
            if (Pattern.compile("^\\d{1,5}$").matcher(responseString).matches()){
                response = Integer.parseInt(responseString);
                if (response >= min && response <= max ){
                    break;
                }
            }
            System.out.println(errorMessage);
        }while (true);
        return response;
    }

    private static int inputYear(String message){
        return inputNumber(
                message,
                "Error: Introduce un valor numérico entero de 4 dígitos entre 1900-2022.",
                1900,
                2023);
    }

    private static FilmGenero inputFilmGenero(String message){
        System.out.println(message);
        System.out.println(Arrays.toString(FilmGenero.values()));
        String responseString;
        do {
            responseString = sc.nextLine().toUpperCase();
            if (Arrays.stream(FilmGenero.values()).map(FilmGenero::name).noneMatch(responseString::equals)) {
                System.out.println("Error: Introduce uno de estos valores, " + Arrays.toString(FilmGenero.values()) + ":");
            }else break;
        } while (true);
        return FilmGenero.valueOf(responseString);
    }

    //region Input Pos
    private static Pair<Integer,Integer> inputPos(String message, Pair<Integer,Integer> size) {

        String[] responseSplit;
        do {
            String response = inputString(message);
            if (!Pattern.compile("^[A-Z]{1,2}:\\d{1,2}$").matcher(response).matches()) {
                System.out.println("Error: Introduce la posición con el siguiente formato A:1");
            } else {
                responseSplit = response.split(":");
                int strToAlphNum = stringToAlphabetNumber(responseSplit[0]);
                int splitNum = Integer.parseInt(responseSplit[1]);
                if (strToAlphNum >= 0 && strToAlphNum <= size.getValue()
                        && (splitNum - 1) >= 0 && (splitNum - 1) <= size.getKey()) break;
                else System.out.println("Error: introduce una posición dentro del tamaño.");
            }
        } while (true);

        return new Pair<>(Integer.parseInt(responseSplit[1]), stringToAlphabetNumber(responseSplit[0]));
    }

    public static int stringToAlphabetNumber(String toTranslate) {
        int plusEnie = (toTranslate.charAt(0) - 'A') > 13 ? 1 : 0;
        if (toTranslate.length() == 1) return toTranslate.charAt(0) == 'Ñ' ? 14 : toTranslate.charAt(0) - 'A' + plusEnie;
        return ((toTranslate.charAt(0) - 'A' + 1) * 26) + (stringToAlphabetNumber(String.valueOf(toTranslate.charAt(1))) + 1) + (toTranslate.charAt(0) - 'A');
    }
    //endregion
    //endregion

    private static void clear(){
        clear(25);
    }
    private static void clear(int row){
        for (int i = 0; i < row; i++){
            System.out.println();
        }
    }
}