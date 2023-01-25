package org.example.models;

public class Electricista extends Trabajador{
    public Electricista(String nombre, int experiencia, int horasDiarias) {
        super(nombre, experiencia, horasDiarias);
    }

    int salario = 1800;

    @Override
    public void comer() {
        System.out.println("El trabajador chapista " + nombre + " come.");
    }

    @Override
    public int getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Electricista -> Nombre: " + nombre + ", Experiencia: " + experiencia + ", Horas diarias: " + horasDiarias + ", Salario: " + salario;
    }
}
