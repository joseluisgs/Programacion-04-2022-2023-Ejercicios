package models

import interfaces.IBajista

data class Bajista(override val nombre:String,
              override val numeroCuerdasBajo:Int,
              override var experiencia:Int):Musico(),IBajista {
    val sueldo = (sueldoBase/10)*13
    override val titulo = "Bajista"
    override fun interpretar():String{
        return "$nombre esta tocando su bajo de $numeroCuerdasBajo cuerdas."
    }
}