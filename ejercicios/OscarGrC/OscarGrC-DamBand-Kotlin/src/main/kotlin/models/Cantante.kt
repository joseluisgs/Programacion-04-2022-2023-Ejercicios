package models

import interfaces.ICantante

class Cantante(override val nombre:String,
               override val tono:ICantante.TonosCantante,
               override var experiencia: Int):Musico(),ICantante {
    val sueldo:Int = ((sueldoBase/10) *14)
    override val titulo: String = "Cantante"
    override fun respirar(): String {
        return "$nombre respira fuerte."
    }
    override fun interpretar():String{
        return "$nombre esta cantando"
    }

}