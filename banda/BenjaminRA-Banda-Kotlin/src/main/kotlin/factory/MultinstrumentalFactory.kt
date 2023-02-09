package factory
import models.Multinstrumental
/*Factory para crear multiinstrumentales de nombre aleatoria entre un array de 50 nombres, con una experiencia de entre 5
y 10 años, un número aleatorio de cuerdas, un número aleatorio de teclados y un tipo de percusión.*/
object MultinstrumentalFactory {
    var contadorMultinstrumentales = 0
    fun crearMultinstriumental(): Multinstrumental{
        contadorMultinstrumentales++
        val vectorNombres = arrayOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Igor", "Jack", "Kate", "Luke", "Mark", "Noah", "Olivia", "Peter", "Quinn", "Ryan", "Sarah", "Tom", "Ursula", "Victoria", "William", "Xander", "Yara", "Zach", "Aaron", "Beth", "Claire", "Dylan", "Ellie", "Felix", "Gabriela", "Harry", "Isabella", "Jasper", "Kelly", "Liam", "Megan", "Nicholas", "Emily", "Anthony", "Brittany", "Carlos", "Dakota", "Ethan", "Fiona", "Gavin", "Harper", "Moha")
        val tipoPercusion = arrayOf("Tambor", "Pandereta", "Tamboril", "Tambor de madera", "Tambor de metal")
        return Multinstrumental(vectorNombres.random(), (5..10).random(), (1..6).random(),(24..48).random(),tipoPercusion.random())
    }
}