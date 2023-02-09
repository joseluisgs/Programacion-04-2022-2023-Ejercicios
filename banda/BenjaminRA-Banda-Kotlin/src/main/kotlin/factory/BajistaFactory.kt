package factory
import models.Bajista
/*Factory para crear bajistas de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5 y 10 años
y cuenta con entre 1 y 6 cuerdas*/
object BajistaFactory {
    var contadorBajistas = 0
    fun crearBajista(): Bajista {
        contadorBajistas++
        val arrayNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        return Bajista(arrayNombres.random(), (5..10).random(), (1..6).random())
    }
}