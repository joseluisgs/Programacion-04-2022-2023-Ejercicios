package org.example.factories;

import org.example.enums.GuitarraType;
import org.example.enums.PercussionType;
import org.example.enums.TonoType;
import org.example.models.*;

import java.util.Arrays;

public class MusicianFactory {
    private static MusicianFactory persona;

    public static MusicianFactory getInstance() {
        if (persona == null) {
            persona = new MusicianFactory();
        }
        return persona;
    }

    private String getNombreRandom(){
        String[] names = {"Pepe", "Juan", "Ana", "Pedro", "María"};
        return names[(int)(Math.random() * names.length)];
    }

    private TonoType getTonoRandom(){
        return TonoType.values()[(int)(Math.random() * TonoType.values().length)];
    }

    private GuitarraType getGuitarraRandom(){
        return GuitarraType.values()[(int)(Math.random() * GuitarraType.values().length)];
    }

    private PercussionType getPercussionRandom(){
        return PercussionType.values()[(int)(Math.random() * PercussionType.values().length)];
    }


    public Musician[] getBandaRandom(int[] porcentajes){
        if (porcentajes == null){
            porcentajes = new int[] {20, 10, 10, 10, 15, 15, 15, 5};
        }
        if (porcentajes.length != 8) throw new IllegalArgumentException("Error: porcentajes ha de tener un tamaño de 8");
        for (var item : porcentajes){
            if (item == 0)
                throw new IllegalArgumentException("Error: ninguno valor de porcentajes puede sr menor o igual a 0");
        }
        if (Arrays.stream(porcentajes).sum() != 100)
            throw new IllegalArgumentException("Error: la suma de todos los valores de porcentajes a de ser igual a 100");

        int[] values = new int[]{
                porcentajes[0],
                porcentajes[0] + porcentajes[1],
                porcentajes[0] + porcentajes[1] + porcentajes[2],
                porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3],
                porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4],
                porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4] + porcentajes[5],
                porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] + porcentajes[4] + porcentajes[5] + porcentajes[6]
        };

        // val banda = Array<Musician>(50){Cantante("", 2, TonoType.BAJO)}
        Musician[] banda = new Musician[50];

        for (int i = 0; i < banda.length; i++){
            String nombre = getNombreRandom();
            int experiencia = (int)(Math.random() * 40);
            int rdn = (int) (Math.random() * 100);
            if (rdn > 0 && rdn < values[0])
            {
                banda[i] = new Cantante(nombre, experiencia, getTonoRandom());
            }else if (rdn > values[0] && rdn < values[1])
            {
                banda[i] = new Guitarrista(nombre, experiencia, getGuitarraRandom());
            }else if (rdn > values[1] && rdn < values[2])
            {
                banda[i] = new Bajista(nombre, experiencia, (int)(Math.random() * 47));
            }else if (rdn > values[2] && rdn < values[3])
            {
                banda[i] = new Teclista(nombre, experiencia, (int)(Math.random() * 10));
            }else if (rdn > values[3] && rdn < values[4])
            {
                banda[i] = new Percusionista(nombre, experiencia, getPercussionRandom());
            }else if (rdn > values[4] && rdn < values[5])
            {
                banda[i] = new Trompetista(nombre, experiencia, (int)(Math.random() * 25));
            }else if (rdn > values[5] && rdn < values[6])
            {
                banda[i] = new CantanteGuitarrista(nombre, experiencia, getTonoRandom(), getGuitarraRandom());
            }else {
                banda[i] = new Multinstrumentista(nombre, experiencia, (int)(Math.random() * 10), getPercussionRandom(), (int)(Math.random() * 10));
            }
        }
        return banda;
    }
}
