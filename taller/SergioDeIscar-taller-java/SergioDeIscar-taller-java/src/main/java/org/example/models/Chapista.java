package org.example.models;

public final class Chapista extends Trabajador{
    public Chapista(String nombre, int experiencia, int horasDiarias) {
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

    public void arreglarChapa(){
        System.out.println("El chapista " + nombre + " esta arreglando la chapa.");
    }
}
