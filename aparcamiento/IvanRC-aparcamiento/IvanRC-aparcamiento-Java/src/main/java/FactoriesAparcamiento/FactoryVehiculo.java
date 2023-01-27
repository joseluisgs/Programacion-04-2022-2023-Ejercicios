package FactoriesAparcamiento;

import ModelsAparcamiento.Conductor;
import ModelsAparcamiento.Vehiculo;
import ModelsAparcamiento.tipoVehiculo;

public class FactoryVehiculo {

    public FactoryVehiculo(){}
    private static FactoryVehiculo instance = null;

    public static FactoryVehiculo getInstance(){
        if(instance == null){
            instance = new FactoryVehiculo();
        }
        return instance;
    }

    /**
     * función que sirve para crear el objeto vehiculo
     * @param matricula la matricula con la que se creará el vehiculo
     * @param añoFabricacion el año de fabircacion con el que se creará el vehiculo
     * @param tipo el tipo con el que se creará el vehiculo
     * @param conductor el conductor con el que se creará el vehiculo
     * @return el objeto vehiculo creado a traves de los valores por parametros
     */
    public Vehiculo create(String matricula, int añoFabricacion, tipoVehiculo tipo, Conductor conductor){
        return new Vehiculo( matricula, añoFabricacion, tipo, conductor);
    }

    /**
     * función que sirve para crear un vehículo con datos aleatorios
     * @return el vehículo generado aleatoriamente
     */
    public Vehiculo createRandom(){
        String[] matriculas = {"5463-HGR", "4673-DEF", "4673-GED", "8495-GRE", "7684-ASD"};
        int añoFabricacion = (int) (Math.random()*2023);
        tipoVehiculo tipo = tipoVehiculo.values()[(int) (Math.random()*tipoVehiculo.values().length)];
        return new Vehiculo( matriculas[(int) (Math.random()*matriculas.length)], añoFabricacion, tipo, FactoryConductor.getInstance().createRandom());
    }
}
