package org.example.models;

import org.example.enums.GuitarraType;
import org.example.interfaces.IGuitarrista;

public final class Guitarrista extends Musician implements IGuitarrista {
    private final float salario = super.salario * 1.5f;
    private GuitarraType guitarra;
    public Guitarrista(String nombre, int experiencia, GuitarraType guitarra) {
        super(nombre, experiencia);
        setGuitarra(guitarra);
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public GuitarraType getGuitarra() {
        return guitarra;
    }

    @Override
    public void setGuitarra(GuitarraType guitarra) {
        this.guitarra = guitarra;
    }

    @Override
    public void guitarrear() {
        System.out.println("El guitarrista " + nombre + " esta guitarreando");
    }
}