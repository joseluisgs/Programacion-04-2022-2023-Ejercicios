package Taller.factories

import Taller.models.Electricista

class ElectricistaFactory {

    companion object{
        private var instance: ElectricistaFactory? = null
        fun getInstance(): ElectricistaFactory {
            if (instance == null){
                instance = ElectricistaFactory()
            }
            return instance!!
        }
    }

    fun crearElectricista(): Electricista {
        val arrayNombres = arrayOf("Robert", "Brook","Shake", "Yuta", "Evan", "Tyler", "Quentin", "Hunter", "Chris",
            "Patrick", "Fred", "Corey", "Bol", "Miles", "Marvin", "Jones", "Simons")

        val nombre = arrayNombres.random()
        val horas = (1..25).random()
        val años = (0..15).random()

        return Electricista(horas, nombre, años)
    }
}