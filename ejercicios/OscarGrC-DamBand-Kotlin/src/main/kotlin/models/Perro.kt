package models

class Perro :AnimalDomestico( nombre = "", raza = "", peso = 0, color = "") {
    override var tipoAnimal = TipoAnimal.Perro
    override fun vacunar ():String{
        return "$nombre el $raza esta en el veterinario. Siendo vacunado."
    }
    override fun comer ():String{
        return "$nombre el $raza esta comiendo"
    }
    override fun dormir():String{
        return "$nombre el $raza esta durmiendo"
    }
    fun salirPaseo():String{
        return  "$nombre esta paseando"
    }

    override fun toString(): String {
        return "Nombre=$nombre, Raza=$raza, Peso=$peso, Color=$color."
    }
}