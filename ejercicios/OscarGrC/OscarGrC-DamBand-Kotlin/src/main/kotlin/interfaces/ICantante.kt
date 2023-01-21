package interfaces

import models.Musico

interface ICantante {
    fun respirar():String
    val tono:TonosCantante
    enum class TonosCantante {
        Soprano,Baritono,Tenor,Alto
    }
}