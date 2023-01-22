package models

import interfaces.ITrompetista

class Trompetista(override val nombre:String,
                  override val capacidadPulmonar: Int,
                  override var experiencia: Int,):Musico(),ITrompetista {
    val sueldo = (sueldoBase/10)*12
    override val titulo = "Trompetista"
    override fun respirar(): String {
        return "$nombre respira fuerte."
    }
    override fun interpretar():String{
        return "$nombre esta tocando su trompeta"
    }
}