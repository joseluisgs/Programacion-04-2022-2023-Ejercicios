package FactorySalaDeCine;

import ModelsSalaDeCine.butaca;

public class FactoryButaca {

    public FactoryButaca(){}
    private static FactoryButaca instance = null;

    public static FactoryButaca getInstance(){
        if(instance == null){
            instance = new FactoryButaca();
        }
        return instance;
    }

    /**
     * función que sirve para crear y devolver una butaca
     * @param identificador es la combinación de fila y columna única de la butaca
     * @param estado es el estado de la butaca, puede ser libre, reservado, o ocupado
     * @return la butaca creada según los parametros introducidos
     */
    public butaca create(String identificador, String estado){
        return new butaca(identificador, estado);
    }
}
