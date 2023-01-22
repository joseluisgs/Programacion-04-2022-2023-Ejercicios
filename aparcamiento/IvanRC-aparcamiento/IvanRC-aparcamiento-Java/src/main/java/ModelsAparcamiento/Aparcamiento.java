package ModelsAparcamiento;

import FactoriesAparcamiento.FactoryConductor;
import FactoriesAparcamiento.FactoryVehiculo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Aparcamiento {
    private static Scanner sc = new Scanner(System.in);
    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String ROSE = "\u001b[35m";
    private static String CYAN = "\u001b[36m";
    public Vehiculo[][] aparcamientos = new Vehiculo[4][4];
    public int contadorVehiculosAparcados = 0;

    /**
     * función que sirve para introducir un vehículo en la matriz parking
     */
    public void aparcarUnNuevoVehiculo(){
        String posicionLibre = buscarPrimeraPosicionLibre();

        if (posicionLibre != "") {

            Vehiculo nuevoVehiculo = null;
            do {
                System.out.println(CYAN+"Seleccione la opción que deseé:");
                switch(menu()){
                    case 1 -> nuevoVehiculo = introducirDatosVehiculo();
                    case 2 -> nuevoVehiculo = FactoryVehiculo.getInstance().createRandom();
                }
            }while(nuevoVehiculo == null);

            System.out.println(CYAN+"De acuerdo, se ha aparcado el vehículo: "+aparcar(nuevoVehiculo, posicionLibre));
            contadorVehiculosAparcados++;
        }else{
            System.out.println(YELLOW+"No hay más aparcamientos libres donde poder meter nuevos coches, libera espacio y vuelve a probar");
        }
    }

    /**
     * función que sirve para aparcar un vehículo en la matriz parking
     * @param nuevoVehiculo es el vehículo a introducir en el parking
     * @param posicionLibre es la posición donde meteremos al vehículo
     * @return el vehículo introducido en la matriz
     */
    public Vehiculo aparcar(Vehiculo nuevoVehiculo, String posicionLibre){
        int fila = Integer.parseInt(posicionLibre.split("-")[0]);
        int columna = Integer.parseInt(posicionLibre.split("-")[1]);
        aparcamientos[fila][columna] = nuevoVehiculo;
        return aparcamientos[fila][columna];
    }

    /**
     * función que sirve para que el usuario introduzca los datos del vehiculo por teclado
     * @return el vehiculo creado con los datos introducidos por el usuario
     */
    private Vehiculo introducirDatosVehiculo() {
        System.out.println(CYAN+"Introduce la información del nuevo vehículo a introducir en el parking:");
        System.out.println(CYAN+"Introduce la matrícula del vehículo:");
        String matricula = introducirMatricula();
        System.out.println(CYAN+"Introduce el año de fabricación del vehículo:");
        int añoFabricacion = introducirAñoFabricacion();
        sc.nextLine();
        System.out.println(CYAN+"Introduce el tipo de vehículo que tienes:");
        tipoVehiculo tipo = introducirTipoVehiculo();

        System.out.println(CYAN+"Ahora te toca introducir la información del conductor del nuevo vehículo:");
        System.out.println(CYAN+"Introduce el nombre del conductor:");
        String nombre = introducirNombre();
        System.out.println(CYAN+"Introduce el dni del conductor:");
        String dni = introducirDni();

        return FactoryVehiculo.getInstance().create(matricula, añoFabricacion, tipo, FactoryConductor.getInstance().create(nombre, dni));
    }

    /**
     * función que sirve para sacar un vehículo de la matriz parking
     */
    public void sacarVehiculoDeAparcamiento(){
        if(matrizNoEstaVacia()) {
            System.out.println(CYAN + "Los coches del aparcamiento actuales son:" + ROSE);
            representarAparcamiento();
            System.out.println(CYAN + "Introduzca la matrícula del vehículo que deseas sacar del apartamento:");
            String posicionVehiculo = buscarVehiculoSegunMatricula(introducirMatricula());
            if (posicionVehiculo != "") {
                System.out.println(CYAN + "El coche: " + eliminarCocheDeAparcamiento(posicionVehiculo) + ", que se encontraba en la posición " + posicionVehiculo + " ha salido del parking");
            } else {
                System.out.println(YELLOW + "No hay ningún coche con esa matrícula");
            }
        }else{
            System.out.println(YELLOW+"No hay ningún vehículo aparcado");
        }
    }

    /**
     * función que sirve para obtener una lista de coches en el aparcamiento
     */
    private void representarAparcamiento() {
        for(int i=0;i<aparcamientos.length;i++){
            for(int j=0;j<aparcamientos[i].length;j++){
                if(aparcamientos[i][j] != null){
                    System.out.println(aparcamientos[i][j]);
                }
            }
        }
    }

    /**
     * función que sirve para saber si la matriz de vehículos tiene vehículos o no
     * @return true en caso de que no este vacia, y false en caso contrario
     */
    public boolean matrizNoEstaVacia() {
        boolean noEstaVacia = false;
        for(int i=0;i<aparcamientos.length;i++){
            for(int j=0;j<aparcamientos[i].length;j++){
                if(aparcamientos[i][j] != null){
                    noEstaVacia = true;
                    break;
                }
            }
            if(noEstaVacia) break;
        }
        return noEstaVacia;
    }

    /**
     * función que srive para eliminar un vehículo de el array parking
     * @param posicionVehiculo la fila y columna de donde eliminaremos al vehiculo
     */
    public Vehiculo eliminarCocheDeAparcamiento(String posicionVehiculo) {
        int fila = Integer.parseInt(posicionVehiculo.split("-")[0]);
        int columna = Integer.parseInt(posicionVehiculo.split("-")[1]);
        Vehiculo vehiculoAuxiliar = aparcamientos[fila][columna];
        aparcamientos[fila][columna] = null;
        return vehiculoAuxiliar;
    }

    /**
     * función que sirve para hallar el número total de vehiculos en el parking
     * @return el número de vehículos que hay
     */
    public int cuantosVehiculosHayAparcados(){
        int contadorVehiculosAparcados = 0;
        for(int i = 0; i< aparcamientos.length; i++){
            for(int j = 0; j< aparcamientos[i].length; j++){
                if(aparcamientos[i][j] != null) {
                    contadorVehiculosAparcados++;
                }
            }
        }
        return contadorVehiculosAparcados;
    }

    /**
     * función que sirve para representar el array de vehículos
     */
    public void listadoDeVehiculos(){
        if(matrizNoEstaVacia()) {
            Vehiculo[] vectorVehiculos = pasarMatrizAVector(cuantosVehiculosHayAparcados());

            if(vectorVehiculos.length >= 2) {
                ordenarMetodoBurbujaDescendente(vectorVehiculos);
            }

            System.out.println(CYAN + "Hay un total de " +ROSE+vectorVehiculos.length+CYAN+ " vehículos aparcados, y son:" + ROSE);
            for (int i = 0; i < vectorVehiculos.length; i++) {
                if (vectorVehiculos[i] != null) {
                    System.out.println(vectorVehiculos[i]);
                }
            }
        }else{
            System.out.println(YELLOW+"No hay ningún vehículo aparcado");
        }
    }

    /**
     * función que sirve para representar el número de coches en total que tiene un mismo usuario
     */
    public void cuantosVehiculosTieneUnConductorAparcados(){
        if(matrizNoEstaVacia()) {
            System.out.println(CYAN+"Introduzca el dni del conductor cuya cantidad de vehículos aparcados quiere comprobar:");
            String dni = introducirDni();
            System.out.println("El conductor del dni: " +ROSE+dni+CYAN+ " tiene aparcados un total de: " +ROSE+contarVehiculosAparcadosDeConductor(dni)+CYAN+ " coches");
        }else{
            System.out.println(YELLOW+"No hay ningún vehículo aparcado");
        }
    }

    /**
     * función que sirve para representar la recaudación total
     */
    public void recaudacion(){
        System.out.println(CYAN+"Por ahora, a habido un total de "+ROSE+contadorVehiculosAparcados+ROSE+" vehículos, " +
                "por lo que la recaudación actual ( a 3.75 euros el aparcamiento ) es de: "
                +ROSE+String.format("%.2f",calcularRecaudacion())+" euros");
    }

    /**
     * función que sirve para calcular la recaudación total
     */
    public double calcularRecaudacion() {
        return contadorVehiculosAparcados*3.75;
    }

    /**
     * función que sirve para hallar el número de coches en total que tiene un mismo usuario
     * @param dni el dni del conductor cuyos coches queremos contar
     * @return el número de coches que tiene un usuario
     */
    public int contarVehiculosAparcadosDeConductor(String dni) {
        int contador = 0;
        for(int i = 0; i< aparcamientos.length; i++){
            for(int j = 0; j< aparcamientos[i].length; j++){
                if(aparcamientos[i][j] != null) {
                    if (aparcamientos[i][j].conductor.getDni().equals(dni)) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    /**
     * función que sirve para ordenar la de manera descendente el array de vehículos
     */
    public static void ordenarMetodoBurbujaDescendente(Vehiculo[] vectorVehiculos) {
        for(int i = 0; i<vectorVehiculos.length; i++){
            for(int j = 0; j<vectorVehiculos.length-i; j++){
                if(j >= 0 && j < vectorVehiculos.length && (j+1) >= 0 && (j+1) < vectorVehiculos.length) {
                    if (vectorVehiculos[j].getAñoFabricacion() < vectorVehiculos[j + 1].getAñoFabricacion()) {
                        Vehiculo vehiculoAuxiliar = vectorVehiculos[j + 1];
                        vectorVehiculos[j + 1] = vectorVehiculos[j];
                        vectorVehiculos[j] = vehiculoAuxiliar;
                    }
                }
            }
        }
    }

    /**
     * función que sirve para pasar la matriz de vehículos a un array de vehículos
     * @param cantidadVehiculos es la cantidad de vehículos que hay en el parking
     * @return el array de vehículos conseguido a traves de la matriz de vehículos
     */
    public Vehiculo[] pasarMatrizAVector(int cantidadVehiculos) {
        Vehiculo[] vectorVehiculos = new Vehiculo[cantidadVehiculos];
        int contador = 0;
        for(int i = 0; i< aparcamientos.length; i++){
            for(int j = 0; j< aparcamientos[i].length; j++){
                if(aparcamientos[i][j] != null) {
                    vectorVehiculos[contador] = aparcamientos[i][j];
                    contador++;
                }
            }
        }
        return vectorVehiculos;
    }

    /**
     * función que sirve para buscar un vehículo según su matrícula
     * @return la fila y columna vacia como un Pair<Int, Int>
     */
    public String buscarVehiculoSegunMatricula(String matricula) {
        String posicion = "";
        for(int i = 0; i< aparcamientos.length; i++){
            for(int j = 0; j< aparcamientos[i].length; j++){
                if(aparcamientos[i][j] != null) {
                    if (aparcamientos[i][j].getMatricula().equals(matricula)) {
                        posicion = i + "-" + j;
                        break;
                    }
                }
            }
            if(posicion != "") break;
        }
        return posicion;
    }

    /**
     * función que sirve para buscar el primer hueco libre en el matriz parking
     * @return la fila y columna vacia como un Pair<Int, Int>
     */
    public String buscarPrimeraPosicionLibre() {
        String posicion = "";
        for(int i = 0; i< aparcamientos.length; i++){
            for(int j = 0; j< aparcamientos[i].length; j++){
                if(aparcamientos[i][j] == null){
                    posicion = i+"-"+j;
                    break;
                }
            }
            if(posicion != ""){
                break;
            }
        }
        return posicion;
    }

    /**
     * función que sirve para introducir una matricula, validarla y devolverla
     * @return la matricula introducida y validada
     */
    public String introducirMatricula(){
        String matricula = "";
        do{
            try{
                matricula = sc.nextLine().trim();
                matriculaValida(matricula);
            }catch(Exception e){
                System.out.println(e.getMessage());
                matricula = "";
            }
        }while(matricula == "");
        return matricula;
    }

    /**
     * función que sirve para comprobar si la matricula introducida es válida
     * @param matricula es la matricula que queremos validar
     * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
     */
    public boolean matriculaValida(String matricula) {
        if(matricula == null){
            throw new IllegalArgumentException(RED+"La matricula introducida no puede ser nula, vuelva a probar:");
        }
        if(matricula.isEmpty()){
            throw new IllegalArgumentException(RED+"La matricula introducida no puede estar vacia, vuelva a probar:");
        }
        Pattern matriculaRegex = Pattern.compile("[0-9]{4}-[A-Z]{3}");
        if (!matriculaRegex.matcher(matricula).matches()) {
            throw new IllegalArgumentException(RED+"La matrícula introducida no es válida, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un año de fabricación, validarlo y devolverlo
     * @return el año de fabricación introducido y validado
     */
    public int introducirAñoFabricacion(){
        String añoFabricacion = "";
        do{
            try{
                añoFabricacion = sc.nextLine().trim();
                añoFabricacionValido(añoFabricacion);
            }catch(Exception e){
                System.out.println(e.getMessage());
                añoFabricacion = "";
            }
        }while(añoFabricacion == "");
        return Integer.parseInt(añoFabricacion);
    }

    /**
     * función que sirve para comprobar si el año de fabricación introducido es válido
     * @param añoDeFabricacion es el año de fabricacion que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    public boolean añoFabricacionValido(String añoDeFabricacion) {
        if(añoDeFabricacion == null){
            throw new IllegalArgumentException(RED+"El año de fabricacion introducido no puede ser nulo, vuelva a probar:");
        }
        if(añoDeFabricacion.isEmpty()){
            throw new IllegalArgumentException(RED+"El año de fabricacion introducido no puede estar vacio, vuelva a probar:");
        }
        int añoFabricacion = Integer.parseInt(añoDeFabricacion);
        if (añoFabricacion < 1950 || añoFabricacion > 2022) {
            throw new IllegalArgumentException(RED+"El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un tipo, validarlo y devolverlo
     * @return el tipo introducido y validado
     */
    public tipoVehiculo introducirTipoVehiculo(){
        String tipo = "";
        do{
            try{
                tipo = sc.nextLine().trim();
                tipoValido(tipo);
            }catch(Exception e){
                System.out.println(e.getMessage());
                tipo = "";
            }
        }while(tipo == "");
        tipoVehiculo tipoV = null;
        switch (tipo){
            case "coche" -> tipoV = tipoVehiculo.coche;
            case "moto" -> tipoV = tipoVehiculo.moto;
            case "patinete" -> tipoV = tipoVehiculo.patinete;
        }
        return tipoV;
    }

    /**
     * función que sirve para comprobar si el tipo introducido es válido
     * @param tipo es el tipo que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    public boolean tipoValido(String tipo) {
        if(tipo == null){
            throw new IllegalArgumentException(RED+"El tipo introducido no puede ser nulo, vuelva a probar:");
        }
        if(tipo.isEmpty()){
            throw new IllegalArgumentException(RED+"El tipo introducido no puede estar vacio, vuelva a probar:");
        }
        if (!(tipo.equals("coche")) && !(tipo.equals("moto")) && !(tipo.equals("patinete"))) {
            throw new IllegalArgumentException(RED+"El tipo introducido no es ni un coche, ni una moto, ni un patinete, por lo que no está permitido en el aparcamiento, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un nombre, validarlo y devolverlo
     * @return el nombre introducido y validado
     */
    public String introducirNombre(){
        String nombre = "";
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
     * función que sirve para comprobar si el nombre introducida es válido
     * @param nombre es el nombre que queremos validar
     * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
     */
    public boolean nombreValido(String nombre){
        if(nombre == null){
            throw new IllegalArgumentException(RED+"El nombre introducido no puede ser nulo, vuelva a probar:");
        }
        if(nombre.isEmpty()){
            throw new IllegalArgumentException(RED+"El nombre introducido no puede estar vacio, vuelva a probar:");
        }
        Pattern nombreRegex = Pattern.compile("[a-zA-ZáéúíóÁÉÚÍÓ]+");
        if(!nombreRegex.matcher(nombre).matches()){
            throw new IllegalArgumentException(RED+"El nombre introducido no es válido, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un dni, validarlo y devolverlo
     * @return el dni introducido y validado
     */
    public String introducirDni(){
        String dni = "";
        do{
            try{
                dni = sc.nextLine().trim();
                dniValido(dni);
            }catch(Exception e){
                System.out.println(e.getMessage());
                dni = "";
            }
        }while(dni == "");
        return dni;
    }

    /**
     * función que sirve para comprobar si el dni introducido es válido
     * @param dni es el dni que queremos validar
     * @return true en caso de que sea válido, y una excepción en caso de que no lo sea
     */
    public boolean dniValido(String dni){
        if(dni == null){
            throw new IllegalArgumentException(RED+"El dni introducido no puede ser nulo, vuelva a probar:");
        }
        if(dni.isEmpty()){
            throw new IllegalArgumentException(RED+"El dni introducido no puede estar vacio, vuelva a probar:");
        }
        Pattern dniRegex = Pattern.compile("[0-9]{8}[A-Z]");
        if(!dniRegex.matcher(dni).matches()){
            throw new IllegalArgumentException(RED+"El dni introducido no es válido, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que presenta un menú con todas la opciones posibles, al usuario
     * @return la opción que haya introducido el usuario
     */
    public static int menu(){
        System.out.println(GREEN+"************************************************");
        System.out.println("*                     menú                     *");
        System.out.println("************************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Introducir datos de vehículo a mano"+GREEN+"      *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Generar vehículo aleatorio"+GREEN+"               *");
        System.out.println("************************************************");
        return introducirOpcion();
    }

    /**
     * función que sirve para introducir una opción, validarla y devolverla
     * @return la opción introducida y validada
     */
    private static int introducirOpcion(){
        String opcion = "";
        do{
            try{
                opcion = sc.nextLine().trim();
                opcionValida(opcion);
            }catch(Exception e){
                System.out.println(e.getMessage());
                opcion = "";
            }
        }while(opcion == "");
        return Integer.parseInt(opcion);
    }

    /**
     * función que sirve para comprobar si la opción introducida es válida
     * @param opcion es la opcion que queremos validar
     * @return true en caso de que sea válida, y una excepción en caso de que no lo sea
     */
    public static boolean opcionValida(String opcion) {
        if(opcion == null){
            throw new IllegalArgumentException(RED+"La opción seleccionada no puede ser nula, vuelva a probar:");
        }
        if(opcion.isEmpty()){
            throw new IllegalArgumentException(RED+"La opción seleccionada no puede estar vacia, vuelva a probar:");
        }
        int opciones = Integer.parseInt(opcion);
        if(opciones < 1 || opciones > 2){
            throw new IllegalArgumentException(RED+"La opción seleccionada es inválida, vuelva a probar:");
        }
        return true;
    }
}
