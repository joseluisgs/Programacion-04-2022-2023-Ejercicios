//Mario Bueno López
//maarioo2525@gmail.com

package models

class JefeDeTaller(nombre: String, experiencia: Int): Persona(id, nombre, experiencia) {
    override fun saludar() {
        println("Hola soy una persona y te saludo")
    }
    fun darLatigazo(){
        println("Te voy a dar un latigazo")
    }
    fun pagar(){
        println("Te voy a pagar")
    }
}