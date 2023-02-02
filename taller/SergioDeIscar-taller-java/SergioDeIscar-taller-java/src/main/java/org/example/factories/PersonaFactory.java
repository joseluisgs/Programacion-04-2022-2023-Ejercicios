package org.example.factories;

import org.example.models.*;

public class PersonaFactory {
    private static PersonaFactory persona;

    public static PersonaFactory getInstance() {
        if (persona == null) {
            persona = new PersonaFactory();
        }
        return persona;
    }

    public Trabajador getRandomTrabajador(int chapiPro, int electPro) {
        checkInputPro(chapiPro, electPro);

        int random = (int) (Math.random() * 100);
        if (random < chapiPro) {
            return new Chapista(randomNombre(), (int) (Math.random() * 25), (int) (Math.random() * 7) + 6);
        }
        return new Electricista(randomNombre(), (int) (Math.random() * 25), (int) (Math.random() * 7) + 6);
    }

    private static void checkInputPro(int chapiPro, int electPro) {
        if (chapiPro < 0 || chapiPro > 100) {
            throw new IllegalArgumentException("La probabilidad de chapista ha de estar entre 0-100");
        }
        if (electPro < 0 || electPro > 100) {
            throw new IllegalArgumentException("La probabilidad de electricista ha de estar entre 0-100");
        }
        if (electPro + chapiPro != 100) {
            throw new IllegalArgumentException("La probabilidad de chapista + electricista ha de dar 100");
        }
    }

    public Persona[] getRandomTallerCompleto(int chapiPro, int electPro) {
        checkInputPro(chapiPro, electPro);

        Persona[] personas = new Persona[50];
        int count = 0;
        do {
            int experiencia = (int) (Math.random() * 25);
            int countTrabajadores;
            if (experiencia <= 5) {
                countTrabajadores = 5;
            } else if (experiencia <= 15) {
                countTrabajadores = 15;
            } else {
                countTrabajadores = 25;
            }
            if (countTrabajadores + count + 1 > 50) {
                countTrabajadores = countTrabajadores + count - 1 - 50;
            }
            JefeTaller jefe = new JefeTaller(randomNombre(), experiencia, countTrabajadores);
            for (int i = 0; i < countTrabajadores; i++) {
                Trabajador trabajador = getRandomTrabajador(chapiPro, electPro);
                addPersona(trabajador, personas);
                jefe.addTrabajador(trabajador);
            }
            addPersona(jefe, personas);
            count++; //Jefe
            count += countTrabajadores;
        } while (count < 50);
        return personas;
    }

    private void addPersona(Persona persona, Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = persona;
                return;
            }
        }
    }

    private String randomNombre() {
        String[] nombres = {"Pedro", "Juan", "Ana", "Daniel", "Lucía"};
        return nombres[(int) (Math.random() * nombres.length)];
    }
}
