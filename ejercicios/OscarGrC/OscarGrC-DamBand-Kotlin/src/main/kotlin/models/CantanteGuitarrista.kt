package models

import interfaces.ICantante
import interfaces.IGuitarrista

class CantanteGuitarrista(override val nombre: String,
                          override val tono: ICantante.TonosCantante,
                          override val tipoGuitarra: IGuitarrista.Tipoguitarra,
                          override var experiencia: Int):Musico(),ICantante,IGuitarrista {
    val sueldo:Int = ((sueldoBase/10) *14)
    override val titulo: String = "Cantante y guitarrista"
    override fun respirar(): String {
        return "$nombre respira fuerte."
    }
    override fun interpretar():String{
        return "$nombre esta cantando y tocando la guitarra $tipoGuitarra"
    }

}