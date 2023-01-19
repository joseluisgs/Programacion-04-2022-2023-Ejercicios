package models

abstract class Persona (open val nombre:String){

     open fun respirar():String{
         return "$nombre esta respirando."
     }
}