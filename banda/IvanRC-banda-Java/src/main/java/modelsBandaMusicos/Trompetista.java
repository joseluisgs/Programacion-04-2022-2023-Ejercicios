package modelsBandaMusicos;

public class Trompetista extends Musico {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;
    int capacidadPulmonar;

    public Trompetista(String nombre, int añosExperiencia, int capacidadPulmonar) {
        super(nombre, añosExperiencia);
        this.capacidadPulmonar = capacidadPulmonar;
    }

    @Override
    public void respirar(){
        System.out.println("Tropetista: respiro como un tromptista...");
    }

    /**
     * función que sirve para recalcular el salario base del músico según su especialización
     * @param salario es el salario base a recalcular
     * @return el salario recalculado según la ocupación
     */
    public Double recalcularSalario(Double salario){
        Double incremento = 1.2;
        return (salario*incremento);
    }
}
