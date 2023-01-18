package modelsTaller

class JefeTaller(nombre: String, experiencia: Int, val personasACargo: Int): Persona(nombre, experiencia) {

    override fun saludar(){
        println("Jajajaja, hola empleado, soy tu jefe *derrogatorio*")
    }

    fun darLatigazos(){
        println("*Pum* Soy tu jefe $nombre y te pego...")
    }

    fun pagar(){
        println("Hola, empleado, te pago *tristeza*")
    }

    override fun toString(): String {
        return "Soy un jefe de taller, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y tengo a mi cargo a $personasACargo personas"
    }

}