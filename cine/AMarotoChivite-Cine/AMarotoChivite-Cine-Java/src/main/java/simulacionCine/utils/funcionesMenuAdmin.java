package simulacionCine.utils;

import simulacionCine.enums.EstadoButaca;
import simulacionCine.models.Butaca;
import simulacionCine.models.Cliente;
import simulacionCine.models.Sala;

import java.util.Scanner;

import static simulacionCine.simulacionCine.*;
import static simulacionCine.utils.funcionesEsteticaDeConsola.*;


// import static kotlin.io.ConsoleKt.readln;

public class funcionesMenuAdmin {

    /**
     * Verifica si una contraseña es correcta.
     *
     * @param passCorrect La contraseña correcta a comparar.
     * @return "true" si la contraseña es correcta, "false" si no lo es.
     */
    public static boolean isPassCorrect(String passCorrect) {
        while (true) {
            System.out.println("Introduzca la contraseña:");
            // Importando librería de kotlin
            //String entradaInicioSesion = readln();

            // Con puro JAVA
            Scanner sc = new Scanner(System.in);
            String entradaInicioSesion = sc.nextLine();

            if (entradaInicioSesion.equals(passCorrect)) {
                falsoBorradoDeConsola();
                return true;
            } else {
                System.out.println("Contraseña incorrecta!");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                falsoBorradoDeConsola();
                return false;
            }
        }
    }

    /**
     * Muestra un menú para el administrador.
     *
     * @param cine El cine del que se desea obtener información.
     */
    public static void menuAdmin(Sala[] cine, Cliente[] almacenClientes) {
        while (true) {
            portadaCinesAngel();
            System.out.println("(ADMIN) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Informe de butacas (libres, reservadas y ocupadas)");
            System.out.println("2: Recaudación total (caja final de las butacas compradas/ocupadas)");
            System.out.println("0: Salir");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()) {
                // Admin
                case "1" -> {
                    falsoBorradoDeConsola();
                    informeButacas(cine);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    informeRecaudacionTotal(cine);
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();

                }
                // Salir
                case "0" -> {
                    falsoBorradoDeConsola();
                    menuEleccionUsuario(cine, almacenClientes);
                }
            }
        }
    }

    /**
     * Muestra un informe de las butacas de una sala determinada.
     *
     * @param cine El cine del que se desea obtener información.
     */
    public static void informeButacas(Sala[] cine) {
        String[] almacenIDSalaElegida = new String[1];
        almacenIDSalaElegida[0] = " ";

        boolean salirBucle = false;
        while (!salirBucle) {
            mostrarCatalogo(cine);
            System.out.println("Introduzca el ID de la sala para representar un informe de su estado:");
            Scanner sc = new Scanner(System.in);
            String entradaIDsala = sc.nextLine();
            falsoBorradoDeConsola();

            // Filtro para elegir un ID existente
            for (int i = 0; i < cine.length; i++) {
                if (entradaIDsala.equals(cine[i].id)) {
                    almacenIDSalaElegida[0] = entradaIDsala;
                    salirBucle = true;
                    break;
                }
                if (i == cine.length - 1) {
                    if (!entradaIDsala.equals(cine[i].id)) {
                        System.out.println("ID inválido! Debe existir la sala en el CINE!");
                        try {
                            Thread.sleep(2250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        falsoBorradoDeConsola();
                        break;
                    }
                }

            }
        }

        mostrarSala(cine, almacenIDSalaElegida[0]);


        Sala[] salaElegida = new Sala[1];
        salaElegida[0] = cine[0];
        for (int i = 0; i < cine.length; i++) {
            if (cine[i].id.equals(almacenIDSalaElegida[0])) {
                salaElegida[0] = cine[i];
            }
        }

        Butaca[][] sala = salaElegida[0].getMatrizSala();

        int contadorButacasLibres = 0;
        int contadorButacasLibresVIP = 0;
        int contadorButacasReservadas = 0;
        int contadorButacasReservadasVIP = 0;
        int contadorButacasOcupadas = 0;
        int contadorButacasOcupadasVIP = 0;

        for (int filas = 0; filas < sala.length; filas++) {
            for (int columnas = 0; columnas < sala[filas].length; columnas++) {
                // Si es ESTÁNDAR libres
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.LIBRE && !sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasLibres += 1;
                }
                // Si es VIP libres
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.LIBRE && sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasLibresVIP += 1;
                }
                // Si es ESTÁNDAR reservadas
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.RESERVADO && !sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasReservadas += 1;
                }
                // Si es VIP reservadas
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.RESERVADO && sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasReservadasVIP += 1;
                }
                // Si es ESTÁNDAR ocupadas
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.OCUPADO && !sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasOcupadas += 1;
                }
                // Si es VIP ocupadas
                if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.OCUPADO && sala[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasOcupadasVIP += 1;
                }
            }
        }
        System.out.println("====================Informe SALA " + salaElegida[0].id + "=======================");
        System.out.println("Butacas ESTÁNDAR libres -> (" + contadorButacasLibres + ")");
        System.out.println("Butacas VIP libres ->  (" + contadorButacasLibresVIP + ")");
        System.out.println();
        System.out.println("Butacas ESTÁNDAR reservadas -> (" + contadorButacasReservadas + ")");
        System.out.println("Butacas VIP reservadas ->  (" + contadorButacasReservadasVIP + ")");
        System.out.println();
        System.out.println("Butacas ESTÁNDAR ocupadas ->(" + contadorButacasOcupadas + ")");
        System.out.println("Butacas VIP ocupadas ->  (" + contadorButacasOcupadasVIP + ")");
        System.out.println("=========================================================");
    }

    /**
     * Calcula la recaudación total del cine en función número de butacas ocupadas y su precio.
     *
     * @param cine Array de objetos Sala con las salas del cine
     */
    static void informeRecaudacionTotal(Sala[] cine) {
        int contadorButacasVIP = 0;
        int contadorButacasNoVIP = 0;

        // Tenemos que recorrer cada sala del cine
        for (int i = 0; i < cine.length; i++) {
            Butaca[][] sala = cine[i].getMatrizSala();
            // Recorremos cada sala
            for (int filas = 0; filas < sala.length; filas++) {
                for (int columnas = 0; columnas < sala[filas].length; columnas++) {
                    // Si es VIP
                    if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.OCUPADO && sala[filas][columnas].getBooleanButacaVip()) {
                        contadorButacasVIP++;
                    }
                    // Si no es VIP
                    if (sala[filas][columnas].getEstadoButaca() == EstadoButaca.OCUPADO && !sala[filas][columnas].getBooleanButacaVip()) {
                        contadorButacasNoVIP++;
                    }
                }
            }
        }

        double totalVIP = contadorButacasVIP * PRECIO_VIP;
        double totalNoVIP = contadorButacasNoVIP * PRECIO_ESTANDAR;
        double totalFinal = totalVIP + totalNoVIP;
        System.out.println("====================Informe de CAJA FINAL=======================");
        System.out.println("Recaudación butacas ESTÁNDAR (" + contadorButacasNoVIP + ") -> " + totalNoVIP + "€ ");
        System.out.println("Recaudación butacas VIP (" + contadorButacasVIP + ") -> " + totalVIP + "€ ");
        System.out.println("Recaudación TOTAL -> " + totalFinal + "€ ");
        System.out.println("================================================================");
    }
}
