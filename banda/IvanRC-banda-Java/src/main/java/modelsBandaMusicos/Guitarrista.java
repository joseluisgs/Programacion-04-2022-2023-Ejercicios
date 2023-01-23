package modelsBandaMusicos;

public class Guitarrista extends Musico implements IGuitarrista {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    tipoGuitarra tipoDeGuitarra;

    public Guitarrista(String nombre, int añosExperiencia, tipoGuitarra tipoDeGuitarra) {
        super(nombre, añosExperiencia);
        this.tipoDeGuitarra = tipoDeGuitarra;
    }

    public tipoGuitarra getTipoDeGuitarra() {
        return tipoDeGuitarra;
    }

    public double recalcularSalario(double salario) {
        return IGuitarrista.super.recalcularSalario(salario);
    }
}
