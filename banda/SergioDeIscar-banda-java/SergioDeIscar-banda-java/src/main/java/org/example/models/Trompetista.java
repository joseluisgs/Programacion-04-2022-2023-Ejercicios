package org.example.models;

import org.example.interfaces.ITrompetista;

public final class Trompetista extends Musician implements ITrompetista {
    private int capacidadPulmonar;
    private final float salario = super.salario * 1.2f;
    public Trompetista(String nombre, int experiencia, int capacidadPulmonar) {
        super(nombre, experiencia);
        setCapacidadPulmonar(capacidadPulmonar);
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public int getCapacidadPulmonar() {
        return capacidadPulmonar;
    }

    @Override
    public void setCapacidadPulmonar(int capacidadPulmonar) {
        this.capacidadPulmonar = capacidadPulmonar;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
