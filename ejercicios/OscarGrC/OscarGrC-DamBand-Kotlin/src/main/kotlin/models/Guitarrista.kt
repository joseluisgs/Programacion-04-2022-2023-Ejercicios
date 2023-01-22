package models

import interfaces.ICantante
import interfaces.IGuitarrista

class Guitarrista(override val nombre:String,
                  override val tipoGuitarra: IGuitarrista.Tipoguitarra,
                  override var experiencia: Int):Musico(), IGuitarrista {
         val sueldo:Int = (sueldoBase/10)*13
    override val titulo: String = "Guitarrista"
    override fun interpretar():String{
        return "$nombre esta tocando la guitarra $tipoGuitarra"
    }
}