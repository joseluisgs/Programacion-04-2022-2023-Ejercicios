package ModelsSalaDeCine;

import FactorySalaDeCine.FactoryPelicula;
import FactorySalaDeCine.FactorySala;

import java.util.Scanner;
import java.util.regex.Pattern;

public class simuladorSalaDeCine {

    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String CYAN = "\u001b[36m";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        salaDeCine salaCine = null;
        switch (elegirComoIntroducirDatosDeLaSalaDeCine()) {
            case 1 -> salaCine = introducirDatosAMano();
            case 2 -> salaCine = FactorySala.getInstance().crearSalaDeCineCompletamenteAleatoria();
        }

        salaCine.inicializadorSalaDeCine();

        System.out.println(CYAN+"La sala del cine es la siguiente:");
        salaCine.representacionInicialDeLaSala();

        int opcion = 0;
        do{
            System.out.println(CYAN+"Seleccione la opción que desea:");
            opcion = menu();
            switch (opcion){
                case 1 -> salaCine.comprarEntrada();
                case 2 -> salaCine.reservarEntrada();
                case 3 -> salaCine.formalizarReserva();
                case 4 -> salaCine.anularReservaCompra();
                case 5 -> System.out.println(salaCine.informeDeLaSalaDeCine());
                case 6 -> salaCine.dineroTotalEnCaja();
            }

        }while(opcion != 0);
        System.out.println(CYAN+"Adios...");
    }

    /**
     * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
     * @return la opcion seleccionada por el usuario
     */
    private static int elegirComoIntroducirDatosDeLaSalaDeCine() {
        System.out.println(GREEN+"***************************************");
        System.out.println("*                MENÚ                 *");
        System.out.println("***************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Introducir datos a mano"+GREEN+"         *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Generar datos aleatoriamente"+GREEN+"    *");
        System.out.println("***************************************");
        return introducirOpcionDeIntroducirDatos();
    }

    /**
     * función que sirve para introducir una opción válida
     * @return la opcion válida
     */
    public static int introducirOpcionDeIntroducirDatos() {
        var opcion = "";
        do {
            try {
                opcion = sc.nextLine().trim();
                opcionDeIntroducirDatosValida(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                opcion = "";
            }
        } while (opcion == "");
        return Integer.parseInt(opcion);
    }

    /**
     * función que sirve para validar la opción introducida por teclado
     * @param opcion lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static boolean opcionDeIntroducirDatosValida(String opcion) {
        if(opcion == null){
            throw new IllegalArgumentException(RED+"La opción introducida no puede ser nula, vuelve a probar:");
        }
        if(opcion.isEmpty()){
            throw new IllegalArgumentException(RED+"La opción introducida no puede estar vacía, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[0-9]+");
        if(!regex.matcher(opcion).matches()){
            throw new IllegalArgumentException(RED+"La opción introducida no es válida, vuelve a probar:");
        }
        int opciones = Integer.parseInt(opcion);
        if(opciones < 1 || opciones > 2){
            throw new IllegalArgumentException(RED+"No has elegido una de las opciones posibles, vuelve a probar:");
        }
        return true;
    }

    public static salaDeCine introducirDatosAMano(){
        System.out.println(CYAN+"Primero introduce los datos de la sal del cine:");
        System.out.println(CYAN+"Introduce el nombre que tiene su cine:");
        String nombre = introducirNombre();
        System.out.println(CYAN+"Introduce el número de fila que tiene su cine:");
        int filas = introducirFilaColumna();
        System.out.println(CYAN+"Introduce el número de columnas que tiene su cine:");
        int columnas = introducirFilaColumna();

        System.out.println(CYAN+"Ahora introduce los datos de la pelicula que se va a mostrar:");
        System.out.println(CYAN+"Introduce el titulo de la pelicula:");
        String titulo = introducirTitulo();
        System.out.println(CYAN+"Introduce el año de publicación de la pelicula:");
        int añoPublicacion =  introducirAñoPublicacion();
        System.out.println(CYAN+"Introduce el nombre del director de la pelicula:");
        String director = introducirDirector();
        System.out.println(CYAN+"Introduce el genero de la pelicula:");
        String genero = introducirGenero();

        return new salaDeCine(nombre, filas, columnas, FactoryPelicula.create(titulo, añoPublicacion, director, genero));
    }

    /**
     * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
     * @return la opcion seleccionada por el usuario
     */
    public static int menu(){
        System.out.println(GREEN+"*************************************************");
        System.out.println("*                    MENÚ                       *");
        System.out.println("*************************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Comprar entrada"+GREEN+"                           *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Reservar entrada"+GREEN+"                          *");
        System.out.println("* "+YELLOW+"[3] "+CYAN+"Formalizar reserva de entrada"+GREEN+"             *");
        System.out.println("* "+YELLOW+"[4] "+CYAN+"Anular reserva o compra de entrada"+GREEN+"        *");
        System.out.println("* "+YELLOW+"[5] "+CYAN+"Conseguir informe de la sala"+GREEN+"              *");
        System.out.println("* "+YELLOW+"[6] "+CYAN+"Conseguir recaudación total de la caja"+GREEN+"    *");
        System.out.println("* "+YELLOW+"[0] "+CYAN+"Salir"+GREEN+"                                     *");
        System.out.println("*************************************************");
        return introducirOpcion();
    }

    /**
     * función que sirve para introducir una opción válida
     * @return la opcion válida
     */
    public static int introducirOpcion() {
        String opcion = "";
        do {
            try {
                opcion = sc.nextLine().trim();
                opcionValida(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                opcion = "";
            }
        } while (opcion == "");
        return Integer.parseInt(opcion);
    }

    /**
     * función que sirve para validar la opción introducida por teclado
     * @param opcionElegida lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean opcionValida(String opcionElegida) {
        if(opcionElegida == null){
            throw new IllegalArgumentException(RED+"La opción introducida no puede ser nula, vuelve a probar:");
        }
        if(opcionElegida.isEmpty()){
            throw new IllegalArgumentException(RED+"La opción introducida no puede estar vacía, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[0-9]+");
        if(!regex.matcher(opcionElegida).matches()){
            throw new IllegalArgumentException(RED+"La opción introducida no es válida, vuelve a probar:");
        }
        int opcion = Integer.parseInt(opcionElegida);
        if(opcion < 0 || opcion > 6){
            throw new IllegalArgumentException(RED+"No has elegido una de las opciones posibles, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir una fila o columna válida
     * @return la fila o columna introducida por teclado
     */
    public static int introducirFilaColumna(){
        String filaColumna = "";
        do{
            try{
                filaColumna = sc.nextLine().trim();
                filaColumnaValida(filaColumna);
            }catch(Exception e){
                System.out.println(e.getMessage());
                filaColumna = "";
            }
        }while(filaColumna == "");
        return Integer.parseInt(filaColumna);
    }

    /**
     * función que sirve para validar el año de publicación introducido por teclado
     * @param filaColumnaIntroducida lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean filaColumnaValida(String filaColumnaIntroducida) {
        if(filaColumnaIntroducida == null){
            throw new IllegalArgumentException(RED+"La fila/columna introducida no puede ser nulo, vuelve a probar:");
        }
        if(filaColumnaIntroducida.isEmpty()){
            throw new IllegalArgumentException(RED+"La fila/columna introducida no puede estar vacia, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[0-9]+");
        if(!regex.matcher(filaColumnaIntroducida).matches()){
            throw new IllegalArgumentException(RED+"La fila/columna introducida no es válida, vuelve a probar:");
        }
        int filaColumna = Integer.parseInt(filaColumnaIntroducida);
        if(filaColumna <= 0){
            throw new IllegalArgumentException(RED+"La fila/columna no puede ser menor que 1, vuelve a probar:");
        }
        if(filaColumna > 26){
            throw new IllegalArgumentException(RED+"La fila/columna sobrepasar el tamaño 26, vuelve a probar:");
        }
        return true;
    }
    /**
     * función que sirve para introducir un nombre válido
     * @return el nombre introducido por teclado
     */
    public static String introducirNombre(){
        String nombre;
        do{
            try{
                nombre = sc.nextLine().trim();
                nombreValido(nombre);
            }catch(Exception e){
                System.out.println(e.getMessage());
                nombre = "";
            }
        }while(nombre == "");
        return nombre;
    }

    /**
     * función que sirve para validar el nombre introducido por teclado
     * @param nombre lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean nombreValido(String nombre) {
        if(nombre == null){
            throw new IllegalArgumentException(RED+"El nombre no puede ser nulo, vuelve a probar:");
        }
        if(nombre.isEmpty()){
            throw new IllegalArgumentException(RED+"El nombre no puede estar vacio, vuelve a probar:");
        }
        return true;
    }
    /**
     * función que sirve para introducir un titulo válido
     * @return el título introducido por teclado
     */
    public static String introducirTitulo(){
        String titulo;
        do{
            try{
                titulo = sc.nextLine().trim();
                tituloValido(titulo);
            }catch(Exception e){
                System.out.println(e.getMessage());
                titulo = "";
            }
        }while(titulo == "");
        return titulo;
    }

    /**
     * función que sirve para validar el título introducido por teclado
     * @param titulo lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean tituloValido(String titulo) {
        if(titulo == null){
            throw new IllegalArgumentException(RED+"El título no puede ser nulo, vuelve a probar:");
        }
        if(titulo.isEmpty()){
            throw new IllegalArgumentException(RED+"El título de la peli no puede estar vacio, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un año de publicacion válido
     * @return el año de publicacion introducido por teclado
     */
    public static int introducirAñoPublicacion() {
        String añoPublicacion = "";
        do {
            try {
                añoPublicacion = sc.nextLine().trim();
                añoPublicacionValido(añoPublicacion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                añoPublicacion = "";
            }
        } while (añoPublicacion == "");
        return Integer.parseInt(añoPublicacion);
    }

    /**
     * función que sirve para validar el año de publicación introducido por teclado
     * @param añoPublicacionIntroducido lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean añoPublicacionValido(String añoPublicacionIntroducido) {
        if(añoPublicacionIntroducido == null){
            throw new IllegalArgumentException(RED+"El año de publicación introducido no puede ser nulo, vuelve a probar:");
        }
        if(añoPublicacionIntroducido.isEmpty()){
            throw new IllegalArgumentException(RED+"El año de publicación introducido no puede estar vacio, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("-?[0-9]+");
        if(!regex.matcher(añoPublicacionIntroducido).matches()){
            throw new IllegalArgumentException(RED+"El año de publicación no es válido, vuelve a probar:");
        }
        int añoPublicacion = Integer.parseInt(añoPublicacionIntroducido);
        if(añoPublicacion < 0){
            throw new IllegalArgumentException(RED+"El año de publicación no puede ser negativo, vuelve a probar:");
        }
        if(añoPublicacion < 1950 || añoPublicacion > 2022){
            throw new IllegalArgumentException(RED+"El año de publicación de la peli debe ser entre 1950 y 2022, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un director válido
     * @return el director introducido por teclado
     */
    public static String introducirDirector() {
        String director = "";
        do {
            try {
                director = sc.nextLine().trim();
                directorValido(director);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                director = "";
            }
        } while (director == "");
        return director;
    }

    /**
     * función que sirve para validar el director introducido por teclado
     * @param director lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean directorValido(String director) {
        if(director == null){
            throw new IllegalArgumentException(RED+"El director no puede ser nulo, vuelve a probar:");
        }
        if(director.isEmpty()){
            throw new IllegalArgumentException(RED+"El director de la peli no puede estar vacio, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un género válido
     * @return el género introducido por teclado
     */
    public static String introducirGenero() {
        String genero = "";
        do {
            try {
                genero = sc.nextLine().trim();
                generoValido(genero);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                genero = "";
            }
        } while (genero == "");
        return genero;
    }

    /**
     * función que sirve para validar el género introducido por teclado
     * @param genero lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static Boolean generoValido(String genero) {
        if(genero == null){
            throw new IllegalArgumentException(RED+"El género no puede ser nulo, vuelve a probar:");
        }
        if(genero.isEmpty()){
            throw new IllegalArgumentException(RED+"El género de la peli no puede estar vacio, vuelve a probar:");
        }
        return true;
    }
}
