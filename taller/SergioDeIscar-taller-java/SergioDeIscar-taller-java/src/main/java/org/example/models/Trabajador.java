package org.example.models;

public abstract class Trabajador extends Persona{
    public Trabajador(String nombre, int experiencia, int horasDiarias){
        super(nombre, experiencia);
        setHorasDiarias(horasDiarias);
    }

    int salario = 1800;

    protected int horasDiarias;

    @Override
    void saludar() {
        System.out.println("Trabajador " + nombre + " saluda con respeto.");
    }

    public void descansar(){
        System.out.println("El trabajador " + nombre + " descansa, con un horario de " + horasDiarias + " horas.");
    }

    abstract void comer();

    //region Getter
    int getHorasDiarias(){
        return horasDiarias;
    }
    //endregion

    //region Setter
    private void setHorasDiarias(int horasDiarias){
        if (horasDiarias < 0 || horasDiarias > 13) return;
        this.horasDiarias = horasDiarias;
    }
    //endregion
}
