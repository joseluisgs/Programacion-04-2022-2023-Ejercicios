package ModelsAparcamiento;

import java.util.Scanner;

public class simuladorAparcamiento {

    private static Scanner sc = new Scanner(System.in);

    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String CYAN = "\u001b[36m";
    public static void main(String[] args){
        Aparcamiento aparcamiento = new Aparcamiento();

        int opcion = 0;
        do {
            System.out.println(CYAN+"Seleccione la opción que deseé:");
            opcion = menu();
            switch(opcion){
                case 1 -> aparcamiento.aparcarUnNuevoVehiculo();
                case 2 -> aparcamiento.sacarVehiculoDeAparcamiento();
                case 3 -> aparcamiento.listadoDeVehiculos();
                case 4 -> aparcamiento.cuantosVehiculosTieneUnConductorAparcados();
                case 5 -> aparcamiento.recaudacion();
            }
        }while(opcion != 0);
        System.out.println(CYAN+"Adios..");
    }

    /**
     * función que presenta un menú con todas la opciones posibles, al usuario
     * @return la opción que haya introducido el usuario
     */
    public static int menu(){
        System.out.println(GREEN+"************************************************************");
        System.out.println("*                          menú                            *");
        System.out.println("************************************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Aparcar un nuevo vehículo"+GREEN+"                            *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Sacar un vehículo del aparcamiento"+GREEN+"                   *");
        System.out.println("* "+YELLOW+"[3] "+CYAN+"Mostrar un listado de vehiculos"+GREEN+"                      *");
        System.out.println("* "+YELLOW+"[4] "+CYAN+"Cuantos vehículos aparcados tiene un conductor"+GREEN+"       *");
        System.out.println("* "+YELLOW+"[5] "+CYAN+"Calcular recaudación total"+GREEN+"                           *");
        System.out.println("* "+YELLOW+"[0] "+CYAN+"Salir"+GREEN+"                                                *");
        System.out.println("************************************************************");
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
    private static boolean opcionValida(String opcion) {
        if(opcion == null){
            throw new IllegalArgumentException(RED+"La opción seleccionada no puede ser nula, vuelva a probar:");
        }
        if(opcion.isEmpty()){
            throw new IllegalArgumentException(RED+"La opción seleccionada no puede estar vacia, vuelva a probar:");
        }
        int opciones = Integer.parseInt(opcion);
        if(opciones < 0 || opciones > 5){
            throw new IllegalArgumentException(RED+"La opción seleccionada es inválida, vuelva a probar:");
        }
        return true;
    }
}
