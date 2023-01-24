package org.example.models;

import org.example.interfaces.ITrompetista;

public final class Trompetista extends Musician implements ITrompetista {
    private int capacidadPulmonar;
    public Trompetista(String nombre, int experiencia, int capacidadPulmonar) {
        super(nombre, experiencia);
        setCapacidadPulmonar(capacidadPulmonar);
    }

    @Override
    public float getSalario() {
        return 0;
    }

    @Override
    public int getCapacidadPulmonar() {
        return capacidadPulmonar;
    }

    @Override
    public void setCapacidadPulmonar(int capacidadPulmonar) {
        this.capacidadPulmonar = capacidadPulmonar;
    }
}
