package modelsBandaMusicos;

public class Multinstrumental extends Musico implements IBajista, ITeclista, IPercusionista{

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    int numeroCuerdas;
    int cantidadTeclas;
    tipoPercusion tipoDePercusion;

    public Multinstrumental(String nombre, int añosExperiencia, int numeroCuerdas, int cantidadTeclas, tipoPercusion tipoDePercusion) {
        super(nombre, añosExperiencia);
        this.numeroCuerdas = numeroCuerdas;
        this.cantidadTeclas = cantidadTeclas;
        this.tipoDePercusion = tipoDePercusion;
    }

    public int getNumeroCuerdas() {
        return 0;
    }

    public double recalcularSalario(double salario) {
        return IBajista.super.recalcularSalario(salario);
    }

    public tipoPercusion getTipoDePercusion() {
        return tipoDePercusion;
    }

    public int getCantidadTeclas() {
        return cantidadTeclas;
    }

    @Override
    public Double recalcularSalario(Double salario){
        Double incremento = 1.5;
        return (salario*incremento);
    }
}
