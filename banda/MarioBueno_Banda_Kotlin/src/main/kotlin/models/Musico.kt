//Mario Bueno López
//maarioo2525@gmail.com

package models

open class Musico(override var nombre: String?, open var experiencia: Int) : Persona() {

    open fun interpretar() {
        println("Estoy interpretando")
    }
    companion object{
        var salario = 1500.00
    }
}