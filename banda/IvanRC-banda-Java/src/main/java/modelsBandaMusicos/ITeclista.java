package modelsBandaMusicos;

public interface ITeclista {

    int cantidadTeclas = 24;

    /**
     * función que sirve para recalcular el salario base del músico según su especialización
     * @param salario es el salario base a recalcular
     * @return el salario recalculado según la ocupación
     */
    public default Double recalcularSalario(Double salario){
        Double incremento = 1.3;
        return (salario*incremento);
    }
}
