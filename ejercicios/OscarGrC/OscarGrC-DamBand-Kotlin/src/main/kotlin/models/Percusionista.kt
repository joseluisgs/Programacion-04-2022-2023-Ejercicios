package models

import interfaces.IPercusionista

class Percusionista(override val nombre:String,
                    override val tipoPercusion: IPercusionista.TipoPercusion,
                    override var experiencia: Int):Musico(),IPercusionista {
        val sueldo:Int = (sueldoBase/100)*135
    override val titulo: String = "Percusionista"
    override fun interpretar():String{
        return "$nombre esta tocando ${tipoPercusion}"
    }
}