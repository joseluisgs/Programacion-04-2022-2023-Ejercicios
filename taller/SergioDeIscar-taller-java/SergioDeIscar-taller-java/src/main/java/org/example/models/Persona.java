package org.example.models;

public abstract class Persona {
    protected int id = contador++;
    private static int contador = 0;

    protected int salario;
    protected String nombre;
    protected int experiencia;

    public Persona(String nombre, int experiencia){
        this.setNombre(nombre);
        this.setExperiencia(experiencia);
    }

    //region Getter
    public String getNombre(){
        return nombre;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public int getId() {
        return id;
    }
    public int getSalario() {
        return salario;
    }
    //endregion

    //region Setter
    public void setNombre(String nombre){
        if (nombre.isEmpty()) return;
        this.nombre = nombre;
    }
    public void setExperiencia(int experiencia){
        if (experiencia < 0) return;
        this.experiencia = experiencia;
    }
    //endregion

    abstract void saludar();
}
