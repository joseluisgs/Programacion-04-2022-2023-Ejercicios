package FactoriesCesta;

import ModelsCesta.Cesta;
import ModelsCesta.ListaCesta;

import java.time.LocalDate;

public class FactoryCesta {

    public FactoryCesta(){}
    private static FactoryCesta instance = null;

    public static FactoryCesta getInstance(){
        if(instance == null){
            instance = new FactoryCesta();
        }
        return instance;
    }
    private static int contadorCesta = 1;
    private int nextId(){
        return contadorCesta++;
    }

    /**
     * función que srive para crear una cesta random
     * @return la cesta creada aleatoriamente
     */
    public Cesta crearCestaRandom() {
        String[] fechas = {"2023-12-03", "2003-02-23", "2023-12-03", "2023-12-03", "2023-12-03", "2023-12-03", "2023-12-03"};
        return new Cesta(nextId(), LocalDate.parse(fechas[(int) (Math.random()*fechas.length)]), FactoryUsuario.getInstance().crearUsuarioRandom(), new ListaCesta());
    }
}
