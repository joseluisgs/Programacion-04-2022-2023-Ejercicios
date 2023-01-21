package models

open class Musico():Persona("") {
     open var experiencia:Int = 0
     open val titulo:String = ""
    val sueldoBase:Int = 1500
     open fun interpretar():String{
         return  "$nombre esta tocando"
     }
}