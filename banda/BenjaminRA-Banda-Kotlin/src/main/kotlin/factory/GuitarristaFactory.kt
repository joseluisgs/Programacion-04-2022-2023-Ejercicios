package factory
import models.Guitarrista
/*Factory para crear guitarristas de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5 y 10 años
y un tipo de guitarra entre 3 disponibles*/
object GuitarristaFactory {
    var contadorGuitarristas = 0
    fun crearGuitarrista(): Guitarrista {
        contadorGuitarristas++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        val vectorGuitarras = arrayOf("Acustica", "Electrica", "Bajo")
        return Guitarrista(vectorNombres.random(), (5..10).random(), vectorGuitarras.random())
    }
}