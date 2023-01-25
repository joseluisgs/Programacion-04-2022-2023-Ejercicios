package org.example;

import org.example.factories.PersonaFactory;
import org.example.models.*;

import java.lang.reflect.Type;

public class TallerMain {
    public static void main(String[] args){
        Persona[] personas = PersonaFactory.getInstance().getRandomTallerCompleto(30, 70);
        System.out.println("---------------------");
        System.out.println("Simulador de taller con 50 trabajadores:");
        System.out.println("---------------------");
        System.out.println("Número de personas: " + countType(personas, Persona.class));
        System.out.println("Número de jefes: " + countType(personas, JefeTaller.class));
        System.out.println("Número de trabajadores: " + countType(personas, Trabajador.class) + " ->");
        System.out.println("\t-> Número de chapistas: " + countType(personas, Chapista.class));
        System.out.println("\t-> Número de electricistas: " + countType(personas, Electricista.class));
        System.out.println("---------------------");
        System.out.println("Nomina total del taller " + calculateNomina(personas) + "€");
        System.out.println("---------------------");
        JefeTaller primerJefe = (JefeTaller) findFirstType(personas, JefeTaller.class);
        primerJefe.darLatigazo(primerJefe.getTrabajador(0));
        System.out.println("---------------------");
        Chapista chapista = (Chapista) findFirstType(personas, Chapista.class);
        chapista.arreglarChapa();
        chapista.descansar();
        chapista.comer();
        System.out.println("---------------------");
        Electricista electricista = (Electricista) findFirstType(personas, Electricista.class);
        System.out.println(electricista);
        electricista.descansar();
        electricista.comer();
        System.out.println("---------------------");
    }

    public static int calculateNomina(Persona[] personas) {
        int total = 0;
        for (Persona i : personas) {
            total += i != null ? i.getSalario() : 0;
        }
        return total;
    }

    // No son genéricos, pero hacen la misma funcionalidad, no me funcionaban con genéricos
    public static int countType(Persona[] personas, Class countClass) {
        int count = 0;
        for (Persona i : personas) {
            if (countClass.isInstance(i)) {
                count++;
            }
        }
        return count;
    }

    public static Persona findFirstType(Persona[] personas, Class findClass) {
        for (Persona persona : personas) {
            if (findClass.isInstance(persona)) {
                return persona;
            }
        }
        return null;
    }
}
