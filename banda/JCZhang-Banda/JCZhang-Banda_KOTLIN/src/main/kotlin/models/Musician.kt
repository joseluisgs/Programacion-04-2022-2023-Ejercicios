package models

open class Musician(override var name: String?, open var yearsOfExperience: Int) : Person() {

    open fun interpret() {
        println("Im interpreting")
    }
companion object{
    var salary = 1500.00
}


}