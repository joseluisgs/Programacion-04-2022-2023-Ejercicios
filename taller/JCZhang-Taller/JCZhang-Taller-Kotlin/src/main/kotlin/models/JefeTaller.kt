package models


class JefeTaller(nombre: String, aniosExp: Int) : Persona(id, nombre, aniosExp) {


    fun JefeTaller(nombre: String, aniosExp: Int) {
        this.nombre = nombre
        this.aniosExp = aniosExp
    }


    override fun saludar() {
        println("Jefe De Taller: Hola! Me llamo $nombre, soy el jefe de taller y aquí mando yo")
    }

    fun darLatigazo(){
        println("Jefe De Taller: ESTOY DANDO LATIGAZOS!!! SUFREEE!!!!")
    }

    fun pagar(){
        println("Jefe De Taller: TE ESTOY PAGANDO PEDAZO DE VAGO SUCIO FEO ASQUEROSO RARO TONTO (insertar aquí cosas malas), ASI QUE TRABAJA PARA MI!!!!!")
    }

    override fun toString(): String {
        return "JefeTaller($nombre con $aniosExp años de experiencia)"
    }


}