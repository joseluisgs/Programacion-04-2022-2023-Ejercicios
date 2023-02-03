package factory
import models.Teclista
/*Factory para crear cantantes guitarristas de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5
y 10 años y una cantidad de teclados de entre 24 y 48.*/
object TeclistaFactory {
    var contadorTeclistas = 0
    fun crearTeclista(): Teclista {
        contadorTeclistas++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        return Teclista(vectorNombres.random(), (5..10).random(), (24..48).random())
    }
}