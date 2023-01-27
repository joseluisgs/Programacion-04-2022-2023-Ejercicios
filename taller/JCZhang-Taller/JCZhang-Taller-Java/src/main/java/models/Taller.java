package models;
import factories.*;

import java.util.Scanner;

import static factories.ChapistasFactory.nominaChapistas;
import static factories.ElectricistasFactory.nominaElectricista;
import static factories.JefeTallerFactory.nominaJefeTaller;
import static factories.NavajaSuizaFactory.nominaNavajaSuiza;
import static factories.TrabajadoresFactory.nominaTrabajadorNormal;
import static java.lang.Integer.parseInt;


public class Taller {
    private static final int NUM_PERSONAS_MAX = 50;
    static Scanner sc = new Scanner(System.in);

    /**
     * Es una función que saca las nóminas de cada clase y el total de dinero que se ha ido en nóminas
     */
    public void informeDeNominas() {
        System.out.println("ESTE ES EL INFORME DE NOMINAS!");
        System.out.println();
        System.out.println(" - Las chapistas han cobrado un total de " + nominaChapistas + " €");
        System.out.println(" - Las electricistas han cobrado un total de " + nominaElectricista + " €");
        System.out.println(" - Las jefes de taller han cobrado un total de " + nominaJefeTaller + " €");
        System.out.println(" - Las trabajadores normales han cobrado un total de " + nominaTrabajadorNormal + " €");
        System.out.println(" - Las navajas suizas han cobrado un total de "+ nominaNavajaSuiza + " €");
        System.out.println();
        System.out.println("El total de dinero que se ha pagado en nominas es de " + (nominaChapistas + nominaElectricista + nominaTrabajadorNormal + nominaJefeTaller + nominaNavajaSuiza) + "€");
    }

    public int numeroJefeTaller(Persona[] arrayPersonas) {
        int contadorJefesTaller = 0;
        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] instanceof JefeTaller) {
                contadorJefesTaller++;
            }
        }

        System.out.println("(El numero de jefes de taller que hay en el total es de " + contadorJefesTaller+")");
        return contadorJefesTaller;
    }

    public int numeroDeElectricistas(Persona[] arrayPersonas) {
        int contadorElectricistas = 0;
        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] instanceof Electricista) {
                contadorElectricistas++;
            }
        }
        System.out.println("(El numero de electricistas es de " + contadorElectricistas + ")");
        return contadorElectricistas;

    }

    public int numeroDeChapistas(Persona[] arrayPersonas) {
        int contadorChapistas = 0;
        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] instanceof Chapista) {
                contadorChapistas++;
            }
        }
        System.out.println("(El numero de chapistas es de " + contadorChapistas + ")");
        return contadorChapistas;
    }

    public int numeroDeTrabajadoresNormales(Persona[] arrayPersonas) {
        int contadorTrabajadoresNormales = 0;
        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] instanceof Trabajador && !(arrayPersonas[i] instanceof Chapista) && !(arrayPersonas[i] instanceof Electricista) && !(arrayPersonas[i] instanceof NavajaSuiza)){
                contadorTrabajadoresNormales++;
            }
        }
        System.out.println("(El numero de trabajadores normales es de " + contadorTrabajadoresNormales + ")");
        return contadorTrabajadoresNormales;
    }


    public int seleccionarOpcion() {

        String regex = "[0-9]";

        System.out.println("*** HOLA! BIENVENIDO AL TALLER! ***");
        System.out.println("¿Que quieres ver?");
        System.out.println("Introduce el numero de la opción que quieras");
        System.out.println(" - 1 --> Numero de personas totales que hay en el taller");
        System.out.println(" - 2 --> Numero de Trabajadores normales");
        System.out.println(" - 3 --> Numero de chapistas");
        System.out.println(" - 4 --> Numero de electricistas");
        System.out.println(" - 5 --> Numero de jefes de taller");
        System.out.println(" - 6 --> Numero de navajas suizas");
        System.out.println(" - 7 --> Informe de nominas");
        System.out.println(" - 8 --> Salir");

        String entrada;
        do {
            System.out.println("Introduce la opción deseada: ");
            entrada = sc.nextLine();
            if ((!entrada.matches(regex))|| parseInt(entrada) > 8 || parseInt(entrada) < 1) {
                System.out.println("DEBES INTRODUCIR UN NUMERO ENTRE 1 Y 8!");
            } else {
                return parseInt(entrada);
            }
        } while (!entrada.matches(regex)|| (parseInt(entrada) > 8) || (parseInt(entrada) < 1));

        return 0;

    }

    /**
     * Es una función que llena la matriz con distintos tipos de personas con los porcentajes que ha indicado el profesor
     *
     * @param arrayPersonas Es la matriz de las personas inicializada a null
     * @author JiaCheng Zhang
     */
    public void llenarMatrizConPersonas(Persona[] arrayPersonas) {

        int contadorPersonas;

        do {
            contadorPersonas = 0;
            // variable auxiliar que sirve para hacer los porcentajes de probabilidad
            int aux;
            for (int i = 0; i < arrayPersonas.length; i++) {
                aux = (int) (Math.random() * 100) + 1;
                if (aux >= 1 && aux <= 10) {
                    arrayPersonas[i] = JefeTallerFactory.crearJefeTallerRandom();
                }
                if (aux >= 11 && aux <= 40) {
                    arrayPersonas[i] = ChapistasFactory.crearChapistaRandom();
                }
                if (aux >= 41 && aux <= 50) {
                    arrayPersonas[i] = ElectricistasFactory.crearElectricistaRandom();
                }
                if (aux >= 51 && aux <= 90) {
                    arrayPersonas[i] = TrabajadoresFactory.crearTrabajadorRandom();
                }
                if (aux >= 91 && aux <= 100){
                    arrayPersonas[i] = NavajaSuizaFactory.crearNavajaSuizaRandom();
                }
                contadorPersonas++;
            }
        } while (contadorPersonas < NUM_PERSONAS_MAX);

    }


    public void numeroTotalDePersonas() {
        System.out.println("El número total de personas que hay en el taller es de " + NUM_PERSONAS_MAX);
        System.out.println();
    }

    public int numeroNavajasSuizas(Persona[] arrayPersonas) {
        int contadorNavajasSuizas = 0;
        for (int i = 0; i < arrayPersonas.length; i++) {
            if (arrayPersonas[i] instanceof NavajaSuiza){
                contadorNavajasSuizas++;
            }
        }
        System.out.println("(El numero de navajas suizas es de " + contadorNavajasSuizas + ")");
        return contadorNavajasSuizas;
    }
}
