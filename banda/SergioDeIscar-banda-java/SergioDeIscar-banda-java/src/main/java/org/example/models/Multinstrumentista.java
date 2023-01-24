package org.example.models;

import org.example.enums.PercussionType;
import org.example.interfaces.IBajista;
import org.example.interfaces.IPercusionista;
import org.example.interfaces.ITeclista;

public final class Multinstrumentista extends Musician implements IBajista, ITeclista, IPercusionista {
    private final float salario = super.salario * 1.5f;
    private int numeroCuerdas;
    private PercussionType percussionType;
    private int cantidadTeclados;

    public Multinstrumentista(String nombre, int experiencia, int numeroCuerdas, PercussionType percussionType, int cantidadTeclados) {
        super(nombre, experiencia);
        setNumeroCuerdas(numeroCuerdas);
        setPercussionType(percussionType);
        setCantidadTeclados(cantidadTeclados);
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
    public PercussionType getPercussionType() {
        return percussionType;
    }

    @Override
    public void setPercussionType(PercussionType percussionType) {
        this.percussionType = percussionType;
    }

    @Override
    public int getCantidadTeclados() {
        return cantidadTeclados;
    }

    @Override
    public void setCantidadTeclados(int cantidadTeclados) {
        this.cantidadTeclados = cantidadTeclados;
    }

    @Override
    public void tocarPiano() {
        System.out.println("El multinstrumentalista " + nombre + " toca el piano, cantidad de teclados = " + cantidadTeclados);
    }

    @Override
    public float getSalario() {
        return salario;
    }
}
