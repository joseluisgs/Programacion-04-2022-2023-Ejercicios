package models

abstract class AnimalDomestico(var nombre:String, var raza:String, var peso:Int,var color:String) {
   open lateinit var tipoAnimal:TipoAnimal
    open fun vacunar ():String{
        return "$nombre esta en el veterinario. Siendo vacunado."
    }
    open fun comer ():String{
        return "$nombre esta comiendo"
    }
    open fun dormir():String{
        return "$nombre esta durmiendo"
    }

    fun hacerRuido ():String{
        return when(tipoAnimal){
            TipoAnimal.Gato-> "$nombre dice que Miau"
            TipoAnimal.Perro-> "$nombre dice WOOF? Aruff roof! Woof-woof arf woof... ...warroof, Mêlée " +
                    "Island™! ...a-roof wuf: ...LeChuck! Grrrrrrr!"

            TipoAnimal.Otros-> "$nombre dice PIO PIO  "
        }
    }
    fun hacerCaso ():Boolean{
        val azar = (1..100).random()
        if(azar>=10 && tipoAnimal==TipoAnimal.Perro) return true
        if(azar>95 && tipoAnimal==TipoAnimal.Gato) return true
        else return false
    }

}