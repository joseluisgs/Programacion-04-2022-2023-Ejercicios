package org.example.models;

import org.example.enums.GuitarraType;
import org.example.enums.TonoType;
import org.example.interfaces.ICantante;
import org.example.interfaces.IGuitarrista;

public final class CantanteGuitarrista extends Musician implements ICantante, IGuitarrista {
    private TonoType tonoType;
    private GuitarraType guitarraType;
    private final Float salario = super.salario * 1.5f;
    public CantanteGuitarrista(String nombre, int experiencia, TonoType tono, GuitarraType guitarra) {
        super(nombre, experiencia);
        setTono(tono);
        setGuitarra(guitarra);
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
        System.out.println("El cantanteGuitarrista " + nombre + " esta cantando");
    }

    @Override
    public GuitarraType getGuitarra() {
        return guitarraType;
    }

    @Override
    public void setGuitarra(GuitarraType guitarra) {
        guitarraType = guitarra;
    }

    @Override
    public void guitarrear() {
        System.out.println("El cantanteGuitarrista " + nombre + " esta guitarreando");
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
