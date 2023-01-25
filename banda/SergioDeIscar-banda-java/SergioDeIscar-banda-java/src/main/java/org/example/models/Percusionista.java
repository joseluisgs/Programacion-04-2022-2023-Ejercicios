package org.example.models;

import org.example.enums.PercussionType;
import org.example.interfaces.IPercusionista;

public final class Percusionista extends Musician implements IPercusionista {
    private final Float salario = super.salario * 1.35f;
    private PercussionType percussionType;
    public Percusionista(String nombre, int experiencia, PercussionType percussionType) {
        super(nombre, experiencia);
        setPercussionType(percussionType);
    }

    @Override
    public PercussionType getPercussionType() {
        return percussionType;
    }

    @Override
    public void setPercussionType(PercussionType percussionType) {
        this.percussionType = percussionType;
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
