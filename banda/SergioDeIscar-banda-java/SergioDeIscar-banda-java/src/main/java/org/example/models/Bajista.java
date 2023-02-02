package org.example.models;

import org.example.interfaces.IBajista;

public final class Bajista extends Musician implements IBajista {
    private final Float salario = super.salario * 1.3f;
    private int numeroCuerdas;

    public Bajista(String nombre, int experiencia, int numeroCuerdas) {
        super(nombre, experiencia);
        setNumeroCuerdas(numeroCuerdas);
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    @Override
    public void setNumeroCuerdas(int numeroCuerdas) {
        this.numeroCuerdas = numeroCuerdas;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
