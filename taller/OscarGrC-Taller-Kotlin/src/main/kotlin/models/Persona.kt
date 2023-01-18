package models
abstract class Persona(var nombre:String, var  personalidad :Personalidad){
    val id =  getId()
    var experiencia = 0

    companion object{
        private var contador = 0
        private fun getId(): Int {
            contador += 1
            return contador
        }
    }

   open fun saludar():String{
        return "Hola soy $nombre y soy una persona"
    }
}