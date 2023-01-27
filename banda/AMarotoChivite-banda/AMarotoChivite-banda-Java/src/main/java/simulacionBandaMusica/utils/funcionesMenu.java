package simulacionBandaMusica.utils;

import simulacionBandaMusica.models.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class funcionesMenu {
    /**
     * Menú de la banda de música
     */
    public static void menuBandaMusica(Musico[] banda) {

        while (true) {
            System.out.println("(USUARIO) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Listar banda " +
                    "(músicos de cada tipo y cantantes/guitarristas y multi-instrumentistas) " +
                    "con sus salarios");
            System.out.println("2: Calcular mantenimiento banda (salario total)");
            System.out.println("0: Salir");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()) {

                // Listar banda
                case "1" -> {
                    falsoBorradoDeConsola();
                    listarBanda(banda);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    System.out.println(calcularMantenimientoBanda(banda) + " €");
                    while (!volverAlMenu()) {
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

    /**
     * Imprime en pantalla toda la banda
     */
    private static void listarBanda(Musico[] bandaMusicos) {
        System.out.println("Con un total de " + Musico.getContadorMusic() + " músicos:");
        System.out.println();
        for (int i = 0; i < bandaMusicos.length; i++) {
            System.out.println(bandaMusicos[i].toString());
        }
    }

    /**
     * Crea una sensación de borrado de la consola.
     * Mediante una impresión de varias líneas en blanco.
     */
    public static void falsoBorradoDeConsola() {
        // Para crear una senación de borrado en consola
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    /**
     * Calcula el salario total que costará mantener la banda
     *
     * @param banda donde se encuentran los músicos con sus salarios
     * @return el total del coste de mantenimiento
     */
    public static int calcularMantenimientoBanda(Musico[] banda) {
        // Recorremos la banda, y practicamos casteo del polimorfismo
        int salarioTotal = 0;
        for (int i = 0; i < banda.length; i++) {
            if (banda[i] instanceof Bajista) {
                salarioTotal = salarioTotal + ((Bajista) banda[i]).salarioBajista;
            }
            if (banda[i] instanceof Cantante) {
                salarioTotal = salarioTotal + ((Cantante) banda[i]).salarioCantante;
            }
            if (banda[i] instanceof CantantePro) {
                salarioTotal = salarioTotal + ((CantantePro) banda[i]).salarioCantantePro;
            }
            if (banda[i] instanceof Guitarrista) {
                salarioTotal = salarioTotal + ((Guitarrista) banda[i]).salarioGuitarrista;
            }
            if (banda[i] instanceof MultiInstrumentista) {
                salarioTotal = salarioTotal + ((MultiInstrumentista) banda[i]).salarioMultiInstrumento;
            }
            if (banda[i] instanceof Percusionista) {
                salarioTotal = salarioTotal + ((Percusionista) banda[i]).salarioPercusionista;
            }
            if (banda[i] instanceof Teclista) {
                salarioTotal = salarioTotal + ((Teclista) banda[i]).salarioTeclista;
            }
            if (banda[i] instanceof Trompetista) {
                salarioTotal = salarioTotal + ((Trompetista) banda[i]).salarioTrompetista;
            }
        }
        return salarioTotal;
    }

    /**
     * Permite al usuario volver al menú principal.
     *
     * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
     */
    public static Boolean volverAlMenu() {
        System.out.println("Introduzca (menu), para volver al menú principal:");
        Scanner sc = new Scanner(System.in);
        String entradaDireccionMenu = sc.nextLine().toLowerCase();
        return entradaDireccionMenu.equals("menu");
    }
}
