package models;

public class Trabajador extends Persona {

    String nombre;
    int aniosExp;
    int horasDiarias;

    public Trabajador(String nombre, int aniosExp, int horasDiarias) {
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.horasDiarias = horasDiarias;
    }


    @Override
    void saludar() {
        System.out.println("Trabajador: Hola! Me llamo "+ nombre+ " y soy un humilde trabajador");
    }

    public void trabajar(){
        System.out.println("Trabajador: Hola soy $nombre y estoy trabajando");
    }

    public void descansar(){
        System.out.println("Trabajador: Hola soy $nombre estoy descansando");
    }

    public void comer(){}

    @Override
    public String toString() {
        return "Trabajador (" +nombre+" con " + aniosExp +"años de experiencia trabaja " + horasDiarias + "horas al dia)";

    }
}

