package org.example.models;

public abstract class Musician extends Persona{
    protected float salario = 1500.0f;
    protected int experiencia;
    protected Musician(String nombre, int experiencia) {
        super(nombre);
        this.experiencia = experiencia;
    }

    public abstract float getSalario();

    void interpretar() {
        System.out.println("El musico " + nombre + " esta interpretando");
    }

    @Override
    void Respirar() {
        System.out.println("El musico " + nombre + " esta respirando");
    }
}
