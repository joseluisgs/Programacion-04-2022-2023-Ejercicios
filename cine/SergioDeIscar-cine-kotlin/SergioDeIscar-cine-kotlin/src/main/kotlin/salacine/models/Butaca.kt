package salacine.models

import salacine.enums.ButacaEstado

class Butaca(private var estado: ButacaEstado){
    private var isVip: Boolean = false

    constructor(estado: ButacaEstado, probability: Int):  this(estado){
        this.isVip = (0..100).random() in 0..probability
    }

    fun getEstado(): ButacaEstado {
        return estado
    }
    fun setEstado(newEstado: ButacaEstado){
        estado = newEstado
    }
    fun getIsVip(): Boolean {
        return isVip
    }
}
