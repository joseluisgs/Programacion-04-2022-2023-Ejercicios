package Taller.models

class JefeDeTaller(nombre: String, añosExperiencia: Int) : Persona(nombre, añosExperiencia) {

    override fun saludar(){
        println("Hola soy $nombre, llevo $añosExperiencia años siendo el mejor jefe que ha habido en este sitio")
    }

    fun darLatigazo(){
        println("*Le da un latigazo*")
    }

    override fun toString(): String {
        return "JefeDeTaller(nombre= '$nombre', añosExperiencia= $añosExperiencia)"
    }
}