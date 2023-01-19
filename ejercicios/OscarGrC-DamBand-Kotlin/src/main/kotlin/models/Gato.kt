package models

class Gato :AnimalDomestico(nombre = "", raza = "", peso = 0, color = "") {
    override var tipoAnimal = TipoAnimal.Gato
    override fun vacunar ():String{
        return "$nombre el $raza esta en el veterinario. Siendo vacunado."
    }
    override fun comer ():String{
        return "$nombre el $raza esta comiendo"
    }
    override fun dormir():String{
        return "$nombre el $raza esta durmiendo"
    }
    fun toserBolaPelo():String{
        return "$nombre escupio una bola de pelo \n No parece muy efectivo "
    }
    override fun toString(): String {
        return "Nombre=$nombre, Raza=$raza, Peso=$peso, Color=$color."
    }
}