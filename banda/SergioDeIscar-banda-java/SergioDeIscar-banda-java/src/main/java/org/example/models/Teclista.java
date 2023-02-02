package org.example.models;

import org.example.interfaces.ITeclista;

public final class Teclista extends Musician implements ITeclista {
    private int cantidadTeclados;
    private final float salario = super.salario * 1.3f;
    public Teclista(String nombre, int experiencia, int cantidadTeclados) {
        super(nombre, experiencia);
        setCantidadTeclados(cantidadTeclados);
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
        System.out.println("El teclista " + nombre + " toca el piano, cantidad de teclados = " + cantidadTeclados);
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
