package factory
import models.Cantante
/*Factory para crear cantantes de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5 y 10 años
y un tono aleatorio entre 3 disponibles*/
object CantanteFactory {
    var contadorCantantes = 0
    fun crearCantante(): Cantante {
        contadorCantantes++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        val vectorTonos = arrayOf("Agudo", "Medio", "Grave")
        return Cantante(vectorNombres.random(), (5..10).random(), vectorTonos.random())
    }
}