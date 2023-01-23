package FactoriesAparcamiento;

import ModelsAparcamiento.Conductor;

public class FactoryConductor {

    public FactoryConductor(){}
    private static FactoryConductor instance = null;

    public static FactoryConductor getInstance(){
        if(instance == null){
            instance = new FactoryConductor();
        }
        return instance;
    }

    /**
     * función que sirve para crear el objeto conductor
     * @param nombre el nombre con el que se creará el conductor
     * @param dni el dni con el que se creará el conductor
     * @return el objeto conductor creado a traves de los valores por parametros
     */
    public Conductor create(String nombre, String dni){
        return new Conductor( nombre, dni );
    }

    /**
     * función que sirve para crear un conductor con datos aleatorios
     * @return el conductor creado con datos aleatorios
     */
    public Conductor createRandom(){
        String[] nombres = {"Jorge", "Iván", "Ramón", "Roberto", "Martina"};
        String[] dnis = {"53749873M", "64536475J", "75534869J", "87264953H", "75026584M"};
        return new Conductor(nombres[(int) (Math.random()*nombres.length)], dnis[(int) (Math.random()* dnis.length)]);
    }
}
