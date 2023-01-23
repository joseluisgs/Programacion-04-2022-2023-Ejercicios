package models;

public abstract class Persona {


    public Persona(int id, String nombre, int aniosExp) {
        this.id = nextId();
        this.nombre = nombre;
        this.aniosExp = aniosExp;

    }
    int id;
    String nombre;
    int aniosExp;

    protected Persona() {
    }

    public int nextId() {
        int id = 0;
        return id++;
    }
    abstract void saludar ();
}