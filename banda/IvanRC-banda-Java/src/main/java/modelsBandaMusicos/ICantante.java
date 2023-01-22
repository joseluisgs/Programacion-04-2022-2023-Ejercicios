package modelsBandaMusicos;

public interface ICantante {

    public void respirar();
    String tono = "";

    /**
     * función que sirve para recalcular el salario base del músico según su especialización
     * @param salario es el salario base a recalcular
     * @return el salario recalculado según la ocupación
     */
    public default Double recalcularSalario(Double salario){
        Double incremento = 1.4;
        return (salario*incremento);
    }
}
