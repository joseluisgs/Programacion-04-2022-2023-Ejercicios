package models

abstract class Persona(var nombrePersona: String? = null){
    open fun respirar(){
        println("Hola, soy $nombrePersona y estoy respirando como persona.")
    }
}
