package models;

public class Chapista extends Trabajador implements iChapista{

    private final int aniosExp;
    private final String nombre;
    private final int horasDiarias;

    public Chapista(String nombre, int aniosExp, int horasDiarias) {
        super(nombre, aniosExp, horasDiarias);
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.horasDiarias = horasDiarias;
    }


    @Override
    public String toString() {
        return "Chapista (" +nombre+" con " + aniosExp +"años de experiencia trabaja" + horasDiarias + "horas al dia)";

    }

    @Override
    public void arreglarChapa(){
        System.out.println("Chapista: Estoy arreglando chapa");

    }

}
