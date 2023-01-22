package simulacionTaller.utils;

import simulacionTaller.models.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class funcionesMenu {
    public static void menuWorkShop(PersonBrench[] workShop) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("(USUARIO) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Listar todos los miembros del Taller");
            System.out.println("2: Listar Jefes del Taller");
            System.out.println("3: Listar todos los trabajadores");
            System.out.println("4: Listar todos los chapistas");
            System.out.println("5: Listar todos los electricistas");
            System.out.println("6: Listar trabajadores no chapistas");
            System.out.println("7: Listar trabajadores no electricistas");
            System.out.println("8: Listar trabajadores MultiNavajas");
            System.out.println("9: Ejecutar simulación del Taller");
            System.out.println("0: Salir");

            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    falsoBorradoDeConsola();
                    listAllMembers(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                    break;
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    listBosses(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "3" -> {
                    falsoBorradoDeConsola();
                    listAllWorkers(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "4" -> {
                    falsoBorradoDeConsola();
                    listPlater(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "5" -> {
                    falsoBorradoDeConsola();
                    listElectrician(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "6" -> {
                    falsoBorradoDeConsola();
                    listNoPlater(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "7" -> {
                    falsoBorradoDeConsola();
                    listNoElectrician(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "8" -> {
                    falsoBorradoDeConsola();
                    listMulti(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "9" -> {
                    falsoBorradoDeConsola();
                    simulacionTaller(workShop);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                // Salir
                case "0" -> {
                    falsoBorradoDeConsola();
                    exit(0);
                }
            }
        }
    }

    private static void simulacionTaller(PersonBrench[] workShop) throws InterruptedException {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Boss) {
                int random = (int) (Math.random() * 5 + 1);
                if (random == 1) {
                    System.out.println("El jefe " + workShop[i].name + " hoy se ha levantado de mal humor...");
                    System.out.println(((Boss) workShop[i]).lashes());
                    System.out.println();
                    Thread.sleep(2000);
                } else {
                    System.out.println(((Boss) workShop[i]).greetAsBoss());
                    Thread.sleep(1500);
                    System.out.println();
                    // Le responden sus trabajadores
                    for (int j = 0; j < ((Boss) workShop[i]).dependents.length; j++) {
                        System.out.println(((Boss) workShop[i]).dependents[j].greet());
                        Thread.sleep(500);
                    }
                    System.out.println();
                    ((Boss) workShop[i]).printPayWorkers();
                    Thread.sleep(1000);
                    System.out.println();
                }
            }
            if (workShop[i] instanceof Electrician) {
                System.out.println("Soy " + workShop[i].name + " electricista");
                Thread.sleep(500);
                System.out.println(((Electrician) workShop[i]).fixElectrician());
                Thread.sleep(500);
                System.out.println(((Electrician) workShop[i]).eatAsElectrician());
                Thread.sleep(500);
                System.out.println();
            }
            if (workShop[i] instanceof Plater) {
                System.out.println("Soy " + workShop[i].name + " chapista");
                Thread.sleep(500);
                System.out.println(((Plater) workShop[i]).fixPlate());
                Thread.sleep(500);
                System.out.println(((Plater) workShop[i]).restAsPlater());
                Thread.sleep(500);
                System.out.println();
            }
            if (workShop[i] instanceof Multi) {
                System.out.println("Soy " + workShop[i].name + " multi-navajas");
                Thread.sleep(500);
                System.out.println(((Multi) workShop[i]).fixPlate());
                Thread.sleep(500);
                System.out.println(((Multi) workShop[i]).restAsPlater());
                Thread.sleep(500);
                System.out.println(((Multi) workShop[i]).fixElectrician());
                Thread.sleep(500);
                System.out.println(((Multi) workShop[i]).eatAsElectrician());
                Thread.sleep(500);
                System.out.println();
            }
            if (workShop[i] instanceof Worker && !(workShop[i] instanceof Plater) && !(workShop[i] instanceof Electrician) && !(workShop[i] instanceof Multi)) {
                System.out.println("Soy " + workShop[i].name + " trabajador normal");
                Thread.sleep(500);
                int random = (int) (Math.random() * 4 + 1);
                if (random == 1) {
                    System.out.println(((Worker) workShop[i]).restAsWorker());
                    Thread.sleep(500);
                    System.out.println();
                } else {
                    System.out.println(((Worker) workShop[i]).work());
                    Thread.sleep(500);
                    System.out.println();
                }
            }
        }
        System.out.println("FIN SIMULACION");
    }

    /**
     * Lista todos los multi del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listMulti(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Multi) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los trabajadores no electricistas del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listNoElectrician(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (!(workShop[i] instanceof Plater) && !(workShop[i] instanceof Boss)) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los trabajadores no chapistas del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listNoPlater(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (!(workShop[i] instanceof Plater) && !(workShop[i] instanceof Boss)) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los electricistas del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listElectrician(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Electrician) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los chapistas del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listPlater(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Plater) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los jefes del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listBosses(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Boss) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los trabajadores del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listAllWorkers(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            if (workShop[i] instanceof Worker) {
                System.out.println(workShop[i]);
            }
        }
    }

    /**
     * Lista todos los miembros del Taller
     *
     * @param workShop el almacén donde se encuentran todos los miembros
     */
    private static void listAllMembers(PersonBrench[] workShop) {
        for (int i = 0; i < workShop.length; i++) {
            System.out.println(workShop[i]);
        }
    }

    /**
     * Permite al usuario volver al menú principal.
     *
     * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
     */
    public static Boolean returnToMenu() {
        System.out.println("Introduzca (menu), para volver al menú principal:");
        Scanner sc = new Scanner(System.in);
        String entradaDireccionMenu = sc.nextLine().toLowerCase();
        return entradaDireccionMenu.equals("menu");
    }

    /**
     * Crea una sensación de borrado de la consola.
     * Mediante una impresión de varias líneas en blanco.
     */
    public static void falsoBorradoDeConsola() {
        // Para crear una sensación de borrado en consola
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
