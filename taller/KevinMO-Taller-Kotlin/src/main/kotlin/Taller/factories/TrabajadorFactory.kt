package Taller.factories

import Taller.models.Trabajador

class TrabajadorFactory {
    companion object {
        private var instace: TrabajadorFactory? = null
        fun getInstance(): TrabajadorFactory {
            if(instace == null){
                instace = TrabajadorFactory()
            }
            return instace!!
        }

    }

    fun crearTrabajador(): Trabajador {
        val arrayNombres = arrayOf("Brown", "Irving", "Jrue", "Maxey", "Darius", "Julius", "Bam", "Buddy", "Murray", "Zach", "Pascal",
            "Kyle", "Franz", "Cade", "LaMelo", "Jamal", "Bane", "Brandon", "Fox", "Christian", "George", "Thompson", "Lauri", "Rudy",
            "Damian", "Josh", "Chris Paul", "Davis", "Johnson", "Green")
        val horas = (0..24).random()
        val nombre = arrayNombres.random()
        val añosExperiencia = (0..20).random()
        val salario = 1200

        return Trabajador(horas, nombre, añosExperiencia)
    }
}