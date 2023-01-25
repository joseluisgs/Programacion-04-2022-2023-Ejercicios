package org.example.models;

public abstract class Persona {
    protected String nombre;

    protected Persona(String nombre) {
        this.nombre = nombre;
    }

    public abstract void Respirar();

    public abstract String getNombre();
}
