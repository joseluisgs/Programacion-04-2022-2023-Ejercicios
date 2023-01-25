package org.example.models;

import org.example.enums.TonoType;
import org.example.interfaces.ICantante;

public final class Cantante extends Musician implements ICantante {
    private TonoType tonoType;
    private final Float salario = super.salario * 1.4f;

    public Cantante(String nombre, int experiencia, TonoType tono) {
        super(nombre, experiencia);
        setTono(tono);
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public TonoType getTono() {
        return tonoType;
    }

    @Override
    public void setTono(TonoType tono) {
        tonoType = tono;
    }

    @Override
    public void cantar() {
        System.out.println("El cantante " + nombre + " esta cantando");
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
