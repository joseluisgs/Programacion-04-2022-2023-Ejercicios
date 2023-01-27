package factories

import models.snake.Snake
import java.util.*

class SnakeFactory {

    val nombre = "Factory de Snake + ${UUID.randomUUID()}"
    companion object {
        private var instance: SnakeFactory? = null
        fun getInstance(): SnakeFactory {
            if (instance == null) {
                instance = SnakeFactory()
            }
            return instance!!
        }
    }
    private val listaDeNombres:Array<String> = arrayOf("Ana","DuditaMacUsuario","Jose","Pepe","JoseMaria","Monica","Emilio",
        "Mariano","Nemo","Pocholo","Nicolas","Gunter","Biörk","ZZTopmate","Perseo","Helios","Romulo","Ciceron",
        "JoseLuis","Sara","Lurdes","Julia","Leonor","Borja","Manuel","Teresa","Gorka","Ulises","Matilde","Alarico",
        "Ataúlfo","Sigérico","Walia","Teodorico","Turismundo","Eurico","Gesaleico","Amalarico","Theudis","Theudisclo",
        "Agila","Atanagildo","Liuva","Leovigildo","Recaredo","Witérico","Gundemaro","Sisebuto","Suíntila","Sisenando",
        "Khíntila","Tulga","Khindasvinto","Recesvinto","Wamba","Abul-Abbas","Adwaita","Alba","Alex","ANDi","April",
        "Argos","Arthur","Avispado","Ayumu","Balto","Barry","Becerrillo","Belisario","Benson","Blondi","Bonfire","Boo",
        "Brownie","Bubbles","Bucéfalo","Cassius","Chantek","Cher","Chonino","Chu-Lin","Cook","Puff","Crystal","Darley",
        "Dolly","Eddie","Fala","Félicette","Ferdinand","Flocke","Frida","Ducato","Greyfriars","Grumpy","Guillermo",
        "Gustave","Hachikō","Hanno","Harambe","Harriet","Incitatus","Jambo","Jenny","Marius","Orion","Owen","Pipper",
        "Sunny","Teddy","Titus")

    fun getAnillaRandom(): Snake.TipoColorAnilla {
        return Snake.TipoColorAnilla.values().random()
    }

    fun getSnakeRandom():Snake{
        return Snake(listaDeNombres.random())
    }
    fun getQuiverRandom(numeroSnake:Int):Array<Snake>{
        return Array(numeroSnake){getSnakeRandom()}
    }
}