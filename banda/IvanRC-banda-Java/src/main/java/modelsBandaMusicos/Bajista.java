package modelsBandaMusicos;

public class Bajista extends Musico implements IBajista{
    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    int numeroCuerdas;

    public Bajista(String nombre, int añosExperiencia, int numeroCuerdas){
        super(nombre, añosExperiencia);
        this.numeroCuerdas = numeroCuerdas;
    }

    public double recalcularSalario(double salario) {
        return IBajista.super.recalcularSalario(salario);
    }

    public int getNumeroCuerdas() {
        return 0;
    }
}
