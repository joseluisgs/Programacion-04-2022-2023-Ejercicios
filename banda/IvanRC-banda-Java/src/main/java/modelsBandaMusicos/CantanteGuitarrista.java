package modelsBandaMusicos;

public class CantanteGuitarrista extends Musico implements ICantante, IGuitarrista {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    String tono;
    tipoGuitarra tipoDeGuitarra;

    public CantanteGuitarrista(String nombre, int añosExperiencia, String tono, tipoGuitarra tipoDeGuitarra) {
        super(nombre, añosExperiencia);
        this.tono = tono;
        this.tipoDeGuitarra = tipoDeGuitarra;
    }


    public String getTono() {
        return tono;
    }

    public Double recalcularSalario(Double salario){
        Double incremento = 1.5;
        return (salario*incremento);
    }

    public tipoGuitarra getTipoDeGuitarra() {
        return tipoDeGuitarra;
    }
}
