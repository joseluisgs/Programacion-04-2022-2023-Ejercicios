package ModelsCesta;

import FactoriesCesta.FactoryCesta;

import java.util.Scanner;
import java.util.regex.Pattern;

public class simulacionCesta {

    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String CYAN = "\u001b[36m";

    public static Scanner sc = new Scanner(System.in);
    public static Cesta cesta = FactoryCesta.getInstance().crearCestaRandom();

    public static void main(String[] args) {
        var opcion = 0;
        do {
            opcion = menu();
            switch (opcion) {
                case 1 -> cesta.listaCesta.añadirProductosALaListaDeLaCesta();
                case 2 -> cesta.listaCesta.eliminarProductosALaListaDeLaCesta();
                case 3 -> cesta.listaCesta.actualizarProductosALaListaDeLaCesta();
                case 4 -> cesta.listaCesta.optenerElTotalDeLosProductosEnCaja();
                case 5 -> cesta.listaCesta.representarLaListaDeLaCesta();
            }
        } while (opcion != 0);
        System.out.println(CYAN+"Adios...");

    }

    /**
     * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
     *
     * @return la opcion seleccionada por el usuario
     */
    public static int menu() {
        System.out.println(GREEN+"*********************************************************");
        System.out.println("*                        MENÚ                           *");
        System.out.println("*********************************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Añadir producto a la cesta"+GREEN+"                        *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Eliminar producto de la cesta"+GREEN+"                     *");
        System.out.println("* "+YELLOW+"[3] "+CYAN+"Actualizar cantidad de producto en la cesta"+GREEN+"       *");
        System.out.println("* "+YELLOW+"[4] "+CYAN+"Obtener el total de dinero de la cesta"+GREEN+"            *");
        System.out.println("* "+YELLOW+"[5] "+CYAN+"Mostrar la lista de la cesta"+GREEN+"                      *");
        System.out.println("* "+YELLOW+"[0] "+CYAN+"Salir"+GREEN+"                                             *");
        System.out.println("*********************************************************");
        return introducirOpcion();
    }

    /**
     * función que sirve para introducir una opción válida
     * @return la opcion válida
     */
    public static int introducirOpcion() {
        var opcion = "";
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
     * @param opcion lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public static boolean opcionValida(String opcion) {
        if(opcion == null){
            throw new IllegalArgumentException(RED+"La opción no puede ser nula, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[0-9]+");
        if(!regex.matcher(opcion).matches()){
            throw new IllegalArgumentException(RED+"La opción introducida no es válida, vuelve a probar:");
        }
        if(Integer.parseInt(opcion) < 0 || Integer.parseInt(opcion) > 5){
            throw new IllegalArgumentException(RED+"No has elegido una de las opciones posibles, vuelve a probar:");
        }
        return true;
    }

}

