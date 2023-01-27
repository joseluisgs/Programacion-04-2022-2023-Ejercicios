package ModelsSalaDeCine;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class salaDeCine {

    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String ROSE = "\u001b[35m";
    private static String CYAN = "\u001b[36m";

    private static Scanner sc = new Scanner(System.in);
    String nombre;
    int fila;
    int columna;
    pelicula pelicula;

    /**
     * es el constructor del objeto "salaDeCine"
     * @param nombre es el nombre de la sala de cine
     * @param fila es el número de filas de butacas en la sala
     * @param columna es el número de columnas de butacas en la sala
     * @param pelicula es el objeto pelicula que se representará en la sala del cine
     */
    public salaDeCine(String nombre, int fila, int columna, pelicula pelicula){
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.pelicula = pelicula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        salaDeCine that = (salaDeCine) o;
        return fila == that.fila && columna == that.columna && Objects.equals(nombre, that.nombre) && Objects.equals(pelicula, that.pelicula) && Arrays.equals(butacas, that.butacas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nombre, fila, columna, pelicula);
        result = 31 * result + Arrays.hashCode(butacas);
        return result;
    }

    @Override
    public String toString() {
        return "salaDeCine{" +
                "nombre='" + nombre + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                ", pelicula=" + pelicula +
                ", butacas=" + Arrays.toString(butacas) +
                '}';
    }

    public butaca[][] butacas = new butaca[fila][columna];

    public void inicializadorSalaDeCine() {
        butacas = new butaca[fila][columna];
        for(int i = 0; i<butacas.length; i++){
            for(int j = 0; j<butacas[i].length; j++){
                butacas[i][j] = new butaca(hallarIdentificadorButaca(i, j) , "libre");
            }
        }
    }

    /**
     * función que sirve para averiguar el identificador de la butaca a la hora de inicializar la matriz
     * @param fila la posición de la fila sobre la que se colocará la butaca
     * @param columna la posición de la columna sobre la que se colocará la butaca
     * @return el indentificador creado a partir de los datos pasados por parametros
     */
    public String hallarIdentificadorButaca(int fila, int columna) {
        String identificador = ""+(char)(65 + fila)+(columna+1);
        return identificador;
    }

    /**
     * función que sirve para comprar 1 o varias entradas
     */
    public void comprarEntrada(){
        System.out.println(CYAN+"La sala del cine es la siguiente:");
        representacionInicialDeLaSala();
        var butaca = "";
        var contadorEntradas = 0;
        do {
            System.out.println(CYAN+"Introduzca las butacas que quieras comprar, puedes introducir el indentificador de una butaca a comprar ( A1, por ejemplo ) o escribir: stop, para dejar de comprar butacas: ");
            butaca = introducirButaca();
            if(butacaLibre(butaca)) {
                if (!butaca.equals("stop")) {
                    String posicionButaca = buscarButacaPorIndentificador(butaca);
                    if (!posicionButaca.equals("-1-1")) {
                        System.out.println(GREEN+"De acuerdo, has comprado la butaca "+comprar(posicionButaca).identificador);
                        contadorEntradas++;
                    } else {
                        System.out.println(YELLOW+"No existe ninguna butaca con esa identificación");
                    }
                }
            }else{
                System.out.println(YELLOW+"La bucata seleccionada ya está ocupada");
            }
        }while(!butaca.equals("stop"));
        System.out.println(GREEN+"Has comprado un total de "+contadorEntradas+" butacas");
    }

    /**
     * función que sirve para poner el estado de una butaca en "comprado"
     * @return la butaca cuyo estado fue cambiado
     */
    public butaca comprar(String posicionButaca) {
        String[] posicion = posicionButaca.split("-");
        butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado = "comprado";
        return  butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])];
    }

    /**
     * función que sirve para reservar 1 o varias entradas
     */
    public void reservarEntrada(){
        System.out.println(CYAN+"La sala del cine es la siguiente:");
        representacionInicialDeLaSala();
        var butaca = "";
        var contadorEntradas = 0;
        do {
            System.out.println(CYAN+"Introduzca las butacas que quieras reservar, puedes introducir el indentificador de una butaca a reservar ( A1, por ejemplo ) o escribir: stop, para dejar de reservar butacas: ");
            butaca = introducirButaca();
            if(butacaLibre(butaca)) {
                if (!butaca.equals("stop")) {
                    String posicionButaca = buscarButacaPorIndentificador(butaca);
                    if (!posicionButaca.equals("-1-1")) {
                        System.out.println(YELLOW+"De acuerdo, has reservado la butaca "+reservar(posicionButaca).identificador);
                        contadorEntradas++;
                    } else {
                        System.out.println(YELLOW+"No existe ninguna butaca con esa identificación");
                    }
                }
            }else{
                System.out.println(YELLOW+"La bucata seleccionada ya está ocupada");
            }
        }while(!butaca.equals("stop"));
        System.out.println(YELLOW+"Has reservado un total de "+contadorEntradas+" butacas");
    }

    /**
     * función que sirve para poner el estado de una butaca en "reservado"
     * @return la butaca cuyo estado fue cambiado
     */
    public butaca reservar(String posicionButaca) {
        String[] posicion = posicionButaca.split("-");
        butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado = "reservado";
        return  butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])];
    }

    /**
     * función que sirve para formalizar de reservado a comprado 1 o varias butacas
     */
    public void formalizarReserva(){
        System.out.println(CYAN+"La sala del cine es la siguiente:");
        representacionInicialDeLaSala();
        var butaca = "";
        var contadorEntradas = 0;
        do {
            System.out.println(CYAN+"Introduzca las butacas que quieras formalizar de reservas a compras, puedes introducir el indentificador de una butaca ( A1, por ejemplo ) o escribir: stop, para dejarlo: ");
            butaca = introducirButaca();
            if(!butaca.equals("stop")){
                String posicionButaca = buscarButacaPorIndentificador(butaca);
                String[] posicion = posicionButaca.split("-");
                if(!posicionButaca.equals("-1-1") && butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("reservado")) {
                    System.out.println(GREEN+"De acuerdo, has formalizado la butaca "+comprar(posicionButaca).identificador);
                    contadorEntradas++;
                }else{
                    if(butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("reservado")) {
                        System.out.println(YELLOW+"No existe ninguna butaca con esa identificación");
                    }else{
                        System.out.println(YELLOW+"Esa butaca no estaba reservada, por lo que no puedes formalizarla");
                    }
                }
            }
        }while(!butaca.equals("stop"));
        System.out.println(GREEN+"Has formalizado un total de "+contadorEntradas+" butacas");
    }

    /**
     * función que sirve para formalizar de reservado a comprado 1 o varias butacas
     */
    public void anularReservaCompra(){
        System.out.println(CYAN+"La sala del cine es la siguiente:");
        representacionInicialDeLaSala();
        var butaca = "";
        var contadorEntradas = 0;
        do {
            System.out.println(CYAN+"Introduzca las butacas cuya reserva/compra quieras anular, puedes introducir el indentificador de una butaca ( A1, por ejemplo ) o escribir: stop, para dejar de anular reservas/compras: ");
            butaca = introducirButaca();
            if(!butaca.equals("stop")){
                String posicionButaca = buscarButacaPorIndentificador(butaca);
                String[] posicion = posicionButaca.split("-");
                if(!posicionButaca.equals("-1-1")) {
                    if(butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("reservado") || butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("comprado")){
                        System.out.println(RED+"De acuerdo, has cancelado la reserva/compra de la butaca "+anular(posicionButaca).identificador);
                        contadorEntradas++;
                    }
                }else{
                    if(butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("reservado") || butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado.equals("comprado")) {
                        System.out.println(YELLOW+"No existe ninguna butaca con esa identificación");
                    }else{
                        System.out.println(YELLOW+"Esa butaca está libre, por lo que no puedes cancelar ninguna reserva/compra");
                    }
                }
            }
        }while(!butaca.equals("stop"));
        System.out.println(RED+"Has cancelado la reserva/compra de un total de "+contadorEntradas+" butacas");
    }

    /**
     * función que sirve para poner el estado de una butaca en "reservado"
     * @return la butaca cuyo estado fue cambiado
     */
    public butaca anular(String posicionButaca) {
        String[] posicion = posicionButaca.split("-");
        butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].estado = "libre";
        return  butacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])];
    }

    /**
     * función que proporciona un informe de la sala del cine
     */
    public String informeDeLaSalaDeCine(){
        representarButacas();
        String[] tiposDeButacas = contarNumeroDeButacasPorTipo().split("-");
        return (ROSE+"Hay un total de "+CYAN+tiposDeButacas[0]+ROSE+" butacas libres, un total de "+CYAN+tiposDeButacas[1]+ROSE+" butacas reservadas y un total de "+CYAN+tiposDeButacas[2]+ROSE+" butacas compradas");
    }

    /**
     * función que sirve para calcular el dinero total que hay en caja para la pelicula
     */
    public void dineroTotalEnCaja(){
        System.out.println(CYAN+"El dinero total en caja en la actualidad es de: "+ String.format("%.2f",calcularDineroEnCaja()));
    }

    /**
     * función que sirve para calcular el dinero en caja actual de la sala de cine
     * @return el dinero en caja actual en la sala de cine
     */
    public double calcularDineroEnCaja() {
        var resultado = 0.0;
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null){
                    if(butacas[i][j].estado.equals("comprado")){
                        if (butacas[i][j].esVip) {
                            resultado += 5.25;
                        } else if (!(butacas[i][j].esVip)) {
                            resultado += 8.5;
                        }
                    }
                }
            }
        }
        return resultado;
    }

    /**
     * función que sirve para calcula el número de butacas libres, reservadas y compradas que hay
     * @return un triple con el número de butacas libres, reservadas y compradas
     */
    public String contarNumeroDeButacasPorTipo() {
        String numeroTipoButacas = "";
        int libres = 0;
        int reservadas = 0;
        int compradas = 0;
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null){
                    switch (butacas[i][j].estado){
                        case "libre" -> libres++;
                        case "reservado" -> reservadas++;
                        case "comprado" -> compradas++;
                    }
                }
            }
        }
        numeroTipoButacas = libres+"-"+reservadas+"-"+compradas;
        return numeroTipoButacas;
    }

    /**
     * función que sirve para representar las butacas de la sala de cine como libre, reservadas o compradas
     */
    public String representarButacas() {
        String representacion = "";
        String mensaje = "";
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null){
                    switch (butacas[i][j].estado){
                        case "libre" -> mensaje = mensaje+" "+GREEN+"l";
                        case "reservado" -> mensaje = mensaje+" "+YELLOW+"r";
                        case "comprado" -> mensaje = mensaje+" "+RED+"c";
                    }
                }
            }
            representacion = representacion+
                    mensaje;
            System.out.println(mensaje);
            mensaje = "";
        }
        return representacion;
    }

    /**
     * función que sirve para hallar la posición de una butaca según su identificador
     * @param identificador el dato de la butaca usado para buscar la posición de la butaca
     * @return un par con la fila y columna de la butaca
     */
    public String buscarButacaPorIndentificador(String identificador) {
        var posicion = "-1-1";
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null) {
                    if (butacas[i][j].identificador.equals(identificador)){
                        posicion = i+"-"+j;
                        break;
                    }
                }
            }
            if(!posicion.equals("-1-1")){
                break;
            }
        }
        return posicion;
    }

    /**
     * función que sirve para introducir un identificador de butaca válido o "stop"
     * @return la butaca o el "stop" introducido por teclado
     */
    public String introducirButaca(){
        var butaca = "";
        do{
            try{
                butaca = sc.nextLine().trim();
                butacaValida(butaca);
            }catch(Exception e){
                System.out.println(e.getMessage());
                butaca = "";
            }
        }while(butaca == "");
        return butaca;
    }

    /**
     * función que sirve para validar la butaca o el "stop" introducido por teclado
     * @param butaca lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public Boolean butacaValida(String butaca) {
        if(butaca == null){
            throw new IllegalArgumentException(RED+"El mensaje no puede ser nulo, vuelve a probar:");
        }
        if(butaca.isEmpty()){
            throw new IllegalArgumentException(RED+"El mensaje no puede estar vacio, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[A-Z][0-9]+");
        if(!butaca.equals("stop") && !butaca.matches(regex.pattern())){
            throw new IllegalArgumentException(RED+"El mensaje introducido no es válido, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para comprobar si la butaca seleccionada está libre o no
     * @param butaca lo que queremos validar
     * @return true si está libre, false si está ocupada
     */
    public Boolean butacaLibre(String butaca) {
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null){
                    if(butacas[i][j].identificador.equals(butaca)){
                        if(!butacas[i][j].estado.equals("libre")){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * función que sirve para representar las butacas de la sala de cine con su identificador
     */
    public void representacionInicialDeLaSala() {
        String mensaje = "";
        for(int i=0;i<butacas.length;i++){
            for(int j=0;j<butacas[i].length;j++){
                if(butacas[i][j] != null){
                    if(butacas[i][j].esVip == false) {
                        switch (butacas[i][j].estado) {
                            case "libre" -> mensaje += " "+GREEN+butacas[i][j].identificador;
                            case "reservado" -> mensaje += " "+YELLOW+butacas[i][j].identificador;
                            case "comprado" -> mensaje += " "+RED+butacas[i][j].identificador;
                        }
                    }else{
                        if(butacas[i][j].identificador.length() == 2) {
                            char letra = butacas[i][j].identificador.charAt (0);
                            char numero = butacas[i][j].identificador.charAt (1);
                            switch (butacas[i][j].estado) {
                                case "libre" -> mensaje += " "+ROSE+letra+GREEN+numero;
                                case "reservado" -> mensaje += " "+ROSE+letra+YELLOW+numero;
                                case "comprado" -> mensaje += " "+ROSE+letra+RED+numero;
                            }
                        }else{
                            char letra = butacas[i][j].identificador.charAt (0);
                            String numero = ""+butacas[i][j].identificador.charAt (1)+butacas[i][j].identificador.charAt (2);
                            switch (butacas[i][j].estado) {
                                case "libre" -> mensaje +=
                                        " "+ROSE+letra+GREEN+numero;

                                case "reservado" -> mensaje +=
                                        " "+ROSE+letra+YELLOW+numero;

                                case "comprado" -> mensaje +=
                                        " "+ROSE+letra+RED+numero;
                            }
                        }
                    }
                }
            }
            System.out.println(mensaje);
            mensaje = "";
        }
    }
}
