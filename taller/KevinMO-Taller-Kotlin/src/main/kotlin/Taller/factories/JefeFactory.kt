package Taller.factories

import Taller.models.JefeDeTaller
import Taller.models.Persona

class JefeFactory{

    companion object {
        private var instace: JefeFactory? = null
        fun getInstance(): JefeFactory {
            if(instace == null){
                instace = JefeFactory()
            }
            return instace!!
        }
    }

    fun crearJefe(): JefeDeTaller {
        val arrayNombres = arrayOf("LeBron", "Stephen", "James", "Joel", "Jayson", "Ja", "Devin", "Giannis", "Nikola", "Luka", "Trae",
            "Kevin", "Donovan", "Jalen", "Jimmy", "Tyrese", "Demar", "Zion", "Leonard", "Domantas", "Edwards", "Shai")
        val arrayExperiencia = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val nombre = arrayNombres.random()
        val añosExperiencia = arrayExperiencia.random()

        return JefeDeTaller(nombre, añosExperiencia)
    }

}