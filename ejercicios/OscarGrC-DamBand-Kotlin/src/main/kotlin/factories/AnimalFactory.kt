package factories

import models.Gato
import models.Perro
import java.util.*

class AnimalFactory {
    val nombre = "Factory de Animales + ${UUID.randomUUID()}"
    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: AnimalFactory? = null
        fun getInstance(): AnimalFactory {
            if (instance == null) {
                instance = AnimalFactory()
            }
            return instance!!
        }
    }
    private val listaNombres = arrayOf ("Abul-Abbas","Adwaita", "Alba", "Alex", "ANDi", "April", "Argos", "Arthur", "Avispado",
          "Ayumu", "Balto", "Barry", "Becerrillo", "Belisario", "Benson","Blondi","Bonfire", "Boo","Brownie","Bubbles",
          "Bucéfalo","Cassius","Chantek","Cher", "Chonino","Chu-Lin","Cook","Puff","Crystal","Darley","Dime","Dolly",
          "Eddie","Fala" ,"Félicette","Ferdinand","Flocke","Frida","Ducato","Greyfriars","Grumpy" ,"Guillermo",
          "Gustave","Hachikō","Hanno","Harambe","Harriet","Incitatus","Jambo","Jenny","Lassie","Marius","Nevado",
          "Orion","Owen","Pelorus","Pipper","Rin Tin Tin","Secretariat","Snuppy","Sunny","Teddy","Titus","Firulais")
    private  val listadeRazasGato = arrayOf("Sphynx","Siamés","Persa","Birmano","Bombay","Angora")
    private val listaRazasPerro= arrayOf("Dalmata","BullDog","Caniche","Labrador","Chiguagua","Pastor Aleman","Corgi")
    private val listaColores= arrayOf("Blanco","Negro","Pardo","Naranja","Gris","Blanco con manchas negras")

    fun getRandomPerro():Perro{
        var perrosalida = Perro()
        perrosalida.nombre=listaNombres.random()
        perrosalida.raza= listaRazasPerro.random()
        perrosalida.peso= (5..25).random()
        perrosalida.color=listaColores.random()
        return  perrosalida
    }
    fun getRandomGato():Gato{
        var gatoosalida = Gato()
        gatoosalida.nombre=listaNombres.random()
        gatoosalida.raza= listadeRazasGato.random()
        gatoosalida.peso= (2..10).random()
        gatoosalida.color=listaColores.random()
        return  gatoosalida
    }

}