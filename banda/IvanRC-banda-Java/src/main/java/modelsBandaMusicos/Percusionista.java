package modelsBandaMusicos;

public class Percusionista extends Musico implements IPercusionista {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    tipoPercusion tipoDePercusion;

    public Percusionista(String nombre, int añosExperiencia, tipoPercusion tipoDePercusion) {
        super(nombre, añosExperiencia);
        this.tipoDePercusion = tipoDePercusion;
    }

    public tipoPercusion getTipoDePercusion() {
        return tipoDePercusion;
    }

    public double recalcularSalario(double salario) {
        return IPercusionista.super.recalcularSalario(salario);
    }
}
