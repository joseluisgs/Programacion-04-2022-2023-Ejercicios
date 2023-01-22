package modelsBandaMusicos;

public class Teclista extends Musico implements ITeclista {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    int cantidadTeclas;

    public Teclista(String nombre, int añosExperiencia, int cantidadTeclas) {
        super(nombre, añosExperiencia);
        this.cantidadTeclas = cantidadTeclas;
    }

    public int getCantidadTeclas() {
        return cantidadTeclas;
    }

    public double recalcularSalario(double salario) {
        return ITeclista.super.recalcularSalario(salario);
    }
}
