package models

data class ButacaCine (val fila:String,val columna:Int,val isVip:Boolean){
    var estadoButaca = EstadoButacas.LIBRE
    var entradaAsignada: Entrada? = null

    enum class EstadoButacas {
        LIBRE,OCUPADA,RESERVADA
    }
}
