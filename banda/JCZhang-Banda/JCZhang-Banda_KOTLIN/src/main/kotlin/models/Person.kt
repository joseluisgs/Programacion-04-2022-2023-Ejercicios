package models

abstract class Person {
    open var name: String? = null
    open fun breath() {
        println("Im breathing")
    }
}