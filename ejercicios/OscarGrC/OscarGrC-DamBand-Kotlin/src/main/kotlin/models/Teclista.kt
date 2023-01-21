package models

import interfaces.ITeclista

class Teclista(override val nombre:String,
               override val tipoTeclaco:ITeclista.TipoTeclado,
               override var experiencia: Int
):Musico(),ITeclista {
    val sueldo = (sueldoBase/10)*13
    override val titulo = "Teclista"
    override fun interpretar():String{
        return "$nombre esta tocando el teclado"
    }
}