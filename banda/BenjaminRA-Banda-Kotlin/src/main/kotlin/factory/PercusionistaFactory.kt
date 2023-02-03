package factory
import models.Percusionista
/*Factory para crear cantantes guitarristas de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5
y 10 años y un tipo de percusión aleatoria entre 5 disponibles*/
object PercusionistaFactory {
    var contadorPercusionistas = 0
    fun crearPercusionista(): Percusionista {
        contadorPercusionistas++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        val tipoPercusion = arrayOf("Tambor", "Pandereta", "Tamboril", "Tambor de madera", "Tambor de metal")
        return Percusionista(vectorNombres.random(), (5..10).random(), tipoPercusion.random())
    }
}