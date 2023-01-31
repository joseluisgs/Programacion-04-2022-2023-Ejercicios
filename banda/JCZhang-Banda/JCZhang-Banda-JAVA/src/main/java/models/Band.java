package models;

import factories.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Band {
    static int maxArraySize = 50;
    public Scanner sc = new Scanner(System.in);

    Person[] bandArray = new Person[maxArraySize];
    static boolean exit = false;

    public void startProgram() {
        fillArray(bandArray);
    }

    public void Menu() {
        do {
            System.out.println("***BIENVENIDO A LA BANDA***");

            switch (selectOption()) {
                case 1 -> numberOfGuitarists(bandArray);
                case 2 -> numberOfPianists(bandArray);
                case 3 -> numberOfSingers(bandArray);
                case 4 -> numberOfMultiInstrumentalists(bandArray);
                case 5 -> numberOfTrumpeters(bandArray);
                case 6 -> numberOfBassGuitarists(bandArray);
                case 7 -> numberOfSingerGutarists(bandArray);
                case 8 -> numberOfPercussionists(bandArray);
                case 9 -> salaryReport();
                case 10 -> exit = true;
            }
        } while (!exit);
    }

    public int selectOption() {
        System.out.println(" - 1 -> Número de Guitarristas");
        System.out.println(" - 2 -> Número de Pianistas");
        System.out.println(" - 3 -> Número de Cantantes");
        System.out.println(" - 4 -> Número de MultiInstrumentalistas");
        System.out.println(" - 5 -> Número de Trompetistas");
        System.out.println(" - 6 -> Número de Bajistas");
        System.out.println(" - 7 -> Número de CantanteGuitarristas");
        System.out.println(" - 8 -> Número de Percusionistas");
        System.out.println(" - 9 -> Informe de Nóminas");
        System.out.println(" - 10 -> Salir");
        System.out.println();
        String regex = ("[0-9]+");
        String option;
        do {
            System.out.println("Introduce la opción que desees: ");
            option = sc.nextLine();
            if (!option.matches(regex) || parseInt(option) < 1 || parseInt(option) > 10) {
                System.out.println("DEBES INTRODUCIR UN NÚMERO ENTRE 1 y 10");
            } else {
                return parseInt(option);
            }
        } while (!option.matches(regex) || parseInt(option) < 1 || parseInt(option) > 10);
        return 0;
    }

    public void fillArray(Person[] BandArray) {

        int peopleCount;

        do {
            peopleCount = 0;
            // variable auxiliar que sirve para hacer los porcentajes de probabilidad
            int aux;
            for (int i = 0; i < BandArray.length; i++) {
                aux = (int) (Math.random() * 100) + 1;
                if (aux >= 1 && aux <= 5) {
                    BandArray[i] = TrumpeterFactory.createRandomTrumpeter();
                }
                if (aux >= 6 && aux <= 25) {
                    BandArray[i] = SingerFactory.createRandomSinger();
                }
                if (aux >= 26 && aux <= 45) {
                    BandArray[i] = GuitaristFactory.createRandomGuitarist();
                }
                if (aux >= 46 && aux <= 55) {
                    BandArray[i] = BassGuitaristFactory.createRandomBassGuitarist();
                }
                if (aux >= 56 && aux <= 65) {
                    BandArray[i] = PianistFactory.createRandomPianist();
                }
                if (aux >= 66 && aux <= 80) {
                    BandArray[i] = PercussionistFactory.createRandomPercussionist();
                }
                if (aux >= 81 && aux <= 95) {
                    BandArray[i] = SingerGuitaristFactory.createRandomSingerGuitarist();
                }
                if (aux >= 96 && aux <= 100) {
                    BandArray[i] = MultiInstrumentalistFactory.createRandomMultiInstrumentalist();
                }
                peopleCount++;
            }
        } while (peopleCount < maxArraySize);

    }

    public static int numberOfTrumpeters(Person[] bandArray) {
        int numberOfTrumpeters = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof Trumpeter) {
                numberOfTrumpeters++;
            }
        }
        System.out.println("El número de Trompetistas que hay es de " + numberOfTrumpeters);
        return numberOfTrumpeters;
    }


    public static int numberOfGuitarists(@NotNull Person[] bandArray) {
        int numberOfGuitarists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof Guitarist) {
                numberOfGuitarists++;
            }
        }
        System.out.println("El número de Guitarristas que hay es de " + numberOfGuitarists);
        return numberOfGuitarists;
    }

    public static int numberOfBassGuitarists(Person[] bandArray) {
        int numberOfBassGuitarists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof BassGuitarist) {
                numberOfBassGuitarists++;
            }
        }
        System.out.println("El número de Bajistas que hay es de " + numberOfBassGuitarists);
        return numberOfBassGuitarists;
    }

    public static int numberOfPianists(Person[] bandArray) {
        int numberOfPianists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof Pianist) {
                numberOfPianists++;
            }
        }
        System.out.println("El número de Pianistas que hay es de " + numberOfPianists);
        return numberOfPianists;
    }


    public static int numberOfPercussionists(Person[] bandArray) {
        int numberOfPercussionists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof Percussionist) {
                numberOfPercussionists++;
            }
        }
        System.out.println("El número de Percusionistas que hay es de " + numberOfPercussionists);
        return numberOfPercussionists;
    }

    public static int numberOfSingerGutarists(Person[] bandArray) {
        int numberOfSingerGutarists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof SingerGuitarist) {
                numberOfSingerGutarists++;
            }
        }
        System.out.println("El número de CantantesGuitarristas que hay es de " + numberOfSingerGutarists);
        return numberOfSingerGutarists;
    }

    public static int numberOfMultiInstrumentalists(Person[] bandArray) {
        int numberOfMultiInstrumentalists = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof MultiInstrumentalist) {
                numberOfMultiInstrumentalists++;
            }
        }
        System.out.println("El número de MultiInstrumentalistas que hay es de " + numberOfMultiInstrumentalists);
        return numberOfMultiInstrumentalists;
    }

    public static int numberOfSingers(Person[] bandArray) {
        int numberOfSingers = 0;
        for (int i = 0; i < bandArray.length; i++) {
            if (bandArray[i] instanceof Singer) {
                numberOfSingers++;
            }
        }
        System.out.println("El número de Cantantes que hay es de " + numberOfSingers);
        return numberOfSingers;
    }

    public static double calculateTrumpeterSalary() {
        return Math.round(Trumpeter.salary * TrumpeterFactory.counter*100)/100.0;
    }

    public static double calculateGuitaristSalary() {
        return Math.round(Guitarist.salary * GuitaristFactory.counter*100)/100.0;
    }

    public static double calculatePianistSalary() {
        return Math.round(Pianist.salary * PianistFactory.counter*100)/100.0;
    }

    public static double calculatePercussionistSalary() {
        return Math.round(Percussionist.salary * PercussionistFactory.counter*100)/100.0;
    }

    public static double calculateSingerSalary() {
        return Math.round(Singer.salary * SingerFactory.counter*100)/100.0;
    }

    public static double calculateMultiInstrumentalistSalary() {
        return  Math.round((MultiInstrumentalist.salary * MultiInstrumentalistFactory.counter*100)/100.0) ;
    }

    public static double calculateSingerGutaristSalary() {
        return Math.round(SingerGuitarist.salary * SingerGuitaristFactory.counter *100)/100.0;
    }

    public static double calculateBassGuitaristSalary() {
        return Math.round(BassGuitarist.salary * BassGuitaristFactory.counter*100)/100.0;
    }

    public void salaryReport() {
        System.out.println("***INFORME DE SALARIOS***");
        System.out.println();
        System.out.println("El salario que han cobrado los Bajistas es de " + calculateBassGuitaristSalary() + " €");
        System.out.println("El salario que han cobrado los Guitarristas es de " + calculateGuitaristSalary() + " €");
        System.out.println("El salario que han cobrado los Cantantes es de " + calculateSingerSalary() + " €");
        System.out.println("El salario que han cobrado los MultiInstrumentalistas es de " + calculateMultiInstrumentalistSalary() + " €");
        System.out.println("El salario que han cobrado los Pianistas es de " + calculatePianistSalary() + " €");
        System.out.println("El salario que han cobrado los Percusionistas es de " + calculatePercussionistSalary() + " €");
        System.out.println("El salario que han cobrado los Trompetistas es de " + calculateTrumpeterSalary() + " €");
        System.out.println("El salario que han cobrado los CantanteGuitarristas es de " + calculateSingerGutaristSalary() + " €");
        System.out.println();
        System.out.println("Se ha gastando un total de "+
                Math.round(
                + calculateSingerGutaristSalary()
                + calculateMultiInstrumentalistSalary()
                + calculateTrumpeterSalary()
                + calculateBassGuitaristSalary()
                + calculatePercussionistSalary()
                + calculatePianistSalary()
                + calculateSingerSalary()
                + calculateGuitaristSalary()*100)/100.0 + " €");

    }
}

















