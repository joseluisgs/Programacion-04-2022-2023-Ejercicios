import models.Persona;
import models.Taller;

public class Main {

    public static void main(String[] args) {
        int NUM_PERSONAS_MAX = 50;
        boolean salir = false;

        Taller taller = new Taller();
        //Inicializo la matriz a nulos para poder rellenarla con Personas
        Persona[] arrayPersonas = new Persona[NUM_PERSONAS_MAX];
        taller.llenarMatrizConPersonas(arrayPersonas);
        do {
            switch (taller.seleccionarOpcion()) {
                case 1 -> taller.numeroTotalDePersonas();
                case 2 -> taller.numeroDeTrabajadoresNormales(arrayPersonas);
                case 3 -> taller.numeroDeChapistas(arrayPersonas);
                case 4 -> taller.numeroDeElectricistas(arrayPersonas);
                case 5 -> taller.numeroJefeTaller(arrayPersonas);
                case 6 -> taller.numeroNavajasSuizas(arrayPersonas);
                case 7 -> taller.informeDeNominas();
                case 8 -> {
                    System.out.println("Es una lastima que te vayas, nos vemos a la próxima");
                    salir = true;
                }
            }
        } while (!salir);
    }
}

