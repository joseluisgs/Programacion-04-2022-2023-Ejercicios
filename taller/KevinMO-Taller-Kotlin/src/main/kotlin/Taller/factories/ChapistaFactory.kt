package Taller.factories

import Taller.models.Chapista


class ChapistaFactory{

    companion object {
        private var instance: ChapistaFactory? = null
        fun getInstance(): ChapistaFactory {
            if(instance == null){
                instance = ChapistaFactory()
            }
            return instance!!
        }
    }

    fun crearChapista(): Chapista {
        val arrayNombres = arrayOf("Marcus", "Ben", "Kris", "Melton", "Jarrett", "Immanuel", "Max", "Myles", "John", "Alex", "Scottie",
        "Corey", "Cole", "Sadiq", "Mason", "Aaron", "Steven", "Huerter", "Spencer", "Jordan", "Mike", "Norman", "Austin")

        val horas = (1..25).random()
        val nombre = arrayNombres.random()
        val años = (0..15).random()

        return Chapista(horas, nombre, años)
    }
}