package models;

public class NavajaSuiza extends Trabajador implements iChapista, iElectricista{
    String nombre;
    int aniosExp;
    int horasDiarias;

    public NavajaSuiza(String nombre, int aniosExp, int horasDiarias) {
        super(nombre, aniosExp, horasDiarias);
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.horasDiarias = horasDiarias;
    }

    @Override
    void saludar() {
        System.out.println("Navaja Suiza: Hola! Me llamo " + nombre +" y soy una navaja suiza");
    }

    @Override
    public void arreglarChapa() {
        System.out.println("Navaja Suiza: Estoy arreglando la chapa");
    }

    @Override
    public void arreglarElectricidad() {
        System.out.println("Navaja Suiza: Estoy arreglando los circuitos eléctricos");
    }



    @Override
    public String toString(){
        return "Navaja Suiza (" +nombre+" con " + aniosExp +"años de experiencia trabaja "+ horasDiarias+ " al día)";
    }

}
