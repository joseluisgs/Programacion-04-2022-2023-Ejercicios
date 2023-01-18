package models

class JefeTaller(var empresa:String):Persona(  "",Personalidad.Chulo,) {
    var personasAlCargo = 0
    val sueldo = 2500
    fun darLatigazo(personaAlaQueAmar:Trabajador){
         val motivacion = (0 until 100).random()
        println("Das un latigazo a ${personaAlaQueAmar.nombre} su motivación a aumentado un $motivacion%. ")
    }

    override fun saludar():String{
        return if(personalidad==Personalidad.Chulo) "Hola soy $nombre por las mañanas soy jefe de taller " +
                "por las tardes el pu** Amo."
        else "Hola, Soy $nombre un admirador, un amigo, un esclavo, un siervo."
    }
    fun cuantosMasillasTienes():String{
        return "Soy $nombre. y tengo a $personasAlCargo personas a mi cargo"
    }
}