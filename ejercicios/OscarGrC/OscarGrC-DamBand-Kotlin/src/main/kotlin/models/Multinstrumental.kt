package models

import interfaces.IBajista
import interfaces.IGuitarrista
import interfaces.IPercusionista

class Multinstrumental(override val nombre: String, override val numeroCuerdasBajo: Int,
                       override val tipoGuitarra: IGuitarrista.Tipoguitarra,
                       override val tipoPercusion: IPercusionista.TipoPercusion,
                       override var experiencia: Int)
                        :Musico(),IGuitarrista,IBajista,IPercusionista {
    val sueldo = (sueldoBase/100)*145
    override val titulo ="Guitarrista, bajista y percusionista"
    override fun interpretar():String{
        return "$nombre esta tocando su bajo de $numeroCuerdasBajo cuerdas, o su guitarra $tipoGuitarra, o " +
                "tocando su $tipoPercusion, vete tu a saber."
    }
}