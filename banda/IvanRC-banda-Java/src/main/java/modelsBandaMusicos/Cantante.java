package modelsBandaMusicos;

public class Cantante extends Musico implements ICantante {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    String tono;

    public Cantante(String nombre, int añosExperiencia, String tono) {
        super(nombre, añosExperiencia);
        this.tono = tono;

    }

    public String getTono() {
        return tono;
    }

    public double recalcularSalario(double salario) {
        return ICantante.super.recalcularSalario(salario);
    }
}
