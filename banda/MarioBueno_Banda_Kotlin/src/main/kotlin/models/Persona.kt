//Mario Bueno López
//maarioo2525@gmail.com

package models

abstract class Persona (open var nombre: String? = null){
    open fun respirar() {
        println("Soy una persona y estoy respirando.")
    }
}
