package models;



public class Electricista extends Trabajador implements iElectricista {

    String nombre;
    int aniosExp;
    int horasDiarias;

    public Electricista(String nombre, int aniosExp, int horasDiarias) {
        super(nombre, aniosExp, horasDiarias);
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.horasDiarias = horasDiarias;
    }


    @Override
    public void comer() {
        System.out.println("Electricista: Hola! soy " +nombre+ " y estoy comiendo");

    }

    @Override
    public void arreglarElectricidad(){
        System.out.println("Electricista: Estoy arreglando los circuitos eléctricos");
    }

    @Override
    public String toString() {
        return "Electricista (" +nombre+" con " + aniosExp +"años de experiencia trabaja "+ horasDiarias+ " al día)";

    }

}
