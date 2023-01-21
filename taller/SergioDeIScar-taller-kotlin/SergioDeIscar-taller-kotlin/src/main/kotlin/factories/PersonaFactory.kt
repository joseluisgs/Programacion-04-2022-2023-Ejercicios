package taller.factories

import taller.models.*

class PersonaFactory{
    companion object {
        private var persona: PersonaFactory? = null
        fun getInstance(): PersonaFactory {
            if (persona == null) {
                persona = PersonaFactory()
            }
            return persona!!
        }
    }

    fun getRandomTrabajador(chapiPro: Int = 30, electPro: Int = 70): Trabajador{
        require(chapiPro in 0.. 100){"La probabilidad de chapista ha de estar entre 0-100"}
        require(electPro in 0.. 100){"La probabilidad de electricista ha de estar entre 0-100"}
        require(electPro + chapiPro == 100){"La probabilidad de chapista + electricista ha de dar 100"}

        if ((0..100).random() in 0..chapiPro)
            return Chapista(randomNombre(), (0..25).random(), (6..13).random())
        return Electricista(randomNombre(), (0..25).random(), (6..13).random())
    }

    fun getRandomTallerCompleto(chapiPro: Int = 30, electPro: Int = 70): Array<Persona?>{
        require(chapiPro in 0.. 100){"La probabilidad de chapista ha de estar entre 0-100"}
        require(electPro in 0.. 100){"La probabilidad de electricista ha de estar entre 0-100"}
        require(electPro + chapiPro == 100){"La probabilidad de chapista + electricista ha de dar 100"}
        // List :(
        val personas = Array<Persona?>(50){null}
        var count = 0
        do {
            val experiencia = (0..25).random()
            var countTrabajadores = when(experiencia){
                in 0..5 -> 5
                in 6..15 -> 15
                else ->25
            }
            //+1 por el Jefe
            if (countTrabajadores + count + 1 > 50) countTrabajadores = countTrabajadores + count -1 -50

            val jefe = JefeTaller(randomNombre(), experiencia, countTrabajadores)
            for (i in 0 until countTrabajadores){
                val trabajador = getRandomTrabajador(chapiPro, electPro)
                addPersona(trabajador, personas)
                jefe.addTrabajador(trabajador)
            }
            addPersona(jefe, personas)
            count++ //Jefe
            count += countTrabajadores
        }while (count < 50)
        return personas
    }

    private fun addPersona(persona: Persona, personas: Array<Persona?>){
        for (i in personas.indices){
            if (personas[i] == null)
            {
                personas[i] = persona
                return
            }
        }
    }

    private fun randomNombre(): String{
        val nombres = arrayOf("Pedro", "Juan", "Ana", "Daniel", "Lucía")
        return nombres[(0..nombres.lastIndex).random()]
    }
}