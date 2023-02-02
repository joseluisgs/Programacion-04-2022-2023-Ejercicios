package Taller.factories

import Taller.models.JefeDeTaller
import Taller.models.Persona

class PersonaFactory {

    companion object{
        private var instance: PersonaFactory? = null
        fun getInstance(): PersonaFactory {
            if(instance == null){
                instance = PersonaFactory()
            }
            return instance!!
        }
    }

    fun crearPersona(): Persona {
        val probabilidad = (0..100).random()
        if (probabilidad < 10){
            return JefeFactory.getInstance().crearJefe()
        }
        if(probabilidad in 10..60){
            return TrabajadorFactory.getInstance().crearTrabajador()
        }
        if(probabilidad in 60..75){
            return ChapistaFactory.getInstance().crearChapista()
        }
        if(probabilidad in 75..90){
            return ElectricistaFactory.getInstance().crearElectricista()
        }
        if(probabilidad in 90..100){
            return NavajaFactory.crearNavaja()
        }
        return getInstance().crearPersona()
    }
}