package simulacionCine.utils;

import simulacionCine.models.Sala;

public class funcionesEsteticaDeConsola {
    /**
     * Muestra información detallada del cine y sus salas.
     *
     * @param cine El cine a mostrar.
     */
    public static void mostrarCine(Sala[] cine) {
        portadaCinesAngel();
        for (int i = 0; i < cine.length; i++) {
            System.out.println("=======--- SALA -> " + cine[i].id + "---=======");
            System.out.println(cine[i]);
            System.out.println("========--- PANTALLA ---========");
            cine[i].imprimirMatrizButacas();
            System.out.println();
        }
    }

    /**
     * Muestra un catálogo de películas disponibles en el cine.
     *
     * @param cine El cine del que se desea obtener el catálogo de películas.
     */
    public static void mostrarCatalogo(Sala[] cine) {
        for (Sala element : cine) {
            System.out.println(element);
            System.out.println();
        }
    }

    /**
     * Muestra información detallada de una sala en particular.
     *
     * @param cine   El cine al que pertenece la sala.
     * @param idSala El ID de la sala a mostrar.
     */
    public static void mostrarSala(Sala[] cine, String idSala) {
        portadaCinesAngel();
        System.out.println("=======--- SALA -> " + idSala + "---=======");
        System.out.println("========--- PANTALLA ---========");
        for (int i = 0; i < cine.length; i++) {
            if (cine[i].id.equals(idSala)) {
                cine[i].imprimirMatrizButacas();
            }
        }
        System.out.println();
    }

    /**
     * Muestra la portada del cine.
     */
    public static void portadaCinesAngel() {
        String red = "\u001b[31m";
        String reset = "\u001b[0m";
        System.out.println(red + "======================" + reset);
        System.out.println("  ***CINES ANGEL***");
        System.out.println("Precio = 5,25€/persona");
        System.out.println(" VIP = 8,5€/persona");
        System.out.println(red + "======================" + reset);
        System.out.println();
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
}
