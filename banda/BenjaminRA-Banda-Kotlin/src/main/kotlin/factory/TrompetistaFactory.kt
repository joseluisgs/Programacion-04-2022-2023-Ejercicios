package factory
import models.Trompetista
/*Factory para crear cantantes guitarristas de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5
y 10 años y una capacidad pulmonar aleatoria de entre 3 opciones disponibles*/
object TrompetistaFactory {
    var contadorTrompetistas = 0
    fun crearTrompetista(): Trompetista{
        contadorTrompetistas++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        val vectorCapacidadPulmonar = arrayOf("Nobato", "Experimentado", "Profesional")
        return Trompetista(vectorNombres.random(), (5..10).random(), vectorCapacidadPulmonar.random())
    }
}