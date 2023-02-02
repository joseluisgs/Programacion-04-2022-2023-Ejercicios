package org.example;

import org.example.factories.MusicianFactory;
import org.example.models.*;

public class BandaMain {
    public static void main(String[] args) {
        Musician[] bandaRandom = MusicianFactory.getInstance().getBandaRandom(null);
        System.out.println("---------------------");
        System.out.println("Simulador de banda con 50 músicos:");
        System.out.println("---------------------");
        System.out.println("Número de músicos: " + countType(bandaRandom, Musician.class));
        System.out.println("\t-> Número de cantantes: " + countType(bandaRandom, Cantante.class));
        System.out.println("\t-> Número de guitarrista: " + countType(bandaRandom, Guitarrista.class));
        System.out.println("\t-> Número de bajista: " + countType(bandaRandom, Bajista.class));
        System.out.println("\t-> Número de teclista: " + countType(bandaRandom, Teclista.class));
        System.out.println("\t-> Número de percusionista: " + countType(bandaRandom, Percusionista.class));
        System.out.println("\t-> Número de trompetista: " + countType(bandaRandom, Trompetista.class));
        System.out.println("\t-> Número de cantanteGuitarrista: " + countType(bandaRandom, CantanteGuitarrista.class));
        System.out.println("\t-> Número de multinstrimentalista: " + countType(bandaRandom, Multinstrumentista.class));
        System.out.println("---------------------");
        System.out.println("Nomina total de la banda " + calculateNomina(bandaRandom) + "€");
        System.out.println("---------------------");
        ((Multinstrumentista) findFirstType(bandaRandom, Multinstrumentista.class)).tocarPiano();
        System.out.println("---------------------");
        ((Teclista) findFirstType(bandaRandom, Teclista.class)).tocarPiano();
        System.out.println("---------------------");
        ((Cantante) findFirstType(bandaRandom, Cantante.class)).cantar();
        System.out.println("---------------------");
        CantanteGuitarrista cantanteGuitarrista = (CantanteGuitarrista) findFirstType(bandaRandom, CantanteGuitarrista.class);
        cantanteGuitarrista.cantar();
        cantanteGuitarrista.guitarrear();
        System.out.println("---------------------");
    }

    public static float calculateNomina(Musician[] personas) {
        float total = 0;
        for (Musician i : personas) {
            total += i != null ? i.getSalario() : 0.0f;
        }
        return total;
    }

    // No son genéricos, pero hacen la misma funcionalidad, no me funcionaban con genéricos
    public static int countType(Musician[] personas, Class countClass) {
        int count = 0;
        for (Musician i : personas) {
            if (countClass.isInstance(i)) {
                count++;
            }
        }
        return count;
    }

    public static Musician findFirstType(Musician[] personas, Class findClass) {
        for (Musician persona : personas) {
            if (findClass.isInstance(persona)) {
                return persona;
            }
        }
        return null;
    }
}