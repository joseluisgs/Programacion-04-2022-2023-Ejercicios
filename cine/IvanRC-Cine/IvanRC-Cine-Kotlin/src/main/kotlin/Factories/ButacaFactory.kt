package Factories

import ModelsSalaDeCine.TipoButaca
import ModelsSalaDeCine.butaca

class ButacaFactory {

    companion object{
        private var instance: ButacaFactory? = null

        fun getInstance(): ButacaFactory?{
            if(instance == null){
                instance = ButacaFactory()
            }
            return instance
        }
    }

    /**
     * función que sirve para crear y devolver una butaca
     * @param identificador es la combinación de fila y columna única de la butaca
     * @param estado es el estado de la butaca, puede ser libre, reservado, o ocupado
     * @param tipoButaca es el tipo de butaca, el precio de cada butaca varia dependiendo de si es normal o vip
     * @return la butaca creada según los parametros introducidos
     */
    fun crearButaca(identificador: String, estado: String, tipoButaca: TipoButaca): butaca {
        return butaca(identificador, estado, tipoButaca)
    }
}